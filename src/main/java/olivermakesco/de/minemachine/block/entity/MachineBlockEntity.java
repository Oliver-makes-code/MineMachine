package olivermakesco.de.minemachine.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.minemachine.Mod;
import olivermakesco.de.minemachine.block.MachineBlock;
import olivermakesco.de.minemachine.machine.MachineThread;
import olivermakesco.de.minemachine.mixin.MM_Duck_MachineAccess;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityType;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;

public class MachineBlockEntity extends BlockEntity {
	public static final BlockEntityType<MachineBlockEntity> TYPE = QuiltBlockEntityTypeBuilder.create(
			MachineBlockEntity::new,
			MachineBlock.BLOCK_INSTANCE
	).build();
	public static Identifier ID = Mod.id("machine");
	public int id = -1;
	MachineThread thread;

	public MachineBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(TYPE, blockPos, blockState);
	}


	public void tick(World world, BlockPos pos, BlockState state) {
		var duckWorld = (MM_Duck_MachineAccess) world;
		if (thread == null) {
			if (id == -1) {
				id = duckWorld.MM$requestNewMachine();
			}
			thread = new MachineThread(id);
		}
	}
}
