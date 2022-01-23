package goodtrailer.adventtic.lang;

import goodtrailer.adventtic.fluids.AdventTiCFluids;
import goodtrailer.adventtic.materials.AdventTiCMaterials;
import goodtrailer.adventtic.modifiers.AdventTiCModifiers;
import net.minecraft.data.DataGenerator;

public class AdventTiCEnglishProvider extends AdventTiCLanguageProvider
{
    public static final String NAME = "AdventTiC English";
    public static final String LOCALE = "en_us";

    public AdventTiCEnglishProvider(DataGenerator gen)
    {
        super(gen, LOCALE);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected String getBucketFormat()
    {
        return "%s Bucket";
    }

    @Override
    protected void addFluids()
    {
        addFluid(AdventTiCFluids.MOLTEN_BARONYTE, "Molten Baronyte");
        addFluid(AdventTiCFluids.MOLTEN_BLAZIUM, "Molten Blazium");
        addFluid(AdventTiCFluids.MOLTEN_CHARGER, "Molten Charger");
        addFluid(AdventTiCFluids.MOLTEN_ELECANIUM, "Molten Elecanium");
        addFluid(AdventTiCFluids.MOLTEN_EMBERSTONE, "Molten Emberstone");
        addFluid(AdventTiCFluids.MOLTEN_GHASTLY, "Molten Ghastly");
        addFluid(AdventTiCFluids.MOLTEN_GHOULISH, "Molten Ghoulish");
        addFluid(AdventTiCFluids.MOLTEN_LIMONITE, "Molten Limonite");
        addFluid(AdventTiCFluids.MOLTEN_LUNAR, "Molten Lunar");
        addFluid(AdventTiCFluids.MOLTEN_LYON, "Molten Lyon");
        addFluid(AdventTiCFluids.MOLTEN_MYSTITE, "Molten Mystite");
        addFluid(AdventTiCFluids.MOLTEN_ROSITE, "Molten Rosite");
        addFluid(AdventTiCFluids.MOLTEN_SHYRESTONE, "Molten Shyrestone");
        addFluid(AdventTiCFluids.MOLTEN_SKELETAL, "Molten Skeletal");
        addFluid(AdventTiCFluids.MOLTEN_VARSIUM, "Molten Varsium");
    }

    @Override
    protected void addMaterials()
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

    @Override
    protected void addModifiers()
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
                "Burden, eternal...",
                "Each hit has a chance to amplify and extend a negative effect on a mob");
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
                "Massively increases tool efficiency while on fire");
        addModifier(AdventTiCModifiers.LACED,
                "Laced",
                "Just a little touch of this~",
                "Poisons creatures when hit");
        addModifier(AdventTiCModifiers.RUNIC,
                "Runic",
                "Imbued with runic energy!",
                "Converts a portion of damage dealt into magic damage");
        String runic = AdventTiCModifiers.RUNIC.getId().getPath();
        addMisc("modifier", runic, "attack_damage", "Magic Damage");
        addModifier(AdventTiCModifiers.SHYRE_SYNTHESIS,
                "Shyre Synthesis",
                "Alien chlorophyll!?",
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
}
