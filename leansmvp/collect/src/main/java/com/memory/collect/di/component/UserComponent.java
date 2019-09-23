package com.memory.collect.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.memory.collect.di.module.UserModule;
import com.memory.collect.mvp.contract.UserContract;

import com.jess.arms.di.scope.ActivityScope;
import com.memory.collect.mvp.ui.activity.UserActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/17/2019 14:30
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {
	void inject(UserActivity activity);

	@Component.Builder
	interface Builder {
		@BindsInstance
		UserComponent.Builder view(UserContract.View view);

		UserComponent.Builder appComponent(AppComponent appComponent);

		UserComponent build();
	}
}