public class findingNonDuplicate {


        public int singleNonDuplicate(int[] nums) {
            return binarySearch(nums,0,nums.length-1);
        }
        int binarySearch(int arr[], int l, int r)
        {
            if(r==l)return arr[r];
            if (r >= l) {
                int mid = l + (r - l) / 2;

                if (arr[mid] != arr[mid-1] && arr[mid]!=arr[mid+1] )
                    return arr[mid];

                if (mid % 2==0)
                { if (arr[mid] == arr[mid+1])
                    return binarySearch(arr, mid + 1,r);
                else
                    return binarySearch(arr, l,mid);
                }
                else{
                    if(arr[mid] == arr[mid-1])
                        return binarySearch(arr, mid + 1, r);
                    else
                        return binarySearch(arr, l, mid - 1);
                }
            }

            // We reach here when element is not present
            // in array
            return -1;
        }
        public static void main(String[] args){
            findingNonDuplicate ob = new findingNonDuplicate();
            int arr[] = { 1,2,2,3,3};
            int n = arr.length;
            int x = 10;
            int result = ob.binarySearch(arr, 0, n - 1);
            if (result == -1)
                System.out.println("Element not present");
            else
                System.out.println("Element found at index " + result);

        }
    }

