import java.util.*;
import java.io.*;


/*
class GFG
{

    // function that rotates s towards left by d
    static String leftrotate(String str, int d)
    {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    // function that rotates s towards right by d
    static String rightrotate(String str, int d)
    {
        return leftrotate(str, str.length() - d);
    }

    // Driver code
    public static void main(String args[])
    {
        String str1 = "GeeksforGeeks";
        System.out.println(leftrotate(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(rightrotate(str2, 2));
    }
}*/

// This code is contributed by rachana soma


// for integer

class LeftRotate {
    /* Function to left rotate arr[] of size n by d */
    static void leftRotate(int arr[], int d)
    {

        if (d == 0)
            return;
        int n = arr.length;
        rvereseArray(arr, 0, d - 1);

        printArray(arr);
        System.out.println("2nd");
        rvereseArray(arr, d, n - 1);
        printArray(arr);
        System.out.println("3rd");
        rvereseArray(arr, 0, n - 1);
        printArray(arr);
    }

    /*Function to reverse arr[] from index start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 2;

        // in case the rotating factor is
        // greater than array length
        d = d % n;
        leftRotate(arr, d); // Rotate array by d
        //printArray(arr);
    }
}
/*This code is contributed by Devesh Agrawal*/
