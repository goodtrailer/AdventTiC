package goodtrailer.adventtic.modifiers;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class AdventTiCModifierLanguageProvider extends LanguageProvider
{
    public AdventTiCModifierLanguageProvider(DataGenerator gen)
    {
        super(gen, AdventTiC.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        addAbilities();
        addUpgrades();
    }

    private void addAbilities()
    {
        addModifier(AdventTiCModifiers.CREEPIFIED_MODIFIER,
                "Creepified",
                "Harness the power of fast air!",
                "Creates explosions when attacking mobs");

        addModifier(AdventTiCModifiers.MONEYBAGS_MODIFIER,
                "Moneybags",
                "Explosive pickpocketing!",
                "Mobs to explode into coins when killed");
    }

    private void addUpgrades()
    {
        addModifier(AdventTiCModifiers.AIR_BLADE_MODIFIER,
                "Air Blade",
                "Splitting the air itself!",
                "Increases the damage dealt by sweep attacks");

        addModifier(AdventTiCModifiers.BUTCHERER_MODIFIER,
                "Butcherer",
                "Satisfying the bloodlust...",
                "Increases the chance of bloodlusts spawning when attacking");

        addModifier(AdventTiCModifiers.REFREEZING_MODIFIER,
                "Refreezing",
                "Everlasting ice crystals~",
                "Regenerates tool damage when in cold environments");

        addModifier(AdventTiCModifiers.SURPRISE_ME_MODIFIER,
                "Surprise Me",
                "Installing unreliability module...",
                "Increases average tool damage, but makes tool damage random");
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
