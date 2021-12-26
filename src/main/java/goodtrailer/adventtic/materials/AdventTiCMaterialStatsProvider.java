package goodtrailer.adventtic.materials;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

public class AdventTiCMaterialStatsProvider extends AbstractMaterialStatsDataProvider
{
    public static final String NAME = "AdventTiC Material Stats";

    public AdventTiCMaterialStatsProvider(DataGenerator gen,
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
    protected void addMaterialStats()
    {
        addGeneralMaterials();
        addHarvestMaterials();
        addWeaponMaterials();
    }

    private void addGeneralMaterials()
    {
        addMaterialStats(AdventTiCMaterials.BLAZIUM,
                new HandleMaterialStats(0.70f, 0.85f, 0.90f, 1.10f),
                new HeadMaterialStats(800, 4.5f, 4, 3.6f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.EMBERSTONE,
                new HandleMaterialStats(0.65f, 0.80f, 1.00f, 1.10f),
                new HeadMaterialStats(640, 4.0f, 5, 3.8f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.GHOULISH,
                new HandleMaterialStats(1.30f, 0.80f, 1.00f, 1.05f),
                new HeadMaterialStats(1000, 3.9f, 6, 3.2f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.LIMONITE,
                new HandleMaterialStats(0.60f, 0.75f, 1.00f, 0.95f),
                new HeadMaterialStats(250, 3.0f, 2, 2.8f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.LYON,
                new HandleMaterialStats(1.05f, 1.05f, 1.10f, 1.15f),
                new HeadMaterialStats(840, 6.2f, 6, 4.0f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.ROSITE,
                new HandleMaterialStats(0.95f, 0.75f, 1.00f, 1.05f),
                new HeadMaterialStats(400, 3.4f, 3, 3.4f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.SHYRESTONE,
                new HandleMaterialStats(1.00f, 1.40f, 1.10f, 1.25f),
                new HeadMaterialStats(640, 13.0f, 6, 3.6f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.SKELETAL,
                new HandleMaterialStats(0.65f, 1.25f, 1.00f, 1.10f),
                new HeadMaterialStats(610, 10.0f, 5, 4.3f),
                ExtraMaterialStats.DEFAULT);

        addMaterialStats(AdventTiCMaterials.CHARGER,
                new HandleMaterialStats(0.50f, 0.90f, 0.90f, 0.50f),
                new HeadMaterialStats(110, 2.4f, 0, 2.5f),
                ExtraMaterialStats.DEFAULT);
    }

    private void addHarvestMaterials()
    {
        addMaterialStats(AdventTiCMaterials.LUNAR,
                new HandleMaterialStats(0.90f, 1.10f, 1.00f, 1.00f),
                new HeadMaterialStats(660, 3.8f, 6, 2.0f),
                ExtraMaterialStats.DEFAULT);
    }

    private void addWeaponMaterials()
    {
        addMaterialStats(AdventTiCMaterials.BARONYTE,
                new HandleMaterialStats(1.15f, 0.95f, 1.00f, 1.10f),
                new HeadMaterialStats(900, 5.3f, 4, 3.75f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.ELECANIUM,
                new HandleMaterialStats(2.00f, 1.15f, 0.90f, 1.40f),
                new HeadMaterialStats(600, 8.3f, 6, 6.1f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.GHASTLY,
                new HandleMaterialStats(0.90f, 0.85f, 1.00f, 1.30f),
                new HeadMaterialStats(730, 4.7f, 6, 4.5f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.MYSTITE,
                new HandleMaterialStats(1.05f, 0.80f, 1.00f, 1.25f),
                new HeadMaterialStats(760, 3.65f, 6, 4.3f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(AdventTiCMaterials.VARSIUM,
                new HandleMaterialStats(1.00f, 0.95f, 1.00f, 1.20f),
                new HeadMaterialStats(870, 5.2f, 3, 3.75f),
                ExtraMaterialStats.DEFAULT);
    }
}
