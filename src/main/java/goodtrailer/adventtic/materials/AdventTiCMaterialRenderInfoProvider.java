package goodtrailer.adventtic.materials;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class AdventTiCMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider
{
    public static final String NAME = "AdventTiC Material Render Info";
    
    public AdventTiCMaterialRenderInfoProvider(DataGenerator gen,
            AbstractMaterialSpriteProvider spriteProvider)
    {
        super(gen, spriteProvider);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addMaterialRenderInfo()
    {
        addGeneralMaterials();
        addHarvestMaterials();
        addWeaponMaterials();
    }
    
    private void addGeneralMaterials()
    {
        buildRenderInfo(AdventTiCMaterials.BLAZIUM);
        buildRenderInfo(AdventTiCMaterials.EMBERSTONE);
        buildRenderInfo(AdventTiCMaterials.GHOULISH);
        buildRenderInfo(AdventTiCMaterials.LIMONITE);
        buildRenderInfo(AdventTiCMaterials.LYON);
        buildRenderInfo(AdventTiCMaterials.ROSITE);
        buildRenderInfo(AdventTiCMaterials.SHYRESTONE);
        buildRenderInfo(AdventTiCMaterials.SKELETAL);
    
        buildRenderInfo(AdventTiCMaterials.CHARGER);
    }
    
    private void addHarvestMaterials()
    {
        buildRenderInfo(AdventTiCMaterials.LUNAR);
    }
    
    private void addWeaponMaterials()
    {
        buildRenderInfo(AdventTiCMaterials.BARONYTE);
        buildRenderInfo(AdventTiCMaterials.ELECANIUM);
        buildRenderInfo(AdventTiCMaterials.GHASTLY);
        buildRenderInfo(AdventTiCMaterials.MYSTITE);
        buildRenderInfo(AdventTiCMaterials.VARSIUM);
    }
}
