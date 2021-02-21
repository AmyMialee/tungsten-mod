package amymialee.tungstenmod;

import amymialee.tungstenmod.blocks.TungstenBlock;
import amymialee.tungstenmod.blocks.TungstenBlockItem;
import amymialee.tungstenmod.equipment.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {
    public static final ArmorMaterial tungstenArmorMaterial = new TungstenArmorMaterial();
    public static final Item TUNGSTEN_HELMET = new TungstenArmorItem(tungstenArmorMaterial, EquipmentSlot.HEAD, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static final Item TUNGSTEN_CHESTPLATE = new TungstenArmorItem(tungstenArmorMaterial, EquipmentSlot.CHEST, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static final Item TUNGSTEN_LEGGINGS = new TungstenArmorItem(tungstenArmorMaterial, EquipmentSlot.LEGS, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static final Item TUNGSTEN_BOOTS = new TungstenArmorItem(tungstenArmorMaterial, EquipmentSlot.FEET, new Item.Settings().group(TungstenMod.MOD_GROUP));

    public static final Block TUNGSTEN_BLOCK = new TungstenBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block TUNGSTEN_TILES = new TungstenBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Block TUNGSTEN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f));
    public static final Item TUNGSTEN_INGOT = new Item(new FabricItemSettings().group(TungstenMod.MOD_GROUP));

    public static ToolItem TUNGSTEN_SWORD = new TungstenSwordItem(TungstenToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static ToolItem TUNGSTEN_PICKAXE = new TungstenPickaxeItem(TungstenToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static ToolItem TUNGSTEN_AXE = new TungstenAxeItem(TungstenToolMaterial.INSTANCE, 7, -3.1F, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static ToolItem TUNGSTEN_SHOVEL = new TungstenShovelItem(TungstenToolMaterial.INSTANCE, 1.5F, -3F, new Item.Settings().group(TungstenMod.MOD_GROUP));
    public static ToolItem TUNGSTEN_HOE = new TungstenHoeItem(TungstenToolMaterial.INSTANCE, -1, -1F, new Item.Settings().group(TungstenMod.MOD_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_ingot"), TUNGSTEN_INGOT);
        Registry.register(Registry.BLOCK, new Identifier("tungstenmod", "tungsten_block"), TUNGSTEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("tungstenmod", "tungsten_tiles"), TUNGSTEN_TILES);
        Registry.register(Registry.BLOCK, new Identifier("tungstenmod", "tungsten_ore"), TUNGSTEN_ORE);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_block"), new TungstenBlockItem(TUNGSTEN_BLOCK, new FabricItemSettings().group(TungstenMod.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_tiles"), new TungstenBlockItem(TUNGSTEN_TILES, new FabricItemSettings().group(TungstenMod.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_ore"), new BlockItem(TUNGSTEN_ORE, new FabricItemSettings().group(TungstenMod.MOD_GROUP)));

        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_helmet"), TUNGSTEN_HELMET);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_chestplate"), TUNGSTEN_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_leggings"), TUNGSTEN_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_boots"), TUNGSTEN_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_sword"), TUNGSTEN_SWORD);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_pickaxe"), TUNGSTEN_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_axe"), TUNGSTEN_AXE);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_shovel"), TUNGSTEN_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("tungstenmod", "tungsten_hoe"), TUNGSTEN_HOE);
    }
}
