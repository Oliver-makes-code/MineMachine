package olivermakesco.de.minemachine.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.minemachine.Mod;
import olivermakesco.de.minemachine.block.entity.MachineBlockEntity;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class MachineBlock extends BlockWithEntity {
	public static MachineBlock BLOCK_INSTANCE = new MachineBlock();
	public static BlockItem ITEM_INSTANCE = new BlockItem(
			BLOCK_INSTANCE,
			new QuiltItemSettings()
					.group(ItemGroup.REDSTONE)
	);
	public static Identifier ID = Mod.id("machine");

	public MachineBlock() {
		super(QuiltBlockSettings.of(Material.METAL));
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return null;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return checkType(type, MachineBlockEntity.TYPE, (world1, pos, state1, be) -> be.tick(world1, pos, state1));
	}
}
