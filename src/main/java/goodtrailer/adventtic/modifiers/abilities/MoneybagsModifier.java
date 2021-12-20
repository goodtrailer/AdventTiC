package goodtrailer.adventtic.modifiers.abilities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.tslat.aoa3.common.registration.AoAItems;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class MoneybagsModifier extends Modifier
{
    public static final int COLOR = 0xFFCC00;
    public static final int COIN_COUNT_SQRT = 3; // nxn square of coins
    public static final int COIN_LIFESPAN = 200;
    public static final int COIN_PICKUP_DELAY = 10;
    public static final float COIN_PROB_PER_LEVEL = 0.3f;
    public static final double COIN_VELOCITY = 0.5;
    public static final float SILVER_PROB_PER_LEVEL = 1 / 30f;

    private static final float coin_increment = 2f / (COIN_COUNT_SQRT - 1);

    public MoneybagsModifier()
    {
        super(COLOR);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context,
            float damageDealt)
    {
        PlayerEntity player = context.getPlayerAttacker();
        LivingEntity target = context.getLivingTarget();
        if (player.level.isClientSide || !target.isDeadOrDying())
            return 0;

        for (float x = -1f; x <= 1f; x += coin_increment)
        {
            for (float z = -1f; z <= 1f; z += coin_increment)
            {
                if (RANDOM.nextFloat() < level * COIN_PROB_PER_LEVEL)
                {
                    Item coinType = RANDOM.nextFloat() < level * SILVER_PROB_PER_LEVEL
                            ? AoAItems.SILVER_COIN.get()
                            : AoAItems.COPPER_COIN.get();

                    ItemEntity coin = new ItemEntity(player.level, target.getX(),
                            target.getY() + target.getBbHeight(), target.getZ(),
                            new ItemStack(coinType));

                    coin.setDeltaMovement(x * COIN_VELOCITY, COIN_VELOCITY, z * COIN_VELOCITY);
                    coin.setPickUpDelay(COIN_PICKUP_DELAY);
                    coin.lifespan = COIN_LIFESPAN;

                    player.level.addFreshEntity(coin);
                }
            }
        }

        return 0;
    }
}
