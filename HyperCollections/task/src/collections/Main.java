package collections;


import java.util.Map;

public class Main {
  public static void main(String[] args) {

    SizeLimitedQueue<Integer> collection = new SizeLimitedQueue<>(3); // limit is 3

    System.out.println(collection); // []
    System.out.println(collection.maxSize()); // 3
    System.out.println(collection.size()); // 0
    System.out.println(collection.isEmpty()); // true

    collection.add(1);
    collection.add(2);

    System.out.println(collection.isEmpty()); // false
    System.out.println(collection); // [1, 2]
    System.out.println(collection.isAtFullCapacity()); // false

    collection.add(3);

    System.out.println(collection); // [1, 2, 3]
    System.out.println(collection.isAtFullCapacity()); // true

    collection.add(4);
    System.out.println(collection); // [2, 3, 4]

    System.out.println(collection.peek()); // 2
    System.out.println(collection); // [2, 3, 4]
    System.out.println(collection.remove()); // 2
    System.out.println(collection); // [3, 4]

    System.out.println(collection.toArray().getClass()); // class [Ljava.lang.Object;
    System.out.println(collection.toArray(new Integer[0]).getClass()); // class [Ljava.lang.Integer;

  }

}