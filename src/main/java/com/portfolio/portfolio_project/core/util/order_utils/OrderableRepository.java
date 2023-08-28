package com.portfolio.portfolio_project.core.util.order_utils;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderableRepository<T extends Orderable, ID> extends MongoRepository<T, ID> {
    T findTopByOrderByOrderDesc();
}