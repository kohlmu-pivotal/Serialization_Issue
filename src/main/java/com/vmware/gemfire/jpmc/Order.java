package com.vmware.gemfire.jpmc;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.Builder
@Region("Orders")
public class Order implements Serializable {
  @Id
  private String orderId;
  private String settlementInstruction;
}
