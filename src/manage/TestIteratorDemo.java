package manage;

import java.util.*;

public class TestIteratorDemo {
	public static void main(String a[]){
		ArrayList<String> list = new ArrayList<String>();
	}

	public static void removeEvenLength(ArrayList<String> list){
		Iterator<String> itr = list.iterator();
		String i = "";
		while (itr.hasNext()){
			i = itr.next();
			if (i.length()%2 == 0){
				list.remove(itr);
			}
		}
	}
}