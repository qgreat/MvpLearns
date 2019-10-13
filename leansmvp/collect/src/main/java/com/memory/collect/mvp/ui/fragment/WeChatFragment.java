package com.memory.collect.mvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.memory.collect.R;
import com.memory.collect.app.Constant;
import com.yeyue.library.base.YeBottomBarFragment;

public class WeChatFragment extends YeBottomBarFragment {

    @Override
    public Fragment getFragment(int tag) {
        Fragment fragment = null;
        switch (tag) {
            case R.id.wechat_newlist:
                fragment = WeChatListFragment.newInstance(Constant.WECHAT_NEW_LIST,"keji");
                break;
            case R.id.wechat_tag:
                fragment = WeChatPageFragment.newInstance(Constant.WECHAT_NEW_TAG);
                break;
        }
        return fragment;
    }

    @Override
    public int inflateMenu() {
        return R.menu.wechat_bottombars;
    }

    @Override
    public int defaultItem() {
        return R.id.wechat_tag;
    }


    @Override
    public void initData() {
    }


    @Override
    public void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void initView(View mRootView) {

    }

    @Override
    public void onInitView() {

    }

    @Override
    public boolean isToolbar() {
        return false;
    }

    @Override
    public void killMyself() {

    }
}