package goodtrailer.adventtic.materials;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class AdventTiCMaterialProvider extends AbstractMaterialDataProvider
{
    public static final String NAME = "AdventTiC Materials";

    public AdventTiCMaterialProvider(DataGenerator gen)
    {
        super(gen);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addMaterials()
    {
        addGeneralMaterials();
        addHarvestMaterials();
        addWeaponMaterials();
    }

    private void addGeneralMaterials()
    {
        addCompatMetalMaterial(AdventTiCMaterials.BLAZIUM,
                3,
                ORDER_GENERAL + ORDER_COMPAT,
                0xFF5D00);
        addCompatMetalMaterial(AdventTiCMaterials.EMBERSTONE,
                3,
                ORDER_GENERAL + ORDER_NETHER + ORDER_COMPAT,
                0x6B1919);
        addCompatMetalMaterial(AdventTiCMaterials.GHOULISH,
                4,
                ORDER_GENERAL + ORDER_COMPAT,
                0x99A8FC);
        addCompatMetalMaterial(AdventTiCMaterials.LIMONITE,
                2,
                ORDER_GENERAL + ORDER_COMPAT,
                0xFFB200);
        addCompatMetalMaterial(AdventTiCMaterials.LYON,
                3,
                ORDER_GENERAL + ORDER_COMPAT,
                0xA88100);
        addCompatMetalMaterial(AdventTiCMaterials.ROSITE,
                2,
                ORDER_GENERAL + ORDER_COMPAT,
                0xD31336);
        addCompatMetalMaterial(AdventTiCMaterials.SHYRESTONE,
                4,
                ORDER_GENERAL + ORDER_COMPAT,
                0x009BFC);
        addCompatMetalMaterial(AdventTiCMaterials.SKELETAL,
                3,
                ORDER_GENERAL + ORDER_COMPAT,
                0xFFE8A0);

        addMaterial(AdventTiCMaterials.CHARGER,
                0,
                ORDER_GENERAL + ORDER_COMPAT,
                false,
                0xFFE500);
    }

    private void addHarvestMaterials()
    {
        addCompatMetalMaterial(AdventTiCMaterials.LUNAR,
                4,
                ORDER_HARVEST + ORDER_COMPAT,
                0xFF8CBF);
    }

    private void addWeaponMaterials()
    {
        addCompatMetalMaterial(AdventTiCMaterials.BARONYTE,
                3,
                ORDER_WEAPON + ORDER_COMPAT,
                0xCE0000);
        addCompatMetalMaterial(AdventTiCMaterials.ELECANIUM,
                4,
                ORDER_WEAPON + ORDER_COMPAT,
                0x00F9F9);
        addCompatMetalMaterial(AdventTiCMaterials.GHASTLY,
                4,
                ORDER_WEAPON + ORDER_COMPAT,
                0xCFF99F);
        addCompatMetalMaterial(AdventTiCMaterials.MYSTITE,
                3,
                ORDER_WEAPON + ORDER_COMPAT,
                0x6BFFBE);
        addCompatMetalMaterial(AdventTiCMaterials.VARSIUM,
                3,
                ORDER_WEAPON + ORDER_COMPAT,
                0xC68A2F);
    }
}
