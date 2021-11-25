package goodtrailer.adventtic.modifiers;

import java.util.function.Consumer;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.tags.AdventTiCItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.tslat.aoa3.common.registration.AoAItems;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

public class AdventTiCModifierRecipeProvider extends BaseRecipeProvider
{
    public static final String NAME = "AdventTiC Modifier Recipes";
    public static final String ABILITY_FOLDER = "tools/modifiers/ability/";
    public static final String UPGRADE_FOLDER = "tools/modifiers/upgrade/";

    public AdventTiCModifierRecipeProvider(DataGenerator gen)
    {
        super(gen);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    public String getModId()
    {
        return AdventTiC.MOD_ID;
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        buildAbilityRecipes(consumer);
        buildUpgradeRecipes(consumer);
    }

    private void buildAbilityRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ModifierRecipeBuilder.modifier(AdventTiCModifiers.CREEPIFIED.get())
                .addInput(AoAItems.UNSTABLE_GUNPOWDER.get(), 1)
                .setMaxLevel(2)
                .setSlots(SlotType.ABILITY, 1)
                .build(consumer, prefix(AdventTiCModifiers.CREEPIFIED, ABILITY_FOLDER));

        ModifierRecipeBuilder.modifier(AdventTiCModifiers.MONEYBAGS.get())
                .addInput(AoAItems.GOLD_COIN.get(), 1)
                .setMaxLevel(3)
                .setSlots(SlotType.ABILITY, 1)
                .build(consumer, prefix(AdventTiCModifiers.MONEYBAGS, ABILITY_FOLDER));
    }

    private void buildUpgradeRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ModifierRecipeBuilder.modifier(AdventTiCModifiers.AIR_BLADE.get())
                .addInput(AoAItems.SHARP_CLAW.get(), 1)
                .setMaxLevel(3)
                .setSlots(SlotType.UPGRADE, 1)
                .setTools(AdventTiCItemTags.SWEEP)
                .build(consumer, prefix(AdventTiCModifiers.AIR_BLADE, UPGRADE_FOLDER));

        ModifierRecipeBuilder.modifier(AdventTiCModifiers.BUTCHERER.get())
                .addInput(AoAItems.BLOODSTONE.get(), 3)
                .setMaxLevel(3)
                .setSlots(SlotType.UPGRADE, 1)
                .build(consumer, prefix(AdventTiCModifiers.BUTCHERER, UPGRADE_FOLDER));

        ModifierRecipeBuilder.modifier(AdventTiCModifiers.REFREEZING.get())
                .addInput(AoAItems.ICE_CRYSTAL.get(), 3)
                .setMaxLevel(3)
                .setSlots(SlotType.UPGRADE, 1)
                .build(consumer, prefix(AdventTiCModifiers.REFREEZING, UPGRADE_FOLDER));

        ModifierRecipeBuilder.modifier(AdventTiCModifiers.SURPRISE_ME.get())
                .addInput(AoAItems.CONFETTI_PILE.get(), 4)
                .setMaxLevel(3)
                .setSlots(SlotType.UPGRADE, 1)
                .build(consumer, prefix(AdventTiCModifiers.SURPRISE_ME, UPGRADE_FOLDER));

    }
}
