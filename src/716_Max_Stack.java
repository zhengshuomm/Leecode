//Design a max stack that supports push, pop, top, peekMax and popMax.
//
//push(x) -- Push element x onto stack.
//pop() -- Remove the element on top of the stack and return it.
//top() -- Get the element on the top.
//peekMax() -- Retrieve the maximum element in the stack.
//popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

class MaxStack {
 2     Stack<Integer> stk;
 3     Stack<Integer> maxStk;
 4     
 5     /** initialize your data structure here. */
 6     public MaxStack() {
 7         stk = new Stack<Integer>();
 8         maxStk = new Stack<Integer>();
 9     }
10     
11     public void push(int x) {
12         stk.push(x);
13         if(maxStk.isEmpty() || maxStk.peek()<=x){
14             maxStk.push(x);
15         }
16     }
17     
18     public int pop() {
19         int x = stk.pop();
20         if(!maxStk.isEmpty() && x==maxStk.peek()){
21             maxStk.pop();
22         }
23 
24         return x;
25     }
26     
27     public int top() {
28         return stk.peek();
29     }
30     
31     public int peekMax() {
32         return maxStk.peek();
33     }
34     
35     public int popMax() {
36         Stack<Integer> tempStk = new Stack<Integer>();
37         int x = maxStk.pop();
38         while(!stk.isEmpty() && stk.peek()<x){
39             tempStk.push(stk.pop());
40         }
41         
42         stk.pop();
43         while(!tempStk.isEmpty()){
44             int top = tempStk.pop();
45             push(top);
46         }
47         return x;       
48     }
49 }