package com.memory.collect.mvp.contract;

import android.support.annotation.Nullable;

import com.jess.arms.mvp.IModel;
import com.yeyue.library.contract.YeBaseRecyview;
import com.yeyue.library.data.BaseItem;

import java.util.List;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/17/2019 14:46
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public interface DiyCodeListContract {
	//对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
	interface View<T> extends YeBaseRecyview<T>{
	}

	//Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
	interface Model extends IModel {
		Observable<List<BaseItem>> getTopicsList(String type, @Nullable Integer node_id, @Nullable Integer offset, @Nullable Integer limit);

		Observable<List<BaseItem>> getNewsList(@Nullable Integer node_id, @Nullable Integer offset, @Nullable Integer limit);

		Observable<List<BaseItem>> getSites();

		Observable<List<BaseItem>> getUserCreateTopicList(String login_name, String order, Integer offset, Integer limit);

		Observable<List<BaseItem>> getUserCollectionTopicList(String login_name, Integer offset, Integer limit);

		Observable<List<BaseItem>> getUserReplyTopicList(String login_name, String order, Integer offset, Integer limit);

		Observable<List<BaseItem>> getUserFollowingList(String login_name, Integer offset, Integer limit);

		Observable<List<BaseItem>> getUserFollowerList(String login_name, Integer offset, Integer limit);
	}
}
