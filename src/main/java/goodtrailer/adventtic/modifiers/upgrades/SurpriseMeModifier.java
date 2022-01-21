package goodtrailer.adventtic.modifiers.upgrades;

import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class SurpriseMeModifier extends IncrementalModifier
{
    public static final int COLOR = 0xF200FF;
    public static final float COEFFICIENT_PER_LEVEL = 0.08f;

    public SurpriseMeModifier()
    {
        super(COLOR);
    }

    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {
        float bonus = COEFFICIENT_PER_LEVEL * getScaledLevel(tool, level);
        float avgCoefficient = bonus + 1f;
        float coefficient = avgCoefficient + (float) (RANDOM.nextGaussian() * 2 * bonus);
        return coefficient * damage;
    }
}
