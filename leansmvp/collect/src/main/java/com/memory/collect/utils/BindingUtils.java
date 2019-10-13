package com.memory.collect.utils;

import android.app.Activity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.memory.collect.app.Constant;
import com.memory.collect.mvp.model.entity.diycode.DiyNew;
import com.memory.collect.mvp.model.entity.diycode.DiySite;
import com.memory.collect.mvp.model.entity.diycode.DiyTopic;
import com.memory.collect.mvp.model.entity.diycode.DiyUser;
import com.memory.collect.mvp.model.entity.wechat.WeChat;
import com.yeyue.library.base.YeWebActivity;

public class BindingUtils {
	public static void openDiySite(View view, DiySite diyNew){
		if(diyNew!=null && view!=null){
			YeWebActivity.loadUrl(view.getContext(),diyNew.getUrl(),diyNew.getName());
		}
	}
	public static void openDiyTopic(View view, DiyTopic diyTopic){
		if(diyTopic!=null && view!=null){
			ToastUtils.showShort("点击-"+diyTopic.getTitle());
//			ActivityUtils.openDiyTopDetailActivity((Activity) view.getContext(),diyTopic);
		}
	}
	public static void openDiyTopicNode(View view, DiyTopic diyTopic){
		if(diyTopic!=null && view!=null){
//			CMFragment cmFragment = new CMFragment();
//			cmFragment.setType(Constant.DIYCODE_TOPIC_NODE);
//			cmFragment.setExtend(diyTopic.getNode_id()+"");
//			cmFragment.setTitle(diyTopic.getNode_name());
//			ActivityUtils.openCommonFragmentActivity((Activity) view.getContext(),cmFragment);
		}
	}
	public static void openDiyNew(View view, DiyNew diyNew){
		if(diyNew!=null && view!=null){
			YeWebActivity.loadUrl(view.getContext(),diyNew.getAddress(),diyNew.getTitle());
		}
	}
	public static void openDiyUser(View view, DiyUser diyUser){
		if(diyUser!=null && view!=null){
			ActivityUtils.openDiyUserActivity((Activity) view.getContext(),diyUser);
		}
	}

	public static void openWeChat(View view, WeChat diyNew){
		if(diyNew!=null && view!=null){
			YeWebActivity.loadUrl(view.getContext(),diyNew.getUrl(),diyNew.getTitle());
		}
	}
}