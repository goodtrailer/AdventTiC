package goodtrailer.adventtic.fluids;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.TinkerTags;

public class AdventTiCFluidTagsProvider extends FluidTagsProvider
{
    public static final String NAME = "AdventTiC Fluid Tags";

    public AdventTiCFluidTagsProvider(DataGenerator gen, ExistingFileHelper efh)
    {
        super(gen, AdventTiC.MOD_ID, efh);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addTags()
    {
        cheap(AdventTiCFluids.MOLTEN_LIMONITE);
        cheap(AdventTiCFluids.MOLTEN_ROSITE);
        cheap(AdventTiCFluids.MOLTEN_CHARGER);

        average(AdventTiCFluids.MOLTEN_BARONYTE);
        average(AdventTiCFluids.MOLTEN_BLAZIUM);
        average(AdventTiCFluids.MOLTEN_EMBERSTONE);
        average(AdventTiCFluids.MOLTEN_LYON);
        average(AdventTiCFluids.MOLTEN_MYSTITE);
        average(AdventTiCFluids.MOLTEN_SKELETAL);
        average(AdventTiCFluids.MOLTEN_VARSIUM);

        expensive(AdventTiCFluids.MOLTEN_ELECANIUM);
        expensive(AdventTiCFluids.MOLTEN_GHASTLY);
        expensive(AdventTiCFluids.MOLTEN_GHOULISH);
        expensive(AdventTiCFluids.MOLTEN_LUNAR);
        expensive(AdventTiCFluids.MOLTEN_SHYRESTONE);
    }
    
    private void cheap(FluidObject<ForgeFlowingFluid> fluid)
    {
        fluid(fluid);
        tag(TinkerTags.Fluids.CHEAP_METAL_SPILLING).addTag(fluid.getForgeTag());
    }
    
    private void average(FluidObject<ForgeFlowingFluid> fluid)
    {
        fluid(fluid);
        tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING).addTag(fluid.getForgeTag());
    }
    
    private void expensive(FluidObject<ForgeFlowingFluid> fluid)
    {
        fluid(fluid);
        tag(TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING).addTag(fluid.getForgeTag());
    }
    
    private void fluid(FluidObject<ForgeFlowingFluid> fluid)
    {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
        tag(fluid.getForgeTag()).addTag(fluid.getLocalTag());
        tag(TinkerTags.Fluids.METAL_LIKE).addTag(fluid.getForgeTag());
    }
}
