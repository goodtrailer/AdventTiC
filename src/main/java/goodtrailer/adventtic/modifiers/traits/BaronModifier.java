package goodtrailer.adventtic.modifiers.traits;

import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class BaronModifier extends SingleUseModifier
{
    public static final int COLOR = 0xCE0000;
    public static final int DAMAGE = 3;
    public static final float PROB = 0.2f;

    public BaronModifier()
    {
        super(COLOR);
    }
    
    @Override
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {
        return RANDOM.nextFloat() < PROB ? damage + DAMAGE : damage;
    }
}
