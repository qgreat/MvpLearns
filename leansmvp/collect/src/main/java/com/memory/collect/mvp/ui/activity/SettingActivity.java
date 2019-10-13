package com.memory.collect.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.memory.collect.mvp.ui.fragment.SettingFragment;
import com.yeyue.library.base.YeFragmentActivity;

public class SettingActivity extends YeFragmentActivity {
    @Override
    public Fragment getFragment() {
        return new SettingFragment();
    }

    @Override
    public void initData(Bundle bundle) {
        super.initData(bundle);
        setTitle("设置");
    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }
}
