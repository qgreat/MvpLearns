package com.memory.collect.mvp.ui.adaptor;

/**
 * Created by li.xiao on 2017-9-25.
 */


import com.memory.collect.R;
import com.memory.collect.app.AdapterConstant;

import java.util.HashMap;
import java.util.Map;

/**
  *@describe Adapter映射关系，
  *@author li.xiao
  *@time 2017-9-25 16:17
  */
public class AdapterShine{
    public static Map<Integer, Integer> fetchAdapterMap(){
        Map<Integer, Integer> maps = new HashMap<>();
        /*DiyCode*/
        maps.put(AdapterConstant.ITEM_DIY_TOPIC_DEFAULT, R.layout.item_diy_topic_default);
        maps.put(AdapterConstant.ITEM_DIY_TOPIC_REPLAY, R.layout.item_diy_topic_replay);
        maps.put(AdapterConstant.ITEM_DIY_NEW_DEFAULT, R.layout.item_diy_new_default);
        maps.put(AdapterConstant.ITEM_DIY_USER_DEFAULT, R.layout.item_diy_user_default);
        maps.put(AdapterConstant.ITEM_DIY_SITE_DEFAULT, R.layout.item_diy_site_default);
        maps.put(AdapterConstant.ITEM_DIY_SITE_LIST, R.layout.collect_item_diy_site_list);
        /*WeChat*/
        maps.put(AdapterConstant.ITEM_WECHAT_DEFAULT, R.layout.item_wechat_default);
        maps.put(AdapterConstant.ITEM_WECHAT_NEW_TAG, R.layout.item_wechat_new_tag);
        return maps;
    }
}
