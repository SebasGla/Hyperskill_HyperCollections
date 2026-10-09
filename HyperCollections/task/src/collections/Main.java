package collections;


public class Main {
  public static void main(String[] args) {
    String test1 = "string 1";
    String test2 = "string 2";

    ImmutableCollection<String> stringCollection = ImmutableCollection.of(test1, test2);
    System.out.println(stringCollection.isEmpty());
    System.out.println(stringCollection.size());

    System.out.println(stringCollection.contains("string 1"));

    ImmutableCollection<?> emptyCollection = ImmutableCollection.of();

    System.out.println(emptyCollection.size()); // 0
    System.out.println(emptyCollection.isEmpty()); // true
  }
}