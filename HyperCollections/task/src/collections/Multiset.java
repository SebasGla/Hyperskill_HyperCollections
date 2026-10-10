package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Multiset<E> {
    private Map<E, Integer> multiset = new HashMap<>();

    public void add(E element){
        int count = this.count(element);
        this.multiset.put(element, ++count);
    }

    public void add(E element, int occurrences){
        int count = this.count(element) + occurrences;
        this.multiset.put(element, count);
    }

    public int count(E element){
        try{
            return this.multiset.get(element);
        } catch (NullPointerException e) {
            return 0;
        }

    }

    public boolean contains(E element){
        return this.multiset.containsKey(element);
    }

    public Set<E> elementSet(){
        return this.multiset.keySet();
    }

    @Override
    public String toString(){
        for
        return this.multiset.get
    }
}
