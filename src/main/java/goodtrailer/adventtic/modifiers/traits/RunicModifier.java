package goodtrailer.adventtic.modifiers.traits;

import java.util.List;

import goodtrailer.adventtic.AdventTiC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tslat.aoa3.util.DamageUtil;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.utils.Util;

public class RunicModifier extends Modifier
{
    public static final int COLOR = 0x89FBFF;
    public static final float COEFFICIENT_PER_LEVEL = 0.2f;
    
    private float primaryNominalDamage = 0f;
    private float extraNominalDamage = 0f;

    private static final TranslationTextComponent damage_desc = new TranslationTextComponent(
            Util.makeTranslationKey("modifier", AdventTiC.getResource("runic.attack_damage")));

    public RunicModifier()
    {
        super(COLOR);
    }

    @Override
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
            float baseDamage, float damage)
    {
        return damage * (1f - COEFFICIENT_PER_LEVEL * level);
    }

    @Override
    public float beforeEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damage, float baseKnockback, float knockback)
    {
        if (context.isExtraAttack())
            extraNominalDamage = damage;
        else
            primaryNominalDamage = damage;
        
        return knockback;
    }
    
    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        LivingEntity attacker = context.getAttacker();
        if (attacker.level.isClientSide)
            return 0;
        
        doMagicDamage(level, context);
        return 0;
    }
    
    @Override
    public void failedEntityHit(IModifierToolStack tool, int level, ToolAttackContext context)
    {
        if (doMagicDamage(level, context))
            ToolDamageUtil.damage(tool, 1, null, null);
    }
    
    private boolean doMagicDamage(int level, ToolAttackContext context)
    {
        LivingEntity attacker = context.getAttacker();
        if (attacker.level.isClientSide)
            return false;
        
        float physical = 1 - COEFFICIENT_PER_LEVEL * level;
        float magicDamage = (1 - physical) / physical;
        magicDamage *= context.isExtraAttack() ? extraNominalDamage : primaryNominalDamage;
        
        Entity target = context.getTarget();
        return DamageUtil.dealMagicDamage(null, attacker, target, magicDamage, false);
    }
    
    @Override
    public void addInformation(IModifierToolStack tool, int level, List<ITextComponent> tooltip,
            boolean isAdvanced, boolean detailed)
    {
        float coef = COEFFICIENT_PER_LEVEL * level;
        StringTextComponent text = new StringTextComponent(Util.PERCENT_FORMAT.format(coef));
        text.append(" ").append(damage_desc);
        tooltip.add(applyStyle(text));
    }
}
