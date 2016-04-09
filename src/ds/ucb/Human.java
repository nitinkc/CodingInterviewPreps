package ds.ucb;

public class Human {
	//If private other classes can't use them
	public int age; //default is 0
	public String name; //default is null
	public static int noOfHumans;
	
	public void introduce(){
		
		System.out.println("I am "+name+" and I am "+age
				+" years old.");
	}
	
	public void copyHuman(Human orignal){ //Object as a parameter
		age = orignal.age; //this.age = age, if age is passed as argument
		name = orignal.name;	
	}
	
	public Human(){ //default value is set here...default goes away
		
		noOfHumans++;
	}
	
	public Human(String name){
		this.age = 21;
		this.name = name;
	}
	
	public Human(int age){
		this.age = age;
		this.name = "name already set";
	}
	
	public Human(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public Human(String name, int age){
		this.age = age;
		this.name = name;
	}
	
	
	
	
	
		
}
