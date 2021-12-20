package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.LivingEntity;
import net.tslat.aoa3.util.EntityUtil;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class AntiAirModifier extends Modifier
{
    public static final int COLOR = 0xCFF99F;
    public static final float DAMAGE_PER_LEVEL = 1.5f;

    public AntiAirModifier()
    {
        super(COLOR);
    }
    
    @Override
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {
        LivingEntity target = context.getLivingTarget();
        return EntityUtil.isFlyingCreature(target) ? damage + level * DAMAGE_PER_LEVEL : damage;
    }
}
