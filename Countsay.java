import java.util.*;

public class Countsay {
    public static void main(String args[]){
        Countsay countsay = new Countsay();
        System.out.println(countsay.countAndSay(5));
    }
    public String countAndSay(int n){
        int num=n;
        Queue<Integer> stack = new LinkedList<>();
        Queue<Integer> stack2 = new LinkedList<>();
        stack.add(1);
        while(n-1>0){
            int stack2size = stack2.size();
            int stacksize= stack.size();
            if(stacksize>0){
                int count=1,last=0;
                while(stack.size()>0) {
                     last = stack.poll();
                     if(stack.size()>0 && last==stack.peek()) {
                         count++;
                     }
                     else{
                             stack2.add(count);
                             stack2.add(last);
                         count=1;
                     }

                }
            }
            if(stack2size>0){
                int count=1,last=0;
                while(stack2.size()>0) {
                    last = stack2.poll();
                    if(stack2.size()>0 && last==stack2.peek()) {
                        count++;
                    }
                    else{
                        stack.add(count);
                        stack.add(last);
                        count=1;
                    }

                }
            }
            n--;
        }
        if(stack.size()>0){
            String last="";
            while(stack.size()>0){
                last = last +  stack.poll();
            }
            return last;
        }
        if(stack2.size()>0){
            String last="";
            while(stack2.size()>0){
                last = last +  stack2.poll();
            }
            return last;
        }
        return "1";
    }
}
