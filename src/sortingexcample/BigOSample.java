/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingexcample;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Random;
import static javafx.scene.input.KeyCode.N;

/**
 *
 * @author int320
 */
public class BigOSample {

    private static void initial(int[] n) {
        Random r = new Random();
        for (int i = 0; i < n.length; i++) {
            n[i] = r.nextInt(1000);
        }
    }

    long sort(int arr[]) {
        int n = arr.length;
        long begin = System.currentTimeMillis();
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return System.currentTimeMillis()-begin;
    }
    
    long arraySort(int arr[]){
        long begin = System.currentTimeMillis();
        Arrays.sort(arr);
        return System.currentTimeMillis()-begin;
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = new int[1000000];
        initial(arr);
        BigOSample ob1 = new BigOSample();
        long manualSortTime = ob1.sort(arr);
        BigOSample ob2 = new BigOSample();
        long javaSortTime = ob2.arraySort(arr);
        printArray(arr);
        System.out.println("Manual Sort Duration:" + manualSortTime + "milliseconds");
        System.out.println("Java Sort Duration:" + javaSortTime + "milliseconds");

    }

    /**
     * @param args the command line arguments
     */
}
