package goodtrailer.adventtic;

import goodtrailer.adventtic.fluids.*;
import goodtrailer.adventtic.items.*;
import goodtrailer.adventtic.lang.*;
import goodtrailer.adventtic.materials.*;
import goodtrailer.adventtic.modifiers.*;
import goodtrailer.adventtic.smeltery.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.common.data.tags.BlockTagProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

@Mod(AdventTiC.MOD_ID)
@EventBusSubscriber(bus = Bus.MOD)
public class AdventTiC
{
    public static final String MOD_ID = "adventtic";
    public static final String MOD_NAME = "AdventTiC";

    public AdventTiC()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        AdventTiCFluids.FLUIDS.register(bus);
        AdventTiCModifiers.MODIFIERS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation getResource(String name)
    {
        return new ResourceLocation(MOD_ID, name);
    }

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e)
    {
        DataGenerator gen = e.getGenerator();
        ExistingFileHelper efh = e.getExistingFileHelper();

        if (e.includeClient())
        {
            gen.addProvider(new AdventTiCChineseProvider(gen));
            gen.addProvider(new AdventTiCEnglishProvider(gen));
            
            gen.addProvider(new AdventTiCFluidStateProvider(gen, efh));
            gen.addProvider(new AdventTiCItemModelProvider(gen, efh));

            AdventTiCMaterialSpriteProvider msp = new AdventTiCMaterialSpriteProvider();
            TinkerPartSpriteProvider psp = new TinkerPartSpriteProvider();
            gen.addProvider(new AdventTiCMaterialRenderInfoProvider(gen, msp));
            gen.addProvider(new MaterialPartTextureGenerator(gen, efh, psp, msp));
        }

        if (e.includeServer())
        {
            gen.addProvider(new AdventTiCCastingRecipeProvider(gen));
            gen.addProvider(new AdventTiCMaterialRecipeProvider(gen));
            gen.addProvider(new AdventTiCMeltingRecipeProvider(gen));
            gen.addProvider(new AdventTiCModifierRecipeProvider(gen));

            BlockTagProvider btp = new BlockTagProvider(gen, efh);
            gen.addProvider(new AdventTiCItemTagsProvider(gen, btp, efh));
            gen.addProvider(new AdventTiCFluidTagsProvider(gen, efh));

            AdventTiCMaterialProvider mat = new AdventTiCMaterialProvider(gen);
            gen.addProvider(mat);
            gen.addProvider(new AdventTiCMaterialStatsProvider(gen, mat));
            gen.addProvider(new AdventTiCMaterialTraitsProvider(gen, mat));
        }
    }
}
