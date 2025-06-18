class Solution {
    public List<List<Integer>> combinationSum2(int[] ar, int tar) {
        Arrays.sort(ar);
        List<List<Integer>>a1=new ArrayList<>();
        Recur(ar,a1,0,new ArrayList<>(),tar);
        return a1;
    }
    static void Recur(int[]ar,List<List<Integer>>a1,int j,ArrayList<Integer>list,int tar)
    {
        if(tar==0)
        {
            a1.add(new ArrayList(list));
            return;
        }
        for(int i=j;i<ar.length;i++)
        {
            if(i>j && ar[i]==ar[i-1]) continue;
            if(tar>=ar[i])
            {
                list.add(ar[i]);
                Recur(ar,a1,i+1,list,tar-ar[i]);
                list.remove(list.size()-1);
            }
        }
    }
}