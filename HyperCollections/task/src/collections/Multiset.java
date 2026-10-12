package collections;

import java.util.*;

public class Multiset<E> {
    private Map<E, Integer> multiset = new HashMap<>();

    public void add(E element){
        int count = this.count(element);
        this.multiset.put(element, ++count);
    }

    public void add(E element, int occurrences){
        if(occurrences > 0) {
            int count = this.count(element) + occurrences;
            this.multiset.put(element, count);
        }
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

        if(occurences > 0){
            int count = Optional.ofNullable(this.multiset.get(element)).orElse(0);
            if(count > occurences){
                this.multiset.put(element, count-occurences);
            }
            else{
                this.multiset.remove(element);
            }
        }

    }


    public void setCount(E element, int count) {
        if(count > 0){
            if (this.multiset.containsKey(element)) {
                this.multiset.put(element, count);
            }
        }
        else if(count == 0){
            this.multiset.remove(element);
        }

    }

    public void setCount (E element,int oldCount, int newCount){
        if(newCount > 0){
            if (this.multiset.containsKey(element)) {
                if (this.multiset.get(element) == oldCount) {
                    this.multiset.put(element, newCount);
                }
            }
        } else if(newCount == 0){
            this.multiset.remove(element);
        }


    }

}
