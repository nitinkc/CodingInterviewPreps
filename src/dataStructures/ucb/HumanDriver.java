package dataStructures.ucb;

public class HumanDriver {

	public static void main(String[] args) {
		
		Human a = new Human();
		a.introduce();//with default variable

		Human b = new Human();
		b.age = 6;
		b.name = "Amenda";
		b.introduce();
		
		Human c = new Human();
		c.age = 13;
		c.name = "Nitin";
		c.introduce();		
		
		b.copyHuman(c);
		b.introduce();
		
		Human d = new Human("Sindhu R");
		d.introduce();
		
		//Human.noOfHumans

	}

}
