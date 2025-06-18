class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[]ar=new int[9];
        List<List<Integer>>a1=new ArrayList<>();
        for(int i=1;i<=9;i++)
        {
            ar[i-1]=i;
        }
        Recur(ar,a1,k,0,new ArrayList<>(),n);
        return a1;
    }
    static void Recur(int[]ar,List<List<Integer>>a1,int k,int i,ArrayList<Integer>list,int tar)
    {
        if(list.size()==k && tar==0)
        {
            a1.add(new ArrayList(list));
            return;
        }
        if(i<ar.length)
        {
            if(tar>=ar[i])
            {
                list.add(ar[i]);
                Recur(ar,a1,k,i+1,list,tar-ar[i]);
                list.remove(list.size()-1);
                Recur(ar,a1,k,i+1,list,tar);
            }
        }
    }
}