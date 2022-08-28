package olivermakesco.de.minemachine.mixin;

import net.minecraft.server.world.ServerWorld;
import olivermakesco.de.minemachine.machine.MachineThread;
import olivermakesco.de.minemachine.machine.ThreadMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.List;

@Mixin(ServerWorld.class)
public class MM_Mixin_ServerWorld implements MM_Duck_MachineAccess {
	@Unique
	private final ArrayList<MachineThread> machines = new ArrayList<>();
	@Unique
	private int machineCount = 0;

	@Override
	public List<MachineThread> MM$getLoadedMachines() {
		return machines;
	}

	@Override
	public void MM$loadMachine(MachineThread machine) {
		machines.add(machine);
	}

	@Override
	public void MM$unloadMachine(MachineThread machine) {
		machine.messages.add(new ThreadMessage(ThreadMessage.MessageType.TERMINATE, ""));
		machines.remove(machine);
	}

	@Override
	public int MM$requestNewMachine() {
		return machineCount++;
	}
}
