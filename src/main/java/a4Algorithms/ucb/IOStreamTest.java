package a4Algorithms.ucb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class IOStreamTest {

	public static void main(String[] args) throws Exception {
		
		URL u = new URL("https://www.narendramodi.in/humble-beginnings-the-early-years-3131");
//		InputStream ins = u.openStream();
//		InputStreamReader isr = new InputStreamReader(ins);
//		BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
		System.out.println(br.readLine());

		br.close();
	}

}
