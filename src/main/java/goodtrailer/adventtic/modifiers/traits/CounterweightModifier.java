package goodtrailer.adventtic.modifiers.traits;

import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class CounterweightModifier extends Modifier
{
    public static final int COLOR = 0xFF8CBF;
    public static final float COEFFICIENT_PER_LEVEL = 0.5f;

    public CounterweightModifier()
    {
        super(COLOR);
    }
    
    @Override
    public void onBreakSpeed(IModifierToolStack tool, int level, BreakSpeed event,
            Direction sideHit, boolean isEffective, float miningSpeedModifier)
    {
        Entity entity = event.getEntity();
        if (entity.isOnGround() || !isEffective)
            return;
        
        event.setNewSpeed(event.getNewSpeed() * (1f + COEFFICIENT_PER_LEVEL * level));
    }
}
