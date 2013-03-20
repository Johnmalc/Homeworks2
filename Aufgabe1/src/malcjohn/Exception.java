package malcjohn;

/**
 * @author johnmalc
 * @author heiko
 * @author thomas
 * 
 */
@SuppressWarnings("serial")
public class Exception extends IllegalStateException {
	String fehler;

	public Exception(String fehler) {
		super(fehler);
	}

	public Exception() {

	}

}
