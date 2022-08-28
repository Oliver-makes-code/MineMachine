package olivermakesco.de.minemachine.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import olivermakesco.de.minemachine.Mod;
import olivermakesco.de.minemachine.block.MachineBlock;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityType;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;

public class MachineBlockEntity extends BlockEntity {
	public static final BlockEntityType<?> TYPE = QuiltBlockEntityTypeBuilder.create(
			MachineBlockEntity::new,
			MachineBlock.BLOCK_INSTANCE
	).build();
	public static Identifier ID = Mod.id("machine");

	public MachineBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TYPE, blockPos, blockState);
	}

	
}
