package goodtrailer.adventtic.fluids;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.fluids.AdventTiCFluids;
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
        for (FluidObject<ForgeFlowingFluid> molten : AdventTiCFluids.MOLTEN)
        {
            tag(molten.getLocalTag()).add(molten.getStill(), molten.getFlowing());
            tag(molten.getForgeTag()).addTag(molten.getLocalTag());
            tag(TinkerTags.Fluids.METAL_LIKE).addTag(molten.getForgeTag());
        }

        // TODO figure out spilling types
        for (FluidObject<ForgeFlowingFluid> molten : AdventTiCFluids.MOLTEN)
            tag(TinkerTags.Fluids.AVERAGE_METAL_SPILLING).addTag(molten.getForgeTag());
    }
}
