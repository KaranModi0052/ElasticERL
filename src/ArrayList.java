package ERL;
import java.util.Random;

public class ArrayList {
    class Packet{
       long key;
        String val;
        public Packet(long key,String val){
            this.key = key;
            this.val = val;
        }
    }
    private Packet[] data;
    private int count = 0;
    private int size;
    public long[] keys;

    public ArrayList(int size) {
        SetINThreshold(size);
        data = new Packet[this.size];
        keys = new long[this.size];
        for(int i=0;i<this.size;i++){
            keys[i] = -1;
        }
    }
    public void add(ArrayList ERL,long key, String value){
        int duplicateCount=0;
        if(!contains(keys,key)){
            keys[count] = key;
            data[count] = new Packet(key, value);
            count++;
            if (count > size) {
                this.reSizeArray();
            }
        }
        else{
            duplicateCount++;
        }
        if(duplicateCount!=0){
            System.out.println("Duplicate keys were found: "+ duplicateCount);
            System.out.println("Duplicate keys were rejected.");
        }
    }
    private void SetINThreshold(int size){
        this.size = size;
    }
    public boolean contains(long[] keys, long id) {
        for (long element : keys) {
            if (element == id) {
                return true;
            }
        }
        return false;
    }
    public void display(){
        for(int i=0;i<count;i++){
            if(data[i]!=null){
                System.out.println("key " + data[i].key);
                System.out.println("value " + data[i].val);
            }
            else{
                continue;
            }
        }
    }
    public long generate(){
        Random rnd = new Random();
       long key = rnd.nextLong(99999999);
        while(contains(keys,key)) {
            key = rnd.nextLong(99999999);
        }
        return key;
    }
    public long[] allKeys(ArrayList ElasticERL){
        long[] updatedKeys = new long[ElasticERL.count];
        int i = -1;
        for (int j = 0; j < ElasticERL.size; j++) {
            if (keys[j] != -1) {
                i++;
                updatedKeys[i] = keys[j];
            }
        }
        return updatedKeys;
    }

    public String getValues(ArrayList ElasticERL,long key){
        if(contains(keys,key)){
            for (int i = 0; i < keys.length; i++) {
                if (data[i].key == key) {
                    return data[i].val;
                }
            }
        }
        else{
            System.out.println("Given key does not exist in ERL.ElasticERL");
        }
        return null;
    }
    public void nextKey(ArrayList ElasticERL,long key){
        if(contains(keys,key)){
            int index=-1;
            long nextkey=0;
            for(int i=0;i<keys.length;i++){
                if (data[i].key == key) {
                    index = i;
                    break;
                } else {
                    continue;
                }
            }
            while(index<count-1){
                {
                    while (true) {
                        index++;
                        if (data[index] == null) {
                            index++;
                        } else {
                            nextkey = data[index].key;
                            break;
                        }
                    }
                }
            }
            if(index!=count && nextkey!=0){
                System.out.println("Next available key after " + key + " is " + nextkey);
            }
            else{
                System.out.println("No next key available");
            }
        }
        else{
            System.out.println("Given key does not exist !!");
        }
    }
    public void prevKey(ArrayList ElasticERL,long key){
        int index=-1;
        long prevkey=-1;
        if(contains(keys,key)){
            for(int i=keys.length-1;i>=0;i--){
                if(data[i] == null) continue;
                else if(data[i].key==key){
                    index = i;
                    break;
                }
                else{
                    continue;
                }
            }
            if (index == 0) {
                System.out.println("No previous key available");
            }
            while(index>0){
                index--;
                if (data[index] != null) {
                    prevkey = data[index].key;
                    break;
                } else {
                    index--;
                }
            }
            System.out.println("Previous available key before " + key + " is " + prevkey);
        }
        else{
            System.out.println("Given key does not exist !!");
        }
    }
    public void rangeKey(long key1,long key2){
        int counter=-1;
        if(contains(keys,key1) && contains(keys,key2)){
            for(int i=0;i<keys.length;i++){
                if(keys[i] == key1){
                    counter++;
                }
                else if(keys[i]!= key1 && keys[i]!= key2 && keys[i] !=-1 ){
                    counter++;
                }
                else if(keys[i] == key2){
                    break;
                }
            }
            System.out.println("There is/are "+counter+ " number of key(s) between "+key1+" "+key2+".");
        }
        else{
            System.out.println("Data does not contain one of the keys !!");
        }

    }

    public void remove(ArrayList ERL,long key) {
        if(contains(keys,key)){
            for(int i=0;i<keys.length;i++){
                if(keys[i] == key){
                    keys[i] = -1;
                    break;
                }
            }
            for(int i=0;i<data.length;i++){
                if(data[i].key == key){
                        data[i] = null;
                        break;
                }
            }
            count--;
            System.out.println("Entry removed with key: "+key);
        }
        else{
            System.out.println("No entry found with given key: "+key);
        }
    }

    public void reSizeArray() {
        Packet[] temp = new Packet[data.length*2];
        for(int i=0;i<data.length;i++){
            temp[i] = data[i];
        }
        data = temp;
        long[] temp1 = new long[keys.length*2];
        for (int i=0;i<keys.length;i++){
            temp1[i] = keys[i];
        }
        keys = temp1;
    }
    public int size() {
        return count;
    }

//    public static void main(String[] args) {
//        ERL.ArrayList a = new ERL.ArrayList(4);
//        a.add(a,1,"abc");
//        a.add(a,2,"bcd");
//        a.add(a,3,"cde");
//        a.remove(a,2);
//        a.display();
//    }
}
