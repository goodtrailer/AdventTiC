package goodtrailer.adventtic.lang;

import goodtrailer.adventtic.AdventTiC;
import goodtrailer.adventtic.fluids.AdventTiCFluids;
import goodtrailer.adventtic.materials.AdventTiCMaterials;
import goodtrailer.adventtic.modifiers.AdventTiCModifiers;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class AdventTiCChineseProvider extends LanguageProvider
{

    public static final String NAME = "AdventTiC 中文 (Chinese)";
    public static final String LOCALE = "zh_cn";

    public AdventTiCChineseProvider(DataGenerator gen)
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
        addFluids();
        addMaterials();
        addModifiers();
    }

    private void addFluids()
    {
        addFluid(AdventTiCFluids.MOLTEN_BARONYTE, "熔融爵士");
        addFluid(AdventTiCFluids.MOLTEN_BLAZIUM, "熔融虚空");
        addFluid(AdventTiCFluids.MOLTEN_CHARGER, "熔融袭击者");
        addFluid(AdventTiCFluids.MOLTEN_ELECANIUM, "熔融荧银");
        addFluid(AdventTiCFluids.MOLTEN_EMBERSTONE, "熔融余烬石");
        addFluid(AdventTiCFluids.MOLTEN_GHASTLY, "熔融阴森");
        addFluid(AdventTiCFluids.MOLTEN_GHOULISH, "熔融恐惧");
        addFluid(AdventTiCFluids.MOLTEN_LIMONITE, "熔融褐铁");
        addFluid(AdventTiCFluids.MOLTEN_LUNAR, "熔融月");
        addFluid(AdventTiCFluids.MOLTEN_LYON, "熔融焦铁");
        addFluid(AdventTiCFluids.MOLTEN_MYSTITE, "熔融神秘");
        addFluid(AdventTiCFluids.MOLTEN_ROSITE, "熔融玫石");
        addFluid(AdventTiCFluids.MOLTEN_SHYRESTONE, "熔融塞尔瑞");
        addFluid(AdventTiCFluids.MOLTEN_SKELETAL, "熔融骷髅");
        addFluid(AdventTiCFluids.MOLTEN_VARSIUM, "熔融超金");
    }

    private void addMaterials()
    {
        // General Materials
        addMaterial(AdventTiCMaterials.BLAZIUM, "虚空");
        addMaterial(AdventTiCMaterials.EMBERSTONE, "余烬石");
        addMaterial(AdventTiCMaterials.GHOULISH, "恐惧");
        addMaterial(AdventTiCMaterials.LIMONITE, "褐铁");
        addMaterial(AdventTiCMaterials.LYON, "焦铁");
        addMaterial(AdventTiCMaterials.ROSITE, "玫石");
        addMaterial(AdventTiCMaterials.SHYRESTONE, "塞尔瑞");
        addMaterial(AdventTiCMaterials.SKELETAL, "骷髅");

        addMaterial(AdventTiCMaterials.CHARGER, "袭击者");

        // Harvest Materials
        addMaterial(AdventTiCMaterials.LUNAR, "月");

        // Weapon Materials
        addMaterial(AdventTiCMaterials.BARONYTE, "爵士");
        addMaterial(AdventTiCMaterials.ELECANIUM, "荧银");
        addMaterial(AdventTiCMaterials.GHASTLY, "阴森");
        addMaterial(AdventTiCMaterials.MYSTITE, "神秘");
        addMaterial(AdventTiCMaterials.VARSIUM, "超金");
    }

    private void addModifiers()
    {
        // Abilities
        addModifier(AdventTiCModifiers.CREEPIFIED,
                "蠕变",
                "利用极速气流的力量！",
                "攻击时产生爆炸");
        addModifier(AdventTiCModifiers.MONEYBAGS,
                "钱袋",
                "爆炸般的窃取！",
                "杀死的怪物会爆炸变成钱币");

        // Traits
        addModifier(AdventTiCModifiers.ANTI_AIR,
                "防空",
                "下来吧你！",
                "对飞行生物造成额外伤害");
        addModifier(AdventTiCModifiers.BARON,
                "爵士",
                "不太靠谱~",
                "偶尔造成额外伤害");
        addModifier(AdventTiCModifiers.BLAZING,
                "炽热",
                "感受来自太阳的高温！",
                "让目标着火");
        addModifier(AdventTiCModifiers.BONE_SHOCK,
                "骨头休克",
                "敲响骨头！",
                "对非节肢生物造成额外伤害");
        addModifier(AdventTiCModifiers.COUNTERWEIGHT,
                "配重",
                "向上的……",
                "提升浮空时的挖掘效率");
        addModifier(AdventTiCModifiers.DISCOUNTED,
                "折扣",
                "每个人都喜欢免费！",
                "显著提高修复工具时恢复的耐久");
        addModifier(AdventTiCModifiers.EVIL_PRESSURE,
                "邪恶的压力",
                "压力，不断增加……",
                "每次攻击都有概率使生物身上的负面效果延长");
        addModifier(AdventTiCModifiers.FLAMING_FURY,
                "烈焰之怒",
                "把它强化到3级！",
                "若目标着火，则增加额外伤害");
        addModifier(AdventTiCModifiers.HIGH_IN_CALCIUM,
                "高钙",
                "丢掉那些骨头！",
                "破坏方块时掉落骨头和骨粉");
        addModifier(AdventTiCModifiers.INFERNAL_ENERGY,
                "炼狱之力",
                "最极致的热！",
                "着火时大大提高工具效率");
        addModifier(AdventTiCModifiers.LACED,
                "镶边",
                "就这样轻轻一碰~",
                "攻击生物时使之中毒");
        addModifier(AdventTiCModifiers.RUNIC,
                "符文",
                "被符文能量所浸透！",
                "将造成的一部分伤害转化为魔法伤害");
        String runic = AdventTiCModifiers.RUNIC.getId().getPath();
        addMisc("modifier", runic, "attack_damage", "魔法伤害");
        addModifier(AdventTiCModifiers.SHYRE_SYNTHESIS,
                "塞尔瑞风格",
                "外星叶绿素！？",
                "阳光直射时不消耗工具耐久");
        addModifier(AdventTiCModifiers.SOUL_HARVEST,
                "灵魂收割",
                "直接连根拔起~",
                "采矿时恢复灵魂力");
        addModifier(AdventTiCModifiers.SOUL_SAP,
                "灵魂汁液",
                "来自空灵的深处……",
                "根据造成的伤害恢复灵魂力");
        addModifier(AdventTiCModifiers.TOXIC,
                "剧毒",
                "经不起消耗……",
                "暴击敌人时释放一片毒云");
        addModifier(AdventTiCModifiers.TWEETING,
                "啾啾",
                "啾啾，啾啾！",
                "想要听起来像一只袭击者吗？");

        // Upgrades
        addModifier(AdventTiCModifiers.AIR_BLADE,
                "气刃",
                "分裂了空气本身！",
                "增加横扫造成的伤害");
        addModifier(AdventTiCModifiers.BUTCHERER,
                "屠夫",
                "满足嗜血的欲望……",
                "增加攻击时生成嗜血晶体的概率");
        addModifier(AdventTiCModifiers.REFREEZING,
                "再冻",
                "永恒的冰晶~",
                "在寒冷环境中恢复工具耐久");
        addModifier(AdventTiCModifiers.SURPRISE_ME,
                "惊喜",
                "安装不可靠模块……",
                "增加平均工具伤害，但伤害将会更加随机");
    }

    private void addFluid(FluidObject<ForgeFlowingFluid> fluid, String name)
    {
        String id = fluid.getId().getPath();
        String prefix = "fluid." + AdventTiC.MOD_ID + ".";
        addBlock(() -> fluid.getBlock(), name);
        add(prefix + id, name);

        addItem(fluid.get().getBucket(), name + "桶");
    }

    private void addItem(Item item, String name)
    {
        String id = item.getRegistryName().getPath();
        String prefix = "item." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
    }

    private void addMaterial(MaterialId materialId, String name)
    {
        String id = materialId.getPath();
        String prefix = "material." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
    }

    private <T extends Modifier> void addModifier(RegistryObject<T> mod, String name, String flavor,
            String description)
    {
        String id = mod.getId().getPath();
        String prefix = "modifier." + AdventTiC.MOD_ID + ".";
        add(prefix + id, name);
        add(prefix + id + ".flavor", flavor);
        add(prefix + id + ".description", description);
    }
    
    private void addMisc(String keyPart0, String keyPart2, String... keyPartsAndValue)
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
