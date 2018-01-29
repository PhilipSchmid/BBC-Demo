package demo.socket.urlconnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTester {

	public static void main(String[] args) {
		try {
			//URL u = new URL("http://www.bbcag.ch/");
			URL u = new URL("http://www.google.ch/");

			URLConnection uc = u.openConnection();
			uc.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
