package goodtrailer.adventtic.materials;

import java.util.function.Consumer;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.fluids.AdventTiCFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.material.MaterialFluidRecipeBuilder;
import slimeknights.tconstruct.library.recipe.melting.MaterialMeltingRecipeBuilder;

public class AdventTiCMaterialRecipeProvider extends BaseRecipeProvider
        implements IMaterialRecipeHelper
{
    public static final String NAME = "AdventTiC Material Recipes";
    public static final String FOLDER = "tools/materials/";

    public AdventTiCMaterialRecipeProvider(DataGenerator gen)
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
        buildItems(con);
        buildMeltingCasting(con);
    }

    private void buildItems(Consumer<IFinishedRecipe> con)
    {
        for (MaterialId general : AdventTiCMaterials.GENERAL)
            materialItem(con, general);
        for (MaterialId harvest : AdventTiCMaterials.HARVEST)
            materialItem(con, harvest);
        for (MaterialId weapon : AdventTiCMaterials.WEAPON)
            materialItem(con, weapon);
    }

    private void buildMeltingCasting(Consumer<IFinishedRecipe> con)
    {
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_BARONYTE);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_BLAZIUM);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_ELECANIUM);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_EMBERSTONE);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_GHASTLY);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_GHOULISH);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_LIMONITE);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_LUNAR);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_LYON);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_MYSTITE);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_ROSITE);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_SHYRESTONE);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_SKELETAL);
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_VARSIUM);

        // ??? normally it subtracts by 300, not sure what to do here so I just did what
        // the temperature of melting an (imaginary) ingot, which is ~75
        int temp = (int) Math.pow(2.0, Math.log(1 * FluidValues.INGOT / 20) / Math.log(9)) * 40;
        materialMeltingCasting(con, AdventTiCFluids.MOLTEN_CHARGER, temp, 1 * FluidValues.INGOT);
    }

    private void materialItem(Consumer<IFinishedRecipe> con, MaterialId material)
    {
        metalMaterialRecipe(con, material, FOLDER, material.getPath(), true);
    }

    private void materialMeltingCasting(Consumer<IFinishedRecipe> con,
            FluidObject<ForgeFlowingFluid> molten, int temperature, int amount)
    {
        String name = molten.getId().getPath().substring(AdventTiCFluids.MOLTEN_PREFIX.length());
        MaterialId mat = new MaterialId(AdventTiC.getResource(name));

        MaterialFluidRecipeBuilder.material(mat)
                .setFluid(molten.getForgeTag(), amount)
                .setTemperature(temperature)
                .build(con, modResource(FOLDER + "casting/" + mat.getPath()));
        MaterialMeltingRecipeBuilder
                .material(mat, temperature, new FluidStack(molten.get(), amount))
                .build(con, modResource(FOLDER + "melting/" + mat.getPath()));
    }

    private void materialMeltingCasting(Consumer<IFinishedRecipe> con,
            FluidObject<ForgeFlowingFluid> molten)
    {
        String name = molten.getId().getPath().substring(AdventTiCFluids.MOLTEN_PREFIX.length());
        MaterialId mat = new MaterialId(AdventTiC.getResource(name));

        materialMeltingCasting(con, mat, molten, true, FOLDER);
    }
}
