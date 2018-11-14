import java.io.IOException;

import javax.naming.OperationNotSupportedException;
import static net.sf.expectit.matcher.Matchers.contains;
import org.apache.commons.net.telnet.TelnetClient;

import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;

public class TelnetManager extends SshFactory{

	public TelnetManager(String ipAddress, String userName, String password)  {
		super(ipAddress, userName, password);
		// TODO Auto-generated constructor stub
	}

	
	public void getNrate(String ipAddressTelnet) {
		try {
			sendCommand("telnetcommand.sh " + ipAddressTelnet+  " \"nrate\" > /tmp/telnetnrate.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getRate(String ipAddressTelnet) {
		try {
			sendCommand("telnetcommand.sh " + ipAddressTelnet+  " \"rate\" > /tmp/telnetrate.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readNrate() {
		try {
			sendCommand("cat /tmp/telnetnrate.txt | grep ldpc ;echo" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readRate() {
		try {
			sendCommand("cat /tmp/telnetrate.txt | grep Mbps ;echo" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readRssi(String ipAddressTelnet, String userNameTelnet, String passwordTelnet) {
		
	}
	

}
