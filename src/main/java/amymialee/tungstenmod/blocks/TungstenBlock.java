package amymialee.tungstenmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TungstenBlock extends Block {

    public TungstenBlock(Settings settings) {
        super(settings);
    }

    public void onSteppedOn(World world, BlockPos pos, Entity entity) {
        if (LivingEntity.class.isAssignableFrom(entity.getClass())) {
            if (((LivingEntity) entity).getGroup() == EntityGroup.ARTHROPOD) {
                entity.damage(DamageSource.MAGIC, 3.0F);
            }
        }
        super.onSteppedOn(world, pos, entity);
    }

    public BlockSoundGroup getSoundGroup(BlockState state) {
        return this.soundGroup;
    }
}