package org.mountcloud.springcloud.common.mongo.config;

import org.mountcloud.springcloud.common.mongo.setting.MongoSetting;
import org.mountcloud.springproject.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientOptionsFactoryBean;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import com.mongodb.ReadPreference;

@Configuration
public class MongoConfig {

	@Autowired
	@Lazy
	private MongoSetting setting;

	private MongoDbFactory mongoDbFactory;

	private MongoMappingContext mongoMappingContext;

	public MongoDbFactory getMongoDbFactory() {
		return mongoDbFactory;
	}

	@Autowired

	public void setMongoDbFactory(@Lazy MongoDbFactory mongoDbFactory) {
		this.mongoDbFactory = mongoDbFactory;
	}

	public MongoMappingContext getMongoMappingContext() {
		return mongoMappingContext;
	}

	@Autowired
	public void setMongoMappingContext(@Lazy MongoMappingContext mongoMappingContext) {
		this.mongoMappingContext = mongoMappingContext;
	}

	@Bean
	@Lazy
	public MongoClientOptionsFactoryBean mongoClientOptionFactoryBeanProd() {

		MongoClientOptionsFactoryBean bean = new MongoClientOptionsFactoryBean();
		bean.setConnectionsPerHost(setting.getConnectionsPerHost());
		bean.setConnectTimeout(setting.getConnectTimeout());
		bean.setHeartbeatConnectTimeout(setting.getHeartbeatConnectTimeout());
		bean.setMaxConnectionIdleTime(setting.getMaxConnectionIdleTime());
		bean.setMaxConnectionLifeTime(setting.getMaxConnectionLifeTime());
		bean.setMinConnectionsPerHost(setting.getMinConnectionsPerHost());
		bean.setReadPreference(ReadPreference.secondary());
		if(!StringUtil.isEmpty(setting.getRequiredReplicaSetName())) {
			bean.setRequiredReplicaSetName(setting.getRequiredReplicaSetName());
		}
		bean.setMinHeartbeatFrequency(setting.getMinHeartbeatFrequency());
		bean.setHeartbeatSocketTimeout(setting.getHeartbeatSocketTimeout());
		bean.setSocketKeepAlive(setting.isSocketKeepAlive());
		bean.setThreadsAllowedToBlockForConnectionMultiplier(setting.getThreadsAllowedToBlockForConnectionMultiplier());

		return bean;
	}

	@Bean
	@Lazy
	public MappingMongoConverter mappingMongoConverter() {

		DbRefResolver dbRefResolver = new DefaultDbRefResolver(getMongoDbFactory());
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, getMongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		return converter;
	}
}
