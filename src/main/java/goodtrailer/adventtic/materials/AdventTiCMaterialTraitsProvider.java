package goodtrailer.adventtic.materials;

import goodtrailer.adventtic.modifiers.AdventTiCModifiers;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class AdventTiCMaterialTraitsProvider extends AbstractMaterialTraitDataProvider
{
    public static final String NAME = "AdventTiC Material Traits";
    
    public AdventTiCMaterialTraitsProvider(DataGenerator gen,
            AbstractMaterialDataProvider materials)
    {
        super(gen, materials);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addMaterialTraits()
    {
        addGeneralMaterials();
        addHarvestMaterials();
        addWeaponMaterials();
    }
    
    private void addGeneralMaterials()
    {
        addDefaultTraits(AdventTiCMaterials.BLAZIUM,
                AdventTiCModifiers.FLAMING_FURY.get(),
                AdventTiCModifiers.INFERNAL_ENERGY.get());
        addDefaultTraits(AdventTiCMaterials.EMBERSTONE,
                TinkerModifiers.autosmelt.get(),
                AdventTiCModifiers.BLAZING.get());
        addDefaultTraits(AdventTiCMaterials.GHOULISH,
                AdventTiCModifiers.SOUL_HARVEST.get(),
                AdventTiCModifiers.SOUL_SAP.get());
        addDefaultTraits(AdventTiCMaterials.LIMONITE,
                AdventTiCModifiers.DISCOUNTED.get());
        addDefaultTraits(AdventTiCMaterials.LYON,
                TinkerModifiers.magnetic.get());
        addDefaultTraits(AdventTiCMaterials.ROSITE,
                TinkerModifiers.writable.get());
        addDefaultTraits(AdventTiCMaterials.SHYRESTONE,
                AdventTiCModifiers.SHYRE_SYNTHESIS.get());
        addDefaultTraits(AdventTiCMaterials.SKELETAL,
                AdventTiCModifiers.BONE_SHOCK.get(),
                AdventTiCModifiers.HIGH_IN_CALCIUM.get());
        
        addDefaultTraits(AdventTiCMaterials.CHARGER,
                AdventTiCModifiers.TWEETING.get());
    }

    private void addHarvestMaterials()
    {
        addDefaultTraits(AdventTiCMaterials.LUNAR,
                AdventTiCModifiers.COUNTERWEIGHT.get());
    }
    
    private void addWeaponMaterials()
    {
        addDefaultTraits(AdventTiCMaterials.BARONYTE,
                AdventTiCModifiers.BARON.get());
        addDefaultTraits(AdventTiCMaterials.ELECANIUM,
                AdventTiCModifiers.RUNIC.get());
        addDefaultTraits(AdventTiCMaterials.GHASTLY,
                AdventTiCModifiers.ANTI_AIR.get());
        addDefaultTraits(AdventTiCMaterials.MYSTITE,
                AdventTiCModifiers.LACED.get(),
                AdventTiCModifiers.TOXIC.get());
        addDefaultTraits(AdventTiCMaterials.VARSIUM,
                AdventTiCModifiers.EVIL_PRESSURE.get());
    }
}
