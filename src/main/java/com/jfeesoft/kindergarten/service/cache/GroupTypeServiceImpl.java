package com.jfeesoft.kindergarten.service.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.jfeesoft.kindergarten.model.GroupType;
import com.jfeesoft.kindergarten.repository.GroupTypeRepository;
import com.jfeesoft.kindergarten.service.GroupTypeService;

@Service
@Transactional
public class GroupTypeServiceImpl implements GroupTypeService {

	private LoadingCache<Integer, GroupType> cacheGroupType = null;

	@Autowired
	private GroupTypeRepository groupTypeRepository;

	@Override
	@PostConstruct
	public void load() {
		cacheGroupType = CacheBuilder.newBuilder().maximumSize(10).expireAfterAccess(24, TimeUnit.HOURS)
				.build(new CacheLoader<Integer, GroupType>() {
					@Override
					public GroupType load(Integer arg0) throws Exception {
						return groupTypeRepository.findOne(arg0);
					}

				});
	}

}
