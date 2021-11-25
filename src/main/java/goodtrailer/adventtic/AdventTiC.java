package goodtrailer.adventtic;

import goodtrailer.adventtic.tags.*;
import goodtrailer.adventtic.lang.*;
import goodtrailer.adventtic.materials.*;
import goodtrailer.adventtic.modifiers.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.tconstruct.common.data.tags.BlockTagProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

@Mod(AdventTiC.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdventTiC
{
    public static final String MOD_ID = "adventtic";
    public static final String MOD_NAME = "AdventTiC";

    public AdventTiC()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

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
            gen.addProvider(new AdventTiCEnglishProvider(gen));

            AdventTiCMaterialSpriteProvider materialSprite = new AdventTiCMaterialSpriteProvider();
            TinkerPartSpriteProvider partSprite = new TinkerPartSpriteProvider();
            gen.addProvider(new AdventTiCMaterialRenderInfoProvider(gen, materialSprite));
            gen.addProvider(new MaterialPartTextureGenerator(gen, efh, partSprite, materialSprite));
        }
        
        if (e.includeServer())
        {
            gen.addProvider(new AdventTiCModifierRecipeProvider(gen));

            BlockTagProvider btp = new BlockTagProvider(gen, efh);
            gen.addProvider(new AdventTiCItemTagsProvider(gen, btp, efh));

            AdventTiCMaterialProvider material = new AdventTiCMaterialProvider(gen);
            gen.addProvider(material);
            gen.addProvider(new AdventTiCMaterialStatsProvider(gen, material));
            gen.addProvider(new AdventTiCMaterialTraitsProvider(gen, material));
        }
    }
}
