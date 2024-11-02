package cacheSystem.evictionpolicies;

public interface IEvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evictKey();
    void removeKey(Key key);
}
