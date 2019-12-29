class Solution {
    public int calculate(String s) {
        if (s == null ) return 0;
        int result = 0;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0 ; i < s.length() ; i ++){
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == '('){
                ops.push('(');
            }else if (s.charAt(i) == ')'){
                while (ops.peek() !='('){
                    nums.push(apply(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            }else if ((s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') && processMinus(s, i)) {
                while (!ops.isEmpty() && hasPrecedence(s.charAt(i), ops.peek())){
                    nums.push(apply(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(s.charAt(i));
            }else{
                boolean isPos = true;
                if (!Character.isDigit(s.charAt(i))) {
                    isPos = s.charAt(i) == '-' ? false : true;
                    i ++;
                }
                int num = 0;
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0' ){
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                num = isPos ? num : num * -1;
                nums.push(num);
                System.out.println(ops);
                System.out.println(nums);
                // System.out.println(i);
                i --;
            }
        }
        //  System.out.println(nums.size());
        while (!ops.isEmpty()){
            nums.push(apply(ops.pop(), nums.pop(), nums.pop()));
        }
        if (nums.isEmpty()) return 0;
        return nums.pop();
    }
    
    public boolean hasPrecedence(char op2, char op1){
        if (op1 == '(') return false;
        if ((op1== '+' || op1 == '-') && (op2 == '/' || op2 == '*')) return false;
        return true;
    }
    
    private boolean processMinus(String s, int i) {
        char c = s.charAt(i);
        if (c != '-') return true;
        if (i != 0 && (s.charAt(i - 1) == ' ' || s.charAt(i - 1) == ')' || Character.isDigit(s.charAt(i - 1))) ) return true;
        return false;
    }
    
    public int apply(char c, int num2, int num1){
        if (c == '+'){
            return num2 + num1;
        }else if (c == '-'){
            return num1 - num2;
        }else if (c == '*'){
            return num1 * num2;
        }else{
            return num1 / num2;
        }
    }
}