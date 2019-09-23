package com.memory.citedown.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.memory.citedown.R;
import com.memory.citedown.R2;
import com.memory.citedown.di.component.DaggerMainComponent;
import com.memory.citedown.mvp.contract.MainContract;
import com.memory.citedown.mvp.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;
import timber.log.Timber;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
 * @author Administrator
 */
@Route(path = RouterHub.CITE_HOMEACTIVITY_CITE)
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

	@BindView(R2.id.recyclerView)
	RecyclerView mRecyclerView;
	@BindView(R2.id.swipeRefreshLayout)
	SwipeRefreshLayout mSwipeRefreshLayout;
	@Inject
	RecyclerView.LayoutManager mLayoutManager;
	@Inject
	RecyclerView.Adapter mAdapter;

	@Override
	public void setupActivityComponent(@NonNull AppComponent appComponent) {
		DaggerMainComponent //如找不到该类,请编译一下项目
				.builder()
				.appComponent(appComponent)
				.view(this)
				.build()
				.inject(this);
	}

	@Override
	public int initView(@Nullable Bundle savedInstanceState) {
		return R.layout.cite_activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
	}

	@Override
	public void initData(@Nullable Bundle savedInstanceState) {
		initRecyclerView();
		mRecyclerView.setAdapter(mAdapter);
		showLoading();
		onRefresh();
	}


	private void initRecyclerView() {
		mSwipeRefreshLayout.setOnRefreshListener(this);
		ArmsUtils.configRecyclerView(mRecyclerView, mLayoutManager);
	}

	@Override
	public void showLoading() {
		Timber.tag(TAG).w("showLoading");
		mSwipeRefreshLayout.setRefreshing(true);
	}

	@Override
	public void hideLoading() {
		Timber.tag(TAG).w("hideLoading");
		mSwipeRefreshLayout.setRefreshing(false);
	}

	@Override
	public void showMessage(@NonNull String message) {
		checkNotNull(message);
		ArmsUtils.snackbarText(message);
	}

	@Override
	public void launchActivity(@NonNull Intent intent) {
		checkNotNull(intent);
		ArmsUtils.startActivity(intent);
	}

	@Override
	public void killMyself() {
		finish();
	}


	@Override
	public Activity getActivity() {
		return MainActivity.this;
	}

	@Override
	public void onRefresh() {
		mPresenter.request();
	}
}
