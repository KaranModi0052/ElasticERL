package ERL;

import java.util.Random;

public class HashTable {
    private long[] keys;
    private Node[] data;
    private int size;
    private int count;
    private int hashValue;
    public HashTable(int size){
        SetINThreshold(size);
        data = new Node[1000];
        keys = new long[this.size];
        for(int i=0;i<this.size;i++){
            keys[i] = -1;
        }
    }
    class Node{
        long key;
        String val;
        Node next;
        public Node(long key,String val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public boolean contains(long [] keys,long id) {
        for (long element : keys) {
            if (element == id) {
                return true;
            }
        }
        return false;
    }


    public long generate(){
        Random rnd = new Random();
        long key = rnd.nextInt(99999999);
        while(contains(keys,key)) {
            key = rnd.nextInt(99999999);
        }
        return key;
    }
    private void SetINThreshold(int size){
        this.size = size;
    }

    public  int calculateHash(long key) {
        String strNumber = String.valueOf(key); // Convert number to string
        hashValue =0;
        for (int i = 0; i < strNumber.length(); i++) {
            hashValue = (hashValue * 10 + Character.getNumericValue(strNumber.charAt(i))) % 1000;
        }
        return hashValue;
    }
    public long[] allKeys(HashTable ERL) {
        long[] updatedKeys = new long[ERL.count];
        int i = -1;
        for (int j = 0; j < ERL.size; j++) {
            if (keys[j] != -1) {
                i++;
                updatedKeys[i] = keys[j];
            }
        }
        return updatedKeys;
    }
    public void add(HashTable ERL, long key, String value) {
        int duplicateCount=0;
        if(!contains(keys,key)){
            int hashValue = calculateHash(key);
            Node newNode = new Node(key, value, null);
            if (data[hashValue] == null) {
                data[hashValue] = newNode;
            } else {
                Node temp = data[hashValue];
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            keys[count] = key;
            count++;
            if (count > size) {
                reSizeArray();
            }
        }

    }
    public void remove(HashTable ElasticERL, long key) {
        if (contains(keys, key)) {
            int hashValue = calculateHash(key);
            Node temp = data[hashValue];
            Node prev = null; // Keep track of previous node
            while (temp != null && temp.key != key) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Key not found in ERL.ElasticERL!");
                return;
            }
            if (prev == null) { // If key is in the first node of the linked list
                data[hashValue] = temp.next;
            } else {
                prev.next = temp.next; // Update previous node's next pointer
            }
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == key) {
                    keys[i] = -1; // Shift keys to fill the gap
                    break;
                }
            }
            System.out.println("Entry removed with given key: " + key);
            count--;
        } else {
            System.out.println("Given key does not exist in ERL.ElasticERL!");
        }
    }
    public String getValues(HashTable ElasticERL, long key){
        if(contains(keys,key)){
            hashValue = calculateHash(key);
            Node temp = data[hashValue];
            while(temp.next!=null){
                if(temp.key == key){
                    break;
                }
                else{
                    temp = temp.next;
                }
            }
            return temp.val;
        }
        else{
            System.out.println("There is no entry with given key "+ key+" in ERL.ElasticERL");
            return null;
        }

    }
    public void nextKey(HashTable ElasticERL,long key){
        if(contains(keys,key)){
            long[] updatedKeys = allKeys(ElasticERL);
            long nextKey = -1;
            for (int i =0;i<updatedKeys.length-1;i++) {
                if (updatedKeys[i] == key) {
                    nextKey = updatedKeys[i + 1];
                    break;
                }
            }
            if (nextKey != -1) {
                System.out.println("Next key from given key " + key + " is : " + nextKey);
            } else {
                System.out.println("No next key is available!!");
            }
        }
        else{
            System.out.println("Given key does not exist in ERL.ElasticERL!!");
        }
    }
    public void prevKey(HashTable ElasticERL,long key){
        if(contains(keys,key)){
            long[] updatedKeys = allKeys(ElasticERL);
            long prevKey = -1;
            for (int i = updatedKeys.length - 1; i > 0; i--) {
                if (updatedKeys[i] == key) {
                    prevKey = updatedKeys[i - 1];
                    break;
                }
            }
            if (prevKey != -1) {
                System.out.println("Previous key from given key " + key + " is : " + prevKey);
            } else {
                System.out.println("No previous key is available!!");
            }
        }
        else{
            System.out.println("Given key does not exist in ERL.ElasticERL!!");
        }
    }
    public void rangeKey( long key1,long key2){
        int counter=-1;
        if(contains(keys,key1) && contains(keys,key2)){
            for (long key : keys) {
                if (key == key1) {
                    counter++;
                } else if (key != key2 && key != -1) {
                    counter++;
                } else if (key == key2) {
                    break;
                }
            }
            System.out.println("There is/are "+counter+ " key(s) between "+key1+" & "+key2+".");
        }
        else{
            System.out.println("Data does not contain one of the keys !!");
        }

    }
    public void reSizeArray() {
        long[] temp = new long[keys.length*2];
        for (int i=0;i<keys.length;i++) {
            temp[i] = keys[i];
        }
        keys = temp;
    }
//    public void display(){
//        Node temp = data[4];
//        while(temp!=null){
//            System.out.print(temp.val+" -> ");
//            temp = temp.next;
//        }
//        System.out.print("END");
//    }


}
