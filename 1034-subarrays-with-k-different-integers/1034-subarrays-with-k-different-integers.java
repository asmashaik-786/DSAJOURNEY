class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums,k)-count(nums,k-1);
    }
    static int count(int[]nums,int k)
    {
        HashMap<Integer,Integer>map=new HashMap<>();
        int c=0;
        int i=0;
        int j=0;
        while(j<nums.length)
        {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()>k)
            {
                map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i])==0)
                {
                    map.remove(nums[i]);
                }
                i++;
            }
            if(map.size()<=k)
            {
                c+=(j-i+1);
            }
            j++;
        }
        return c;
    }
}