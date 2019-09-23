package com.memory.test.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.memory.test.mvp.contract.TestContract;
import com.memory.test.mvp.model.TestModel;


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
@Module
public abstract class TestModule {

	@Binds
	abstract TestContract.Model bindTestModel(TestModel model);
}