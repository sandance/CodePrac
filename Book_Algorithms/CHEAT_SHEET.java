

1. Sort Two Dimentional Array in Java

Arrays.sort(intervals, new Comparator<int []>() {
    @Override
    public int compare(int [] o1, int [] o2) {
        return o1[1] - o2[1];
    }
});


1. Sort One Dimentional Arrays

Arrays.sort(arr);

2. String Cheat Sheet

    String Searching:

    The String class provides two methods that allow you to search a string for a specified
    character or substring:
        • indexOf( ) Searches for the first occurrence of a character or substring.
        • lastIndexOf( ) Searches for the last occurrence of a character or substring.

    

    1. Joining Strings String result = String.join(" ", "Alpha", "Beta", "Gamma");

    a. String to Integer conversion: Integer.parseInt(str); where str = "123"
    b. Integer to String conversion: String.valueOf(var); where var = 111;

    c. Compare one string to other

    str1.equals(str2)

    d. To uppper and lower case str1.toUpperCase() and str1.toLowerCase()

    e. Trim Surroding white space str1.trim()

    f. Compare

    A string is less than another if it comes before the other in dictionary order. 
    A string is greater than another if it comes after the other in dictionary order. 
    
    The method compareTo( ) serves this purpose. It is specified by the Comparable<T> interface, which String implements. 
    It has this general form:

    Less than zero The invoking string is less than str.
    Greater than zero The invoking string is greater than str.
    Zero The two strings are equal.
    
    int compareTo(String str)

    // A bubble sort for Strings.
class SortString {
    static String arr[] = {
    "Now", "is", "the", "time", "for", "all", "good", "men",
    "to", "come", "to", "the", "aid", "of", "their", "country"
    };
    public static void main(String args[]) {
    for(int j = 0; j < arr.length; j++) {
        for(int i = j + 1; i < arr.length; i++) {
            if(arr[i].compareTo(arr[j]) < 0) {
                String t = arr[j];
    
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
            System.out.println(arr[j]);
        }
    }





Collections:

A queue that is always automatically sorted
using the comparable function of an object
public static void main(String[] args) {
 Comparator<String> cmp= new LenCmp();
 PriorityQueue<String> queue =new PriorityQueue<String>(10, cmp);
 queue.add("short");
 queue.add("very long indeed");
 queue.add("medium");
 while (queue.size() != 0)
 System.out.println(queue.remove());
}
class LenCmp implements Comparator<String> {
    public int compare(String x, String y){
    return x.length() – y.length();
    }
}


Collections.sort(x); //sorts with comparator
Sort Using Comparator:
Collections.sort(x, new Comparator<T>{
 public int compareTo(T a, T b) {
//calculate which is first
//return -1, 0, or 1 for order:
return someint;
 }
}


Collections.max( … ); //returns maximum
Collections.min( … ); //returns maximum
Collections.copy( A, B); //A list into B
Collections.reverse( A ); //if A is list


StringBuffer, StringBuilder
StringBuffer is synchronized StringBuilder
(Use StringBuilder unless multithreaded)
Use the .apend( xyz ) methods to concat
toString() converts back to String


JAVA MATH:

java.lang.Math
Math.abs(NUM),
Math.ceil(NUM),
Math.floor(NUM)
,Math.log(NUM),
Math.max(A,B),
Math.min(C,D),


