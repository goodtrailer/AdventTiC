package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundCategory;
import net.tslat.aoa3.common.registration.AoASounds;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class TweetingModifier extends Modifier
{
    public static final int COLOR = 0xFFE500;
    public static final float BREAK_PROB_PER_LEVEL = 0.2f;

    public TweetingModifier()
    {
        super(COLOR);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        Entity target = context.getTarget();
        if (target.level.isClientSide || context.isExtraAttack())
            return 0;
        
        target.level.playSound(null, target.getX(), target.getY(),
                target.getZ(), AoASounds.ENTITY_CHARGER_HURT.get(), SoundCategory.PLAYERS, 1.0f,
                1.0f);
        
        return 0;
    }

    @Override
    public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context)
    {
        LivingEntity entity = context.getLiving();
        if (entity.level.isClientSide || RANDOM.nextFloat() > BREAK_PROB_PER_LEVEL * level)
            return;

        entity.level.playSound(null, context.getTargetedPos(), AoASounds.ENTITY_CHARGER_HURT.get(),
                SoundCategory.PLAYERS, 1.0f, 1.0f);
    }
}
