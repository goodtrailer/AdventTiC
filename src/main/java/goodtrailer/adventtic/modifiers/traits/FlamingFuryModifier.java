package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class FlamingFuryModifier extends SingleUseModifier
{
    public static final int COLOR = 0xFF5D00;
    public static final int DAMAGE = 3;

    public FlamingFuryModifier()
    {
        super(COLOR);
    }
    
    @Override
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {
        LivingEntity attacker = context.getAttacker();
        return attacker.isOnFire() ? damage + DAMAGE : damage;
    }
}
