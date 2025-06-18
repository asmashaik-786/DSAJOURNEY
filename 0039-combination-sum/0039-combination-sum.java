class Solution {
    public List<List<Integer>> combinationSum(int[] ar, int n) {
        List<List<Integer>>a1=new ArrayList<>();
        Recur(ar,a1,0,new ArrayList<>(),n);
        return a1;
    }
    static void Recur(int[]ar,List<List<Integer>>a1,int i,ArrayList<Integer>list,int tar)
    {
        if(tar==0)
        {
            a1.add(new ArrayList(list));
            return;
        }
        if(i<ar.length)
        {
            if(tar>=ar[i])
            {
                list.add(ar[i]);
                Recur(ar,a1,i,list,tar-ar[i]);
                list.remove(list.size()-1);
                Recur(ar,a1,i+1,list,tar);
            }
        }
    }
}