import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;



public class SshFactory {
	Session session = null;
	String m_sendData;
	String m_readData;
	String m_ipAddress;
	String m_userName;
	String m_password;
	ChannelExec channel;
	public SshFactory(String ipAddress, String userName, String password) {
		
		this.m_ipAddress = ipAddress;
		this.m_userName = userName;
		this.m_password = password;
		
		try {
			if (checkConnection(ipAddress)) {}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	public void sendCommand(String command) throws IOException {

		try {
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(m_userName, m_ipAddress, 22);
			session.setPassword(m_password);
			session.setConfig(config);
			session.connect();

		      Channel channel=session.openChannel("exec");
		      ((ChannelExec)channel).setCommand("sudo -S -p '' "+command);


		      InputStream in=channel.getInputStream();
		      OutputStream out=channel.getOutputStream();
		      ((ChannelExec)channel).setErrStream(System.err);

		      channel.connect();

		      out.write((m_password+"\n").getBytes());
		      out.flush();

		      byte[] tmp=new byte[1024];
		      while(true){
		        while(in.available()>0){
		          int i=in.read(tmp, 0, 1024);
		          if(i<0)break;
		          System.out.print(new String(tmp, 0, i));
		        }
		        if(channel.isClosed()){
		          break;
		        }
		        try{Thread.sleep(1000);}catch(Exception ee){}
		      }
		      channel.disconnect();
		      session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
     
	
	public String readData() {
		return null;
	}



	public boolean checkConnection(String ipAddress) throws IOException {
		Process proc = Runtime.getRuntime().exec("ping -n 5 " + ipAddress);
	      int returnValp1 = 0;
		try {
			returnValp1 = proc.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      boolean reachablep1 = returnValp1 == 0;
        if (reachablep1) {
    		System.out.println(ipAddress + " is reachable in the network.");
    		return true;
		}else {
			System.out.println(ipAddress + " is NOT reachable in the network. ");
			return false;
		}
	}
}
