package goodtrailer.adventtic.fluids;

import java.util.ArrayList;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.materials.AdventTiCMaterials;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.ModelFluidAttributes;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public final class AdventTiCFluids
{
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(
            AdventTiC.MOD_ID);

    // Molten Fluids
    public static final ArrayList<FluidObject<ForgeFlowingFluid>> MOLTEN = new ArrayList<FluidObject<ForgeFlowingFluid>>();
    public static final String MOLTEN_PREFIX = "molten_";

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_BARONYTE = molten(
            AdventTiCMaterials.BARONYTE, 880);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_BLAZIUM = molten(
            AdventTiCMaterials.BLAZIUM, 1080);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_CHARGER = molten(
            AdventTiCMaterials.CHARGER, 450);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_ELECANIUM = molten(
            AdventTiCMaterials.ELECANIUM, 970);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_EMBERSTONE = molten(
            AdventTiCMaterials.EMBERSTONE, 1100);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_GHASTLY = molten(
            AdventTiCMaterials.GHASTLY, 690);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_GHOULISH = molten(
            AdventTiCMaterials.GHOULISH, 680);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LIMONITE = molten(
            AdventTiCMaterials.LIMONITE, 650);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LUNAR = molten(
            AdventTiCMaterials.LUNAR, 805);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LYON = molten(
            AdventTiCMaterials.LYON, 820);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_MYSTITE = molten(
            AdventTiCMaterials.MYSTITE, 730);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_ROSITE = molten(
            AdventTiCMaterials.ROSITE, 700);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_SHYRESTONE = molten(
            AdventTiCMaterials.SHYRESTONE, 660);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_SKELETAL = molten(
            AdventTiCMaterials.SKELETAL, 660);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_VARSIUM = molten(
            AdventTiCMaterials.VARSIUM, 750);

    private static final <T extends Fluid> FluidObject<ForgeFlowingFluid> molten(
            MaterialId material,
            int temperature)
    {
        FluidObject<ForgeFlowingFluid> f = FLUIDS.register(MOLTEN_PREFIX + material.getPath(),
                ModelFluidAttributes.builder()
                        .density(2000)
                        .viscosity(10000)
                        .temperature(temperature)
                        .sound(SoundEvents.BUCKET_FILL_LAVA,
                                SoundEvents.BUCKET_EMPTY_LAVA),
                Material.LAVA,
                12);
        MOLTEN.add(f);
        return f;
    }
}
