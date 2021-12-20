package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ToxicModifier extends SingleUseModifier
{
    public static final int COLOR = 0x6BFFBE;
    
    public static final int CLOUD_COLOR = 0x336600;
    public static final float CLOUD_GROWTH = -0.015f;
    public static final float CLOUD_RADIUS = 2f;
    public static final int CLOUD_DURATION = 3;
    
    public static final int EFFECT_DURATION = 3 * 20;
    public static final int EFFECT_AMPLIFIER = 1;

    public ToxicModifier()
    {
        super(COLOR);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity atker = context.getAttacker();
        if (atker.level.isClientSide || context.isExtraAttack() || !context.isCritical())
            return 0;

        Entity target = context.getTarget();
        Vector3d pos = target.getPosition(1f);
        AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(atker.level, pos.x, pos.y, pos.z);
        cloud.setDuration(CLOUD_DURATION);
        cloud.setRadius(CLOUD_RADIUS);
        cloud.setRadiusPerTick(CLOUD_GROWTH);
        cloud.setFixedColor(CLOUD_COLOR);
        cloud.addEffect(new EffectInstance(Effects.POISON, EFFECT_DURATION, EFFECT_AMPLIFIER));
        atker.level.addFreshEntity(cloud);

        return 0;
    }
}
