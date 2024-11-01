package cache.evictionpolicies;


import cache.evictionpolicies.IEvictionPolicy;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {

    public LRUEvictionPolicy(){

    }

    @Override
    public void keyAccessed(final Key key) {

    }

    @Override
    public Key evictKey() {
        return null;
    }

    @Override
    public void removeKey(final Key key) {

    }
}
