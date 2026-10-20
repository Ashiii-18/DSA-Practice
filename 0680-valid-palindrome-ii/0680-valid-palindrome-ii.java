class Solution {
    public boolean ispal(String s,int l,int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }

        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return ispal(s,l+1,r)||ispal(s,l,r-1);
            }
            l++;
            r--;
        }
        return true;
    }
}