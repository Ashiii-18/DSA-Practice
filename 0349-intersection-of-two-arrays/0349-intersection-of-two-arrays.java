import java.util.HashSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
        ArrayList<Integer>count = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                count.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        
        int[] ans = new int[count.size()];

        for (int i = 0; i < count.size(); i++) {
            ans[i] = count.get(i);
        }

        return ans;
    }
}