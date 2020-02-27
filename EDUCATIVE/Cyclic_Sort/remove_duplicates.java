class RemoveDuplicates {

    public static int remove(int[] arr) {
      // TODO: Write your code here
    
      int removeNonDuplicate = 1;
  
      for(int i=1; i < arr.length; i++) {
          if (arr[removeNonDuplicate -1] != arr[i]){
              arr[removeNonDuplicate] = arr[i];
              removeNonDuplicate++;
          }
      }
  
  
      return -1;
    }


    public static unsorted_remove(int [] arr, int key {
        int removeDuplicate = 0;
        for(int i=0; i < arr.length;i++) {
            if(key != arr[i]) {
                arr[removeDuplicate] = arr[i];
                removeDuplicate++;
            }
        }

    }
  }
  