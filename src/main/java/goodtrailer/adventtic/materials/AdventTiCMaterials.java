package goodtrailer.adventtic.materials;

import java.util.ArrayList;

import goodtrailer.adventtic.AdventTiC;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public final class AdventTiCMaterials
{
    public static final ArrayList<MaterialId> GENERAL = new ArrayList<MaterialId>();
    public static final ArrayList<MaterialId> HARVEST = new ArrayList<MaterialId>();
    public static final ArrayList<MaterialId> WEAPON = new ArrayList<MaterialId>();

    // General Materials
    public static final MaterialId BLAZIUM = general("blazium");
    public static final MaterialId EMBERSTONE = general("emberstone");
    public static final MaterialId GHOULISH = general("ghoulish");
    public static final MaterialId LIMONITE = general("limonite");
    public static final MaterialId LYON = general("lyon");
    public static final MaterialId ROSITE = general("rosite");
    public static final MaterialId SHYRESTONE = general("shyrestone");
    public static final MaterialId SKELETAL = general("skeletal");

    public static final MaterialId CHARGER = general("charger");

    // Harvest Materials
    public static final MaterialId LUNAR = harvest("lunar");

    // Weapon Materials
    public static final MaterialId BARONYTE = weapon("baronyte");
    public static final MaterialId ELECANIUM = weapon("elecanium");
    public static final MaterialId GHASTLY = weapon("ghastly");
    public static final MaterialId MYSTITE = weapon("mystite");
    public static final MaterialId VARSIUM = weapon("varsium");

    private static final MaterialId general(String name)
    {
        MaterialId m = new MaterialId(AdventTiC.getResource(name));
        GENERAL.add(m);
        return m;
    }

    private static final MaterialId harvest(String name)
    {
        MaterialId m = new MaterialId(AdventTiC.getResource(name));
        HARVEST.add(m);
        return m;
    }

    private static final MaterialId weapon(String name)
    {
        MaterialId m = new MaterialId(AdventTiC.getResource(name));
        WEAPON.add(m);
        return m;
    }
}
