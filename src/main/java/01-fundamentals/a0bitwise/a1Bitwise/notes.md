short - 16 bits - 2^16 numbers -> -32768 32767
int - 32 bits
long - 64 bits


//LSB and & operator
short lsb = (short) (binNum & 1);//Give ONLY the LSB

//Rightmost Set bit : the 1 from the LSB

https://nitinkc.github.io/algorithms/bitwise-coding/


1 + 1 = 10 -> with Carry over bit

1 ^ 1 == 1 + 1 = 0 -> without carry bit (a ^ b)
0 ^ 0 == 0 + 0 = 0
1 ^ 0 == 1 + 0 = 1
0 ^ 1 == 0 + 1 = 1


(a & ~b) | (~a & b) = a ^ b => Exclusive OR

```java
if ((flag1 & !flag2) || (!flag1 & flag2)){//Intuitive and Self explanatory

}

if (flag ^ flag2){//Optimized

}
```



 
