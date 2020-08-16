
// Java implementation of recursive Binary Search
class CoinPositionInArray {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        else if(l-r==1){
            if(l<arr.length && r >=0 && arr[l]>x && arr[r]<x)
                return r+1;
            else if (l>=arr.length)
                return l;
            else if(r<=arr.length)
                return 0;
        }
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        CoinPositionInArray ob = new CoinPositionInArray();
        int arr[] = { 2, 3, 4, 7, 11, 18, 19, 23, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}
/* This code is contributed by Rajat Mishra */
