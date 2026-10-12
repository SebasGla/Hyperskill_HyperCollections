package collections;


import java.util.Map;

public class Main {
  public static void main(String[] args) {

    Multiset<Integer> multiset = new Multiset<>();
    int i = 2;
// Schritt 1 bis 7 (hast du schon erfolgreich)
    multiset.setCount(i, 5);
    multiset.setCount(i, 2, 5);
    multiset.add(i, 3);
    multiset.setCount(i, 2, 5);
    multiset.setCount(i, -1);
    multiset.setCount(i, 3, -1);
    multiset.setCount(i, 3, 5);
    multiset.setCount(i, 1);
    multiset.setCount(i, 0);

    System.out.println("Zustand nach Schritt 7: " + multiset); // []

    // --- AB HIER KOMMT DER REST DES TESTS ---

    System.out.println("\n--- Schritt 8: add(2, 3) ---");
    multiset.add(i, 3);
    System.out.println("multiset: " + multiset); // Erwartet: [2, 2, 2]

    System.out.println("\n--- Schritt 9: setCount(2, 3, 3) und setCount(2, 3) ---");
    multiset.setCount(i, 3, 3);
    System.out.println("nach setCount(2, 3, 3): " + multiset); // Erwartet: [2, 2, 2]
    multiset.setCount(i, 3);
    System.out.println("nach setCount(2, 3):    " + multiset); // Erwartet: [2, 2, 2]

    System.out.println("\n--- Schritt 10: setCount(2, 3, 0) -> MUSS ENTFERNT WERDEN! ---");
    multiset.setCount(i, 3, 0);
    System.out.println("multiset:   " + multiset);             // Erwartet: []
    System.out.println("elementSet: " + multiset.elementSet()); // Erwartet: []
    System.out.println("contains:   " + multiset.contains(i));   // Erwartet: false
    System.out.println("count:      " + multiset.count(i));      // Erwartet: 0

    System.out.println("\n--- Schritt 11: add(2, 3) für den nächsten Schleifendurchlauf ---");
    multiset.add(i, 3);
    System.out.println("multiset: " + multiset); // Erwartet: [2, 2, 2]

  }

}