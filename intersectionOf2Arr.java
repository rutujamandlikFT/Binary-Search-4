class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length < nums2.length) return intersect(nums2, nums1); //to maintain bigger 
        int m = nums1.length; //this is bigger length
        int n = nums2.length;
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //apply binary search on bigger arr
        int low = 0;
        int high = m-1;
        
        //iterate on smaller arr & check if that val is has any intersection in bigger arr
        for(int i=0; i< n;i++){
            int bIndex = binarySearch(nums1, low, high, nums2[i]);
            if(bIndex != -1){
                low = bIndex+1;
                li.add(nums2[i]);
            }
        }
        
        //add elements from li to result[]
        int[] result = new int[li.size()];
        for(int i=0; i< li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //check first occurance
                if(mid == low || nums[mid-1] < nums[mid]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
