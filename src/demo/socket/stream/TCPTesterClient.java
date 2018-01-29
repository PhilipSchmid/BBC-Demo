/**
 * File   : TCPClient.java
 * Author : R. Scheurer (EIA-FR)
 * Date   : 20.03.2007
 * 
 * Description - a simple TCP client
 *
 */
package demo.socket.stream;

import java.net.*;
import java.io.*;

public class TCPTesterClient {

	private Socket s;
	private int clientId = 0;
	private ObjectOutputStream out;
	
	/**
	 * Constructor to build this object
	 * 
	 * @param isa InetSocketAddress including ip and port of server
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public TCPTesterClient(InetSocketAddress isa) throws IOException{
		s = new Socket(isa.getAddress(), isa.getPort());
		out = new ObjectOutputStream(s.getOutputStream());
		clientId = TCPTesterServer.id++; 
		ClientThread clientThread = new ClientThread(s);
		clientThread.start();
	}
	
	


	/* Public methods */
	/**
	 * Sends a given message to server
	 * 
	 * @param msg message to send
	 * @throws IOException 
	 */
	public void sendMsg(String msg) throws IOException {
		out.writeObject(msg);
	}
	
	/**
	 * Closes socket connection
	 * 
	 * @throws IOException
	 */
	public void closeSocket() throws IOException {
		sendMsg("Client " + clientId + " disconnected.");
		s.close();
	}

}

class ClientThread extends Thread {
	Socket socket;
	ObjectInputStream in;
	
	ClientThread(Socket s) {
		socket = s;
	}
	
	/**
	 * reads on the socket. If there are any new lines, 
	 * we do a System.out.println of the read message
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	private void read() throws IOException, ClassNotFoundException {
		String string;
		while ((string = (String) in.readObject()) != null) {
			System.out.println(string);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			read();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
