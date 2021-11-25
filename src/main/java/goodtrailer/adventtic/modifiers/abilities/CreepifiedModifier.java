package goodtrailer.adventtic.modifiers.abilities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.tslat.aoa3.util.WorldUtil;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class CreepifiedModifier extends Modifier
{
    public static final int COLOR = 0xA4EA00;
    public static final float CRIT_COEFFICIENT = 1.1f;
    public static final double MARGIN = 0.1;
    
    public CreepifiedModifier()
    {
        super(COLOR);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        PlayerEntity player = context.getPlayerAttacker();
        if (player.level.isClientSide)
            return 0;

        float strength = level;
        if (context.isCritical())
            strength *= CRIT_COEFFICIENT;

        LivingEntity target = context.getLivingTarget();

        double offsetXZ = target.getBbWidth() / 2.0 + MARGIN;
        Vector3d offset = new Vector3d(
                MathHelper.clamp(player.getX() - target.getX(), -offsetXZ, offsetXZ),
                MathHelper.clamp(player.getEyeY() - target.getY(), -MARGIN,
                        target.getBbHeight() + MARGIN),
                MathHelper.clamp(player.getZ() - target.getZ(), -offsetXZ, offsetXZ)
        );

        BlockPos explosionPos = new BlockPos(target.position().add(offset));
        WorldUtil.createExplosion(player, player.level, explosionPos, strength);

        return 0;
    }
}
