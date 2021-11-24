package goodtrailer.adventtic.modifiers;

import java.util.Random;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.tslat.aoa3.entity.misc.BloodlustEntity;
import net.tslat.aoa3.util.skill.ButcheryUtil;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class ButchererModifier extends Modifier
{
    public static final int COLOR = 0x960000;
    public static final float BASE_ATTACK_SPEED = 1.6f;
    public static final float PROB_PER_LEVEL = 0.015f;

    private Random rng;

    public ButchererModifier()
    {
        super(COLOR);
        rng = new Random();
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
        float prob = coef * level * PROB_PER_LEVEL;
        if (rng.nextFloat() < prob && ButcheryUtil.canMobSpawnBloodlust(target))
            player.level.addFreshEntity(new BloodlustEntity(target.level, target.blockPosition()));

        return 0;
    }
}
