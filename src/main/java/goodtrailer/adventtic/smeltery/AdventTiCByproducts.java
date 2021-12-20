package goodtrailer.adventtic.smeltery;

import java.util.ArrayList;
import java.util.function.Supplier;

import goodtrailer.adventtic.fluids.AdventTiCFluids;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.data.recipe.IByproduct;
import slimeknights.tconstruct.library.recipe.FluidValues;

public final class AdventTiCByproducts
{
    public static final ArrayList<Byproduct> BYPRODUCTS = new ArrayList<Byproduct>();

    // Barathos
    public static final Byproduct BARONYTE = byproduct(AdventTiCFluids.MOLTEN_BARONYTE);
    public static final Byproduct BLAZIUM = byproduct(AdventTiCFluids.MOLTEN_BLAZIUM);
    public static final Byproduct VARSIUM = byproduct(AdventTiCFluids.MOLTEN_VARSIUM);

    // Greckon
    public static final Byproduct GHOULISH = byproduct(AdventTiCFluids.MOLTEN_GHOULISH);
    public static final Byproduct GHASTLY = byproduct(AdventTiCFluids.MOLTEN_GHASTLY);

    // Overworld
    public static final Byproduct LIMONITE = byproduct(AdventTiCFluids.MOLTEN_LIMONITE);
    public static final Byproduct ROSITE = byproduct(AdventTiCFluids.MOLTEN_ROSITE);

    // Shyrelands :) i wonder what this is for
    public static final Byproduct SHYRESTONE_LESS = byproduct(AdventTiCFluids.MOLTEN_SHYRESTONE, 1);
    public static final Byproduct SHYRESTONE = byproduct(AdventTiCFluids.MOLTEN_SHYRESTONE, 2);

    @SafeVarargs
    private static Byproduct byproduct(FluidObject<ForgeFlowingFluid> molten, int... amount)
    {
        Byproduct b = amount.length > 0 ? new Byproduct(molten, amount[0]) : new Byproduct(molten);
        BYPRODUCTS.add(b);
        return b;
    }

    public static class Byproduct implements IByproduct
    {
        public static final int DEFAULT_AMOUNT = FluidValues.NUGGET * 3;

        private final String name;
        private final Supplier<? extends Fluid> fluidSupplier;
        private final int amount;

        Byproduct(Supplier<? extends Fluid> moltenSupplier, int amount)
        {
            String moltenName = moltenSupplier.get().getRegistryName().getPath();
            name = moltenName.substring(AdventTiCFluids.MOLTEN_PREFIX.length());
            this.fluidSupplier = moltenSupplier;
            this.amount = amount;
        }

        Byproduct(Supplier<? extends Fluid> moltenSupplier)
        {
            this(moltenSupplier, DEFAULT_AMOUNT);
        }

        @Override
        public Fluid getFluid()
        {
            return fluidSupplier.get();
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public boolean isAlwaysPresent()
        {
            return true;
        }

        @Override
        public int getNuggets()
        {
            return amount;
        }
    }
}
