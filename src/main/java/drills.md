
# Daily Drill

### 1D Array
- Declare simple array
```java
int[] a = new int[3];//use [] for array instead of ()
int[] a = new int[] {1,2,3};
// Same as above
int[] b = {1,2,3};
```
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

# Arrays Class

```java
int intArray[] = {4,5,3,8,2,71};
Arrays.sort(intArray);
Arrays.sort(integerArray, Comparator.reverseOrder());//Reverse sorting
```

# Maps

```java
map.containsKey(key) /* returns true if the key is in the map, false otherwise.*/
map.containsValue(value)
```

getOrDefault
```java
for (String str: list) {
    map.put(str, map.getOrDefault(str,0) + 1);//count number of occurances
}
```

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

