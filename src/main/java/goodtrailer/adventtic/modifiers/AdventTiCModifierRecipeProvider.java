package goodtrailer.adventtic.modifiers;

import java.util.function.Consumer;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.tslat.aoa3.common.registration.AoAItems;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.recipe.modifiers.adding.IncrementalModifierRecipeBuilder;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

public class AdventTiCModifierRecipeProvider extends BaseRecipeProvider
{
    public static final String NAME = "AdventTiC Modifier Recipes";
    public static final String ABILITY_FOLDER = "tools/modifiers/ability/";
    public static final String UPGRADE_FOLDER = "tools/modifiers/upgrade/";
    public static final String ABILITY_SALVAGE_FOLDER = "tools/modifiers/salvage/ability/";
    public static final String UPGRADE_SALVAGE_FOLDER = "tools/modifiers/salvage/upgrade/";

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
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> con)
    {
        // Abilities
        // it is unstable after all...
        ability(con, AdventTiCModifiers.CREEPIFIED, 2, AoAItems.UNSTABLE_GUNPOWDER, 1, 0.2f);
        // gold is a pretty inert substance
        ability(con, AdventTiCModifiers.MONEYBAGS, 3, AoAItems.GOLD_COIN, 1, 0.9f);

        // Upgrades
        // the claw of a king charger wouldn't break that easily
        upgrade(con, AdventTiCModifiers.AIR_BLADE, 3, AoAItems.SHARP_CLAW, 1, 0.65f);
        // this is rock-hard crystallized blood, a little bit of water probably won't hurt
        incUpgrade(con, AdventTiCModifiers.BUTCHERER, 3, AoAItems.BLOODSTONE, 3, true);
        // all that scrubbing with a warm wet sponge, that ice is gonna melt :(
        incUpgrade(con, AdventTiCModifiers.REFREEZING, 3, AoAItems.ICE_CRYSTAL, 3, false);
        // plastic doesn't degrade easily, unfortunately
        incUpgrade(con, AdventTiCModifiers.SURPRISE_ME, 3, AoAItems.CONFETTI_PILE, 4, true);
    }

    private void ability(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            int maxLevel, RegistryObject<Item> item, int amount, float salvageChance)
    {
        modifier(con, modifier, maxLevel, item, amount, salvageChance, SlotType.ABILITY,
                ABILITY_FOLDER, ABILITY_SALVAGE_FOLDER);
    }

    private void upgrade(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> mod,
            int maxLevel, RegistryObject<Item> item, int amount, float salvageChance)
    {
        modifier(con, mod, maxLevel, item, amount, salvageChance, SlotType.UPGRADE, UPGRADE_FOLDER,
                UPGRADE_SALVAGE_FOLDER);
    }

    @SuppressWarnings("unused")
    private void incAbility(Consumer<IFinishedRecipe> con, RegistryObject<IncrementalModifier> inc,
            int maxLevel, RegistryObject<Item> item, int amount, boolean fullSalvage)
    {
        incremental(con, inc, maxLevel, item, amount, fullSalvage, SlotType.ABILITY, ABILITY_FOLDER,
                ABILITY_SALVAGE_FOLDER);
    }

    private void incUpgrade(Consumer<IFinishedRecipe> con, RegistryObject<IncrementalModifier> inc,
            int maxLevel, RegistryObject<Item> item, int amount, boolean fullSalvage)
    {
        incremental(con, inc, maxLevel, item, amount, fullSalvage, SlotType.UPGRADE, UPGRADE_FOLDER,
                UPGRADE_SALVAGE_FOLDER);
    }

    private void modifier(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> mod, int maxLevel,
            RegistryObject<Item> item, int amount, float salvageChance, SlotType slotType,
            String folder, String salvageFolder)
    {
        ModifierRecipeBuilder.modifier(mod.get())
                .setMaxLevel(maxLevel)
                .addInput(item.get(), amount)
                .addSalvage(item.get(), salvageChance)
                .setSlots(slotType, 1)
                .buildSalvage(con, prefix(mod, salvageFolder))
                .build(con, prefix(mod, folder));
    }

    private void incremental(Consumer<IFinishedRecipe> con, RegistryObject<IncrementalModifier> inc,
            int maxLevel, RegistryObject<Item> item, int amount, boolean fullSalvage,
            SlotType slotType, String folder, String salvageFolder)
    {
        IncrementalModifierRecipeBuilder.modifier(inc.get())
                .setMaxLevel(maxLevel)
                .setInput(item.get(), 1, amount)
                .setSalvage(item.get(), fullSalvage)
                .setSlots(slotType, 1)
                .buildSalvage(con, prefix(inc, salvageFolder))
                .build(con, prefix(inc, folder));
    }
}
