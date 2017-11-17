//Example 1:
//
//Input: 2
//Output: (1,2)
//Explanation: 
//Initially, we have the team 1 and the team 2, placed like: 1,2.
//Then we pair the team (1,2) together with '(', ')' and ',', which is the final answer.
// 
//
//Example 2:
//
//Input: 4
//Output: ((1,4),(2,3))
//Explanation: 
//In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
//And we got (1,4),(2,3).
//In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the paratheses outside them.
//And we got the final answer ((1,4),(2,3)).
public class Output_Contest_Matches_544 {
    public String findContestMatch(int n) {
        List<String> matches = new ArrayList<>();
        for(int i = 1; i <= n; i++) matches.add(String.valueOf(i));
        
        while(matches.size() != 1){
            List<String> newRound = new ArrayList<>();
            for(int i = 0; i < matches.size()/2; i++)   
                newRound.add("(" + matches.get(i) + "," + matches.get(matches.size() - i - 1) + ")");
            matches = newRound;
        }
        return matches.get(0);
    }
}
