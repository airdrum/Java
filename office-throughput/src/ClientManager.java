import java.io.IOException;

public class ClientManager extends SshFactory {

	public ClientManager(String ipAddress, String userName, String password) {
		super(ipAddress, userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public void startThroughputClient(String ipAddress, String time) {
		try {
			sendCommand("killall iperf;killall iperf;iperf -c "+ ipAddress +" -u -b800M -i1 -t"+time+" > /dev/null");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
