package manage;

public class Stats<T extends Number> {

	T[] nums;
	double sum = 0.0 ;

	public Stats(T[] o) {
		nums=o;
		}

		public double average(){
			for (int i=0;i<nums.length;i++)
				sum += nums[i].doubleValue();		
		return sum/nums.length;
	}
}

