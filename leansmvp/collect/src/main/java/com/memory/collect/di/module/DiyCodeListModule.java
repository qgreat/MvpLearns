package com.memory.collect.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.memory.collect.mvp.contract.DiyCodeListContract;
import com.memory.collect.mvp.model.DiyCodeListModel;


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
@Module
public  class DiyCodeListModule {
	private DiyCodeListContract.View view;

	/**
	 * 构建CommonListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
	 *
	 * @param view
	 */
	public DiyCodeListModule(DiyCodeListContract.View view) {
		this.view = view;
	}

	@ActivityScope
	@Provides
	DiyCodeListContract.View provideCommonListView() {
		return this.view;
	}

	@ActivityScope
	@Provides
	DiyCodeListContract.Model provideCommonListModel(DiyCodeListModel model) {
		return model;
	}
}