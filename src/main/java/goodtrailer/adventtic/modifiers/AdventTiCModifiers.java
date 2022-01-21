package goodtrailer.adventtic.modifiers;

import java.util.function.Supplier;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.modifiers.abilities.*;
import goodtrailer.adventtic.modifiers.traits.*;
import goodtrailer.adventtic.modifiers.upgrades.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.IncrementalModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;

public final class AdventTiCModifiers
{
    public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister
            .create(Modifier.class, AdventTiC.MOD_ID);

    // Abilities
    public static final RegistryObject<Modifier> CREEPIFIED = mod("creepified",
            CreepifiedModifier::new);
    public static final RegistryObject<Modifier> MONEYBAGS = mod("moneybags",
            MoneybagsModifier::new);

    // Traits
    public static final RegistryObject<Modifier> ANTI_AIR = mod("anti_air",
            AntiAirModifier::new);
    public static final RegistryObject<Modifier> BARON = mod("baron",
            BaronModifier::new);
    public static final RegistryObject<Modifier> BLAZING = mod("blazing",
            BlazingModifier::new);
    public static final RegistryObject<Modifier> BONE_SHOCK = mod("bone_shock",
            BoneShockModifier::new);
    public static final RegistryObject<Modifier> COUNTERWEIGHT = mod("counterweight",
            CounterweightModifier::new);
    public static final RegistryObject<Modifier> DISCOUNTED = mod("discounted",
            DiscountedModifier::new);
    public static final RegistryObject<Modifier> EVIL_PRESSURE = mod("evil_pressure",
            EvilPressureModifier::new);
    public static final RegistryObject<Modifier> FLAMING_FURY = mod("flaming_fury",
            FlamingFuryModifier::new);
    public static final RegistryObject<Modifier> INFERNAL_ENERGY = mod("infernal_energy",
            InfernalEnergyModifier::new);
    public static final RegistryObject<Modifier> HIGH_IN_CALCIUM = mod("high_in_calcium",
            HighInCalciumModifier::new);
    public static final RegistryObject<Modifier> LACED = mod("laced",
            LacedModifier::new);
    public static final RegistryObject<Modifier> RUNIC = mod("runic",
            RunicModifier::new);
    public static final RegistryObject<Modifier> SHYRE_SYNTHESIS = mod("shyre_synthesis",
            ShyreSynthesisModifier::new);
    public static final RegistryObject<Modifier> SOUL_HARVEST = mod("soul_harvest",
            SoulHarvestModifier::new);
    public static final RegistryObject<Modifier> SOUL_SAP = mod("soul_sap",
            SoulSapModifier::new);
    public static final RegistryObject<Modifier> TOXIC = mod("toxic",
            ToxicModifier::new);
    public static final RegistryObject<Modifier> TWEETING = mod("tweeting",
            TweetingModifier::new);

    // Upgrades
    public static final RegistryObject<Modifier> AIR_BLADE = mod("air_blade",
            AirBladeModifier::new);
    public static final RegistryObject<IncrementalModifier> BUTCHERER = mod("butcherer",
            ButchererModifier::new);
    public static final RegistryObject<IncrementalModifier> REFREEZING = mod("refreezing",
            RefreezingModifier::new);
    public static final RegistryObject<IncrementalModifier> SURPRISE_ME = mod("surprise_me",
            SurpriseMeModifier::new);

    private static final <T extends Modifier> RegistryObject<T> mod( String name, Supplier<T> sup)
    {
        RegistryObject<T> m = MODIFIERS.register(name, sup);
        return m;
    }
}
