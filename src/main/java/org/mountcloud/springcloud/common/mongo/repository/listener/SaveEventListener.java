package org.mountcloud.springcloud.common.mongo.repository.listener;


import org.mountcloud.springcloud.common.mongo.repository.keys.SeqInfo;
import org.mountcloud.springproject.common.entity.BaseEntity;
import org.mountcloud.springproject.common.entity.annotation.EntityId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * TODO:
 * com.ugirls.listener
 * 2019/4/11.
 *
 * @author zhanghaishan
 * @version V1.0
 */
@Component
public class SaveEventListener extends AbstractMongoEventListener<Object> {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        if (source != null) {
        	
        	//判断是不是BaseEmpty，设置创建时间和更新时间
            if(source instanceof BaseEntity) {
            	Date date = new Date();
            	BaseEntity tempEntity = (BaseEntity) source;
            	if(tempEntity.getId()==null) {
            		if(tempEntity.getCreateTime()==null) {
            			tempEntity.setCreateTime(date);
            		}
            		if(tempEntity.getUpdateTime()==null) {
            			tempEntity.setUpdateTime(date);
            		}
            	}else {
            		tempEntity.setUpdateTime(date);
            	}
            }
        	
        	//设置id
            ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
                public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                    ReflectionUtils.makeAccessible(field);
                    // 如果字段添加了我们自定义的AutoIncKey注解
                    if (field.isAnnotationPresent(EntityId.class)) {

                        Object value = field.get(source);
                        if(value==null){
                            // 设置自增ID
                            field.set(source, getNextId(source.getClass().getSimpleName()));
                        }
                    }
                }
            });
            
        }
    }

    /**
     * 获取下一个自增ID
     *
     * @param collName
     *            集合（这里用类名，就唯一性来说最好还是存放长类名）名称
     * @return 序列值
     */
    private Long getNextId(String collName) {
        Query query = new Query(Criteria.where("collName").is(collName));
        Update update = new Update();
        update.inc("seqId", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        SeqInfo seq = mongo.findAndModify(query, update, options, SeqInfo.class);
        return seq.getSeqId();
    }
}
