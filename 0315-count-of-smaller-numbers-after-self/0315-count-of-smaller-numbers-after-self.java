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
        List<Integer>a1=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            a1.add(0);
        }
        merge(pairs,0,pairs.length-1,a1);
        return a1;
    }
    static void merge(Pair[]arr,int l,int h,List<Integer>a1)
    {
        if(l>=h)
        {
            return;
        }
        int mid=(l+h)/2;
        merge(arr,l,mid,a1);
        merge(arr,mid+1,h,a1);
        merging(arr,l,mid,h,a1);
    }
    static void merging(Pair[]arr,int l,int mid,int h,List<Integer>a1)
    {
        int i=l;
        int j=mid+1;
        int c=0;
        ArrayList<Pair>a2=new ArrayList<>();
        while(i<=mid && j<=h)
        {
            if(arr[i].value<=arr[j].value)
            {
                a1.set(arr[i].index,a1.get(arr[i].index)+c);
                a2.add(arr[i++]);
            }
            else
            {
                c++;
                a2.add(arr[j++]);
            }
        }
        while(i<=mid)
        {
           a1.set(arr[i].index,a1.get(arr[i].index)+c);
            a2.add(arr[i++]);
        }
        while(j<=h)
        {
            a2.add(arr[j++]);
        }
        for(int k=l;k<=h;k++)
        {
            arr[k]=a2.get(k-l);
        }
    }
}