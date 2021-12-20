package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class BlazingModifier extends SingleUseModifier
{
    public static final int COLOR = 0x6B1919;
    public static final int DURATION = 3 * 20;

    public BlazingModifier()
    {
        super(COLOR);
    }
    
    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity attacker = context.getAttacker();
        if (attacker.level.isClientSide)
            return 0;
        
        Entity target = context.getTarget();
        target.setRemainingFireTicks(DURATION);
        return 0;
    }
}
