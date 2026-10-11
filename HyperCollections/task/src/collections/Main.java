package collections;


import java.util.Map;

public class Main {
  public static void main(String[] args) {
    BiMap<Character, Integer> biMap = new BiMap<>();

    biMap.put('a', 3);
    biMap.putAll(Map.of('b', 4, 'c', 5));

    System.out.println(biMap); // {a=3, b=4, c=5}
    System.out.println(biMap.values()); // [3, 4, 5]

    biMap.putAll(Map.of('d', 6, 'e', 7));

    System.out.println(biMap); // {a=3, b=4, c=5, d=6, e=7}
    System.out.println(biMap.inverse()); // {3=a, 4=b, 5=c, 6=d, 7=e}

    biMap.forcePut('f', 8);

    System.out.println(biMap); // {a=3, b=4, c=5, d=6, e=7, f=8}
    System.out.println(biMap.inverse()); // {3=a, 4=b, 5=c, 6=d, 7=e, 8=f}

    biMap.forcePut('a', 9);

    System.out.println(biMap); // {a=9, b=4, c=5, d=6, e=7, f=8}
    System.out.println(biMap.inverse()); // {4=b, 5=c, 6=d, 7=e, 8=f, 9=a}

    biMap.forcePut('g', 4);

    System.out.println(biMap); // {a=9, c=5, d=6, e=7, f=8, g=4}
    System.out.println(biMap.inverse()); // {4=g, 5=c, 6=d, 7=e, 8=f, 9=a}

    biMap.forcePut('c', 6);

    System.out.println(biMap); // {a=9, c=6, e=7, f=8, g=4}
    System.out.println(biMap.inverse()); // {4=g, 6=c, 7=e, 8=f, 9=a}

  }
}