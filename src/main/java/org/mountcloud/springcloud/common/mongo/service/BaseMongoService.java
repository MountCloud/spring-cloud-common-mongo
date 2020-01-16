package org.mountcloud.springcloud.common.mongo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mountcloud.springcloud.common.mongo.repository.BaseMongoRepository;
import org.mountcloud.springcloud.mvc.common.service.BaseService;
import org.mountcloud.springproject.common.entity.BaseEntity;
import org.mountcloud.springproject.common.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;

public class BaseMongoService<E extends BaseEntity,R extends BaseMongoRepository<E>> implements BaseService<E> {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@Autowired
	protected R repository;

    private List<String> notset = new ArrayList<String>();
    
    public BaseMongoService() {
    	notset.add("id");
    }
	
	@Override
	public List<E> findList(E bean) {
		Example<E> example = Example.of(bean);
	    List<E> list = repository.findAll(example);
		return list;
	}

	@Override
	public E findOne(E bean) {
		Example<E> example = Example.of(bean);
		Optional<E> result = repository.findOne(example);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public E save(E bean) {
		ObjectUtil.setNullFields(bean,notset);
        bean = repository.save(bean);
		return bean;
	}

	@Override
	public E update(E bean) {
		bean = repository.save(bean);
		return bean;
	}

	@Override
	public boolean delete(E bean) {
		return false;
	}
	
	public List<E> findAll(){
		return repository.findAll();
	}

}
