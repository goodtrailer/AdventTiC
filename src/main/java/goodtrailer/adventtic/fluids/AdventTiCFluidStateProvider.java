package goodtrailer.adventtic.fluids;

import com.google.gson.JsonObject;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.Mantle;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.TConstruct;

public class AdventTiCFluidStateProvider extends BlockStateProvider
{
    public static final String NAME = "AdventTiC Fluid States";
    public static final String FOLDER = ModelProvider.BLOCK_FOLDER + "/fluid/";
    public static final ResourceLocation FLUID_TEXTURE_LOADER = Mantle.getResource("fluid_texture");

    public static final FluidTextures MOLTEN = new FluidTextures(
            FOLDER + "molten/still",
            FOLDER + "molten/flowing");
    public static final FluidTextures SHINY = new FluidTextures(
            FOLDER + "molten_shiny/still",
            FOLDER + "molten_shiny/flowing");
    public static final FluidTextures TRANSPARENT = new FluidTextures(
            FOLDER + "molten_transparent/still",
            FOLDER + "molten_transparent/flowing");

    public AdventTiCFluidStateProvider(DataGenerator gen, ExistingFileHelper efh)
    {
        super(gen, AdventTiC.MOD_ID, efh);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void registerStatesAndModels()
    {
        fluid(AdventTiCFluids.MOLTEN_BARONYTE, MOLTEN, 0xE86645);
        fluid(AdventTiCFluids.MOLTEN_BLAZIUM, MOLTEN, 0xE5A442);
        fluid(AdventTiCFluids.MOLTEN_CHARGER, MOLTEN, 0xDEC600);
        fluid(AdventTiCFluids.MOLTEN_ELECANIUM, SHINY, 0x28CF62);
        fluid(AdventTiCFluids.MOLTEN_EMBERSTONE, MOLTEN, 0xEE4747);
        fluid(AdventTiCFluids.MOLTEN_GHASTLY, TRANSPARENT, 0xA4C95E);
        fluid(AdventTiCFluids.MOLTEN_GHOULISH, TRANSPARENT, 0x7FAAFF);
        fluid(AdventTiCFluids.MOLTEN_LIMONITE, MOLTEN, 0xEA9554);
        fluid(AdventTiCFluids.MOLTEN_LUNAR, SHINY, 0xA5309F);
        fluid(AdventTiCFluids.MOLTEN_LYON, MOLTEN, 0xE8B63A);
        fluid(AdventTiCFluids.MOLTEN_MYSTITE, MOLTEN, 0xB5FFC6);
        fluid(AdventTiCFluids.MOLTEN_ROSITE, MOLTEN, 0xF46C5A);
        fluid(AdventTiCFluids.MOLTEN_SHYRESTONE, SHINY, 0xA3EDFF);
        fluid(AdventTiCFluids.MOLTEN_SKELETAL, MOLTEN, 0x8C7F6B);
        fluid(AdventTiCFluids.MOLTEN_VARSIUM, MOLTEN, 0xDDC15A);
    }

    private void fluid(FluidObject<ForgeFlowingFluid> fluid, FluidTextures textures, int color)
    {
        FlowingFluidBlock block = fluid.getBlock();

        BlockModelBuilder builder = models().getBuilder(block.getRegistryName().getPath());
        builder.customLoader(
                (p, e) -> new CustomLoaderBuilder<BlockModelBuilder>(FLUID_TEXTURE_LOADER, p, e)
                {
                    public JsonObject toJson(JsonObject json)
                    {
                        super.toJson(json).addProperty("color", String.format("%06X", color));
                        return json;
                    }
                }
        );
        builder.texture("still", textures.still).texture("flowing", textures.flowing);

        simpleBlock(block, builder);
    }

    public static class FluidTextures
    {
        public ResourceLocation still;
        public ResourceLocation flowing;

        private FluidTextures(ResourceLocation still, ResourceLocation flowing)
        {
            this.still = still;
            this.flowing = flowing;
        }

        private FluidTextures(String stillPath, String flowingPath)
        {
            this(TConstruct.getResource(stillPath), TConstruct.getResource(flowingPath));
        }
    }
}
