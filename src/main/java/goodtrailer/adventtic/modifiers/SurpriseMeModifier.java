package goodtrailer.adventtic.modifiers;

import java.util.Random;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class SurpriseMeModifier extends Modifier
{
    public static final int COLOR = 0xF200FF;
    public static final float BONUS_PER_LEVEL = 0.08f;
    
    private Random rng;

    public SurpriseMeModifier()
    {
        super(COLOR);
        rng = new Random();
    }

    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {        
        float bonus = BONUS_PER_LEVEL * level;
        float avgCoefficient = bonus + 1f;
        float coefficient = avgCoefficient + (float)(rng.nextGaussian() * 2 * bonus);
        return coefficient * damage;
    }
}
