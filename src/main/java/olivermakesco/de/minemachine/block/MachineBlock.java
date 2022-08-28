package olivermakesco.de.minemachine.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import olivermakesco.de.minemachine.Mod;
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
}
