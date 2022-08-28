package olivermakesco.de.minemachine.machine;

import olivermakesco.de.minemachine.api.ProgramLibrary;
import olivermakesco.de.minemachine.machine.builtin.DefaultLibrary;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.HostAccess;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;

public class Machine {
	static {
		System.setProperty("polyglot.engine.WarnInterpreterOnly", "false");
	}

	public final HashMap<String, ProgramLibrary> libraries = new HashMap<>();
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
		addLibrary(new DefaultLibrary(this.id));
	}

	public void addLibrary(ProgramLibrary library) {
		libraries.put(library.getCanonicalName(), library);
		bindings.putMember(library.getCanonicalName(), library);
	}

	public Path getPath(String pathName) {
		Path path = defaultPath.resolve(pathName).toAbsolutePath().normalize();
		if (!(path.toString().startsWith(defaultPath.toString()))) return null;
		return path;
	}

	public Value exec(String programName) {
		try (InputStream stream = new FileInputStream(getPath(programName).toFile())) {
			Source source = Source.newBuilder("js", new InputStreamReader(stream), programName).build();
			return context.eval(source);
		} catch (Throwable ignored) {
		}
		return null;
	}
}
