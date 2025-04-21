class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int totalSize = n1+n2;
        int indx1 = (totalSize-1)/2;
        int indx2 = totalSize/2;
        int count = 0;
        double indxValue1 = 0;
        double indxValue2 = 0;
        int left = 0;
        int right = 0;
        while(left<n1 && right <n2){
            if(nums1[left]< nums2[right])
            {
                if(count == indx1) indxValue1 = nums1[left];
                if(count == indx2) indxValue2 = nums1[left];
                count++;
                left++;
            } else {
                if(count == indx1) indxValue1 = nums2[right];
                if(count == indx2) indxValue2 = nums2[right];
                count++;
                right++;
            }
        }
        while(left<n1){
            if(count == indx1) indxValue1 = nums1[left];
            if(count == indx2) indxValue2 = nums1[left];
            count++;
            left++;
        }
        while(right<n2){
            if(count == indx1) indxValue1 = nums2[right];
            if(count == indx2) indxValue2 = nums2[right];
            count++;
            right++;
        }
        if (totalSize % 2 == 0) {
            return (indxValue1 + indxValue2) / 2.0;
        } else {
            return indxValue2;
        }
    }
}