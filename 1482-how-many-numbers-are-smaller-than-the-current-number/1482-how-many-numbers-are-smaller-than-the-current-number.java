class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int []sorted=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            sorted[i]=nums[i];
        }
        Arrays.sort(sorted);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<sorted.length;i++)
        {
            if(!map.containsKey(sorted[i]))
            {
                map.put(sorted[i],i);
            }
        }
        int []res=new int[nums.length];
        for(int i=0;i<res.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                res[i]=map.get(nums[i]);
            }
        }
        return res;
    }
}