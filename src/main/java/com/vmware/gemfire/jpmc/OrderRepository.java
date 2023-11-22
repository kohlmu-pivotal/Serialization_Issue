package com.vmware.gemfire.jpmc;

import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends GemfireRepository<Order, String> {
}
