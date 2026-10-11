package collections;

import java.util.*;

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
        Set<Map.Entry<E,Integer>> entries = this.multiset.entrySet();
        List<E> flatList = new ArrayList<>();

        for (Map.Entry<E, Integer> entry : entries){
            int count = entry.getValue();
            E key = entry.getKey();
            for (int i = 0; i < count; i++){
                flatList.add(key);
            }
        }

        return flatList.toString();
    }

    public void remove(E element) {
        int count = Optional.ofNullable(this.multiset.get(element)).orElse(0);
        if(count > 1){
            this.multiset.put(element, count-1);
        }
        else{
            this.multiset.remove(element);
        }
    }

    public void remove(E element, int occurences) {
        int absOcc = Math.abs(occurences);
        int count = Optional.ofNullable(this.multiset.get(element)).orElse(0);
        if(count > absOcc){
            this.multiset.put(element, count-absOcc);
        }
        else{
            this.multiset.remove(element);
        }
    }


    public void setCount(E element, int count) {
        if (this.multiset.containsKey(element)) {
            this.multiset.put(element, count);
        }
    }

    public void setCount (E element,int oldCount, int newCount){
        if (this.multiset.containsKey(element)) {
            if (this.multiset.get(element) == oldCount) {
                this.multiset.put(element, newCount);
            }
        }
    }

}
