import java.io.IOException;

public class ServerManager extends SshFactory {

	public ServerManager(String ipAddress, String userName, String password) {
		super(ipAddress, userName, password);
		// TODO Auto-generated constructor stub
	}
	
	public void startThroughputServer() {
		try {
			sendCommand("killall iperf;sleep 1;killall iperf; iperf -s -u -i1 > /tmp/iperf.txt &");// /tmp/iperf.txt &");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readIperf4pair() {
		try {
			sendCommand("cat /tmp/iperf.txt | grep SUM | grep -o -P '(?<=MBytes ).*(?=Mbits)'  |tr \"\\n\" \" \" ;echo" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readIperf() {
		try {
			sendCommand("cat /tmp/iperf.txt | grep -o -P '(?<=MBytes  ).*(?=Mbits)'  |tr \"\\n\" \" \" ;echo" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
