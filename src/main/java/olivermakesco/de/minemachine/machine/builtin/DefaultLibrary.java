package olivermakesco.de.minemachine.machine.builtin;

import olivermakesco.de.minemachine.api.ProgramLibrary;
import olivermakesco.de.minemachine.machine.Machine;
import org.graalvm.polyglot.HostAccess;

public class DefaultLibrary extends ProgramLibrary {
	public Object export;

	public DefaultLibrary(int id) {
		super(id);
	}

	@Override
	public String getCanonicalName() {
		return "program";
	}

	@HostAccess.Export
	public Object load(String fileName) {
		Machine isolated = createIsolatedMachine();
		isolated.exec(fileName);
		return ((DefaultLibrary)isolated.libraries.get(getCanonicalName())).export;
	}

	@HostAccess.Export
	public void export(Object obj) {
		export = obj;
	}
}
