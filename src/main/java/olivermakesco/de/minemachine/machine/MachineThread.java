package olivermakesco.de.minemachine.machine;

import java.util.ArrayList;

public class MachineThread extends Thread {
	public final int id;
	public final Machine machine;
	public ArrayList<ThreadMessage> messages = new ArrayList<>();
	public MachineThread(int id) {
		this.id = id;
		machine = new Machine(id);
	}

	@Override
	public void run() {
		boolean exit = false;
		while (!exit) {
			for (ThreadMessage message : messages) {
				switch (message.type()) {
					case RUN_FILE -> machine.exec(message.value());
					case TERMINATE -> {
						exit = true;
					}
					default -> {}
				}
				messages.remove(message);
				if (exit) break;
			}
		}
	}
}
