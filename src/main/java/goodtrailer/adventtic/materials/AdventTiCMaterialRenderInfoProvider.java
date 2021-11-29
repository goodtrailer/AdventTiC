package goodtrailer.adventtic.materials;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

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
        for (MaterialId general : AdventTiCMaterials.GENERAL)
            buildRenderInfo(general);
        for (MaterialId harvest : AdventTiCMaterials.HARVEST)
            buildRenderInfo(harvest);
        for (MaterialId weapon : AdventTiCMaterials.WEAPON)
            buildRenderInfo(weapon);
    }
}
