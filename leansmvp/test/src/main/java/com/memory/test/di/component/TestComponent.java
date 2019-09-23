package com.memory.test.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.memory.test.di.module.TestModule;
import com.memory.test.mvp.contract.TestContract;

import com.jess.arms.di.scope.ActivityScope;
import com.memory.test.mvp.ui.activity.TestActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/09/2019 15:06
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = TestModule.class, dependencies = AppComponent.class)
public interface TestComponent {
	void inject(TestActivity activity);

	@Component.Builder
	interface Builder {
		@BindsInstance
		TestComponent.Builder view(TestContract.View view);

		TestComponent.Builder appComponent(AppComponent appComponent);

		TestComponent build();
	}
}