package amymialee.tungstenmod.equipment;

import amymialee.tungstenmod.RegisterItems;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class TungstenToolMaterial implements ToolMaterial {
    public static final TungstenToolMaterial INSTANCE = new TungstenToolMaterial();

    @Override
    public int getDurability() {
        return 600;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.6F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 16;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.TUNGSTEN_INGOT);
    }
}
