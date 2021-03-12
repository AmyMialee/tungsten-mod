package amymialee.tungstenmod.equipment;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TungstenSwordItem extends SwordItem {
    public TungstenSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.tungstenmod.tungsten_effective.tooltip").formatted(Formatting.DARK_GRAY));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getGroup() == EntityGroup.ARTHROPOD) {
            stack.setDamage(stack.getDamage() - 3);
            target.setHealth(target.getHealth() - 4);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 3));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 30.0F;
        }
        return super.getMiningSpeedMultiplier(stack, state);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.isOf(Blocks.COBWEB)) {
            return true;
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
