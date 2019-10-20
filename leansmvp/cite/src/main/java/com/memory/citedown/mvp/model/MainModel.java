package com.memory.citedown.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.memory.citedown.mvp.contract.MainContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/09/2019 14:34
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {
	@Inject
	Gson mGson;
	@Inject
	Application mApplication;

	@Inject
	public MainModel(IRepositoryManager repositoryManager) {
		super(repositoryManager);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.mGson = null;
		this.mApplication = null;
	}

	@Override
	public List<String> getDatas() {
//		1． 第一个记忆周期：5分钟
//		2． 第二个记忆周期：30分钟
//		3． 第三个记忆周期：12小时
//		4． 第四个记忆周期：1天
//		5． 第五个记忆周期：2天
//		6． 第六个记忆周期：4天
//		7． 第七个记忆周期：7天
//		8． 第八个记忆周期：15天
		int a1 = 24 * 60 * 60;
		int a2 = 2 * 24 * 60 * 60;
		int a4 = 4 * 24 * 60 * 60;
		int a7 = 7 * 24 * 60 * 60;
		int a15 = 15 * 24 * 60 * 60;
		int a24 = 26 * 24 * 60 * 60;
		int a40 = 26 * 24 * 60 * 60;
		List<Integer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a4);
		list.add(a7);
		list.add(a15);
		list.add(a24);
		list.add(a40);
		List<String> dataList = new ArrayList<>();
		dataList.add("科学记忆法");
		for (int i = 0; i < list.size(); i++) {
			long timeMillis = getDateTimeInMillis12() - list.get(i);
			Date date = new Date(timeMillis * 1000L);
			dataList.add(date.toString());
		}
		return dataList;
	}

	/**
	 * 获取今天12:00的时间单位秒
	 */
	public long getDateTimeInMillis12() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		long dateTimeInMillis = calendar.getTimeInMillis() / 1000;

		return dateTimeInMillis;
	}
}