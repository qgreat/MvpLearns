/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.memory.citedown.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;
import com.memory.citedown.R;
import com.memory.citedown.mvp.ui.holder.MainItemHolder;

import java.util.List;

/**
 * ================================================
 * 展示 {@link DefaultAdapter} 的用法
 * <p>
 * Created by JessYan on 09/04/2016 12:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class MainAdapter extends DefaultAdapter<String>{
    public MainAdapter(List<String> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<String> getHolder(View v, int viewType) {
        return new MainItemHolder(v);
    }
//R2用在注解上
    @Override
    public int getLayoutId(int viewType) {
        return R.layout.cite_recycle_lis_item;
    }
}
