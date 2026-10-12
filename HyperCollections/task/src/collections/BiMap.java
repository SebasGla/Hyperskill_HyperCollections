package collections;

import java.util.*;

public class BiMap<K, V>  {
    private Map<K, V> forwardMap = new HashMap<>();
    private Map<V, K> reverseMap = new HashMap<>();

    static <S,W> BiMap<S, W> of(Map<S, W> map){
        BiMap<S, W> bimap = new BiMap<>();

        map.forEach(bimap::put);

        return bimap;
    }

    public V put(K key, V value){
        if(this.forwardMap.containsKey(key)){
            throw new IllegalArgumentException();
        }

        if(this.reverseMap.containsKey(value)){
            throw new IllegalArgumentException();
        }

        this.forwardMap.put(key, value);
        this.reverseMap.put(value, key);

        return value;
    }


    public void putAll(Map<K, V> b) {
        Set<Map.Entry<K,V>> entries = b.entrySet();

        for(Map.Entry<K, V> entry: entries){
            K key = entry.getKey();
            V value = entry.getValue();

            if (this.forwardMap.containsKey(key)){
                throw new IllegalArgumentException();
            }

            if(this.reverseMap.containsKey(value)){
                throw new IllegalArgumentException();
            }

            this.forwardMap.put(key, value);
            this.reverseMap.put(value, key);
        }
    }

    @Override
    public String toString() {
        return this.forwardMap.toString();
    }

    public Set<V> values() {
        return new HashSet<>(this.forwardMap.values());
    }
    
    public BiMap<V, K> inverse() {
        return BiMap.of(this.reverseMap);
    }

    public V forcePut(K key, V value){
        //first check if the entry already exists. If we yes we return withouth doing anything
        if(this.forwardMap.containsKey(key)){
            if(this.forwardMap.get(key).equals(value)){
                return value;
            }
        }

        //check cases of current map states.
        if(this.forwardMap.containsKey(key) && this.forwardMap.containsValue(value)){
            V reverseKey = this.forwardMap.get(key);
            K forwardKey = this.reverseMap.get(value);

            this.forwardMap.replace(key, value);
            this.forwardMap.remove(forwardKey);
            this.reverseMap.replace(value, key);
            this.reverseMap.remove(reverseKey);
        }
        else if(this.forwardMap.containsKey(key)){
            V reverseKey = this.forwardMap.get(key);
            this.forwardMap.replace(key, value);

            this.reverseMap.remove(reverseKey);
            this.reverseMap.put(value, key);

        }else if(this.forwardMap.containsValue(value)){
            K forwardKey = this.reverseMap.get(value);
            this.reverseMap.replace(value, key);

            this.forwardMap.remove(forwardKey);
            this.forwardMap.put(key, value);

        }
        else {
            this.forwardMap.put(key, value);
            this.reverseMap.put(value, key);
        }

        return value;

    }
}
