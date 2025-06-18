class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[]ar=new int[n];
        for(int i=1;i<=n;i++)
        {
            ar[i-1]=i;
        }
        List<List<Integer>>a1=new ArrayList<>();
        Recur(ar,a1,k,0,new ArrayList<>());
        return a1;
    }
    static void Recur(int[]ar,List<List<Integer>>a1,int k,int i,ArrayList<Integer>list)
    {
        if(list.size()==k)
        {
            a1.add(new ArrayList(list));
            return;
        }
        if(i<ar.length)
        {
            list.add(ar[i]);
            Recur(ar,a1,k,i+1,list);
            list.remove(list.size()-1);
            Recur(ar,a1,k,i+1,list);
        }
    }
}