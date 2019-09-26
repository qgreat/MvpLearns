package com.memory.collect.utils;

import android.view.View;

import com.memory.collect.mvp.model.entity.diycode.DiySite;
import com.yeyue.library.base.YeWebActivity;

public class BindingUtils {
	public static void openDiySite(View view, DiySite diyNew){
		if(diyNew!=null && view!=null){
			YeWebActivity.loadUrl(view.getContext(),diyNew.getUrl(),diyNew.getName());
		}
	}
}