package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class BoneShockModifier extends SingleUseModifier
{
    public static final int COLOR = 0xFFE8A0;
    public static final int DAMAGE = 2;
    
    public BoneShockModifier()
    {
        super(COLOR);
    }
    
    @Override
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {
        LivingEntity target = context.getLivingTarget();
        return target.getMobType() != CreatureAttribute.ARTHROPOD ? damage + DAMAGE : damage;
    }
}
