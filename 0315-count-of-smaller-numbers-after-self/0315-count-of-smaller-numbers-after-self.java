class Solution {
    static class Pair{
        int index;
        int value;
        Pair(int value,int index)
        {
            this.value=value;
             this.index=index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Pair[]pairs=new Pair[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            pairs[i]=new Pair(nums[i],i);
        }
        int[]res=new int[nums.length];
        merge(pairs,0,pairs.length-1,res);
        List<Integer>a1=new ArrayList<>();
        for(int i:res)
        {
            a1.add(i);
        }
        return a1;
    }
    static void merge(Pair[]arr,int l,int h,int[]res)
    {
        if(l>=h)
        {
            return;
        }
        int mid=(l+h)/2;
        merge(arr,l,mid,res);
        merge(arr,mid+1,h,res);
        merging(arr,l,mid,h,res);
    }
    static void merging(Pair[]arr,int l,int mid,int h,int[]res)
    {
        int i=l;
        int j=mid+1;
        int c=0;
        ArrayList<Pair>a1=new ArrayList<>();
        while(i<=mid && j<=h)
        {
            if(arr[i].value<=arr[j].value)
            {
                res[arr[i].index]+=c;
                a1.add(arr[i++]);
            }
            else
            {
                c++;
                a1.add(arr[j++]);
            }
        }
        while(i<=mid)
        {
            res[arr[i].index]+=c;
            a1.add(arr[i++]);
        }
        while(j<=h)
        {
            a1.add(arr[j++]);
        }
        for(int k=l;k<=h;k++)
        {
            arr[k]=a1.get(k-l);
        }
    }
}