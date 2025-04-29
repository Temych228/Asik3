import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Test MyHashTable
        MyHashTable<MyTestingClass, String> hashTable = new MyHashTable<>();

        // Add random 10,000 elements
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = rand.nextInt(10000);
            String name = "Name" + rand.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id, name);
            hashTable.put(key, "Student" + i);
        }

        System.out.println("Size of MyHashTable: " + hashTable.size());
        int[] bucketSizes = hashTable.getBucketCounts();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + " has " + bucketSizes[i] + " elements");
        }

        // Test BST
        BST<MyTestingClass, String> bst = new BST<>();
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(rand.nextInt(10000), "Name" + rand.nextInt(10000));
            bst.put(key, "Student" + i);
        }

        System.out.println("\nBST size: " + bst.iterator().spliterator().getExactSizeIfKnown());
    }
}
