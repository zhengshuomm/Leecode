//A string such as "word" contains the following abbreviations:
//
//["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.
//
//Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

    public class Abbreviation{
        public String abbr;
        public int len;
        
        public Abbreviation(String abbr, int len){
            this.abbr = abbr;
            this.len = len;
        }
    }
    
    public String minAbbreviation(String target, String[] dictionary) {
        if(dictionary.length == 0) return Integer.toString(target.length());
        PriorityQueue<Abbreviation> q = new PriorityQueue<Abbreviation>(new Comparator<Abbreviation>(){
           public int compare(Abbreviation a1, Abbreviation a2){
               return a1.len - a2.len;
           } 
        });
        generateAbbrs(target, 0, 0, "", q);
        System.out.println(q.size());
        while(!q.isEmpty()){
            String abbr = q.poll().abbr;
            boolean notMatch = true;
            for(int i=0; i<dictionary.length; i++){
                if(isValidAbbr(dictionary[i], abbr)){
                    notMatch = false;
                    break;
                }
            }
            if(notMatch) return abbr;
        }
        return "";
    }
    
    public void generateAbbrs(String word, int pos, int cnt, String out, PriorityQueue<Abbreviation> p) {
        if (pos == word.length()) {
            if (cnt > 0) out += cnt;
            p.offer(new Abbreviation(out, out.length()));
        } else {
            generateAbbrs(word, pos + 1, cnt + 1, out, p);
            generateAbbrs(word, pos + 1, 0, out + (cnt > 0 ? cnt : "") + word.charAt(pos), p);
        }
    }
    
    private boolean isValidAbbr(String word, String abbr){
        int index = 0, i = 0;
        while(i < abbr.length()){
            if(!Character.isDigit(abbr.charAt(i))){
                if(index >= word.length() || word.charAt(index) != abbr.charAt(i)) return false;
                index++; i++;
            }else{
                int start = i;
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i))) i++;
                int number = Integer.parseInt(abbr.substring(start, i));
                index += number;
            }
        }
        return index == word.length();
    }
