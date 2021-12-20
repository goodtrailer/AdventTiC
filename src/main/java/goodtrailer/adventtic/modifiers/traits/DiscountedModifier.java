package goodtrailer.adventtic.modifiers.traits;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class DiscountedModifier extends Modifier
{
    public static final int COLOR = 0xFFB200;
    public static final float COEFFICIENT_PER_LEVEL = 0.2f;

    public DiscountedModifier()
    {
        super(COLOR);
    }
    
    @Override
    public float getRepairFactor(IModifierToolStack toolStack, int level, float factor)
    {
        return factor * (1f + COEFFICIENT_PER_LEVEL * level);
    }
}
