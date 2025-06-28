class Solution {
    public String minWindow(String s, String t) {
         HashMap<Character,Integer>tmap=new HashMap<>();
        HashMap<Character,Integer>smap=new HashMap<>();
        int c=0;
        int i=0;
        int j=0;
        int idx=0;
        String str="";
        int min=Integer.MAX_VALUE;
        for(int k=0;k<t.length();k++){
                    char ch=t.charAt(k);
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        while(j<s.length())
        {
            char ch=s.charAt(j);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch) && smap.get(ch)<=tmap.get(ch))
            {
                c++;
            }
            while(c==t.length())
            {
                int val=j-i+1;
                if(val<min)
                {
                    min=val;
                    idx=i;
                }
                 char ch2=s.charAt(i);
                if(smap.containsKey(ch2))
                {
                    smap.put(ch2,smap.getOrDefault(ch2,0)-1);
                    if(tmap.containsKey(ch2) && smap.get(ch2)<tmap.get(ch2))
                    {
                        c--;
                    }
                }
                i++;
            }
            j++;
        }
        if(min!=Integer.MAX_VALUE)
        {
            str=s.substring(idx,idx+min);
        }
        return str;
    }
}