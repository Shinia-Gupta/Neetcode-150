class Solution {
    public List<String> letterCombinations(String digits) {
//for each digit,get and store a characters set in the list 
List<String> lettersList=new ArrayList<>();
for(int i=0;i<digits.length();i++){
    lettersList.add(getletters(digits.charAt(i)));
}
// 34- def,ghi
List<String> res=new ArrayList<>();
StringBuilder str=new StringBuilder();
// i was thinking to do it with iteration of for loop. But this iteration is only applicable to 2 digit strings, any strings above 2 digits will have more set of strings in the letters list and at that instance of test case, this approach wont work.
backtrack(res,lettersList,0,str);
return res;
    }

    private void backtrack(List<String> res,List<String> lettersList,int index,StringBuilder str){
        if(str.length()==lettersList.size()){
            if(!str.toString().equals(""))res.add(str.toString());
            return;
        }

        String currLetters=lettersList.get(index);

            for(int j=0;j<currLetters.length();j++){
            str.append(currLetters.charAt(j));
            backtrack(res,lettersList,index+1,str);
            str.deleteCharAt(str.length()-1);
            }
        
    }

    private String getletters(char c){
        switch(c){
            case '2':
            return "abc";
            case '3':
            return "def";
            case '4':
            return "ghi";
            case '5':
            return "jkl";
            case '6':
            return "mno";
            case '7':
            return "pqrs";
            case '8':
            return "tuv";
            case '9':
            return "wxyz";
            default:
            return "";
        }
    }
}
