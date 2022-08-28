package olivermakesco.de.minemachine.mixin;

import net.minecraft.server.world.ServerWorld;
import olivermakesco.de.minemachine.machine.Machine;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerWorld.class)
public class MM_Mixin_ServerWorld implements MM_Duck_MachineAccess {
	@Override
	public Machine MM$getLoadedMachines() {
		return null;
	}

	@Override
	public int MM$requestNewMachine() {
		return 0;
	}
}
