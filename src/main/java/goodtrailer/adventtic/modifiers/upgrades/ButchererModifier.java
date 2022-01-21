package goodtrailer.adventtic.modifiers.upgrades;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.tslat.aoa3.entity.misc.BloodlustEntity;
import net.tslat.aoa3.util.skill.ButcheryUtil;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class ButchererModifier extends IncrementalModifier
{
    public static final int COLOR = 0x960000;
    public static final float BASE_ATTACK_SPEED = 1.6f;
    public static final float PROB_PER_LEVEL = 0.015f;

    public ButchererModifier()
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

        LivingEntity target = context.getLivingTarget();

        float coef = BASE_ATTACK_SPEED / tool.getStats().getFloat(ToolStats.ATTACK_SPEED);
        float prob = coef * getScaledLevel(tool, level) * PROB_PER_LEVEL;
        if (RANDOM.nextFloat() < prob && ButcheryUtil.canMobSpawnBloodlust(target))
            player.level.addFreshEntity(new BloodlustEntity(target.level, target.blockPosition()));

        return 0;
    }
}
