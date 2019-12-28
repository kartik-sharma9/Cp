import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class AmazonQue1 {
    public static void main (String args[]){
        Map<String, List<String>> userBooks = new HashMap<>();
        userBooks.put("Fred", Arrays.asList("mass","world","stress"));
        userBooks.put("Jenie", Arrays.asList("happy","pride"));
        userBooks.put("Rone", Arrays.asList("alexender"));

        Map<String, List<String>> booksGenre = new HashMap<>();
        booksGenre.put("Horror", Arrays.asList("mass","stress"));
        booksGenre.put("Comedy", Arrays.asList("happy"));
        booksGenre.put("Romance", Arrays.asList("world","alexender","pride"));

        AmazonQue1 obj = new AmazonQue1();
        System.out.println(obj.createMap(userBooks,booksGenre).toString());

    }

    private Map<String, List<String>> createMap(Map<String, List<String>> userBooks, Map<String, List<String>> booksGenre) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for(Map.Entry<String,List<String>> entry: userBooks.entrySet()){
            Map<String,Integer> genreCounter = new HashMap<>();
            List<String> booksRead = entry.getValue();
            for(String books:booksRead){
                for(Map.Entry<String,List<String>> bookiterator: booksGenre.entrySet()){
                    if(bookiterator.getValue().contains(books)){
                        genreCounter.put(bookiterator.getKey(),
                                genreCounter.getOrDefault(bookiterator.getKey(),0)+1);
                    }
                }
            }
            resultMap.put(entry.getKey(),sortAndComputeMap(genreCounter));
        }
        return resultMap;
    }

    private List<String> sortAndComputeMap(Map<String, Integer> genreCounter) {
        Map<String, Integer>  sorted = genreCounter
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        // now let's sort the map in decreasing order of value
        sorted = genreCounter
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        List<String> list = new ArrayList<>();
        int highest=0;
        for(Map.Entry<String,Integer> entry:sorted.entrySet()){
            if(highest<=entry.getValue()){
                list.add(entry.getKey());
                highest=entry.getValue();
            }
        }
        return list;
    }

}
