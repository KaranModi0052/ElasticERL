package ERL;


// -----------------------------------------------------
// Assignment #3
// © Karan Modi & Dhruv Panchal
// Written by: Karan Modi - 40220970 & Dhruv Panchal - 40226430
// ---------------------------------------------------

public class ElasticERL {
    private int size;
    private ArrayList erl2;
    private HashTable erl1  ;
    private int thresholdValue;

    public ElasticERL(int size) {
        this.size = size;
        if(size<0 || size>500000){
            System.out.println();
            System.out.println("====================================================================");
            System.out.println("Please Enter Valid Size between 0 and 500000. \n Closing the system.");
            System.out.println("====================================================================");
            System.exit(0);
        }
        else if(size <= 10000){
            System.out.println();
            System.out.println("========================================================================================");
            System.out.println("Given size is less than 10,000 therefore we will create ERL.ArrayList to store the data");
            System.out.println("========================================================================================");
            erl2 = new ArrayList(size);
        }
        else{
            System.out.println("=========================================================================================");
            System.out.println("Given size is greater than 10,000 therefore we will create ERL.HashTable to save the data");
            System.out.println("=========================================================================================");
            erl1 = new HashTable(size);
        }
    }
    public void SetEINThreshold(int size) { // O(1)
        this.thresholdValue = size;
    }

    public long generate(){
        if(size<=10000){
            return erl2.generate();
        }
        else{
            return erl1.generate();
        }
    }
    public long[] allKeys(){
        if(size<=10000){
            return QS.getSortedArr(erl2.allKeys(erl2));  // QuickSort  : quicker response and  less Memory Overhead
        }
        else{
            return MS.getSortedArr(erl1.allKeys(erl1)); // MergeSort : efficient merging in large dataset
        }
    }
    public void add(ElasticERL erl, long key,String val){
            if (size <= 10000) {
                erl2.add(erl2, key, val);
            } else {
                erl1.add(erl1, key, val);
            }
    }
    public void remove(ElasticERL erl,long key){
        if(size <= 10000){
            erl2.remove(erl2,key);
        }
        else if(size<=500000){
            erl1.remove(erl1,key);
        }
    }

    public String getValues(ElasticERL erl,long key){
        if(size <= 10000){
           return erl2.getValues(erl2, key);
        }
        else {
            return erl1.getValues(erl1,key);
        }
    }

    public void prevKey(ElasticERL erl, long key){
        if(size <= 10000){
            erl2.prevKey(erl2,key);
        }
        else {
            erl1.prevKey(erl1,key);
        }
    }
    public void nextKey(ElasticERL erl, long key){
        if(size <= 10000){
            erl2.nextKey(erl2,key);
        }
        else{
            erl1.nextKey(erl1,key);
        }
    }

    public void rangeKey(long key1, long key2){
        if(size <= 10000){
            erl2.rangeKey(key1,key2);
        }
        else{
            erl1.rangeKey(key1,key2);
        }
    }
}
