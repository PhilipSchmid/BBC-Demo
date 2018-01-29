package demo.socket.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTesterServer {

	public static void main(String[] args) {
		// Server
		DatagramSocket dgs = null;
		try {

			dgs = new DatagramSocket(4711);

			while(true) { 
				DatagramPacket dp = new DatagramPacket(
						new byte[1024], 1024);
				dgs.receive(dp);
				InetAddress adr = dp.getAddress();
				int port = dp.getPort();
				int len = dp.getLength();
				byte[] data = dp.getData();
				String msg = new String(data);
				System.out.println("Received from " + adr.toString() + ":" + port + " " + len + " bytes: " + msg);
			}
		} catch (Exception  e) {
			System.err.println(e.getMessage());
		} finally {
			if (dgs != null) {
				dgs.close();
			}
		}
	}

}
