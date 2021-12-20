package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.tslat.aoa3.util.constant.Resources;
import net.tslat.aoa3.util.player.PlayerUtil;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class SoulHarvestModifier extends SingleUseModifier
{
    public static final int COLOR = 0x99A8FC;
    public static final float COEFFICIENT = 0.75f;

    public SoulHarvestModifier()
    {
        super(COLOR);
    }
    
    @Override
    public void afterBlockBreak(IModifierToolStack tool, int level, ToolHarvestContext context)
    {
        ServerPlayerEntity player = context.getPlayer();
        if (player == null || player.level.isClientSide || !context.isEffective())
            return;
        
        float strength = context.getState().getDestroySpeed(player.level, context.getPos());
        PlayerUtil.addResourceToPlayer(player, Resources.SOUL, strength * COEFFICIENT);
    }
}
