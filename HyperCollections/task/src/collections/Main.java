package collections;


import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Multiset<Character> multiset = new Multiset<>();
    multiset.add('a');
    multiset.add('b', 6);

    System.out.println(multiset); // [a, b, b, b, b, b, b]
    System.out.println(multiset.contains('c')); // false
    System.out.println(multiset.count('b')); // 6
    System.out.println(multiset.elementSet()); // ['a', 'b']


  }
}