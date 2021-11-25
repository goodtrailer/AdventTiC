package goodtrailer.adventtic.modifiers;

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

    // Abilities
    public static final RegistryObject<Modifier> CREEPIFIED = modifier("creepified",
            CreepifiedModifier::new);

    public static final RegistryObject<Modifier> MONEYBAGS = modifier("moneybags",
            MoneybagsModifier::new);

    // Traits
    public static final RegistryObject<Modifier> ANTI_AIR = modifier("anti_air",
            AntiAirModifier::new);
    public static final RegistryObject<Modifier> BARON = modifier("baron",
            BaronModifier::new);
    public static final RegistryObject<Modifier> BLAZING = modifier("blazing",
            BlazingModifier::new);
    public static final RegistryObject<Modifier> BONE_SHOCK = modifier("bone_shock",
            BoneShockModifier::new);
    public static final RegistryObject<Modifier> COUNTERWEIGHT = modifier("counterweight",
            CounterweightModifier::new);
    public static final RegistryObject<Modifier> DISCOUNTED = modifier("discounted",
            DiscountedModifier::new);
    public static final RegistryObject<Modifier> EVIL_PRESSURE = modifier("evil_pressure",
            EvilPressureModifier::new);
    public static final RegistryObject<Modifier> FLAMING_FURY = modifier("flaming_fury",
            FlamingFuryModifier::new);
    public static final RegistryObject<Modifier> INFERNAL_ENERGY = modifier("infernal_energy",
            InfernalEnergyModifier::new);
    public static final RegistryObject<Modifier> HIGH_IN_CALCIUM = modifier("high_in_calcium",
            HighInCalciumModifier::new);
    public static final RegistryObject<Modifier> LACED = modifier("laced",
            LacedModifier::new);
    public static final RegistryObject<Modifier> RUNIC = modifier("runic",
            RunicModifier::new);
    public static final RegistryObject<Modifier> SHYRE_SYNTHESIS = modifier("shyre_synthesis",
            ShyreSynthesisModifier::new);
    public static final RegistryObject<Modifier> SOUL_HARVEST = modifier("soul_harvest",
            SoulHarvestModifier::new);
    public static final RegistryObject<Modifier> SOUL_SAP = modifier("soul_sap",
            SoulSapModifier::new);
    public static final RegistryObject<Modifier> TOXIC = modifier("toxic",
            ToxicModifier::new);
    public static final RegistryObject<Modifier> TWEETING = modifier("tweeting",
            TweetingModifier::new);

    // Upgrades
    public static final RegistryObject<Modifier> AIR_BLADE = modifier("air_blade",
            AirBladeModifier::new);

    public static final RegistryObject<Modifier> BUTCHERER = modifier("butcherer",
            ButchererModifier::new);

    public static final RegistryObject<Modifier> REFREEZING = modifier("refreezing",
            RefreezingModifier::new);

    public static final RegistryObject<Modifier> SURPRISE_ME = modifier("surprise_me",
            SurpriseMeModifier::new);

    private static final <T extends Modifier> RegistryObject<Modifier> modifier(String name,
            Supplier<T> sup)
    {
        return MODIFIERS.register(name, sup);
    }
}
