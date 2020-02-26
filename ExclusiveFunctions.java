import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExclusiveFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        System.out.println(logs.size());
        Map<Integer,Integer> map = new HashMap<>();
        map.put(Integer.valueOf(logs.get(0).split(":")[0]),Integer.valueOf(logs.get(1).split(":")[2])-
                Integer.valueOf(logs.get(0).split(":")[2]));
        for(int i=1;i<logs.size()-1;i++){
            String[] current_array = logs.get(i).split(":");
            String[] next_array = logs.get(i+1).split(":");
                if(next_array[1].equalsIgnoreCase("end") && next_array[0].equalsIgnoreCase(current_array[0])){
                    map.put(Integer.valueOf(next_array[0]),
                            Integer.valueOf(next_array[2])-Integer.valueOf(current_array[2])+1);
                }
                else if(next_array[1].equalsIgnoreCase("start")){
                    map.put(Integer.valueOf(next_array[0]),
                            Integer.valueOf(next_array[2])-Integer.valueOf(current_array[2]));
                }
                else if(next_array[1].equalsIgnoreCase("end")){
                    Integer num = map.get(Integer.valueOf(next_array[0]));
                    map.put(Integer.valueOf(next_array[0]),
                        Integer.valueOf(next_array[2])-Integer.valueOf(current_array[2])+ num);
                }
        }
        Integer[] values = map.values().toArray(new Integer[0]);
        return toPrimitive(values);
    }

    public static int[] toPrimitive(Integer[] IntegerArray) {

        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }
    public static void main(String args[]){
        ExclusiveFunctions functions = new ExclusiveFunctions();
        String[] string = {"0:start:0","1:start:2","1:end:5","2:start:6","2:end:6","0:end:7"};
        int[] array = functions.exclusiveTime(2, Arrays.asList(string));
       for(int num: array){
           System.out.println(num);
       }
    }
}
