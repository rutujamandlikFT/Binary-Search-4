//TC: O(log n) n-> length of smaller arr
//SC: O(1) 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int low = 0;
        int high = n1;
        
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;
            
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1 <= R2 && L2 <= R1){
                //correct partition
                if((n1+n2) % 2 == 0){
                    return (Math.max(L1,L2) + Math.min(R1,R2)) /2; //even
                }else{
                    return Math.min(R1,R2); //odd
                }
            }else if(L1 > R2){
                high = partX - 1;
            }else{
                low = partX+1;
            } 
        }
        return 8.00;    
    }
}