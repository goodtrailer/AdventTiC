package goodtrailer.adventtic.modifiers.upgrades;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolAttackUtil;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class AirBladeModifier extends Modifier
{
    public static final int COLOR = 0xFFFDD8;

    private boolean isSprinting;
    private float deltaWalkDist;

    public static float coefficient(int level)
    {
        return level / (float) (level + 2);
    }

    public AirBladeModifier()
    {
        super(COLOR);
        isSprinting = false;
        deltaWalkDist = 0f;
    }

    @Override
    public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damage, float baseKnockback, float knockback)
    {
        LivingEntity attacker = context.getAttacker();
        isSprinting = attacker.isSprinting();
        deltaWalkDist = attacker.walkDist - attacker.walkDistO;
        return knockback;
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity attacker = context.getAttacker();
        if (attacker.level.isClientSide)
            return 0;

        if (tool.getItem().is(TinkerTags.Items.SCYTHES))
            sweepScythe(tool, level, context, damageDealt);
        else if (tool.getItem().is(TinkerTags.Items.SWORD))
            sweepSword(tool, level, context, damageDealt);

        return 0;
    }

    private void sweepScythe(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        if (!context.isExtraAttack())
            return;

        LivingEntity attacker = context.getAttacker();
        Entity target = context.getTarget();
        float damage = damageDealt * coefficient(level);
        ToolAttackUtil.dealDefaultDamage(attacker, target, damage);
    }

    private void sweepSword(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity attacker = context.getAttacker();
        if (!context.isFullyCharged()
                || context.isCritical()
                || !attacker.isOnGround()
                || isSprinting
                || deltaWalkDist >= attacker.getSpeed())
            return;

        Entity target = context.getTarget();
        float damage = damageDealt * coefficient(level);
        double range = tool.getModifierLevel(TinkerModifiers.expanded.get()) + 1;

        for (LivingEntity aoeTarget : attacker.level.getEntitiesOfClass(
                LivingEntity.class, target.getBoundingBox().inflate(range, 0.25, range)))
        {
            if (aoeTarget == attacker
                    || aoeTarget == target
                    || !attacker.canAttack(aoeTarget)
                    || attacker.distanceToSqr(aoeTarget) >= 10.0 + range)
                continue;

            ToolAttackUtil.dealDefaultDamage(attacker, aoeTarget, damage);
        }
    }
}
