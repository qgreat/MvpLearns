package com.memory.collect.mvp.presenter;

import android.app.Application;
import android.support.annotation.Nullable;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import com.memory.collect.mvp.contract.DiyCodeListContract;
import com.yeyue.library.data.BaseItem;
import com.yeyue.library.presenter.YeListIPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/17/2019 14:46
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class DiyCodeListPresenter extends YeListIPresenter<DiyCodeListContract.Model, DiyCodeListContract.View> {
	@Inject
	RxErrorHandler mErrorHandler;
	@Inject
	Application mApplication;
	@Inject
	ImageLoader mImageLoader;
	@Inject
	AppManager mAppManager;
	private int page;
	private List<BaseItem> mDatas;

	@Inject
	public DiyCodeListPresenter(DiyCodeListContract.Model model, DiyCodeListContract.View rootView) {
		super(model, rootView);
		mDatas = new ArrayList<>();
		pregPage = 10;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.mErrorHandler = null;
		this.mAppManager = null;
		this.mImageLoader = null;
		this.mApplication = null;
	}

	public void getTopicsList(String type, @Nullable Integer node_id, boolean pullToRefresh) {
		if(pullToRefresh){
			page = 1;
		}else{
			page++;
		}
		Integer offset = (page-1)*pregPage;
		getDataList(mModel.getTopicsList(type,node_id,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
	}

	public void getNewsList(Integer node_id, boolean pullToRefresh) {
		if(pullToRefresh){
			page = 1;
		}else{
			page++;
		}
		Integer offset = (page-1)*pregPage;
		getDataList(mModel.getNewsList(node_id,offset,pregPage), mDatas, mRootView, mErrorHandler, pullToRefresh);
	}

	public void getSites(boolean pullToRefresh) {
		getDataList(mModel.getSites(), mDatas, mRootView, mErrorHandler, pullToRefresh);
	}

	public void getUserCreateTopicList(String extend, String recent, boolean pullToRefresh) {
	}

	public void getUserCollectionTopicList(String extend, boolean pullToRefresh) {
	}

	public void getUserReplyTopicList(String extend, String recent, boolean pullToRefresh) {
	}

	public void getUserFollowingList(String extend, boolean pullToRefresh) {
	}

	public void getUserFollowerList(String extend, boolean pullToRefresh) {
	}

	public  List<BaseItem>  getmDatas() {
		return mDatas;
	}
}
