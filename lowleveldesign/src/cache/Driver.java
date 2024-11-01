package cache;


import cache.factory.CacheFactory;
import cache.factory.ICacheFactory;
import cache.services.ICacheService;

public class Driver {
    public static void main(String[] args) {
        ICacheFactory<String, String> cacheFactory = new CacheFactory<String, String>();
        ICacheService<String, String> cacheService = cacheFactory.defaultCache(2);
        cacheService.add("K1","V1");
        cacheService.add("K2","V2");
        cacheService.add("K1","V4");
        cacheService.add("K3","V3");
    }
}
