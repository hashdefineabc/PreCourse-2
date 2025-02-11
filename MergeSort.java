class MergeSort 
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    {  
        int leftSize = (m - l + 1);
       int rightSize = r - m;
       int[] leftArr = new int[leftSize];
       int[] rightArr = new int[rightSize];

       for(int i=0; i<leftSize; i++) 
            leftArr[i] = arr[l + i];
       //System.out.println("Left Arr: " ); printArray(leftArr);
        for(int i=0; i<rightSize; i++) 
            rightArr[i] = arr[m + 1 + i];
        //System.out.println("Right Arr: " ); printArray(rightArr);


       int i = 0; int j = 0; int k = l;
       while( i < leftSize && j < rightSize ) {
            if(leftArr[i] <= rightArr[j]) 
                arr[k++] = leftArr[i++];
            else 
                arr[k++] = rightArr[j++];
       }
       if(i < leftSize)
            while(i < leftSize) 
                arr[k++] = leftArr[i++];
       if(j < rightSize)
            while(j < rightSize) 
                arr[k++] = rightArr[j++];
       //System.out.println("After merging: l, m, r " + arr[l] + " " + arr[m] + " " + arr[r]);
       //printArray(arr);
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
	//Write your code here
        //Call mergeSort from here 
        if(l < r) {
            int mid = l + (r - l) / 2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 