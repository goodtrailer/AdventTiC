package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class HighInCalciumModifier extends SingleUseModifier
{
    public static final int COLOR = 0xFAFA96;
    public static final float PROB = 1/3f;
    public static final float BONE_TO_BONE_MEAL_RATIO = 1/5f;
    
    private static final float bone_prob = BONE_TO_BONE_MEAL_RATIO / (BONE_TO_BONE_MEAL_RATIO + 1f);

    public HighInCalciumModifier()
    {
        super(COLOR);
    }
    
    @Override
    public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context)
    {
        LivingEntity entity = context.getLiving();
        if (entity.level.isClientSide || !context.isEffective() || RANDOM.nextFloat() > PROB)
            return;
        
        System.out.println("bone_prob -> " + bone_prob);
        
        BlockPos pos = context.getTargetedPos();
        Item item = RANDOM.nextFloat() < bone_prob ? Items.BONE : Items.BONE_MEAL;
        ItemStack stack = new ItemStack(item);
        ItemEntity drop = new ItemEntity(entity.level, pos.getX(), pos.getY(), pos.getZ(), stack);
        
        entity.level.addFreshEntity(drop);
    }
}
