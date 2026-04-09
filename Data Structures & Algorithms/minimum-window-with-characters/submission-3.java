class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap=new HashMap<>();
        HashMap<Character,Integer> sMap=new HashMap<>();
        int minLen=Integer.MAX_VALUE,minLengthStartWindow=0;
for(int i=0;i<t.length();i++){
tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
}
int required=tMap.size(),formed=0;
        int l=0;
        for(int r=0;r<s.length();r++){
sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);
if(tMap.containsKey(s.charAt(r)) && sMap.get(s.charAt(r))==tMap.get(s.charAt(r))){
formed++;
}
//valid window size
if(formed==required){
while(formed==required){
    if((r-l+1)<minLen){
        minLen=r-l+1;
        minLengthStartWindow=l;
    }
    sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
    if(tMap.containsKey(s.charAt(l)) && sMap.get(s.charAt(l))<tMap.get(s.charAt(l))){
formed--;
    }
    l++;
}
}
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minLengthStartWindow,minLengthStartWindow+minLen);
    }
}
