package com.memory.citedown.di.module;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;

import com.memory.citedown.mvp.contract.MainContract;
import com.memory.citedown.mvp.model.MainModel;
import com.memory.citedown.mvp.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;


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
@Module
public abstract class MainModule {

	@Binds
	abstract MainContract.Model bindMainModel(MainModel model);


	@ActivityScope
	@Provides
	static RecyclerView.LayoutManager provideLayoutManager(MainContract.View view) {
		return new LinearLayoutManager(view.getActivity());
	}

	@ActivityScope
	@Provides
	static List<String> provideList() {
		return new ArrayList<>();
	}

	@ActivityScope
	@Provides
	static RecyclerView.Adapter provideZhihuHomeAdapter(MainContract.View zhihuHomeView, List<String> list){
		MainAdapter adapter = new MainAdapter(list);
		return adapter;
	}

}