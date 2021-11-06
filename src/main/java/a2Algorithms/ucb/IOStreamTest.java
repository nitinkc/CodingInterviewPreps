package a2Algorithms.ucb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class IOStreamTest {

	public static void main(String[] args) throws Exception {
		
		URL u = new URL("http://www.narendramodi.in/humble-beginnings-the-early-years/");
//		InputStream ins = u.openStream();
//		InputStreamReader isr = new InputStreamReader(ins);
//		BufferedReader br = new BufferedReader(isr);
		BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
		
		for(int i=0;i<10;i++)
		System.out.println(br.readLine());

	}

}
