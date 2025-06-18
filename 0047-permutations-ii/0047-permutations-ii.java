class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean []vis=new boolean[nums.length];
        Arrays.fill(vis,false);
        List<List<Integer>>a1=new ArrayList<>();
        Recur(nums,a1,new ArrayList<>(),vis);
        return a1;
    }
    static void Recur(int[]ar,List<List<Integer>>a1,ArrayList<Integer>list,boolean[]vis)
    {
        if(list.size()==ar.length)
        {
            a1.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<ar.length;i++)
        {
            if (i > 0 && ar[i] == ar[i - 1] && !vis[i - 1]) continue;
            if(!vis[i])
            {
                vis[i]=true;
                list.add(ar[i]);
                Recur(ar,a1,list,vis);
                list.remove(list.size()-1);
                Recur(ar,a1,list,vis);
                vis[i]=false;
            }
        }
    }
}