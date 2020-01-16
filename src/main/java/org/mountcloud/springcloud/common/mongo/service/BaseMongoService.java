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

/**
  * @author zhanghaishan
  * @version V1.0
  *
  * TODO: mongo的basesevice，用于简化mongo操作并且起到约束mvc规范的作用
  * 2020/1/17.
  */
public class BaseMongoService<E extends BaseEntity,R extends BaseMongoRepository<E>> implements BaseService<E> {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@Autowired
	protected R repository;

	//不设置默认值的属性
    protected List<String> notset = new ArrayList<String>();

    protected boolean setDefaultValue = true;
    
    public BaseMongoService() {
    	//id不设置默认值，像string类型的属性，null值不保存，数据库里看着缺胳膊短腿的很难受
    	notset.add("id");
    }

	/**
	 * 查询列表
	 * @param bean 查询条件就是bean
	 * @return 返回查询结果
	 */
	@Override
	public List<E> findList(E bean) {
		Example<E> example = Example.of(bean);
	    List<E> list = repository.findAll(example);
		return list;
	}

	/**
	 * 查询一个结果
	 * @param bean 查询条件
	 * @return 结果
	 */
	@Override
	public E findOne(E bean) {
		Example<E> example = Example.of(bean);
		Optional<E> result = repository.findOne(example);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	/**
	 * 保存结果
	 * @param bean 实体
	 * @return 结果
	 */
	@Override
	public E save(E bean) {
		if(setDefaultValue){
			ObjectUtil.setNullFields(bean,notset);
		}
        bean = repository.save(bean);
		return bean;
	}

	/**
	 * 更新实体
	 * @param bean 实体
	 * @return 结果
	 */
	@Override
	public E update(E bean) {
		bean = repository.save(bean);
		return bean;
	}

	/**
	 * 删除实体
	 * @param bean 实体
	 * @return 结果
	 */
	@Override
	public boolean delete(E bean) {
		return false;
	}

	/**
	 * 查询全部
	 * @return 查询结果
	 */
	public List<E> findAll(){
		return repository.findAll();
	}

}
