package demo.socket.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServerTester {

	public static void main(String[] args) {
		MulticastSocket ms = null;
		try {
			InetAddress group = InetAddress.getByName("228.5.6.7");
			ms = new MulticastSocket(6789);
			ms.joinGroup(group);
			byte[] buf = new byte[1000];
			DatagramPacket dpRecv = new DatagramPacket(buf, buf.length);
			ms.receive(dpRecv);
			String msg = new String(buf);
			System.out.println("Got message: " + msg);
			ms.leaveGroup(group);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (ms != null) {
				ms.close();
			}
		}
	}

}
