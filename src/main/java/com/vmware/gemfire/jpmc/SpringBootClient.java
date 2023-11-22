package com.vmware.gemfire.jpmc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootClient {

  public static void main(String[] args) {
    new SpringApplicationBuilder(SpringBootClient.class).run(args);
  }

}
