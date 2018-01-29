package demo.socket.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MuilticastClientTester {

	public static void main(String[] args) {
		MulticastSocket ms = null;
		try {
			while (true) {
				String msg = "Bluuub";
				InetAddress group = InetAddress.getByName("228.5.6.7");
				ms = new MulticastSocket(6789);
				ms.joinGroup(group);
				DatagramPacket dpSend = new DatagramPacket(
				    msg.getBytes(), msg.length(), group, 6789);
				ms.send(dpSend);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (ms != null) {
				ms.close();
			}
		}
	}

}
