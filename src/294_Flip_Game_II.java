/*You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm��s runtime complexity.*/
public class Flip_Game_II_294 {
	public boolean canWin(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+'
					&& !canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
				return true;
			}
		}
		return false;
	}

	
	public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, map);
    }
    
    public boolean dfs(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        if(s == null || s.length() < 2) return false;
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == '+' && ch[i - 1] == '+') {
                ch[i] = '-';
                ch[i - 1] = '-';
                if (!dfs(new String(ch), map)) {
                    map.put(new String(ch), false);
                    return true;
                } else {
                    map.put(new String(ch), true);
                }
                ch[i] = '+';
                ch[i - 1] = '+';
            }
        }
        return false;
    }
