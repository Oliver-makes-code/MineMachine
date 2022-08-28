package olivermakesco.de.minemachine.machine;

public record ThreadMessage(
		MessageType type,
		String value
) {
	public enum MessageType {
		RUN_FILE,
		TERMINATE
	}
}
