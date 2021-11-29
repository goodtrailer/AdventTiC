package goodtrailer.adventtic.items;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.tools.TinkerTools;

public class AdventTiCItemTagsProvider extends ItemTagsProvider
{
    public static final String NAME = "AdventTiC Item Tags";

    public AdventTiCItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTagsProvider,
            ExistingFileHelper existingFileHelper)
    {
        super(gen, blockTagsProvider, AdventTiC.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return NAME;
    }

    @Override
    protected void addTags()
    {
        addItemsToTag(AdventTiCItemTags.SWEEP, TinkerTools.kama, TinkerTools.scythe,
                TinkerTools.sword, TinkerTools.cleaver);
    }

    private void addItemsToTag(INamedTag<Item> tag, ItemObject<?>... items)
    {
        Builder<Item> builder = tag(tag);
        for (ItemObject<?> item : items)
            builder.add(item.asItem());
    }

    @SuppressWarnings({ "unused", "unchecked" })
    private void addTagsToItem(ItemObject<?> item, INamedTag<Item>... tags)
    {
        Item i = item.asItem();
        for (INamedTag<Item> tag : tags)
            tag(tag).add(i);
    }
}
