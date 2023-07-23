
import java.util.*;
import java.io.*;

class matrix05good {

    public static int[] nextsmallerelement(int[] arr, int n)
    {

        Stack<Integer> st = new Stack<>();

        // For the elements which dont have
        // next smaller element ans will be -1
        st.push(-1);

        // Store indices in output
        int[] right = new int[n];

        // Start from last index
        for (int i = n - 1; i >= 0; i--) {

            // If top element is sorted then
            // no need to do anything, just store
            // the answer and push the
            // current element in stack
            if ((st.peek() != -1)
                    && arr[st.peek()] < arr[i]) {
                right[i] = st.peek();
                st.push(i);
            }
            else {
                while ((st.peek() != -1)
                        && arr[st.peek()]
                        >= arr[i]) {
                    st.pop();
                }
                right[i] = st.peek();
                st.push(i);
            }
        }
        return right;
    }

    public static int[] previousmallerelement(int arr[],int n)
    {
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] left = new int[n];

        // Start from first index - Difference Between Next and Previous Smaller element
        for (int i = 0; i < n; i++) {
            if ((st.peek() != -1)
                    && arr[st.peek()] < arr[i]) {
                left[i] = st.peek();
                st.push(i);
            }
            else {
                while ((st.peek() != -1)
                        && arr[st.peek()]
                        >= arr[i]) {
                    st.pop();
                }
                left[i] = st.peek();
                st.push(i);
            }
        }
        return left;
    }

    public static int getMaxArea(int [] arr, int n)
    {
        int [] right = new int [n];
        right = nextsmallerelement(arr, n);

        // Find the smallest element than
        // curr element in right side

        int [] left = new int [n];
        left = previousmallerelement(arr, n);

        // Find the smallest element
        // than curr element in left side
        int maxarea = Integer.MIN_VALUE;

        // Now the left and right array have
        // index of smallest element in left and
        // right respectively, thus the difference
        // of right - left - 1 will give us
        // breadth and thus
        // area = height(curr==arr[i]) * breadth;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            if (right[i] == -1) {
                right[i] = n;
            }
            int breadth = right[i] - left[i] - 1;
            maxarea = Math.max(maxarea,
                    height * breadth);
        }
        return maxarea;
    }

    public static String MatrixChallenge(String[] strArr) {

        int exampleArraySize = strArr.length;
         System.out.println(exampleArraySize);
        int R = exampleArraySize, C = exampleArraySize;
        int [][] M = new int[exampleArraySize][exampleArraySize];


        if (strArr.length > 0) {
            String m0 = strArr[0];
            int[] num0 = new int[m0.length()];
            for (int i = 0; i < m0.length(); i++) {
                num0[i] = m0.charAt(i) - '0';
            }
            M[0][0]= num0[0];M[0][1]= num0[1];
            M[0][2]= num0[2];
            if (strArr.length > 3)  M[0][3]= num0[3];
        }
        if (strArr.length > 1) {
            String m1 = strArr[1];
            int[] num1 = new int[m1.length()];
            for (int i = 0; i < m1.length(); i++) {
                num1[i] = m1.charAt(i) - '0';
            }
            M[1][0]= num1[0];M[1][1]= num1[1];
            M[1][2]= num1[2];
            if (strArr.length > 3) M[1][3]= num1[3];
        }
        if (strArr.length > 2) {
            String m2 = strArr[2];
            int[] num2 = new int[m2.length()];
            for (int i = 0; i < m2.length(); i++) {
                num2[i] = m2.charAt(i) - '0';
            }
            M[2][0]= num2[0];M[2][1]= num2[1];
            M[2][2]= num2[2];
            if ( strArr.length > 3) M[2][3]= num2[3];
        }
        if (strArr.length > 3) {
            String m3 = strArr[3];
            int[] num3 = new int[m3.length()];
            for (int i = 0; i < m3.length(); i++) {
                num3[i] = m3.charAt(i) - '0';
            }
            M[3][0]= num3[0];M[3][1]= num3[1];M[3][2]= num3[2];
            M[3][3]= num3[3];
        }
        if (strArr.length > 4) {
            String m4 = strArr[3];
            int[] num4 = new int[m4.length()];
            for (int i = 0; i < m4.length(); i++) {
                num4[i] = m4.charAt(i) - '0';
            }
            M[4][0]= num4[0];M[4][1]= num4[1];M[4][2]= num4[2];
            M[4][3]= num4[3]; M[4][4]= num4[4];
        }



        int area = getMaxArea(M[0], R);
        int maxarea = area;

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (M[i][j] != 0) {

                    // Add heights of previous rows
                    // into current
                    M[i][j] = M[i][j]
                            + M[i - 1][j];
                }
                else {

                    // If current height is 0 then
                    // don't add previous heights
                    M[i][j] = 0;
                }
            }
            maxarea = Math.max(maxarea,
                    getMaxArea(M[i], R));
        }
        String b =String.valueOf(maxarea);
       // return maxarea;
        strArr[0] = b ;
        //return sss;
        // code goes here
        return strArr[0];
    }

    public static void main (String[] args) {
        // Given array
      //  int R = 4, C = 4;
      /*  int [][]amt = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };*/
        // keep this function call here
        Scanner s = new Scanner(System.in);
      //  System.out.print(MatrixChallenge
      //   (new String[] {"1011", "0011", "0111", "1111"}));
 /*       System.out.println(MatrixChallenge
                (new String[] {"1011", "0011",
                        "0111", "1111"}));*/
        /*System.out.println(MatrixChallenge
                (new String[] {"1111", "1111",
                        "1111", "1111"}));*/
       /* System.out.println(MatrixChallenge
                (new String[] {"11111", "11111",
                        "11111", "11111", "11111"}));*/
        System.out.println(MatrixChallenge
                (new String[] {"1111", "1111",
                        "1111"}));
    }

}