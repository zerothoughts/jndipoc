import java.io.*;
import javax.naming.*;

public class FlawedSerializable implements Serializable {
	String address = "";
	
	public FlawedSerializable(String address) {
		this.address = address;
	}
	
	private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
		objectOutputStream.writeObject(address);
	}
	
	private void readObject(ObjectInputStream objectInputStream) throws Exception {
		objectInputStream.defaultReadObject();
		InitialContext context = new InitialContext();
		context.lookup(address);
	}
}
