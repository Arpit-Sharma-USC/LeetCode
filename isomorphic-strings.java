class Solution {
    public boolean isIsomorphic(String s, String t) {
        return IsAMapB(s, t) && IsAMapB(t, s);
    }
    
    public boolean IsAMapB(String a, String b) {
        int len = a.length();
        
        // map[charA] = charB means charA should match charB.
        char[] map = new char[256]; 
        for (int i = 0; i < len; i++) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            
            if (map[charA] == 0) {
                map[charA] = charB;
            } else if (map[charA] != charB) {
                return false;
            }
        }
        return true;
    }
}
