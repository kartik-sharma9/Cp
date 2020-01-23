import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

        int capacity;
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> dq = new LinkedList<>();
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.get(key)==null)
                return -1;

            else{
                dq.remove(map.get(key));
                dq.addFirst(map.get(key));
                return map.get(key);
            }
        }

        public void put(int key, int value) {
            if(dq.size()==capacity){
                map.remove(dq.getLast());
                dq.removeLast();
                dq.addFirst(key);
                map.put(key,value);
            }
            else{
                dq.addFirst(key);
                map.put(key,value);
            }
        }

        public static void main(String args[]){
            LRUCache cache = new LRUCache(2);
            cache.put(2,1);
            System.out.println(cache.get(2));
            cache.put(3,2);
            System.out.println(cache.get(2));
            System.out.println(cache.get(3));

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

