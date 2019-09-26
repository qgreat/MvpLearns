package com.memory.collect.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.memory.collect.R;
import com.memory.collect.app.Constant;
import com.memory.collect.di.component.DaggerDiyCodeListComponent;
import com.memory.collect.di.module.DiyCodeListModule;
import com.memory.collect.mvp.contract.DiyCodeListContract;
import com.memory.collect.mvp.model.entity.diycode.DiySite;
import com.memory.collect.mvp.presenter.DiyCodeListPresenter;
import com.memory.collect.mvp.ui.adaptor.CommonListAdapter;
import com.yeyue.library.base.YeRecyFragment;
import com.yeyue.library.data.BaseItem;

import java.util.ArrayList;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
public class DiyCodeListFragment extends YeRecyFragment<BaseItem, DiyCodeListPresenter> implements DiyCodeListContract.View<BaseItem> {

	private int type;
	private String extend;

	public static DiyCodeListFragment newInstance() {
		DiyCodeListFragment fragment = new DiyCodeListFragment();
		return fragment;
	}
	public static DiyCodeListFragment newInstance(int type) {
		DiyCodeListFragment fragment = new DiyCodeListFragment();
		fragment.type = type;
		return fragment;
	}
	public static DiyCodeListFragment newInstance(int type, String extend) {
		DiyCodeListFragment fragment = new DiyCodeListFragment();
		fragment.type = type;
		fragment.extend = extend;
		return fragment;
	}

	@Override
	public void setupFragmentComponent(@NonNull AppComponent appComponent) {
		DaggerDiyCodeListComponent //如找不到该类,请编译一下项目
				.builder()
				.appComponent(appComponent)
				.diyCodeListModule(new DiyCodeListModule(this))
				.build()
				.inject(this);
	}


	@Override
	public void initData(@Nullable Bundle savedInstanceState) {
		getData(true);
	}

	@Override
	protected void initData() {

	}

	public void getData(boolean pullToRefresh){
		switch (type){
			case Constant.DIYCODE_TOPIC_LIST:
				mPresenter.getTopicsList(null,null,pullToRefresh);
				break;
			case Constant.DIYCODE_TOPIC_NODE:
				Integer node_id = null;
				try{
					node_id = Integer.valueOf(extend);
				}catch (Exception e){
				}
				mPresenter.getTopicsList(null,node_id,pullToRefresh);
				break;
			case Constant.DIYCODE_NEW_LIST:
				Integer new_node_id = null;
				try{
					new_node_id = Integer.valueOf(extend);
				}catch (Exception e){
				}
				mPresenter.getNewsList(new_node_id,pullToRefresh);
				break;
			case Constant.DIYCODE_SITE_LIST:
				mPresenter.getSites(pullToRefresh);
				break;
			case Constant.DIYCODE_USER_MINE:
				mPresenter.getUserCreateTopicList(extend,"recent",pullToRefresh);
				break;
			case Constant.DIYCODE_USER_COLLECT:
				mPresenter.getUserCollectionTopicList(extend,pullToRefresh);
				break;
			case Constant.DIYCODE_USER_COMMENT:
				mPresenter.getUserReplyTopicList(extend,"recent",pullToRefresh);
				break;
			case Constant.DIYCODE_USER_FANS:
				mPresenter.getUserFollowingList(extend,pullToRefresh);
				break;
			case Constant.DIYCODE_USER_FOLLOW:
				mPresenter.getUserFollowerList(extend,pullToRefresh);
				break;
		}
	}
	/**
	 * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
	 * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
	 * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
	 * <p>
	 * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时 {@link Fragment#onCreate(Bundle)} 还没执行
	 * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在 {@link Fragment#onCreate(Bundle)} 方法中执行的
	 * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在 {@link #initData(Bundle)} 中初始化就可以了
	 * <p>
	 * Example usage:
	 * <pre>
	 * public void setData(@Nullable Object data) {
	 *     if (data != null && data instanceof Message) {
	 *         switch (((Message) data).what) {
	 *             case 0:
	 *                 loadData(((Message) data).arg1);
	 *                 break;
	 *             case 1:
	 *                 refreshUI();
	 *                 break;
	 *             default:
	 *                 //do something
	 *                 break;
	 *         }
	 *     }
	 * }
	 *
	 * // call setData(Object):
	 * Message data = new Message();
	 * data.what = 0;
	 * data.arg1 = 1;
	 * fragment.setData(data);
	 * </pre>
	 *
	 * @param data 当不需要参数时 {@code data} 可以为 {@code null}
	 */
	@Override
	public void setData(@Nullable Object data) {

	}


	@Override
	public void showMessage(@NonNull String message) {
		checkNotNull(message);
		ArmsUtils.snackbarText(message);
	}

	@Override
	public void launchActivity(@NonNull Intent intent) {
		checkNotNull(intent);
		ArmsUtils.startActivity(intent);
	}

	@Override
	public void killMyself() {

	}

	@Override
	public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

	}

	@Override
	public void onDataRefresh() {
		getData(true);
	}

	@Override
	public void onDataLoadMore() {
		getData(false);
	}

	@Override
	public boolean enableRefresh() {
		boolean isRefresh = true;
		switch (type){
			case Constant.DIYCODE_USER_COLLECT:
			case Constant.DIYCODE_USER_COMMENT:
			case Constant.DIYCODE_USER_FANS:
			case Constant.DIYCODE_USER_FOLLOW:
			case Constant.DIYCODE_USER_MINE:
			case Constant.DIYCODE_SITE_LIST:
				isRefresh = false;
				break;
		}
		return isRefresh;
	}

	@Override
	public boolean enableMore() {
		boolean isMore = true;
		switch (type){
			case Constant.DIYCODE_SITE_LIST:
				isMore = false;
				break;
		}
		return isMore;
	}

	@Override
	public BaseQuickAdapter<BaseItem, BaseViewHolder> getAdapter() {
		{
			BaseQuickAdapter adapter = new CommonListAdapter(new ArrayList());
			if(type==Constant.DIYCODE_SITE_LIST){
				adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
					@Override
					public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
						int spanSize = 2;
						if(mPresenter.getmDatas()!=null && mPresenter.getmDatas().size()>0 && mPresenter.getmDatas().size()>position){
							BaseItem item = mPresenter.getmDatas().get(position);
							if(item instanceof DiySite){
								spanSize = 1;
							}
						}
						return spanSize;
					}
				});
			}
			return adapter;
		}
	}

	@Override
	public RecyclerView.LayoutManager getLayoutManager(){
		int count = 1;
		switch (type){
			case Constant.DIYCODE_SITE_LIST:
				count = 2;
				break;
		}
		GridLayoutManager manager = new GridLayoutManager(getActivity(),count);
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		return manager;
	}

	@Override
	public boolean isToolbar() {
		return false;
	}
}
