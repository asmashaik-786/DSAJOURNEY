


class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edge) {
        boolean []vis=new boolean[v+1];
        int c=0;
        ArrayList<ArrayList<Integer>>a1=new ArrayList<>();
        for(int i=0;i<=v;i++)
        {
            a1.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++)
        {
            a1.get(edge[i][0]).add(edge[i][1]);
            a1.get(edge[i][1]).add(edge[i][0]);
        }
        for(int i=1;i<=v;i++)
        {
            if(!vis[i])
            {
                HashSet<Integer>ha=new HashSet<>();
                dfs(vis,i,a1,ha);
                if(isfull(ha,a1))
                {
                    c+=1;
                }
            }
        }
        return c;
    }
    static boolean isfull(HashSet<Integer>ha,ArrayList<ArrayList<Integer>>a1)
    {
        for(int x:ha)
        {
            if(a1.get(x).size()!=ha.size()-1)
            {
                return false;
            }
        }
        return true;
    }
    static void dfs(boolean[]vis,int i,ArrayList<ArrayList<Integer>>a1,HashSet<Integer>ha)
    {
        vis[i]=true;
        ha.add(i);
        for(int x:a1.get(i))
        {
            if(!vis[x])
            {
                dfs(vis,x,a1,ha);
            }
        }
    }
}
