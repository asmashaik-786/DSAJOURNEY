class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String>a1=new ArrayList<>();
        recur(0,0,n,sb,a1);
        return a1;
    }
    static void recur(int open,int close,int n,StringBuilder sb,ArrayList<String>a1)
    {
        if(open==close && close==n)
        {
            a1.add(sb.toString());
            return;
        }
        if(open<n)
        {
            sb.append("(");
            recur(open+1,close,n,sb,a1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open)
        {
            sb.append(")");
            recur(open,close+1,n,sb,a1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}