class Solution {
    public int maxScore(int[] ar, int k) {
        int sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=ar[i];
        }
        int max=sum;
        for(int i=1;i<=k;i++)
        {
            sum=sum-ar[k-i]+ar[ar.length-i];
            max=Math.max(max,sum);
        }
        return max;
    }
}