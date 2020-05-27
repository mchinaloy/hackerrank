package hashtables;

import java.util.ArrayList;

public class HashTableChainingSimpleImplementation {

    static class HashNode<K, V> {

        public K key;
        public V value;

        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    static class SimpleHashTable<K,V> {

        private int numBuckets = 10;

        private ArrayList<HashNode<K, V>> bucketArray;

        public SimpleHashTable() {
            bucketArray = new ArrayList<>(numBuckets);
            for(int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }
        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> bucket = bucketArray.get(bucketIndex);

            while(bucket != null) {
                if(bucket.key.equals(key)) {
                    return bucket.value;
                }
                bucket = bucket.next;
            }

            return null;
        }

        public void put(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> nodeToInsert = new HashNode<>(key, value);

            HashNode<K,V> bucket = bucketArray.get(bucketIndex);

            if(bucket == null) {
                bucketArray.set(bucketIndex, nodeToInsert);
            } else {
                while(bucket.next != null) {
                    bucket = bucket.next;
                }
                bucket.next = nodeToInsert;
                bucketArray.set(bucketIndex, bucket);
            }
        }

        public V remove(K key) {
            int bucketIndex = getBucketIndex(key);
            HashNode<K, V> bucket = bucketArray.get(bucketIndex);

            if(bucket.key == key) {
                bucketArray.set(bucketIndex, bucket.next);
                return bucket.value;
            }

            while(bucket.next != null) {
                if(bucket.next.key.equals(key)) {
                    HashNode<K, V> nodeToRemove = bucket.next;
                    bucket.next = bucket.next.next;
                    bucketArray.set(bucketIndex, bucket);
                    return nodeToRemove.value;
                }
                bucket = bucket.next;
            }

            return null;
        }

        private int getBucketIndex(K key) {
            int hashCode = key.hashCode();
            return hashCode % numBuckets;
        }

    }

    public static void main(String[] args) {
        SimpleHashTable<String, Integer> simpleHashTable = new SimpleHashTable<>();
        simpleHashTable.put("One", 1);
        simpleHashTable.put("Two", 2);
        simpleHashTable.put("Three", 3);
        simpleHashTable.put("Four", 4);

        System.out.println(simpleHashTable.get("One"));
        System.out.println(simpleHashTable.get("Two"));
        System.out.println(simpleHashTable.get("Three"));
        System.out.println(simpleHashTable.get("Four"));

        simpleHashTable.remove("Two");

        System.out.println(simpleHashTable.get("One"));
        System.out.println(simpleHashTable.get("Three"));
        System.out.println(simpleHashTable.get("Four"));
    }

}
