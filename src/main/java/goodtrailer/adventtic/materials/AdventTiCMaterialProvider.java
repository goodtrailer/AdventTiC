package goodtrailer.adventtic.materials;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.crafting.conditions.ItemExistsCondition;
import net.minecraftforge.common.crafting.conditions.OrCondition;
import net.tslat.aoa3.common.registration.AoAItems;
import slimeknights.tconstruct.common.json.ConfigEnabledCondition;
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
                4,
                ORDER_GENERAL + ORDER_COMPAT,
                0xFF5D00);
        addCompatMetalMaterial(AdventTiCMaterials.EMBERSTONE,
                5,
                ORDER_GENERAL + ORDER_NETHER + ORDER_COMPAT,
                0x6B1919);
        addCompatMetalMaterial(AdventTiCMaterials.GHOULISH,
                6,
                ORDER_GENERAL + ORDER_COMPAT,
                0x99A8FC);
        addCompatMetalMaterial(AdventTiCMaterials.LIMONITE,
                2,
                ORDER_GENERAL + ORDER_COMPAT,
                0xFFB200);
        addCompatMetalMaterial(AdventTiCMaterials.LYON,
                6,
                ORDER_GENERAL + ORDER_COMPAT,
                0xA88100);
        addCompatMetalMaterial(AdventTiCMaterials.ROSITE,
                3,
                ORDER_GENERAL + ORDER_COMPAT,
                0xD31336);
        addCompatMetalMaterial(AdventTiCMaterials.SHYRESTONE,
                6,
                ORDER_GENERAL + ORDER_COMPAT,
                0x009BFC);
        addCompatMetalMaterial(AdventTiCMaterials.SKELETAL,
                5,
                ORDER_GENERAL + ORDER_COMPAT,
                0xFFE8A0);

        OrCondition chargerCondition = new OrCondition(
                ConfigEnabledCondition.FORCE_INTEGRATION_MATERIALS,
                new ItemExistsCondition(AoAItems.RAW_CHARGER_SHANK.getId()),
                new ItemExistsCondition(AoAItems.COOKED_CHARGER_SHANK.getId()));
        addMaterial(AdventTiCMaterials.CHARGER,
                0,
                ORDER_GENERAL + ORDER_COMPAT,
                false,
                0xFFE500,
                false,
                chargerCondition);
    }

    private void addHarvestMaterials()
    {
        addCompatMetalMaterial(AdventTiCMaterials.LUNAR,
                6,
                ORDER_HARVEST + ORDER_COMPAT,
                0xFF8CBF);
    }

    private void addWeaponMaterials()
    {
        addCompatMetalMaterial(AdventTiCMaterials.BARONYTE,
                4,
                ORDER_WEAPON + ORDER_COMPAT,
                0xCE0000);
        addCompatMetalMaterial(AdventTiCMaterials.ELECANIUM,
                6,
                ORDER_WEAPON + ORDER_COMPAT,
                0x00F9F9);
        addCompatMetalMaterial(AdventTiCMaterials.GHASTLY,
                6,
                ORDER_WEAPON + ORDER_COMPAT,
                0xCFF99F);
        addCompatMetalMaterial(AdventTiCMaterials.MYSTITE,
                6,
                ORDER_WEAPON + ORDER_COMPAT,
                0x6BFFBE);
        addCompatMetalMaterial(AdventTiCMaterials.VARSIUM,
                3,
                ORDER_WEAPON + ORDER_COMPAT,
                0xC68A2F);
    }
}
