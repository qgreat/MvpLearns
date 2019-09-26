package com.memory.collect.mvp.ui.adaptor.convert;

import android.databinding.ViewDataBinding;

import com.chad.library.adapter.base.BaseViewHolder;
import com.memory.collect.BR;
import com.memory.collect.app.AdapterConstant;
import com.memory.collect.mvp.model.entity.diycode.DiySite;
import com.memory.collect.mvp.model.entity.diycode.DiySiteList;
import com.yeyue.library.data.BaseItem;

/**
  *@describe 通用视图
  *@author li.xiao
  *@time 2017-9-25 16:27
  */
public class CommonAdapterConvert {
    public static void convert(BaseViewHolder helper, BaseItem data, ViewDataBinding binding) {
        switch (helper.getItemViewType()) {

            case AdapterConstant.ITEM_DIY_SITE_LIST:
                if (data != null && data instanceof DiySiteList) {
                    DiySiteList item = (DiySiteList) data;
                    binding.setVariable(BR.sites, item);
                    //设置collect_item_diy_site_list.xml里的sites和item的关系
                    //这样做的好处是，可以少很多负值等等操作
                }
                break;
            case AdapterConstant.ITEM_DIY_SITE_DEFAULT:
                if(data!=null && data instanceof DiySite){
                    DiySite item = (DiySite) data;
                    binding.setVariable(BR.site,item);
                }
                break;
        }
    }
}
