package org.mountcloud.springcloud.common.mongo;

import org.mountcloud.springcloud.common.mongo.config.MongoConfig;
import org.mountcloud.springcloud.common.mongo.setting.MongoSetting;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhanghaishan
 * @version V1.0
 * TODO: 是否启用mongo连接池
 * 2020/1/17.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MongoSetting.class, MongoConfig.class})
public @interface EnableMongoConnectionPool {
}
