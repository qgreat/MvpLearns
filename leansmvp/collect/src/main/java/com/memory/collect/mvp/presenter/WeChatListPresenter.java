package com.memory.collect.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.memory.collect.app.Constant;
import com.memory.collect.mvp.contract.WeChatListContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;


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
public class WeChatListPresenter extends YeListIPresenter<WeChatListContract.Model, WeChatListContract.View> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private List<BaseItem> mDatas;
    private int page;
    @Inject
    public WeChatListPresenter(WeChatListContract.Model model, WeChatListContract.View rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
        mDatas = new ArrayList<>();
        pregPage = 10;
    }

    public void getWXNew(String type,String word,boolean pullToRefresh) {
        if(pullToRefresh){
            page = 1;
        }else{
            page++;
        }
        getDataList(mModel.getWXNew(type, Constant.WECHAT_KEY,pregPage,page,word), mDatas, mRootView, mErrorHandler, pullToRefresh);
    }
    public void getWXTagList(int type) {
        getDataList(mModel.getWXTagList(type), mDatas, mRootView, mErrorHandler, true);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
