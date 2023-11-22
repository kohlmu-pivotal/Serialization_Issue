package com.vmware.gemfire.jpmc;

import org.apache.geode.cache.GemFireCache;
import org.apache.geode.pdx.PdxSerializer;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.mapping.MappingPdxSerializer;
import org.springframework.data.gemfire.util.CollectionUtils;

import java.util.Set;

@Configuration
@ClientCacheApplication(locators = {@ClientCacheApplication.Locator(host = "localhost", port = 10334)})
@EnableEntityDefinedRegions(basePackageClasses = Order.class)
@EnablePdx(serializerBeanName = "OrderPdxSerializer", readSerialized = false)
public class TestConfig {
    @Bean("OrderPdxSerializer")
    @Profile("MappingPdxSerializer")
    MappingPdxSerializer customMappingPdxSerializer() {

      Set<Class<?>> includedTypes = CollectionUtils.asSet(Order.class);

      MappingPdxSerializer customMappingPdxSerializer = MappingPdxSerializer.newMappingPdxSerializer();

      customMappingPdxSerializer.setIncludeTypeFilters(type -> includedTypes.contains(type));

      return customMappingPdxSerializer;
    }

    @Bean("OrderPdxSerializer")
    @Profile("ReflectionBasedAutoSerializer")
    PdxSerializer reflectionAutoSerializer() {
      return new ReflectionBasedAutoSerializer("org.springframework.data.gemfire.serialization.Order");
    }

    @Bean
    @DependsOn("Orders")
    GemfireTemplate ordersTemplate(GemFireCache cache) {
      return new GemfireTemplate(cache.getRegion("/Orders"));
    }
  }
