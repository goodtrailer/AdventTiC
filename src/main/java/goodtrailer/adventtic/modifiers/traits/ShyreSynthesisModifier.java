package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class ShyreSynthesisModifier extends SingleUseModifier
{
    public static final int COLOR = 0x00CFEA;

    public ShyreSynthesisModifier()
    {
        super(COLOR);
    }
    
    @Override
    public int onDamageTool(IModifierToolStack toolStack, int level, int amount,
            LivingEntity holder)
    {
        if (!holder.level.isDay() || !holder.level.canSeeSky(holder.blockPosition()))
            return amount;
        
        return 0;
    }
}
