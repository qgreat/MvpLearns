package com.memory.collect.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IPresenter;
import com.memory.collect.R;
import com.memory.collect.mvp.ui.fragment.DiycodeFragment;
import com.yeyue.library.base.YeDrawerFragmentActivity;
import com.yeyue.library.base.YeWebActivity;

/**
 * Created by yachaoqi
 * on 2019/9/17.
 */
public class MainActivity extends YeDrawerFragmentActivity<IPresenter> {
	@Override
	public Fragment getFragment(int tag) {
		switch (tag) {
			case R.id.nav_diycode:
				return new DiycodeFragment();
			case R.id.nav_header_layout:
				return new DiycodeFragment();
		}
		return null;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		super.initData(savedInstanceState);
		setTitle("COLLECT");
		View headerView = mNavView.getHeaderView(0);
		headerView.setOnClickListener(v -> {
					mDrawerLayout.closeDrawer(GravityCompat.START);
			YeWebActivity.loadUrl(MainActivity.this, "https://github.com/yeyueduxing", "Collect");
				}
		);
		mToolbar.setNavigationIcon(R.drawable.icon_nav_titlebar_menu);
		mToolbar.setNavigationOnClickListener(v -> {
			mDrawerLayout.openDrawer(GravityCompat.START);
		});
	}

	@Override
	public boolean onNavItemSelected(MenuItem item) {
		boolean isSelect = true;
		switch (item.getItemId()) {
			case R.id.nav_skin: {
				isSelect = false;
			}
			case R.id.nav_setting: {
				isSelect = false;
			}
			default:{
				goFragment(item.getItemId());
			}
		}
		return isSelect;
	}

	@Override
	public int initDefaultTag() {
		return R.id.nav_bizhi;
	}

	@Override
	public boolean isToolbar() {
		return true;
	}

	@Override
	public boolean isSlide() {
		return false;
	}

	@Override
	public void intToolBar() {

	}

	@Override
	public int getNavHeaderViewId() {
		return R.layout.collect_activity_main_nav_header;
	}

	@Override
	public int getNavMenuId() {
		return R.menu.activity_main_drawer;
	}

	@Override
	public void setupActivityComponent(@NonNull AppComponent appComponent) {

	}
}
