# tradingAlgorithm

The solution to this problem has been implemented using Java 8. The code is made performant by not using any loops, iterators etc. The code has been written with due care to instantiate minimum number of objects.

Assumption:
In case of the price change for more than 4 times, last 4 prices are considered for taking the average.

For thread safety, i have used ConcurrentHashMap as well as Synchronized block for write and delete operations on the Map.

