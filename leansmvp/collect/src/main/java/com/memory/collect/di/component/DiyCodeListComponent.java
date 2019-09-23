package com.memory.collect.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.memory.collect.di.module.DiyCodeListModule;
import com.memory.collect.mvp.contract.DiyCodeListContract;

import com.jess.arms.di.scope.FragmentScope;
import com.memory.collect.mvp.ui.fragment.DiyCodeListFragment;


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
@FragmentScope
@Component(modules = DiyCodeListModule.class, dependencies = AppComponent.class)
public interface DiyCodeListComponent {
	void inject(DiyCodeListFragment fragment);

	@Component.Builder
	interface Builder {
		@BindsInstance
		DiyCodeListComponent.Builder view(DiyCodeListContract.View view);

		DiyCodeListComponent.Builder appComponent(AppComponent appComponent);

		DiyCodeListComponent build();
	}
}