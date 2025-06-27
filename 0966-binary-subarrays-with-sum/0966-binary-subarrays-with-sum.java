class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0) return count(nums,goal);
        return count(nums,goal)-count(nums,goal-1);
    }
    static int count(int[]nums,int goal)
    {
        int i=0;
        int j=0;
        int c=0;
        int sum=0;
        while(j<nums.length)
        {
            sum+=nums[j];
            while(sum>goal)
            {
                sum-=nums[i];
                i++;
            }
            c+=j-i+1;
            j++;
        }
        return c;
    }
}