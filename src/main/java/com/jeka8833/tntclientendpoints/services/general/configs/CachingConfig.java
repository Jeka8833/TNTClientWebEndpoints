package com.jeka8833.tntclientendpoints.services.general.configs;

import org.cache2k.extra.spring.SpringCache2kCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        return new SpringCache2kCacheManager()
                .defaultSetup(cache -> cache.entryCapacity(10_000)
                        .expireAfterWrite(1, TimeUnit.HOURS).permitNullValues(false))

                .addCache(cache ->
                        cache.name("mojang").entryCapacity(2_000).expireAfterWrite(1, TimeUnit.DAYS)
                                .permitNullValues(false))
                .addCache(cache ->
                        cache.name("googleNsfwCache").expireAfterWrite(1, TimeUnit.DAYS)
                                .permitNullValues(false));
    }
}
