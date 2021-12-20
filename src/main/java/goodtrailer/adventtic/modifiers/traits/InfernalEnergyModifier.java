package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.SingleUseModifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class InfernalEnergyModifier extends SingleUseModifier
{
    public static final int COLOR = 0xFF5D00;
    public static final float COEFFICIENT = 5f;

    public InfernalEnergyModifier()
    {
        super(COLOR);
    }
    
    @Override
    public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event,
            Direction sideHit, boolean isEffective, float miningSpeedModifier)
    {
        Entity entity = event.getEntity();
        if (!entity.isOnFire())
            return;
        
        event.setNewSpeed(event.getNewSpeed() * COEFFICIENT);
    }
}
