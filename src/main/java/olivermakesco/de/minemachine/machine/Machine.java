package olivermakesco.de.minemachine.machine;

import olivermakesco.de.minemachine.Mod;
import olivermakesco.de.minemachine.api.ProgramLibrary;
import olivermakesco.de.minemachine.machine.builtin.IoLibrary;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.ArrayList;

public class Machine {
	static {
		System.setProperty("polyglot.engine.WarnInterpreterOnly", "false");
	}

	final ArrayList<ProgramLibrary> libraries = new ArrayList<>();
	public final int id;
	Context context;
	Value bindings;
	final Path defaultPath;

	public Machine(int id) {
		this.id = id;
		defaultPath = Path.of("computers/"+id).toAbsolutePath().normalize();
		reset();
	}

	public void reset() {
		context = Context
				.newBuilder("js")
				.allowHostAccess(HostAccess.EXPLICIT)
				.allowHostClassLoading(false)
				.useSystemExit(false)
				.build();
		bindings = context.getBindings("js");
		libraries.clear();
		new IoLibrary(this);
	}

	public void addLibrary(ProgramLibrary library) {
		libraries.add(library);
		bindings.putMember(library.getCanonicalName(), library);
	}


	public Path getPath(String pathName) {
		Path path = defaultPath.resolve(pathName).toAbsolutePath().normalize();
		if (!(path.toString().startsWith(defaultPath.toString()))) return null;
		return path;
	}

	public boolean exec(String programName) {

		return false;
	}
}
