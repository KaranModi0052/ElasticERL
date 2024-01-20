package ERL;// -----------------------------------------------------
// Assignment #3
// © Karan Modi & Dhruv Panchal
// Written by: Karan Modi - 40220970 & Dhruv Panchal - 40226430
// ---------------------------------------------------


import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;
public class driver {
    private static String randomStuff() {
        String[] data = new String[] {"Printer", "Stethoscope", "Needle", "Mask", "Pair of Scissors","Gloves","ECG Machine"};
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(9)%5;
        return data[randomIndex];
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Scanner sc = null;
        System.out.println();
        ElasticERL erl;
        System.out.println("==================================================================");
        System.out.println("!!                  Welcome to ERL.ElasticERL !!                      ");
        System.out.println("==================================================================");
        System.out.println("Hello User !! ");
        System.out.print("Please enter the size of Data Structure you want to store data in : ");
        int ds_size = Integer.parseInt(kb.nextLine());
//        int size=10000;

        System.out.println("Enter File Name: ");
        String fileName = kb.nextLine();
//        int fileData = Integer.parseInt(kb.nextLine());
////        String fileName = "EHITS_test_file3.txt";
        System.out.println("Enter how many data you want to add from this file: ");
        int fileData = Integer.parseInt(kb.nextLine());
//        int fileData = 100;
        System.out.println("Given Size is : "+ fileData + "And the given size for data structure is "+ ds_size );
        if(fileData > ds_size){
            System.out.println("Given data structure will not accommodate all expected data from file so we will shift " +
                    "to a bigger data structure");
            erl = new ElasticERL(fileData);
        }
        else{
            erl = new ElasticERL(ds_size);
        }


        try{
            sc = new Scanner(new FileInputStream(fileName));
            for(int i=0;i<fileData;i++){
                int key = Integer.parseInt(sc.nextLine());
                erl.add(erl,key,randomStuff());
            }
            System.out.println();
            System.out.println("===============================================================");
            System.out.println("                   Data Added Successfully !!                  ");
            System.out.println("===============================================================");
            System.out.println();

//            Generating new key
            System.out.println("Generating new key to perform all the operations.");
            long newKey = erl.generate();
            System.out.println();
            System.out.println("Generated new Key: "+newKey);

//            if(fileData<size){
////                Adding new key to ERL.ElasticERL
////                System.out.println("Adding it to corresponding ERL.ElasticERL. ");
////                erl.add(erl, newKey, randomStuff());
//
////                Getting Value of newly created key from ERL.ElasticERL
////                System.out.println("Getting value of newly Created key: ");
////                erl.getValues(erl, newKey);
////                System.out.println();
//                System.out.println("===============================================================");
//            }
//            else{
//                System.out.println("Can not add more data than given threshold size : "+size);
//            }

            // Getting Previous key from given key in ERL.ElasticERL
//            long key = Long.parseLong(kb.nextLine());
//            erl.prevKey(erl, key);
//            System.out.println();
//            System.out.println("===============================================================");

//            Getting Next key from given key in ERL.ElasticERL
//            erl.nextKey(erl, key);
//            System.out.println();
//            System.out.println("===============================================================");

//            Generating 10 keys in sorted Order
            System.out.println("Retrieving few keys from our ERL.ElasticERL: ");
            System.out.println();
            long[] allKeys = erl.allKeys();
            System.out.println("First 10 keys from " + allKeys.length + " keys : ");
            for(int i=0; i<10; i++) {
                System.out.printf("%08d%n", allKeys[i]);
            }

//            Removing newly created key
//            erl.remove(erl,newKey);
//            System.out.println("Value Removed");
//            System.out.println("Value for generated new key: "+ erl.getValues(erl, newKey));


//            Counting number of keys between given key1 & key2
//            System.out.println("Enter two keys to find the keys between that range :");
//            long key1 = Integer.parseInt(kb.nextLine());
//            long key2 = Integer.parseInt(kb.nextLine());
//            erl.rangeKey(key1,key2);
//            sc.close();
            kb.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

    }
}
