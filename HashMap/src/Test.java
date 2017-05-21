import java.util.*;
public class Test {
  public static void main(String[] args) {
  	MyHashMap<Character, Integer> testMap = new MyHashMap<Character, Integer>();
    //System.out.println(testMap.isEmpty());
    System.out.println("cap right now is " + testMap.getCap());
    String s = "abcdefghijklmno";
    char[] key = s.toCharArray();
    for (int i = 0; i < 15; i++) {
    	  testMap.put(key[i], i + 1);
    }
    System.out.println("cap right now is " + testMap.getCap());
    System.out.println("The number of unique key is " + key.length);
    System.out.println("Number of Entry pair is " + testMap.size());
    System.out.println(testMap.get('a'));
    System.out.println(testMap.remove('b')); 
    System.out.println(testMap.get('b'));
    System.out.println("the size of map is " + testMap.size()); 
    System.out.println(testMap.remove('z'));
    s = "pqrstuvwxyz";
    key = s.toCharArray();
    for (int i = 0; i < 11; i++) {
    	  testMap.put(key[i], i + 15);
    }
    System.out.println("");
    System.out.println("cap right now is " + testMap.getCap());
    System.out.println("size right now is " + testMap.size());
    System.out.println(testMap.get('z'));
    System.out.println("");
    System.out.println(testMap.get('a'));
    System.out.println(testMap.get('b'));
    System.out.println(testMap.get('c'));
    System.out.println(testMap.get('d'));
    System.out.println(testMap.get('e'));
    System.out.println(testMap.get('f'));
    System.out.println(testMap.get('g'));
    System.out.println(testMap.get('h'));
    // default load factor 0.75 cap 16 then, when size > 12 rehasing will happend.
    //HashMap<Character, Integer> h = new HashMap<Character, Integer>();
    //h.put('a', 1);
    //System.out.println(h.get('a'));
    //System.out.println(h.remove('a'));
    //System.out.println(h.get('a'));
  }
}
