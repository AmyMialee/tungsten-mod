package amymialee.tungstenmod.equipment;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TungstenHoeItem extends HoeItem {
    public TungstenHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("item.tungstenmod.tungsten_effective.tooltip").formatted(Formatting.DARK_GRAY));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.getGroup() == EntityGroup.ARTHROPOD) {
            stack.setDamage(stack.getDamage() - 3);
            target.setHealth(target.getHealth() - 1);
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 50, 3));
            return true;
        }
        return super.postHit(stack, target, attacker);
    }
}
