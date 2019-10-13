package com.memory.collect.utils;

import android.app.Activity;
import android.content.Intent;

import com.memory.collect.app.Constant;
import com.memory.collect.mvp.model.entity.diycode.DiyTopic;
import com.memory.collect.mvp.model.entity.diycode.DiyUser;
import com.memory.collect.mvp.ui.activity.SettingActivity;
import com.memory.collect.mvp.ui.activity.WeChatTagActivity;
import com.yeyue.library.activity.YeLoadIndicatorActivty;


public class ActivityUtils {
//    public static void openCommonFragmentActivity(Activity activity, CMFragment cmFragment){
//        Intent intent = new Intent(activity, CommonFragmentActivity.class);
//        intent.putExtra(Constant.COMMON_SHOW_FRAGMENT,cmFragment);
//        activity.startActivity(intent);
//    }

    public static void openDiyTopDetailActivity(Activity activity, DiyTopic diyTopic){
//        Intent intent = new Intent(activity, DiyTopDetailActivity.class);
//        intent.putExtra(Constant.DIYTOP_DETAIL,diyTopic);
//        activity.startActivity(intent);
    }



    public static void openSettingActivity(Activity activity){
        Intent intent = new Intent(activity, SettingActivity.class);
        activity.startActivity(intent);
    }
    public static void openLoadTypeActivty(Activity activity){
        Intent intent = new Intent(activity, YeLoadIndicatorActivty.class);
        activity.startActivity(intent);
    }

    public static void openDiyUserActivity(Activity activity, DiyUser diyUser){
//        Intent intent = new Intent(activity, DiyUserActivity.class);
//        intent.putExtra(Constant.DIY_USER_INFO,diyUser);
//        activity.startActivity(intent);
    }

    public static void openWeChataTagActivity(Activity activity, int type){
        Intent intent = new Intent(activity, WeChatTagActivity.class);
        intent.putExtra(Constant.WECHAT_TAG_TYPE,type);
        activity.startActivity(intent);
    }
//
//    public static void openMovieDetailActivity(Activity activity, MovieBean movieBean){
//        Intent intent = new Intent(activity, MovieDetailActivity.class);
//        intent.putExtra(Constant.MOVIE_INFO,movieBean);
//        activity.startActivity(intent);
//    }
//
//    public static void openMovieCelebrityActivity(Activity activity, MoviePerson person){
//        Intent intent = new Intent(activity, MovieCelebrityActivity.class);
//        intent.putExtra(Constant.MOVIE_PERSON,person);
//        activity.startActivity(intent);
//    }
//
//    public static void openMovieFragmentActivity(Activity activity, int type, String extend){
//        Intent intent = new Intent(activity, MovieFragmentActivity.class);
//        intent.putExtra(Constant.MOVIE_SUBJECT_ID,extend);
//        intent.putExtra(Constant.MOVIE_SUBJECT_TYPE,type);
//        activity.startActivity(intent);
//    }
//
//    public static void openMovieSearchActivity(Activity activity, int type){
//        Intent intent = new Intent(activity, MovieSearchActivity.class);
//        intent.putExtra(Constant.SEARCH_TYPE,type);
//        activity.startActivity(intent);
//    }
//
//    public static void openDetailActivity(Activity activity, DetailBean detailBean){
//        Intent intent = new Intent(activity, BizhiDetailActivity.class);
//        intent.putExtra(Constant.DETAIL_INFO,detailBean);
//        activity.startActivity(intent);
//    }
//
//    public static void openAlbumDetailActivity(Activity activity, BizhiAlbumBean albumBean){
//        Intent intent = new Intent(activity, BizhiAlbumDetailActivity.class);
//        intent.putExtra(Constant.ALBUM_INFO,albumBean);
//        activity.startActivity(intent);
//    }
//
//    public static void openDayRecommendActivity(Activity activity){
//        Intent intent = new Intent(activity, BizhiDayRecommendActivity.class);
//        activity.startActivity(intent);
//    }
//    public static void openCategoryActivity(Activity activity, int type){
//        Intent intent = new Intent(activity, BizhiCategoryActivity.class);
//        intent.putExtra(Constant.BIZHI_PAGE_TYPE,type);
//        activity.startActivity(intent);
//    }
//    public static void openCategoryActivity(Activity activity, WalCategory.CategoryBean categoryBean){
//        Intent intent = new Intent(activity, BizhiCategoryActivity.class);
//        intent.putExtra(Constant.CATEGORY_ID,categoryBean);
//        activity.startActivity(intent);
//    }
//    public static void openCategoryActivity(Activity activity, VerCategory categoryBean){
//        Intent intent = new Intent(activity, BizhiCategoryActivity.class);
//        intent.putExtra(Constant.VERTICAL_CATEGORY_ID,categoryBean);
//        activity.startActivity(intent);
//    }
//    public static void openCategoryActivity(Activity activity, VideoCategory videoCategory){
//        Intent intent = new Intent(activity, BizhiCategoryActivity.class);
//        intent.putExtra(Constant.VIDEO_CATEGORY_ID,videoCategory);
//        activity.startActivity(intent);
//    }
//    public static void openUserActivity(Activity activity, UserBean userBean){
//        Intent intent = new Intent(activity, BizhiUserActivity.class);
//        intent.putExtra(Constant.USER_INFO,userBean);
//        activity.startActivity(intent);
//    }
//
//    public static void openVideoDetailActivity(Activity activity, VideoBean videoBean){
//        Intent intent = new Intent(activity, BizhiVideoDetailActivity.class);
//        intent.putExtra(Constant.VIDEO_DETAIL_INFO,videoBean);
//        activity.startActivity(intent);
//    }
}
