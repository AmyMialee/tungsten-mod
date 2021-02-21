package amymialee.tungstenmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class TungstenMod implements ModInitializer {

    private static final ConfiguredFeature<?, ?> ORE_TUNGSTEN_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    RegisterItems.TUNGSTEN_ORE.getDefaultState(),
                    9))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(2);

    public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.create(
            new Identifier("tungstenmod", "general"))
            .icon(() -> new ItemStack(RegisterItems.TUNGSTEN_INGOT))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_SWORD));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_PICKAXE));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_AXE));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_SHOVEL));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_HOE));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_HELMET));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_CHESTPLATE));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_LEGGINGS));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_BOOTS));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_INGOT));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_ORE));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_TILES));
                stacks.add(new ItemStack(RegisterItems.TUNGSTEN_BLOCK));
            })
            .build();

    @Override
    public void onInitialize() {
        RegisterItems.register();

        RegistryKey<ConfiguredFeature<?, ?>> oreTungstenOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("tungstenmod", "ore_tungsten_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreTungstenOverworld.getValue(), ORE_TUNGSTEN_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreTungstenOverworld);
    }
}