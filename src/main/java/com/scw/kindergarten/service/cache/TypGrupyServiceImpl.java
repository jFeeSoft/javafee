package com.scw.kindergarten.service.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.scw.kindergarten.model.GroupType;
import com.scw.kindergarten.repository.TypGrupyRepository;
import com.scw.kindergarten.service.TypGrupyService;

@Service
@Transactional
public class TypGrupyServiceImpl implements TypGrupyService {

	private LoadingCache<Integer, GroupType> cacheTypGrupy = null;

	@Autowired
	private TypGrupyRepository typGrupyRepository;

	@Override
	@PostConstruct
	public void load() {
		cacheTypGrupy = CacheBuilder.newBuilder().maximumSize(10).expireAfterAccess(24, TimeUnit.HOURS)
				.build(new CacheLoader<Integer, GroupType>() {
					@Override
					public GroupType load(Integer arg0) throws Exception {
						return typGrupyRepository.findOne(arg0);
					}

				});
	}

}
