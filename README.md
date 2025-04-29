Assignment 3: HashTable & BST  
This project implements two data structures from scratch in Java.

1. MyHashTable<K, V>  
- Hash table with separate chaining using linked lists  
- Methods: put, get, remove, contains, getKey, size  
- Adjustable number of buckets  
- Tested with 10000 random entries

2. BST<K, V>  
- Binary search tree without recursion in insert and delete  
- Methods: put, get, delete, containsKey, size  
- In-order iteration via Iterable<Map.Entry<K, V>>

Files  
MyHashTable.java – hash table code  
BST.java – binary search tree code  
MyTestingClass.java – custom key class with hashCode and equals  
Main.java – test program that  
 adds 10000 random MyTestingClass→Student pairs into MyHashTable and prints bucket sizes  
 adds 10000 into BST and prints its size  

How to run  
Compile all java files with  
javac *.java  
Then run  
java Main 
