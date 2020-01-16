package org.mountcloud.springcloud.common.mongo.repository;

import org.mountcloud.springproject.common.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
  * @author zhanghaishan
  * @version V1.0
  *
  * TODO: mongodb的Repository，算是dao了，主要核心还是约束mvc规范
  * 2020/1/17.
  */
public interface BaseMongoRepository<T extends BaseEntity> extends MongoRepository<T, Long>{

}
