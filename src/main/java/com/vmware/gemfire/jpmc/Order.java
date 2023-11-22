package com.vmware.gemfire.jpmc;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.Builder
@lombok.Setter
@Region("Orders")
public class Order {
  @Id
  private String orderId;
  private String settlementInstruction;
}
