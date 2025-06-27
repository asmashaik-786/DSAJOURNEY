class Solution {
    public List<Integer> findAnagrams(String s1, String s2) {
        List<Integer>a1=new ArrayList<>();
        HashMap<Character,Integer>map1=new HashMap<>();
        HashMap<Character,Integer>map2=new HashMap<>();
        for(int i=0;i<s2.length();i++)
        {
            char ch=s2.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int i=0;
        int j=0;
        int k=s2.length();
        while(j<s1.length())
        {
            char ch=s1.charAt(j);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(j-i+1==k)
            {
                if(map1.equals(map2))
                {
                    a1.add(i);
                }
                char ch1=s1.charAt(i);
                map2.put(ch1,map2.getOrDefault(ch1,0)-1);
                if(map2.get(ch1)==0)
                {
                    map2.remove(ch1);
                }
                i++;
            }
            j++;
        }
        return a1;
    }
}