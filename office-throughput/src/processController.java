import java.text.SimpleDateFormat;
import java.util.Calendar;

public class processController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TurntableManager turntable = new TurntableManager("10.20.0.155", "turntable", "turntable");
		ServerManager server = new ServerManager("10.20.4.1", "systems-host", "systems");
		ClientManager client = new ClientManager("10.20.4.3", "systems-host", "systems");
		AttenuatorController attenuator = new AttenuatorController("10.20.4.1", "systems-host", "systems");	
		int att[] = {0,5,10,15,20,25,30,35,37,39,40,41,42,43};
		String time[] = {"10","30","60","100"};
		int i = 0;
		while (i<att.length) {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			System.out.println("******"+timeStamp+"*******");
			System.out.println("*****Attenuation: "+att[i] + "*******");
			attenuator.attenuate(att[i]);
			int degree = 0;
			System.out.println("49201 149/80 Full analysis Throughput Test Results");
			while (degree < 360) {
				System.out.print(degree+":");
				turntable.rotate(degree);
				server.startThroughputServer();
	
				client.startThroughputClient("192.168.2.20","20");
				server.readIperf();
				degree = degree + 5;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		i++;
		}
	}

}
