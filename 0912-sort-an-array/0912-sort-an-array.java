class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;

        //len - 1
    }

    //left array - low to mid
    //right array - mid + 1, high

    // low to high

    void mergeSort(int[] arr, int low, int high){

        if(low >= high){
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);// left array
        mergeSort(arr, mid + 1, high); // right array

        merge(arr, low, mid, high);
    }

    void merge(int[] arr, int low, int mid , int high){

        int i = low, j = mid + 1, k = 0;
        int[] result = new int[high - low + 1];

        while(i <= mid && j <= high){

            if(arr[i] < arr[j]){
                result[k] = arr[i];
                i++;
                k++;
            }
            else{
                result[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i <= mid){
            result[k] = arr[i];
            k++;
            i++;
        }

        while(j <= high){
            result[k] = arr[j];
            j++;
            k++;
        }

        //0
        int index = 0;

        for (int s = low; s <= high; s++){
            arr[s] = result[index];
            index++;
        }

    }
}