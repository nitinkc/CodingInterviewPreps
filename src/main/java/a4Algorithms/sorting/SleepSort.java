package a4Algorithms.sorting;

public class SleepSort {
	
	public static void main(String[] args) {
		int[] nums = { 1, 4, 2, 6, 8, 5, 6, 9 };
		sleepSortAndPrint(nums);
	}

	public static void sleepSortAndPrint(int[] nums) {

//        final CountDownLatch doneSignal = new CountDownLatch(nums.length);
//
//        final Integer num = 0;
//        for (num : nums) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    doneSignal.countDown();
//                    try {
//                        doneSignal.await();
//
//                        // using straight milliseconds produces unpredictable
//                        // results with small numbers
//                        // using 1000 here gives a nifty demonstration
//                        Thread.sleep(num * 100);
//                        System.out.print(num + "  ");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
        }
    }
