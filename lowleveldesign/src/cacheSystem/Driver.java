package cacheSystem;


import cacheSystem.factory.CacheFactory;
import cacheSystem.factory.CacheSystemFactory;
import cacheSystem.factory.ICacheFactory;
import cacheSystem.factory.ICacheSystemFactory;
import cacheSystem.models.CacheLeveLStats;
import cacheSystem.services.ICacheService;
import cacheSystem.services.ICacheSystemService;

import java.security.Key;

public class Driver {
    public static void main(String[] args) {
        ICacheFactory<String, String> cacheFactory = new CacheFactory<String, String>();
        ICacheSystemFactory<String, String> cacheSystemFactory = new CacheSystemFactory<>(cacheFactory);
        ICacheSystemService<String, String> cacheSystemService = cacheSystemFactory.defaultCacheSystem(2);
        cacheSystemService.add("K1","V1");
        cacheSystemService.add("K2","V2");
        printCurState(cacheSystemService);
        System.out.println("Value:"+cacheSystemService.get("K2").getValue());
        cacheSystemService.add("K2","V2");
        printCurState(cacheSystemService);
    }

    public static void printCurState(ICacheSystemService<String, String> cacheSystemService){
        System.out.println("Average read time:"+cacheSystemService.getStats().getAvgReadTime());
        System.out.println("Average write time:"+cacheSystemService.getStats().getAvgWriteTime());
        for(CacheLeveLStats cacheLeveLStats:cacheSystemService.getStats().getStats()){
            System.out.println("Usage of Level:"+cacheLeveLStats.getLevel()+":"+cacheLeveLStats.getUsages());
        }
    }
}
