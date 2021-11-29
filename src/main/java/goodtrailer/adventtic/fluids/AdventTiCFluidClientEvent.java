package goodtrailer.adventtic.fluids;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.ClientEventBase;

@EventBusSubscriber(bus = Bus.MOD, modid = AdventTiC.MOD_ID, value = Dist.CLIENT)
public class AdventTiCFluidClientEvent extends ClientEventBase
{
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent e)
    {
        transparent(AdventTiCFluids.MOLTEN_GHASTLY);
        transparent(AdventTiCFluids.MOLTEN_GHOULISH);
    }

    private static void transparent(FluidObject<ForgeFlowingFluid> fluid)
    {
        RenderTypeLookup.setRenderLayer(fluid.getStill(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(fluid.getFlowing(), RenderType.translucent());
    }
}
