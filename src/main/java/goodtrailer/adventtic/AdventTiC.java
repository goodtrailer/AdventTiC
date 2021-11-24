package goodtrailer.adventtic;

import goodtrailer.adventtic.modifiers.AdventTiCModifiers;
import goodtrailer.adventtic.tags.AdventTiCItemTagsProvider;
import goodtrailer.adventtic.modifiers.AdventTiCModifierLanguageProvider;
import goodtrailer.adventtic.modifiers.AdventTiCModifierRecipeProvider;
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
        BlockTagProvider btp = new BlockTagProvider(gen, efh);
        
        if (e.includeClient())
        {
            gen.addProvider(new AdventTiCModifierLanguageProvider(gen));
        }
        if (e.includeServer())
        {
            gen.addProvider(new AdventTiCModifierRecipeProvider(gen));
            gen.addProvider(new AdventTiCItemTagsProvider(gen, btp, efh));
        }
    }
}
