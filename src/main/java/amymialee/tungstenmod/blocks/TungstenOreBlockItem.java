package amymialee.tungstenmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TungstenOreBlockItem extends BlockItem {
    public TungstenOreBlockItem(Block block, Settings settings) {
        super(block, settings);
    }



    /*
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText("block.tungstenmod.tungsten_ore.tooltip").formatted(Formatting.DARK_GRAY));
    }
     */
}