package com.memory.collect.mvp.model.api.cache;

import com.memory.collect.mvp.model.entity.diycode.DiyTopContent;
import com.yeyue.library.data.BannerList;
import com.yeyue.library.data.BaseItem;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

/**
 * Created by jess on 8/30/16 13:53
 * Contact with jess.yan.effort@gmail.com
 */
public interface CommonCache {





    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
	Observable<List<BaseItem>> getListDataCache(Observable<List<BaseItem>> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);





    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
	Observable<BannerList> getBannerList(Observable<BannerList> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);

    @LifeCache(duration = 2, timeUnit = TimeUnit.HOURS)
	Observable<DiyTopContent> getDiyTopContent(Observable<DiyTopContent> users, DynamicKey idLastUserQueried, EvictProvider evictProvider);




}
