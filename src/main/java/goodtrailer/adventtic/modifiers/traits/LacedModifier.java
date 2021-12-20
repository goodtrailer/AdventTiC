package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class LacedModifier extends SingleUseModifier
{
    public static final int COLOR = 0x6BFFBE;
    public static final int DURATION = 3 * 20;

    public LacedModifier()
    {
        super(COLOR);
    }
    
    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity target = context.getLivingTarget();
        if (target.level.isClientSide)
            return 0;
        
        target.addEffect(new EffectInstance(Effects.POISON, DURATION));
        return 0;
    }
}
