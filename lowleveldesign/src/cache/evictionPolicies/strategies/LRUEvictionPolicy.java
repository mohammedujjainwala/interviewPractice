package cache.evictionPolicies.strategies;


import cache.evictionPolicies.IEvictionPolicy;

import java.util.HashMap;

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
