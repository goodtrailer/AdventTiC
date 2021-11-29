package goodtrailer.adventtic.smeltery;

import java.util.function.Consumer;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.fluids.AdventTiCFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;

public class AdventTiCCastingRecipeProvider extends BaseRecipeProvider
        implements ISmelteryRecipeHelper
{
    public static final String NAME = "AdventTiC Casting Recipes";
    public static final String FOLDER = "smeltery/casting/";

    public AdventTiCCastingRecipeProvider(DataGenerator gen)
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
        metal(con, AdventTiCFluids.MOLTEN_BARONYTE);
        metal(con, AdventTiCFluids.MOLTEN_BLAZIUM);
        metal(con, AdventTiCFluids.MOLTEN_ELECANIUM);
        metal(con, AdventTiCFluids.MOLTEN_EMBERSTONE);
        metal(con, AdventTiCFluids.MOLTEN_GHASTLY);
        metal(con, AdventTiCFluids.MOLTEN_GHOULISH);
        metal(con, AdventTiCFluids.MOLTEN_LIMONITE);
        metal(con, AdventTiCFluids.MOLTEN_LUNAR);
        metal(con, AdventTiCFluids.MOLTEN_LYON);
        metal(con, AdventTiCFluids.MOLTEN_MYSTITE);
        metal(con, AdventTiCFluids.MOLTEN_ROSITE);
        metal(con, AdventTiCFluids.MOLTEN_SHYRESTONE);
        metal(con, AdventTiCFluids.MOLTEN_SKELETAL);
        metal(con, AdventTiCFluids.MOLTEN_VARSIUM);
    }

    private void metal(Consumer<IFinishedRecipe> con, FluidObject<ForgeFlowingFluid> molten)
    {
        String mat = molten.getId().getPath().substring(AdventTiCFluids.MOLTEN_PREFIX.length());
        metalTagCasting(con, molten, mat, FOLDER, false);
    }
}
