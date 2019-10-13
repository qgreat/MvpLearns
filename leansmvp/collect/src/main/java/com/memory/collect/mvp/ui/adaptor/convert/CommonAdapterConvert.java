package com.memory.collect.mvp.ui.adaptor.convert;

import android.databinding.ViewDataBinding;
import android.text.Html;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.memory.collect.BR;
import com.memory.collect.R;
import com.memory.collect.app.AdapterConstant;
import com.memory.collect.mvp.model.entity.diycode.DiyNew;
import com.memory.collect.mvp.model.entity.diycode.DiySite;
import com.memory.collect.mvp.model.entity.diycode.DiySiteList;
import com.memory.collect.mvp.model.entity.diycode.DiyTopic;
import com.memory.collect.mvp.model.entity.diycode.DiyTopicReply;
import com.memory.collect.mvp.model.entity.diycode.DiyUser;
import com.memory.collect.mvp.model.entity.wechat.WeChat;
import com.memory.collect.mvp.model.entity.wechat.WeChatTag;
import com.memory.collect.utils.HtmlUtil;
import com.yeyue.library.data.BaseItem;

public class CommonAdapterConvert {
    public static void convert(BaseViewHolder helper, BaseItem data, ViewDataBinding binding) {
        switch (helper.getItemViewType()) {

            case AdapterConstant.ITEM_DIY_SITE_DEFAULT:
                if(data!=null && data instanceof DiySite){
                    DiySite item = (DiySite) data;
                    binding.setVariable(BR.site,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_TOPIC_DEFAULT:
                if(data!=null && data instanceof DiyTopic){
                    DiyTopic item = (DiyTopic) data;
                    binding.setVariable(BR.topic,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_TOPIC_REPLAY:
                if(data!=null && data instanceof DiyTopicReply){
                    DiyTopicReply item = (DiyTopicReply) data;
                    TextView content = helper.getView(R.id.tvContent);
                    binding.setVariable(BR.replay,item);
                    // TODO 评论区代码问题
                    content.setText(Html.fromHtml(HtmlUtil.removeP(item.getBody_html()), null, null));
                }
                break;
            case AdapterConstant.ITEM_DIY_NEW_DEFAULT:
                if(data!=null && data instanceof DiyNew){
                    DiyNew item = (DiyNew) data;
                    binding.setVariable(BR.news,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_SITE_LIST:
                if(data!=null && data instanceof DiySiteList){
                    DiySiteList item = (DiySiteList) data;
                    binding.setVariable(BR.sites,item);
                }
                break;
            case AdapterConstant.ITEM_DIY_USER_DEFAULT:
                if(data!=null && data instanceof DiyUser){
                    DiyUser item = (DiyUser) data;
                    binding.setVariable(BR.user,item);
                }
                break;
            case AdapterConstant.ITEM_WECHAT_DEFAULT:
                if(data!=null && data instanceof WeChat){
                    WeChat item = (WeChat) data;
                    binding.setVariable(BR.wechat,item);
                }
                break;
            case AdapterConstant.ITEM_WECHAT_NEW_TAG:
                if(data!=null && data instanceof WeChatTag){
                    WeChatTag item = (WeChatTag) data;
                    binding.setVariable(BR.wechattag,item);
                }
                break;
        }
    }
}
