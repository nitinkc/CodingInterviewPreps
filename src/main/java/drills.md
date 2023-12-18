
# Daily Drill

### 1D Array
- Declare simple array
```java
int[] a = new int[3];//use [] for array instead of ()
int[] a = new int[] {1,2,3};
// Same as above
int[] b = {1,2,3};
```
`a.length` is a field in array

- Declare an ArrayList using `Arrays.asList()`
```java
List<String> list = Arrays.asList("str1","str2");
```
### 2D Array
Declare and Iterate through the 2D Array
```java
// Declaring a Rectangular Matrix
String arr[][] = new String[6][7];
int row = arr.length;// Row = 6
int col = arr[0].length; // Columns = 7
for (int i = 0; i < arr[0].length; i++) {
   for (int j = 0; j < arr[i].length; j++) {
        arr2[i][j] = "-" + i + "_" + j;
   }
}
```

# Maps

```java
map.containsKey(key) /* returns true if the key is in the map, false otherwise.*/
map.containsValue(value)
```

- getOrDefault
```java
for (String str: list) {
    map.put(str, map.getOrDefault(str,0) + 1);//count number of occurances
}
```
- traditional
```java
for (String str: namesList) {
    if(treeMap.containsKey(str))
        treeMap.put(str, map.get(str) + 1);
    else
        treeMap.put(str,1);
}
```

### Remove from Map
```java
/* removes the key/value pair for this key if present. Does nothing if the key is not present. */
map.remove(key);// Concurrent Modification Exception in a Loop
itr.remove();// used to avoid concurrent modification exception using an Iterator
```
### Navigate/Iterate

- map.entrySet()
```java
// Iterate over the map using entrySet()
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
}
```

- map.keySet().iterator()
```java
Iterator<String> itr = map.keySet().iterator();
while (itr.hasNext()){
    String key = itr.next();
    Integer value = map.get(key);
}
```

- map forEach - Takes in a BiConsumer (key,value)
```java
treeMap.forEach((name, length) -> System.out.println(name + ": " + length));
```

### HashMap


### TreeMap - Comparator needed

```java
Map<String, Integer> treeMap = new TreeMap<>();
Map<String, Integer> treeMapReversed =new TreeMap<>(Comparator.reverseOrder());
Map<String, Integer> treeMap = new TreeMap<>(Comparator.comparing(String::length));

for (String name : namesList) {
    treeMap.put(name, name.length());
}
```

# Integer

```java
Integer fromPrimitiveInt = Integer.valueOf(12);
Integer fromString = Integer.valueOf("123");//NOT NULL SAFE
Double fromPrimitiveInt = Double.valueOf(12.36);//From String or primitive to Wrapper
Double fromString = Double.valueOf("90.25");
```

### to primitive Ints

```java
//To Primitive Ints
int i = Integer.parseInt("12345");//Parses strings into primitive int; From String to primitive
int j = Integer.valueOf("1234").intValue();//From String or primitive to Wrapper
int k =  Integer.valueOf(23).intValue();

double i = Double.parseDouble("12345");//Parses strings into primitive int; From String to primitive
double j = Double.valueOf("1234").doubleValue();//From String or primitive to Wrapper
double k = Double.valueOf(23);
```

# Character

```java
Character d = Character.valueOf('c');//From primitive to Wrapper
        
char myChar = 'a';
int asciiValue = (int) myChar;
System.out.println("From type Casting "+asciiValue);

        
// Same can be achieved through the library method
//Returns unicode for characters from 10 to 35
System.out.println(Character.getNumericValue('A'));//DO NOT USE THIS
System.out.println(Character.getNumericValue(myChar));
System.out.println(Character.getNumericValue('1'));

System.out.println(Character.isLetter('r'));
System.out.println(Character.isDigit('4'));
System.out.println(!Character.isLetterOrDigit('!'));//punctuation mark
        
System.out.println(Character.compare('1','1'));//Compare character
```

# String

# Sorting

### Arrays Class
`Arrays.sort(arr)` returns void
```java
int intArray[] = {4,5,3,8,2,71};
Arrays.sort(intArray);//Default Natural Sorting Order
Arrays.sort(integerArray, Comparator.reverseOrder());//Reverse sorting
```
### List

```java
List<Integer> list = Arrays.asList(4,5,3,8,2,71);
list.sort(Comparator.naturalOrder());
list.sort(Comparator.reverseOrder());
System.out.println("List Sort " + list);

List<String> stringList = Arrays.asList("apple", "banana", "orange");
stringList.sort(Comparator.comparing(String::length).reversed());
```

### Collections sort
```java
List<Integer> integerListWithNull = Arrays.asList(5, 6, null, 71, 2, 3);
Collections.sort(integerListWithNull, Comparator.nullsLast(Comparator.naturalOrder()));

Collections.sort(integerListWithoutNull, Collections.reverseOrder());

List<String> stringList = Arrays.asList("apple","banana", "orange");
Collections.sort(stringList, Comparator
    .comparing(String::length)
    .thenComparing(Comparator.reverseOrder()));
```