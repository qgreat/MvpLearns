package com.memory.citedown.mvp.presenter;

import android.app.Application;
import android.support.v7.widget.RecyclerView;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.memory.citedown.mvp.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/09/2019 14:34
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
	@Inject
	RxErrorHandler mErrorHandler;
	@Inject
	Application mApplication;
	@Inject
	ImageLoader mImageLoader;
	@Inject
	AppManager mAppManager;
	@Inject
	List<String> mDatas;
	@Inject
	RecyclerView.Adapter mAdapter;

	@Inject
	public MainPresenter(MainContract.Model model, MainContract.View rootView) {
		super(model, rootView);
	}

	public void request() {
		mDatas.clear();
		List<String> list = mModel.getDatas();
		mDatas.addAll(list);
		mAdapter.notifyDataSetChanged();
		mRootView.hideLoading();//隐藏下拉刷新的进度条

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
