class Solution {
    public void nextPermutation(int[] nums) {
        int decreasing_ele_index = -1;
        int justGreater = Integer.MAX_VALUE;
        int justGreaterIndex = -1;
        
        for(int i = nums.length - 1; i >= 1; i--) {
            if(nums[i] > nums[i - 1]) {
                decreasing_ele_index = i - 1;
                break;
            }
        }
        
        if(decreasing_ele_index != -1) {
            for(int i = decreasing_ele_index + 1; i < nums.length; i++) {
                if(nums[i] > nums[decreasing_ele_index] && nums[i] <= justGreater) {
                    justGreater = nums[i];
                    justGreaterIndex = i;
                }
            }
        }
        
        if(justGreaterIndex != -1) {
            int temp = nums[justGreaterIndex];
            nums[justGreaterIndex] = nums[decreasing_ele_index];
            nums[decreasing_ele_index] = temp;
        }
        
        int reverseStart = decreasing_ele_index + 1;
        int reverseEnd = nums.length - 1;
        
        while(reverseStart < reverseEnd) {
            int temp1 = nums[reverseStart];
            nums[reverseStart] = nums[reverseEnd];
            nums[reverseEnd] = temp1;
            reverseStart++;
            reverseEnd--;
        }
    }
}