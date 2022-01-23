package goodtrailer.adventtic.lang;

import java.util.Locale;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.client.resources.Language;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.Modifier;

public abstract class AdventTiCLanguageProvider extends LanguageProvider
{
    protected Locale locale;

    public AdventTiCLanguageProvider(DataGenerator gen, String locale)
    {
        super(gen, AdventTiC.MOD_ID, locale);
        this.locale = new Language(locale, null, null, false).getJavaLocale();
    }

    @Override
    protected void addTranslations()
    {
        addFluids();
        addMaterials();
        addModifiers();
    }

    protected abstract void addFluids();

    protected abstract void addMaterials();

    protected abstract void addModifiers();

    protected abstract String getBucketFormat();

    protected void addFluid(FluidObject<ForgeFlowingFluid> fluid, String name)
    {
        String id = fluid.getId().getPath();
        String prefix = "fluid." + AdventTiC.MOD_ID + ".";
        addBlock(() -> fluid.getBlock(), name);
        add(prefix + id, name);

        addItem(fluid.get().getBucket(), String.format(locale, getBucketFormat(), name));
    }

    protected void addItem(Item item, String name)
    {
        String id = item.getRegistryName().getPath();
        String prefix = "item." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
    }

    protected void addMaterial(MaterialId materialId, String name)
    {
        String id = materialId.getPath();
        String prefix = "material." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
    }

    protected <T extends Modifier> void addModifier(RegistryObject<T> mod, String name,
            String flavor, String description)
    {
        String id = mod.getId().getPath();
        String prefix = "modifier." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
        add(prefix + id + ".flavor", flavor);
        add(prefix + id + ".description", description);
    }

    protected void addMisc(String keyPart0, String keyPart2, String... keyPartsAndValue)
    {
        String[] keyParts = new String[keyPartsAndValue.length + 2];
        keyParts[0] = keyPart0;
        keyParts[1] = AdventTiC.MOD_ID;
        keyParts[2] = keyPart2;
        for (int i = 3; i < keyParts.length; i++)
            keyParts[i] = keyPartsAndValue[i - 3];
        String key = String.join(".", keyParts);
        String value = keyPartsAndValue[keyPartsAndValue.length - 1];
        add(key, value);
    }
}
