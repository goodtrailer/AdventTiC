package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.tslat.aoa3.util.constant.Resources;
import net.tslat.aoa3.util.player.PlayerUtil;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class SoulSapModifier extends SingleUseModifier
{
    public static final int COLOR = 0x99A8FC;
    public static final float COEFFICIENT = 1 / 3.5f;

    public SoulSapModifier()
    {
        super(COLOR);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        PlayerEntity player = context.getPlayerAttacker();
        if (!(player instanceof ServerPlayerEntity) || player.level.isClientSide)
            return 0;

        PlayerUtil.addResourceToPlayer((ServerPlayerEntity) player, Resources.SOUL,
                damageDealt * COEFFICIENT);

        return 0;
    }
}
