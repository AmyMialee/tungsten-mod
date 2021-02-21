package amymialee.tungstenmod.mixin;

import amymialee.tungstenmod.RegisterItems;
import amymialee.tungstenmod.TungstenMod;
import amymialee.tungstenmod.equipment.TungstenArmorItem;
import amymialee.tungstenmod.equipment.TungstenArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Inject(method = "damage", at = @At("TAIL"))
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        try {
            if (source.getAttacker() instanceof LivingEntity && ((LivingEntity) source.getAttacker()).getGroup() == EntityGroup.ARTHROPOD) {
                Iterable<ItemStack> armorItems = getArmorItems();
                int damage = 0;
                for (ItemStack item : armorItems) {
                    try {
                        if (item.getItem() == RegisterItems.TUNGSTEN_HELMET ||
                                item.getItem() == RegisterItems.TUNGSTEN_CHESTPLATE ||
                                item.getItem() == RegisterItems.TUNGSTEN_LEGGINGS ||
                                item.getItem() == RegisterItems.TUNGSTEN_BOOTS
                        ) {
                            damage += 1;
                            item.setDamage(item.getDamage() - 3);
                        }
                    } catch (Exception ignored) {}
                }
                if (damage > 0) {
                    source.getAttacker().damage(DamageSource.MAGIC, damage);
                }
            }
        } catch (Exception ignored) {}
    }
}