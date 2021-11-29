package goodtrailer.adventtic.items;

import com.google.gson.JsonObject;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.fluids.AdventTiCFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.versions.forge.ForgeVersion;
import slimeknights.mantle.registration.object.FluidObject;

public class AdventTiCItemModelProvider extends ItemModelProvider
{
    public static final String NAME = "AdventTiC Item Models";
    public static final ResourceLocation BUCKET_LOADER = new ResourceLocation(ForgeVersion.MOD_ID,
            "bucket");
    public static final ResourceLocation BUCKET_DRIP = new ResourceLocation(ForgeVersion.MOD_ID,
            "item/bucket_drip");

    public AdventTiCItemModelProvider(DataGenerator gen, ExistingFileHelper efh)
    {
        super(gen, AdventTiC.MOD_ID, efh);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void registerModels()
    {
        for (FluidObject<ForgeFlowingFluid> molten : AdventTiCFluids.MOLTEN)
            bucket(molten);
    }

    private void bucket(FluidObject<ForgeFlowingFluid> fluid)
    {
        Item bucket = fluid.get().getBucket();

        ItemModelBuilder builder = getBuilder(bucket.getRegistryName().getPath());
        builder.customLoader(
                (p, e) -> new CustomLoaderBuilder<ItemModelBuilder>(BUCKET_LOADER, p, e)
                {
                    public JsonObject toJson(JsonObject json)
                    {
                        super.toJson(json).addProperty("fluid", fluid.getId().toString());
                        return json;
                    }
                }
        );
        builder.parent(getExistingFile(BUCKET_DRIP));
    }
}
