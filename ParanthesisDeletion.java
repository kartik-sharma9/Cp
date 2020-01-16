import java.util.Stack;

public class ParanthesisDeletion {

    public static void main(String args[]){
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> sup_stack = new Stack<>();
        String input_string = "";
        for(int i=0; i < input_string.length();i++){
            stackPush(stack, input_string, i);
            stackPop(stack, input_string, i);
        }
    }

    private static void stackPop(Stack<Character> stack, String input_string, int i) {
        Character pop = stack.pop();
        if(input_string.charAt(i)== '}') || input_string.charAt(i) == ']' || input_string.charAt(i)== ')'){
           if(pop=='{'){

           }
           if(input_string.charAt(i) == ']')
        }
    }

    private static void stackPush(Stack<Character> stack, String input_string, int i) {
        if(input_string.charAt(i)=='(' || input_string.charAt(i) == '{'|| input_string.charAt(i) == '[')
            stack.push(input_string.charAt(i));
    }
}
