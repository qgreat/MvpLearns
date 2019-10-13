package com.memory.collect.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.memory.collect.di.module.WeChatListModule;

import com.jess.arms.di.scope.FragmentScope;
import com.memory.collect.mvp.ui.fragment.WeChatListFragment;


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
@FragmentScope
@Component(modules = WeChatListModule.class, dependencies = AppComponent.class)
public interface WeChatListComponent {
    void inject(WeChatListFragment fragment);

}