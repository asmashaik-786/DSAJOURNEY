// User function Template for Java

class Solution {
    static int largestPrimeFactor(int n) {
        // code here
        ArrayList<Integer>a1=new ArrayList<>();
        for(int i=2;i<=n;i++)
        {
            while(n%i==0)
            {
                a1.add(i);
                n/=i;
            }
        }
        int max=0;
        for(int i:a1)
        {
            max=Math.max(max,i);
        }
        return max;
    }
}