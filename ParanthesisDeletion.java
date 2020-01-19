import java.util.Stack;

public class ParanthesisDeletion {

    public static void main(String args[]){
        Stack<Character> stack = new Stack<Character>();
        String input_string = "(()()()))))))){}{}}";
        String Original_value= input_string;
        for(int i=0; i < input_string.length();i++){
            if(input_string.charAt(i)==')' || input_string.charAt(i)==']' || input_string.charAt(i)=='}' )
            {
                input_string= stackPop(stack, input_string, i);
                if(!input_string.equalsIgnoreCase(Original_value)){
                    --i;
                    Original_value=input_string;
                }
            }
            else if(input_string.charAt(i)=='(' || input_string.charAt(i)=='[' || input_string.charAt(i)=='{')
                stackPush(stack, input_string, i);
        }

        System.out.println(input_string);
    }

    private static String stackPop(Stack<Character> stack, String input_string, int i) {

        Boolean isFound=false;
        if(input_string.charAt(i)== '}') {
            isFound = CheckInStack(stack,'{');
        }
        if(input_string.charAt(i) == ']'){
             isFound= CheckInStack(stack,'[');
        }
        if(input_string.charAt(i)== ')'){
             isFound= CheckInStack(stack,'(');
        }

        if(!isFound){
            return input_string.substring(0,i) + input_string.substring(i+1,input_string.length());
        }
        else
            return input_string;
    }

    private static Boolean CheckInStack(Stack<Character> stack, char bracket) {
        Stack<Character> second_stack = new Stack<>();
        while (!stack.empty()) {
            Character pop = stack.pop();
            if(pop!=bracket) {
                second_stack.push(pop);
                pop = stack.pop();
            }
            else{
                while(!second_stack.empty()){
                    stack.push(second_stack.pop());
                }
                return  true;
            }
        }
            return false;

    }

    private static void stackPush(Stack<Character> stack, String input_string, int i) {
            stack.push(input_string.charAt(i));
    }
}
