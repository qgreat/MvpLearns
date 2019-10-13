package com.memory.collect.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import com.memory.collect.app.Constant;
import com.memory.collect.mvp.contract.WeChatListContract;
import com.memory.collect.mvp.model.api.cache.CommonCache;
import com.memory.collect.mvp.model.api.service.WeChatService;
import com.memory.collect.mvp.model.entity.wechat.WeChatHttpRequest;
import com.memory.collect.mvp.model.entity.wechat.WeChatTag;
import com.memory.collect.utils.WeChatUtils;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/14/2019 02:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class WeChatListModel extends BaseModel implements WeChatListContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public WeChatListModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
    @Override
    public Observable<List<BaseItem>> getWXTagList(int type) {
        List<BaseItem> baseItems = new ArrayList<>();
        List<WeChatTag> tags = WeChatUtils.getWeChatTags();
        if(type== Constant.WECHAT_LIVE_TAG){
            tags = WeChatUtils.getWeChatLifeTags("");
        }
        baseItems.addAll(tags);
        return Observable.just(baseItems);
    }

    @Override
    public Observable<List<BaseItem>> getWXNew(String type,String key, int num, int page, String word) {
        Observable<List<BaseItem>> observable = mRepositoryManager.obtainRetrofitService(WeChatService.class)
                .getWXNew(type,key,num,page,word).flatMap(new Function<WeChatHttpRequest, ObservableSource<List<BaseItem>>>() {
                    @Override
                    public ObservableSource<List<BaseItem>> apply(@NonNull WeChatHttpRequest listReply) throws Exception {
                        List<BaseItem> baseItems = new ArrayList<BaseItem>();
                        //处理分类数据
                        if(listReply!=null){
                            if(listReply.getNewslist()!=null && listReply.getNewslist().size()>0){
                                baseItems.addAll(listReply.getNewslist());
                            }
                        }
                        return Observable.just(baseItems);
                    }
                });
        return mRepositoryManager.obtainCacheService(CommonCache.class).getListDataCache(observable,new DynamicKey("getWXNew"+type+key+num+page+word),new EvictDynamicKey(false));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }
}