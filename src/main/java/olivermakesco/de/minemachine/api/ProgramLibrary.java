package olivermakesco.de.minemachine.api;

import olivermakesco.de.minemachine.machine.Machine;
import org.graalvm.polyglot.HostAccess;

/**
 * An interface for creating a library for computers
 * <br>
 * Mark exported members with the annotation {@link HostAccess.Export}
 *
 * @author Octal
 * */
public abstract class ProgramLibrary {
	public final int id;
	public ProgramLibrary(int id) {
		this.id = id;
	}

	public Machine createIsolatedMachine() {
		return new Machine(id);
	}

	public abstract String getCanonicalName();

	@HostAccess.Export
	@Override
	public String toString() {
		return "MineMachine Library: "+getCanonicalName();
	}
}
