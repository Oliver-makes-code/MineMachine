package olivermakesco.de.minemachine.machine.builtin;

import olivermakesco.de.minemachine.api.ProgramLibrary;
import olivermakesco.de.minemachine.machine.Machine;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;

public class IoLibrary extends ProgramLibrary {
	public IoLibrary(Machine machine) {
		super(machine);
	}

	@Override
	public String getCanonicalName() {
		return "io";
	}

	@HostAccess.Export
	public Value load(String fileName) {
		return null;
	}
}
