class Solution {

    public String encode(List<String> strs) {
        // String ["neet","code","love","you"]

        if(strs.size()==0) return "";
        StringBuilder res=new StringBuilder();
        List<Integer> sizes=new ArrayList<>();
        for(String str:strs){
            sizes.add(str.length());
        }   //sizes=[4,4,4,4]

        for(int i=0;i<sizes.size();i++){
            res.append(sizes.get(i)).append(",");
        }   //res=4,4,4,4,
        res.append("#");    //res=4,4,4,4,#

        for(int i=0;i<strs.size();i++){
            res.append(strs.get(i));
        }   // res=4,4,4,4,#neetcodeloveyou

        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length()==0) return new ArrayList<>();
        List<String> res=new ArrayList<>();
        List<Integer> sizes=new ArrayList<>();
        
        int i=0;

        //extracting sizes appended to the encoded string
        while(str.charAt(i)!='#'){
            StringBuilder currStr=new StringBuilder();
            while(str.charAt(i)!=','){
                currStr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(currStr.toString()));
            i++;
        }   //sizes=[4,4,4,4]

        // character at position i is '#'
        i++;

        //start adding the substrings from the extracted sizes
        for(int size:sizes){
            res.add(str.substring(i,i+size));
            i+=size;
        }
        
return res;

    }
}
