package goodtrailer.adventtic.modifiers.upgrades;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.tslat.aoa3.util.WorldUtil;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;

public class RefreezingModifier extends IncrementalModifier
{
    public static final int COLOR = 0xCEFDFF;
    public static final float MAX_TEMP = 0.15f;
    public static final float PROB_PER_LEVEL = 1 / 12f;
    public static final float SELECTED_COEFFICIENT = 2f;

    public RefreezingModifier()
    {
        super(COLOR);
    }

    @Override
    public void onInventoryTick(IModifierToolStack tool, int level, World world,
            LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot,
            ItemStack stack)
    {
        if (world.isClientSide || holder.tickCount % 20 != 0 || tool.getDamage() <= 0)
            return;

        float repairProb = getScaledLevel(tool, level) * PROB_PER_LEVEL;
        if (isSelected)
            repairProb *= SELECTED_COEFFICIENT;

        float temp = WorldUtil.getAmbientTemperature(world, holder.blockPosition());
        if (RANDOM.nextFloat() < repairProb && temp < MAX_TEMP && !tool.isBroken())
            ToolDamageUtil.repair(tool, 1);
    }
}
