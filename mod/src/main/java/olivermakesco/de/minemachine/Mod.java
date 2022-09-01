package olivermakesco.de.minemachine;

import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mod implements ModInitializer {
	public static final String MODID = "minemachine";
	public static final Logger LOGGER = LoggerFactory.getLogger("Mine Machine");

	@Override
	public void onInitialize(ModContainer mod) {
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
