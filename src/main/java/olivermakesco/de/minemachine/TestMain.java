package olivermakesco.de.minemachine;

import olivermakesco.de.minemachine.machine.Machine;

public class TestMain {
	public static void main(String[] args) {
		Machine machine = new Machine(0);
		machine.exec("test.js");
	}
}
