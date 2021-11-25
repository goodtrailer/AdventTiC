package goodtrailer.adventtic.tags;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public final class AdventTiCItemTags
{
    // Tool tags
    public static final IOptionalNamedTag<Item> SWEEP = tag("modifiable/melee/sweep");
    
    private static final IOptionalNamedTag<Item> tag(String name)
    {
        return ItemTags.createOptional(AdventTiC.getResource(name));
    }
}
