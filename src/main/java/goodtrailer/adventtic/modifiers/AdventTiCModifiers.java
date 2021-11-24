package goodtrailer.adventtic.modifiers;

import goodtrailer.adventtic.AdventTiC;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public final class AdventTiCModifiers
{
    public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister
            .create(Modifier.class, AdventTiC.MOD_ID);

    // abilities
    public static final RegistryObject<Modifier> CREEPIFIED_MODIFIER = MODIFIERS
            .register("creepified", CreepifiedModifier::new);

    public static final RegistryObject<Modifier> MONEYBAGS_MODIFIER = MODIFIERS
            .register("moneybags", MoneybagsModifier::new);
    
    // upgrades
    public static final RegistryObject<Modifier> AIR_BLADE_MODIFIER = MODIFIERS
            .register("air_blade", AirBladeModifier::new);

    public static final RegistryObject<Modifier> BUTCHERER_MODIFIER = MODIFIERS
            .register("butcherer", ButchererModifier::new);

    public static final RegistryObject<Modifier> REFREEZING_MODIFIER = MODIFIERS
            .register("refreezing", RefreezingModifier::new);

    public static final RegistryObject<Modifier> SURPRISE_ME_MODIFIER = MODIFIERS
            .register("surprise_me", SurpriseMeModifier::new);
}
