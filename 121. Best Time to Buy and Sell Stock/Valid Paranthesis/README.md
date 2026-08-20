Valid ParenthesesA highly efficient Java solution for the classic "Valid Parentheses" problem (LeetCode #20). This repository contains an optimized $O(N)$ Time Complexity approach utilizing a Stack data structure.📌 Problem DescriptionGiven a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.An input string is valid if:Open brackets must be closed by the same type of brackets.Open brackets must be closed in the correct order.Every close bracket has a corresponding open bracket of the same type.ExamplesExample 1:Input: s = "()"Output: trueExample 2:Input: s = "()[]{}"Output: trueExample 3:Input: s = "(]"Output: falseExample 4:Input: s = "([])"Output: trueExample 5:Input: s = "([)]"Output: falseConstraints$1 \le s.length \le 10^4$s consists of parentheses only '()[]{}'.🚀 Solution ApproachThe problem requires us to ensure that brackets are closed in the exact reverse order of their opening. This Last-In, First-Out behavior perfectly matches a Stack data structure.Instead of pushing the opening brackets onto the stack, this approach pushes the expected closing bracket. When a closing bracket is encountered in the string, it must match the top of the stack. If the stack is empty before the string is fully processed, or if the top of the stack does not match the current character, the string is invalid. This optimization avoids complex conditional mapping during the pop phase.Complexity AnalysisMetricComplexityDescriptionTime Complexity$O(N)$We traverse the string of length $N$ exactly once. Each character operation (push/pop) takes $O(1)$ time.Space Complexity$O(N)$In the worst-case scenario (e.g., all open brackets "((((("), the stack will store all $N$ characters.💻 Code StructureThe core implementation is written in Java:Javaclass Solution {
    public boolean isValid(String s) {
        // A stack to keep track of expected closing brackets
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // When an opening bracket is found, push its corresponding closing partner
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, it must match the top element of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}