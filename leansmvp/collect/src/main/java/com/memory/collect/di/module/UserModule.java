package com.memory.collect.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.memory.collect.mvp.contract.UserContract;
import com.memory.collect.mvp.model.UserModel;


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
@Module
public abstract class UserModule {

	@Binds
	abstract UserContract.Model bindUserModel(UserModel model);
}