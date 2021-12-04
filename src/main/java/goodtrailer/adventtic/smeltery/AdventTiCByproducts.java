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
    public static final ArrayList<Byproduct> BARATHOS = new ArrayList<Byproduct>();
    public static final ArrayList<Byproduct> GRECKON = new ArrayList<Byproduct>();
    public static final ArrayList<Byproduct> OVERWORLD = new ArrayList<Byproduct>();
    public static final ArrayList<Byproduct> SHYRELANDS = new ArrayList<Byproduct>();

    // Barathos
    public static final Byproduct BARONYTE = barathos(AdventTiCFluids.MOLTEN_BARONYTE);
    public static final Byproduct BLAZIUM = barathos(AdventTiCFluids.MOLTEN_BLAZIUM);
    public static final Byproduct VARSIUM = barathos(AdventTiCFluids.MOLTEN_VARSIUM);

    // Greckon
    public static final Byproduct GHOULISH = greckon(AdventTiCFluids.MOLTEN_GHOULISH);
    public static final Byproduct GHASTLY = greckon(AdventTiCFluids.MOLTEN_GHASTLY);

    // Overworld
    public static final Byproduct LIMONITE = overworld(AdventTiCFluids.MOLTEN_LIMONITE);
    public static final Byproduct ROSITE = overworld(AdventTiCFluids.MOLTEN_ROSITE);

    // Shyrelands :) i wonder what this is for
    public static final Byproduct SHYRESTONE_SMALL = shyre(AdventTiCFluids.MOLTEN_SHYRESTONE, 1);
    public static final Byproduct SHYRESTONE = shyre(AdventTiCFluids.MOLTEN_SHYRESTONE, 2);

    private static Byproduct barathos(FluidObject<ForgeFlowingFluid> molten, int... amount)
    {
        return amount.length > 0 ? byproduct(molten, amount[0], BARATHOS)
                : byproduct(molten, null, BARATHOS);
    }

    private static Byproduct greckon(FluidObject<ForgeFlowingFluid> molten, int... amount)
    {
        return amount.length > 0 ? byproduct(molten, amount[0], GRECKON)
                : byproduct(molten, null, GRECKON);
    }

    private static Byproduct overworld(FluidObject<ForgeFlowingFluid> molten, int... amount)
    {
        return amount.length > 0 ? byproduct(molten, amount[0], OVERWORLD)
                : byproduct(molten, null, OVERWORLD);
    }

    private static Byproduct shyre(FluidObject<ForgeFlowingFluid> molten, int... amount)
    {
        return amount.length > 0 ? byproduct(molten, amount[0], SHYRELANDS)
                : byproduct(molten, null, SHYRELANDS);
    }

    @SafeVarargs
    private static Byproduct byproduct(FluidObject<ForgeFlowingFluid> molten, Integer amount,
            ArrayList<Byproduct>... lists)
    {
        Byproduct b = amount == null ? new Byproduct(molten) : new Byproduct(molten, amount);
        for (int i = 0; i < lists.length; i++)
            lists[i].add(b);
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
