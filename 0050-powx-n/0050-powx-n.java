class Solution {
    public double myPow(double x, int n) {
        long val=n;
        if(val<0)
        {
            x=1/x;
            val=-val;
        }
        double res=calc(x,val);
        return res;
    }
    static double calc(double x,long n)
    {
        if(n==0) return 1;
        double res=0;
        if(n%2==0)
        {
            res=calc(x*x,n/2);
        }
        else
        {
            res=x*calc(x*x,n/2);
        }
        return res;
    }
         
}