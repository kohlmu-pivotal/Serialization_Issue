package com.vmware.gemfire.jpmc;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;

public class GemFireClient {
  public static void main(String[] args) {
    ClientCache clientCache = new ClientCacheFactory().addPoolLocator("localhost", 10334).setPdxSerializer(new ReflectionBasedAutoSerializer("org.springframework.data.gemfire.serialization.Order")).create();

    Region<Object, Object> orders = clientCache.createClientRegionFactory(ClientRegionShortcut.PROXY).create("Orders");

    orders.put("127",new Order("127", "unsettled"));
  }
}
