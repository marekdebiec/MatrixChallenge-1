import java.util.*;
import java.io.*;

class fibonacci {

    public static int ArrayChallenge(int[] arr) {
        // code goes here
        int sum = 0; // initialize sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        arr[0] = sum;

         /*  for ( int i = 1; i < 1000000; i++) {

               if ( arr[0] == i) {
                   arr[0] = 0;
               }
               else {return arr[0];}
           }*/
        int[] fn = new int[11];
        fn[0] = 1; fn[1] = 2; fn[2] = 3; fn[3] = 5; fn[4] = 8;
        fn[5] = 13; fn[6] = 21; fn[7] = 34; fn[8] = 55;
        fn[9] = 89; fn[10] = 144;

            int distance = Math.abs(fn[0] - arr[0]);
            int idx = 0;
            for(int c = 1; c < fn.length; c++){
                int cdistance = Math.abs(fn[c] - arr[0]);
                if(cdistance < distance){
                    idx = c;
                    distance = cdistance;
                }
            }

        int theNumber = 0; // initialize theNumber
            if (fn[idx] < arr[0]) {
                theNumber = fn[idx+1];
            }
            else {theNumber = fn[idx];}

            // return theNumber;
            // return arr[0];
            arr[0] = theNumber - arr[0];
            return arr[0];
       // return arr[0];
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
       /* String g = s.nextLine();
        int i=Integer.parseInt(g);*/
       // System.out.print(ArrayChallenge(new int[] { 15,1,3,8 }));
        System.out.print(ArrayChallenge(new int[] { 5,2,1 }));
    }

}