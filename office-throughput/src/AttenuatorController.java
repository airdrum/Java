import java.io.IOException;

public class AttenuatorController extends SshFactory{

	public AttenuatorController(String ipAddress, String userName, String password) {
		super(ipAddress, userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public void attenuate(String value) {
		
		try {
			String strSend = "sudo echo \"Tesla a " + value + "\" > /dev/ttyACM0";
			System.out.println(strSend);
			sendCommand( strSend );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void attenuate(int value) {
		
		try {
			String strSend = "sudo echo \"Tesla a " + String.valueOf(value) + "\" > /dev/ttyACM0"; 
			System.out.println(strSend);
			sendCommand( strSend +"> /dev/ttyACM0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
