class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer>a1=new ArrayList<>();
        String s="";
        int fact=1;
        for(int i=1;i<n;i++)
        {
            a1.add(i);
            fact*=i;
        }
        a1.add(n);
        k=k-1;
        while(true)
        {
            s+=a1.get(k/fact);
            a1.remove(k/fact);
            if(a1.size()==0)
            {
                break;
            }
            k=k%fact;
            fact=fact/a1.size();
        }
        return s;
    }
}