package goodtrailer.adventtic.materials;

import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class AdventTiCMaterialSpriteProvider extends AbstractMaterialSpriteProvider
{
    public static final String NAME = "AdventTiC Material Sprites";

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addAllMaterials()
    {
        addGeneralMaterials();
        addHarvestMaterials();
        addWeaponMaterials();
    }

    private void addGeneralMaterials()
    {
        buildMaterial(AdventTiCMaterials.BLAZIUM)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                        .builderFromBlack()
                        .addARGB(63, 0xFF56151E)
                        .addARGB(102, 0xFFBA6230)
                        .addARGB(140, 0xFFE5A442)
                        .addARGB(178, 0xFFE5A442)
                        .addARGB(216, 0xFFFFEE70)
                        .addARGB(255, 0xFFFFFDEF)
                        .build());
        buildMaterial(AdventTiCMaterials.EMBERSTONE)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                        .builderFromBlack()
                        .addARGB(63, 0xFF30292E)
                        .addARGB(102, 0xFF4E3F41)
                        .addARGB(140, 0xFF755758)
                        .addARGB(178, 0xFFEE4747)
                        .addARGB(216, 0xFFFF824C)
                        .addARGB(255, 0xFFFFF38E)
                        .build());
        buildMaterial(AdventTiCMaterials.GHOULISH)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF3C2263)
                .addARGB(102, 0xFF746DFF)
                .addARGB(140, 0xFF746DFF)
                .addARGB(178, 0xFF7FAAFF)
                .addARGB(216, 0xFF7FAAFF)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.LIMONITE)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF542834)
                .addARGB(102, 0xFFBF6344)
                .addARGB(140, 0xFFEA9554)
                .addARGB(178, 0xFFEA9554)
                .addARGB(216, 0xFFFFDD93)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.LYON)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF26232B)
                .addARGB(102, 0xFF3D4047)
                .addARGB(140, 0xFF5D606B)
                .addARGB(178, 0xFFE8B63A)
                .addARGB(216, 0xFFF4D96B)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.ROSITE)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF5E2136)
                .addARGB(102, 0xFFBC4343)
                .addARGB(140, 0xFFF46C5A)
                .addARGB(178, 0xFFF46C5A)
                .addARGB(216, 0xFFFFA872)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.SHYRESTONE)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF2A316D)
                .addARGB(102, 0xFF4081E8)
                .addARGB(140, 0xFF58C2FF)
                .addARGB(178, 0xFFA3EDFF)
                .addARGB(216, 0xFFFFFFFF)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.SKELETAL)
                .meleeHarvest()
                .fallbacks("bone", "rock")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF4F3C37)
                .addARGB(102, 0xFF8C7F6B)
                .addARGB(140, 0xFFB5AB99)
                .addARGB(178, 0xFF8C7F6B)
                .addARGB(216, 0xFFE5DDCC)
                .addARGB(255, 0xFFFFFFFF)
                .build());

        buildMaterial(AdventTiCMaterials.CHARGER)
                .meleeHarvest()
                .fallbacks("contrast")
                .colorMapper(GreyToColorMapping
                        .builderFromBlack()
                        .addARGB(63, 0xFF4F460A)
                        .addARGB(102, 0xFFA19109)
                        .addARGB(140, 0xFFB8A802)
                        .addARGB(178, 0xFFDEC600)
                        .addARGB(216, 0xFFEFD900)
                        .addARGB(255, 0xFFFAE21C)
                        .build());
    }

    private void addHarvestMaterials()
    {
        buildMaterial(AdventTiCMaterials.LUNAR)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF31214F)
                .addARGB(102, 0xFFA5309F)
                .addARGB(140, 0xFF642977)
                .addARGB(178, 0xFFA5309F)
                .addARGB(216, 0xFFF464D5)
                .addARGB(255, 0xFFFFFFFF)
                .build());
    }

    private void addWeaponMaterials()
    {
        buildMaterial(AdventTiCMaterials.BARONYTE)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF510A1E)
                .addARGB(102, 0xFFB73333)
                .addARGB(140, 0xFFE86645)
                .addARGB(178, 0xFFE86645)
                .addARGB(216, 0xFFFF9C51)
                .addARGB(255, 0xFFFFE48C)
                .build());
        buildMaterial(AdventTiCMaterials.ELECANIUM)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF2E3245)
                .addARGB(102, 0xFF335275)
                .addARGB(140, 0xFF287FBE)
                .addARGB(178, 0xFF28CF62)
                .addARGB(216, 0xFFB8FF89)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.GHASTLY)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF194226)
                .addARGB(102, 0xFF69A845)
                .addARGB(140, 0xFF69A845)
                .addARGB(178, 0xFFA4C95E)
                .addARGB(216, 0xFFA4C95E)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.MYSTITE)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF2A4F4B)
                .addARGB(102, 0xFF58AA8E)
                .addARGB(140, 0xFF84CCA5)
                .addARGB(178, 0xFFB5FFC6)
                .addARGB(216, 0xFFB5FFC6)
                .addARGB(255, 0xFFFFFFFF)
                .build());
        buildMaterial(AdventTiCMaterials.VARSIUM)
                .meleeHarvest()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping
                .builderFromBlack()
                .addARGB(63, 0xFF3D1C2A)
                .addARGB(102, 0xFFB74840)
                .addARGB(140, 0xFFDB7C46)
                .addARGB(178, 0xFFDDC15A)
                .addARGB(216, 0xFFDDC15A)
                .addARGB(255, 0xFFFFFFFF)
                .build());
    }
}
