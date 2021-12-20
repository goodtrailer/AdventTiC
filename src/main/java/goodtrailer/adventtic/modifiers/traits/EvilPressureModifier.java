package goodtrailer.adventtic.modifiers.traits;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class EvilPressureModifier extends SingleUseModifier
{
    public static final int COLOR = 0xC68A2F;
    public static final int AMPLIFIER = 2;
    public static final int EXTENSION = 3;
    public static final float MAX_PROB = 0.325f;

    public EvilPressureModifier()
    {
        super(COLOR);
    }

    public static float probability(float damage, float maxHealth)
    {
        // scales upwards with health, so that with really tanky mobs, the effects just
        // pile on, making this a possibly effective giant slaying trait
        return MAX_PROB * (1 - damage / (damage + maxHealth));
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity target = context.getLivingTarget();
        float prob = probability(damageDealt, target.getMaxHealth());
        if (target.level.isClientSide || RANDOM.nextFloat() > prob)
            return 0;

        ArrayList<EffectInstance> debuffs = new ArrayList<EffectInstance>();
        Collection<EffectInstance> effects = target.getActiveEffects();
        for (EffectInstance effect : effects)
            if (!effect.getEffect().isBeneficial())
                debuffs.add(effect);

        EffectInstance debuff = debuffs.get(RANDOM.nextInt(debuffs.size()));
        debuff.update(new EffectInstance(debuff.getEffect(), debuff.getDuration() + EXTENSION,
                debuff.getAmplifier() + AMPLIFIER, debuff.isAmbient(), debuff.isVisible(),
                debuff.showIcon()));

        return 0;
    }
}
