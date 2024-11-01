package cache.services;

public interface ICacheService<Key, Value> {
    void add(Key key ,Value value);

    void remove(Key key);

    Value get(Key key);
}
