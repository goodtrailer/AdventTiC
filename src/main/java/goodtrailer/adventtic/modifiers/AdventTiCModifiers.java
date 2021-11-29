package goodtrailer.adventtic.modifiers;

import java.util.ArrayList;
import java.util.function.Supplier;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.modifiers.abilities.*;
import goodtrailer.adventtic.modifiers.traits.*;
import goodtrailer.adventtic.modifiers.upgrades.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public final class AdventTiCModifiers
{
    public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister
            .create(Modifier.class, AdventTiC.MOD_ID);

    public static final ArrayList<RegistryObject<Modifier>> ABILITIES = new ArrayList<RegistryObject<Modifier>>();
    public static final ArrayList<RegistryObject<Modifier>> TRAITS = new ArrayList<RegistryObject<Modifier>>();
    public static final ArrayList<RegistryObject<Modifier>> UPGRADES = new ArrayList<RegistryObject<Modifier>>();

    // Abilities
    public static final RegistryObject<Modifier> CREEPIFIED = ability("creepified",
            CreepifiedModifier::new);
    public static final RegistryObject<Modifier> MONEYBAGS = ability("moneybags",
            MoneybagsModifier::new);

    // Traits
    public static final RegistryObject<Modifier> ANTI_AIR = trait("anti_air",
            AntiAirModifier::new);
    public static final RegistryObject<Modifier> BARON = trait("baron",
            BaronModifier::new);
    public static final RegistryObject<Modifier> BLAZING = trait("blazing",
            BlazingModifier::new);
    public static final RegistryObject<Modifier> BONE_SHOCK = trait("bone_shock",
            BoneShockModifier::new);
    public static final RegistryObject<Modifier> COUNTERWEIGHT = trait("counterweight",
            CounterweightModifier::new);
    public static final RegistryObject<Modifier> DISCOUNTED = trait("discounted",
            DiscountedModifier::new);
    public static final RegistryObject<Modifier> EVIL_PRESSURE = trait("evil_pressure",
            EvilPressureModifier::new);
    public static final RegistryObject<Modifier> FLAMING_FURY = trait("flaming_fury",
            FlamingFuryModifier::new);
    public static final RegistryObject<Modifier> INFERNAL_ENERGY = trait("infernal_energy",
            InfernalEnergyModifier::new);
    public static final RegistryObject<Modifier> HIGH_IN_CALCIUM = trait("high_in_calcium",
            HighInCalciumModifier::new);
    public static final RegistryObject<Modifier> LACED = trait("laced",
            LacedModifier::new);
    public static final RegistryObject<Modifier> RUNIC = trait("runic",
            RunicModifier::new);
    public static final RegistryObject<Modifier> SHYRE_SYNTHESIS = trait("shyre_synthesis",
            ShyreSynthesisModifier::new);
    public static final RegistryObject<Modifier> SOUL_HARVEST = trait("soul_harvest",
            SoulHarvestModifier::new);
    public static final RegistryObject<Modifier> SOUL_SAP = trait("soul_sap",
            SoulSapModifier::new);
    public static final RegistryObject<Modifier> TOXIC = trait("toxic",
            ToxicModifier::new);
    public static final RegistryObject<Modifier> TWEETING = trait("tweeting",
            TweetingModifier::new);

    // Upgrades
    public static final RegistryObject<Modifier> AIR_BLADE = upgrade("air_blade",
            AirBladeModifier::new);
    public static final RegistryObject<Modifier> BUTCHERER = upgrade("butcherer",
            ButchererModifier::new);
    public static final RegistryObject<Modifier> REFREEZING = upgrade("refreezing",
            RefreezingModifier::new);
    public static final RegistryObject<Modifier> SURPRISE_ME = upgrade("surprise_me",
            SurpriseMeModifier::new);

    private static final <T extends Modifier> RegistryObject<Modifier> ability(String name,
            Supplier<T> sup)
    {
        RegistryObject<Modifier> m = MODIFIERS.register(name, sup);
        ABILITIES.add(m);
        return m;
    }

    private static final <T extends Modifier> RegistryObject<Modifier> trait(String name,
            Supplier<T> sup)
    {
        RegistryObject<Modifier> m = MODIFIERS.register(name, sup);
        TRAITS.add(m);
        return m;
    }

    private static final <T extends Modifier> RegistryObject<Modifier> upgrade(String name,
            Supplier<T> sup)
    {
        RegistryObject<Modifier> m = MODIFIERS.register(name, sup);
        UPGRADES.add(m);
        return m;
    }
}
