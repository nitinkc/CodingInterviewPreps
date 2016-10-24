//package aDA.AfterNO.WillPower;
//
//import static org.junit.Assert.*;
//
//import org.junit.GenericSort;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import java.util.Arrays;
//import java.util.Random;
//
//import org.junit.Before;
//import org.junit.GenericSort;
//
//public class MergeSortTest {
//
//  private int[] numbers;
//  private final static int SIZE = 700;
//  private final static int MAX = 20000;
//
//  @Before
//  public void setUp() throws Exception {
//    numbers = new int[SIZE];
//    Random generator = new Random();
//    for (int i = 0; i < numbers.length; i++) {
//      numbers[i] = generator.nextInt(MAX);
//    }
//  }
//
//  @GenericSort
//  public void testMergeSort() {
//    long startTime = System.currentTimeMillis();
//
//    MergeSort sorter = new MergeSort();
//    sorter.mergeSort(numbers, 0, numbers.length-1 );
//
//    long stopTime = System.currentTimeMillis();
//    long elapsedTime = stopTime - startTime;
//    System.out.println("Mergesort " + elapsedTime);
//
//    for (int i = 0; i < numbers.length - 1; i++) {
//      if (numbers[i] > numbers[i + 1]) {
//        fail("Should not happen");
//      }
//    }
//    assertTrue(true);
//
//  }
//
//  @GenericSort
//  public void itWorksRepeatably() {
//    for (int i = 0; i < 200; i++) {
//      numbers = new int[SIZE];
//      Random generator = new Random();
//      for (int a = 0; a < numbers.length; a++) {
//        numbers[a] = generator.nextInt(MAX);
//      }
//      MergeSort sorter = new MergeSort();
//      sorter.mergeSort(numbers, 0, numbers.length-1);
//      for (int j = 0; j < numbers.length - 1; j++) {
//        if (numbers[j] > numbers[j + 1]) {
//          fail("Should not happen");
//        }
//      }
//      assertTrue(true);
//    }
//  }
//
//  @GenericSort
//  public void testStandardSort() {
//    long startTime = System.currentTimeMillis();
//    Arrays.sort(numbers);
//    long stopTime = System.currentTimeMillis();
//    long elapsedTime = stopTime - startTime;
//    System.out.println("Standard Java sort " + elapsedTime);
//
//    for (int i = 0; i < numbers.length - 1; i++) {
//      if (numbers[i] > numbers[i + 1]) {
//        fail("Should not happen");
//      }
//    }
//    assertTrue(true);
//  }
//
//}
