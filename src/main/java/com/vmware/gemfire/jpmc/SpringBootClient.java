package com.vmware.gemfire.jpmc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.GemfireTemplate;

@SpringBootApplication
public class SpringBootClient {

  public static void main(String[] args) {
    new SpringApplicationBuilder(SpringBootClient.class).run(args);
  }

}
