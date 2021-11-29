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
import slimeknights.tconstruct.common.registration.FluidDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public final class AdventTiCFluids
{
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegisterExtension(
            AdventTiC.MOD_ID);

    // Molten Fluids
    public static final ArrayList<FluidObject<ForgeFlowingFluid>> MOLTEN = new ArrayList<FluidObject<ForgeFlowingFluid>>();
    public static final String MOLTEN_PREFIX = "molten_";

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_BARONYTE = molten(
            AdventTiCMaterials.BARONYTE, 580);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_BLAZIUM = molten(
            AdventTiCMaterials.BLAZIUM, 780);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_CHARGER = molten(
            AdventTiCMaterials.CHARGER, 150);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_ELECANIUM = molten(
            AdventTiCMaterials.ELECANIUM, 670);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_EMBERSTONE = molten(
            AdventTiCMaterials.EMBERSTONE, 800);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_GHASTLY = molten(
            AdventTiCMaterials.GHASTLY, 390);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_GHOULISH = molten(
            AdventTiCMaterials.GHOULISH, 380);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LIMONITE = molten(
            AdventTiCMaterials.LIMONITE, 350);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LUNAR = molten(
            AdventTiCMaterials.LUNAR, 505);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_LYON = molten(
            AdventTiCMaterials.LYON, 520);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_MYSTITE = molten(
            AdventTiCMaterials.MYSTITE, 430);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_ROSITE = molten(
            AdventTiCMaterials.ROSITE, 400);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_SHYRESTONE = molten(
            AdventTiCMaterials.SHYRESTONE, 360);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_SKELETAL = molten(
            AdventTiCMaterials.SKELETAL, 360);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_VARSIUM = molten(
            AdventTiCMaterials.VARSIUM, 450);

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
