package goodtrailer.adventtic.modifiers;

import java.util.function.Consumer;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.tslat.aoa3.common.registration.AoAItems;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.modifiers.Modifier;
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
        // this is rock-hard crystallized blood, a little bit of water won't hurt
        upgrade(con, AdventTiCModifiers.BUTCHERER, 3, AoAItems.BLOODSTONE, 3, 2, 3);
        // all that scrubbing with a warm wet sponge, that ice is gonna melt :(
        upgrade(con, AdventTiCModifiers.REFREEZING, 3, AoAItems.ICE_CRYSTAL, 3, 0.8f);
        // plastic doesn't degrade easily, unfortunately
        upgrade(con, AdventTiCModifiers.SURPRISE_ME, 3, AoAItems.CONFETTI_PILE, 4, 3, 4);
    }

    @SuppressWarnings("unused")
    private void ability(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            int maxLevel, RegistryObject<Item> item, int amount, int minSalvage, int maxSalvage)
    {
        modifier(con, modifier, maxLevel, item, amount, SlotType.ABILITY, ABILITY_FOLDER);
        salvage(con, modifier, item, minSalvage, maxSalvage, SlotType.ABILITY,
                ABILITY_SALVAGE_FOLDER);
    }

    private void ability(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            int maxLevel, RegistryObject<Item> item, int amount, float salvageChance)
    {
        modifier(con, modifier, maxLevel, item, amount, SlotType.ABILITY, ABILITY_FOLDER);
        salvage(con, modifier, item, salvageChance, SlotType.ABILITY, ABILITY_SALVAGE_FOLDER);
    }

    private void upgrade(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            int maxLevel, RegistryObject<Item> item, int amount, int minSalvage, int maxSalvage)
    {
        modifier(con, modifier, maxLevel, item, amount, SlotType.UPGRADE, UPGRADE_FOLDER);
        salvage(con, modifier, item, minSalvage, maxSalvage, SlotType.UPGRADE,
                UPGRADE_SALVAGE_FOLDER);
    }

    private void upgrade(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            int maxLevel, RegistryObject<Item> item, int amount, float salvageChance)
    {
        modifier(con, modifier, maxLevel, item, amount, SlotType.UPGRADE, UPGRADE_FOLDER);
        salvage(con, modifier, item, salvageChance, SlotType.UPGRADE, UPGRADE_SALVAGE_FOLDER);
    }

    private void salvage(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            RegistryObject<Item> item, int minAmount, int maxAmount, SlotType slotType,
            String salvageFolder)
    {
        ModifierRecipeBuilder.modifier(modifier.get())
                .addSalvage(item.get(), minAmount, maxAmount)
                .setSlots(slotType, 1)
                .buildSalvage(con, prefix(modifier, salvageFolder));
    }

    private void salvage(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            RegistryObject<Item> item, float chance, SlotType slotType, String salvageFolder)
    {
        ModifierRecipeBuilder.modifier(modifier.get())
                .addSalvage(item.get(), chance)
                .setSlots(slotType, 1)
                .buildSalvage(con, prefix(modifier, salvageFolder));
    }

    private void modifier(Consumer<IFinishedRecipe> con, RegistryObject<Modifier> modifier,
            int maxLevel, RegistryObject<Item> item, int amount, SlotType slotType, String folder)
    {
        ModifierRecipeBuilder.modifier(modifier.get())
                .setMaxLevel(maxLevel)
                .addInput(item.get(), amount)
                .setSlots(slotType, 1)
                .build(con, prefix(modifier, folder));
    }
}
