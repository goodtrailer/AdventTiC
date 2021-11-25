package goodtrailer.adventtic.lang;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.materials.AdventTiCMaterials;
import goodtrailer.adventtic.modifiers.AdventTiCModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class AdventTiCEnglishProvider extends LanguageProvider
{
    public static final String NAME = "AdventTiC English";
    public static final String LOCALE = "en_us";
    
    public AdventTiCEnglishProvider(DataGenerator gen)
    {
        super(gen, AdventTiC.MOD_ID, LOCALE);
    }
    
    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addTranslations()
    {
        addMaterials();
        addModifiers();
    }
    
    private void addMaterials()
    {
        // General Materials
        addMaterial(AdventTiCMaterials.BLAZIUM, "Blazium");
        addMaterial(AdventTiCMaterials.EMBERSTONE, "Emberstone");
        addMaterial(AdventTiCMaterials.GHOULISH, "Ghoulish");
        addMaterial(AdventTiCMaterials.LIMONITE, "Limonite");
        addMaterial(AdventTiCMaterials.LYON, "Lyon");
        addMaterial(AdventTiCMaterials.ROSITE, "Rosite");
        addMaterial(AdventTiCMaterials.SHYRESTONE, "Shyrestone");
        addMaterial(AdventTiCMaterials.SKELETAL, "Skeletal");
        
        addMaterial(AdventTiCMaterials.CHARGER, "Charger");
        
        // Harvest Materials
        addMaterial(AdventTiCMaterials.LUNAR, "Lunar");
        
        // Weapon Materials
        addMaterial(AdventTiCMaterials.BARONYTE, "Baronyte");
        addMaterial(AdventTiCMaterials.ELECANIUM, "Elecanium");
        addMaterial(AdventTiCMaterials.GHASTLY, "Ghastly");
        addMaterial(AdventTiCMaterials.MYSTITE, "Mystite");
        addMaterial(AdventTiCMaterials.VARSIUM, "Varsium");
    }
    
    private void addModifiers()
    {
        // Abilities
        addModifier(AdventTiCModifiers.CREEPIFIED,
                "Creepified",
                "Harness the power of fast air!",
                "Creates explosions when attacking mobs");
        addModifier(AdventTiCModifiers.MONEYBAGS,
                "Moneybags",
                "Explosive pickpocketing!",
                "Mobs to explode into coins when killed");
        
        // Traits
        addModifier(AdventTiCModifiers.ANTI_AIR,
                "Anti-Air",
                "Get down here!",
                "Deals additional damage to flying creatures");
        addModifier(AdventTiCModifiers.BARON,
                "Baron",
                "Only semi-reliable~",
                "Occasionally deals additional damage");
        addModifier(AdventTiCModifiers.BLAZING,
                "Blazing",
                "Feel the heat of the Sun!",
                "Sets targets on fire");
        addModifier(AdventTiCModifiers.BONE_SHOCK,
                "Bone Shock",
                "Rattles the bones!",
                "Deals additional damage to non-arthropod creatures");
        addModifier(AdventTiCModifiers.COUNTERWEIGHT,
                "Counterweight",
                "What goes up...",
                "Increases tool efficiency when not touching the ground");
        addModifier(AdventTiCModifiers.DISCOUNTED,
                "Discounted",
                "Everyone likes free stuff!",
                "Significantly increases durability gained when repairing the tool");
        addModifier(AdventTiCModifiers.EVIL_PRESSURE,
                "Evil Pressure",
                "Burden eternal...",
                "Each hit has a chance to amplify negative effects present on mob");
        addModifier(AdventTiCModifiers.FLAMING_FURY,
                "Flaming Fury",
                "Making it third-degree!",
                "Deals additional damage while on fire");
        addModifier(AdventTiCModifiers.HIGH_IN_CALCIUM,
                "High in Calcium",
                "Just shedding bones!",
                "Drops bones and bonemeal while breaking blocks");
        addModifier(AdventTiCModifiers.INFERNAL_ENERGY,
                "Infernal Energy",
                "Thermocoupling to the max!",
                "Massively increases tool efficiency when on fire");
        addModifier(AdventTiCModifiers.LACED,
                "Laced",
                "Just a little touch of this~",
                "Poisons creatures when hit");
        addModifier(AdventTiCModifiers.RUNIC,
                "Runic",
                "Imbued with runic energy!",
                "Converts a portion of damage dealt into magic damage");
        addModifier(AdventTiCModifiers.SHYRE_SYNTHESIS,
                "Shyre Synthesis",
                "Blue chlorophyll!?",
                "Prevents the tool from taking damage when in direct sunlight");
        addModifier(AdventTiCModifiers.SOUL_HARVEST,
                "Soul Harvest",
                "Pulled straight from the ground~",
                "Regenerates soul power while mining");
        addModifier(AdventTiCModifiers.SOUL_SAP,
                "Soul Sap",
                "From the ethereal depths...",
                "Regenerates soul power based on damage dealt");
        addModifier(AdventTiCModifiers.TOXIC,
                "Toxic",
                "Not for consumption...",
                "Releases a toxic cloud when critically-hitting enemies");
        addModifier(AdventTiCModifiers.TWEETING,
                "Tweeting",
                "Tweet, tweet!",
                "Ever wanted to sound like a charger?");
        
        // Upgrades
        addModifier(AdventTiCModifiers.AIR_BLADE,
                "Air Blade",
                "Splitting the air itself!",
                "Increases the damage dealt by sweep attacks");
        addModifier(AdventTiCModifiers.BUTCHERER,
                "Butcherer",
                "Satisfying the bloodlust...",
                "Increases the chance of bloodlusts spawning when attacking");
        addModifier(AdventTiCModifiers.REFREEZING,
                "Refreezing",
                "Everlasting ice crystals~",
                "Regenerates tool damage when in cold environments");
        addModifier(AdventTiCModifiers.SURPRISE_ME,
                "Surprise Me",
                "Installing unreliability module...",
                "Increases average tool damage, but makes tool damage random");
    }
    
    private void addMaterial(MaterialId materialId, String name)
    {
        String id = materialId.getPath();
        String prefix = "material." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
    }
    
    private void addModifier(RegistryObject<Modifier> modifier, String name, String flavor,
            String description)
    {
        String id = modifier.getId().getPath();
        String prefix = "modifier." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
        add(prefix + id + ".flavor", flavor);
        add(prefix + id + ".description", description);
    }
}
