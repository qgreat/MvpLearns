package com.memory.collect.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jess.arms.di.component.AppComponent;
import com.memory.collect.app.Constant;
import com.memory.collect.mvp.model.entity.wechat.WeChatTag;
import com.memory.collect.mvp.ui.fragment.WeChatTagFragment;
import com.memory.collect.utils.WeChatUtils;
import com.yeyue.library.base.YeFragmentActivity;

import org.simple.eventbus.EventBus;

import java.util.List;


public class WeChatTagActivity extends YeFragmentActivity {

    private List<WeChatTag> tags;
    private int type = Constant.WECHAT_NEW_TAG;
    @Override
    public Fragment getFragment() {
        Fragment fragment = null;
        if(type==Constant.WECHAT_NEW_TAG){
            fragment = WeChatTagFragment.newInstance(Constant.WECHAT_NEW_TAG);
        }else{
            fragment = WeChatTagFragment.newInstance(Constant.WECHAT_LIVE_TAG);
        }
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {
        if(getIntent()!=null && getIntent().hasExtra(Constant.WECHAT_TAG_TYPE)){
            type = getIntent().getIntExtra(Constant.WECHAT_TAG_TYPE,Constant.WECHAT_NEW_TAG);
        }
        super.initData(bundle);
        setTitle("分类");
        if(type==Constant.WECHAT_NEW_TAG){
            tags = WeChatUtils.getSelectWeChatTags();
        }else{
            tags = WeChatUtils.getSelectWeChatLifeTags("");
        }
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public boolean isToolbar() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //判断是否修改了选中
        boolean isChange = false;
        List<WeChatTag> select = WeChatUtils.getSelectWeChatTags();
        if(tags!=null && select!=null){
            if(tags.size()!=select.size()){
                isChange = true;
            }else{
                for (int i=0;i<tags.size();i++){
                    if(!select.contains(tags.get(i))){
                        isChange = true;
                        break;
                    }
                }
            }
        }
        if(isChange){
            //有更新，通知刷新
            EventBus.getDefault().post(new WeChatTag());
        }
    }
}
