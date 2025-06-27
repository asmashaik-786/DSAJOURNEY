class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        int i=0;
        int j=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int maxfreq=0;
        while(j<s.length())
        {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxfreq=Math.max(maxfreq,map.get(s.charAt(j)));
            int window=j-i+1;
            int toreplace=window-maxfreq;
            if(toreplace>k)
            {
                map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                if(map.get(s.charAt(i))==0)
                {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}