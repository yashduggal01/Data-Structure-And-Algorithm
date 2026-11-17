class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m+n];
        int idx =0 ,i=0,j=0;
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                arr[idx++] = nums1[i];
                i++;
            }
            else{
                arr[idx++] = nums2[j];
                j++;
            }
        }
        while(i<m){
            arr[idx++] = nums1[i++];
        }
        while(j<n){
            arr[idx++] = nums2[j++];
        }
        for(int k=0;k<m+n;k++){
            nums1[k] = arr[k];
        }
    }
}