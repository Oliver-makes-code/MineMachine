package olivermakesco.de.minemachine.mixin;

import olivermakesco.de.minemachine.machine.Machine;
import olivermakesco.de.minemachine.machine.MachineThread;

import java.util.List;

public interface MM_Duck_MachineAccess {
	List<MachineThread> MM$getLoadedMachines();
	void MM$loadMachine(MachineThread machine);
	void MM$unloadMachine(MachineThread machine);
	int MM$requestNewMachine();
}
