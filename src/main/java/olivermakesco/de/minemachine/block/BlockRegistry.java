package olivermakesco.de.minemachine.block;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.minemachine.block.entity.MachineBlockEntity;

public class BlockRegistry {
	public static void register() {
		registerBlockWithItem(MachineBlock.ID, MachineBlock.BLOCK_INSTANCE, MachineBlock.ITEM_INSTANCE);

		registerBlockEntity(MachineBlockEntity.ID, MachineBlockEntity.TYPE);
	}

	public static void registerBlockEntity(Identifier id, BlockEntityType<?> be) {
		Registry.register(Registry.BLOCK_ENTITY_TYPE, id, be);
	}

	public static void registerBlock(Identifier id, Block block) {
		Registry.register(Registry.BLOCK, id, block);
	}

	public static void registerBlockWithItem(Identifier id, Block block, Item item) {
		Registry.register(Registry.BLOCK, id, block);
		Registry.register(Registry.ITEM, id, item);
	}
}
