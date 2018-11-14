import java.io.IOException;

public class TurntableManager extends SshFactory {

	public TurntableManager(String ipAddress, String userName, String password) {
		super(ipAddress, userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public void rotate(String angle) {
		
		try {
			sendCommand("turntable -g" +angle + " > /dev/null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rotate(int angle) {
		
		try {
			sendCommand("turntable -g"+String.valueOf(angle)+ " > /dev/null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void calibrate() {
		
		try {
			sendCommand("turntable -c");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
