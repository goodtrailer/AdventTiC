package goodtrailer.adventtic.materials;

import goodtrailer.adventtic.AdventTiC;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public final class AdventTiCMaterials
{
    // General Materials
    public static final MaterialId BLAZIUM = id("blazium");
    public static final MaterialId EMBERSTONE = id("emberstone");
    public static final MaterialId GHOULISH = id("ghoulish");
    public static final MaterialId LIMONITE = id("limonite");
    public static final MaterialId LYON = id("lyon");
    public static final MaterialId ROSITE = id("rosite");
    public static final MaterialId SHYRESTONE = id("shyrestone");
    public static final MaterialId SKELETAL = id("skeletal");

    public static final MaterialId CHARGER = id("charger");
    
    // Harvest Materials
    public static final MaterialId LUNAR = id("lunar");
    
    // Weapon Materials
    public static final MaterialId BARONYTE = id("baronyte");
    public static final MaterialId ELECANIUM = id("elecanium");
    public static final MaterialId GHASTLY = id("ghastly");
    public static final MaterialId MYSTITE = id("mystite");
    public static final MaterialId VARSIUM = id("varsium");

    private static final MaterialId id(String name)
    {
        return new MaterialId(AdventTiC.getResource(name));
    }
}
