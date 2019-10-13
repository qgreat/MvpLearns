package com.memory.collect.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.jess.arms.di.scope.FragmentScope;
import com.memory.collect.mvp.contract.WeChatListContract;
import com.memory.collect.mvp.model.WeChatListModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 10/14/2019 02:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public  class WeChatListModule {

    private WeChatListContract.View view;

    /**
     * 构建CommonListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WeChatListModule(WeChatListContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    WeChatListContract.View provideCommonListView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    WeChatListContract.Model provideCommonListModel(WeChatListModel model) {
        return model;
    }
}