package olivermakesco.de.minemachine.machine.builtin;

import olivermakesco.de.minemachine.api.ProgramLibrary;
import olivermakesco.de.minemachine.machine.Machine;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;

import javax.crypto.Mac;
import java.util.HashMap;

public class IoLibrary extends ProgramLibrary {
	public Object export;

	public IoLibrary(int id) {
		super(id);
	}

	@Override
	public String getCanonicalName() {
		return "io";
	}

	@HostAccess.Export
	public Object loadProgram(String fileName) {
		Machine isolated = createIsolatedMachine();
		isolated.exec(fileName);
		return ((IoLibrary)isolated.libraries.get(getCanonicalName())).export;
	}

	@HostAccess.Export
	public void export(Object obj) {
		export = obj;
	}
}
