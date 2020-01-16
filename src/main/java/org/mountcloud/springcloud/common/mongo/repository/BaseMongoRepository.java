package org.mountcloud.springcloud.common.mongo.repository;

import org.mountcloud.springproject.common.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseMongoRepository<T extends BaseEntity> extends MongoRepository<T, Long>{

}
