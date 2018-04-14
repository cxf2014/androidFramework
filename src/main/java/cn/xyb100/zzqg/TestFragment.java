package cn.xyb100.zzqg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import cn.xyb100.zzqg.R;

import cn.xyb100.zzqg.base.BaseFragment;
import cn.xyb100.zzqg.bean.BaseEventBusBean;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by caoxuefeng on 2017/11/16.
 */

public class TestFragment extends BaseFragment {

    @BindView(R.id.btn_fragment)
    Button btn_fragment;
    public static TestFragment newInstance(String s) {
        Bundle args = new Bundle();
        args.putString("data",s);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void mvpCreate() {
    }

    @Override
    public boolean openEventBus() {
        return false;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        String ss = "sdfsd";
        btn_fragment.setText(ss);
    }

    @Override
    protected void EventBean(BaseEventBusBean event) {

    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarColorTransformEnable(false)
                .navigationBarColor(R.color.colorPrimary)
                .titleBar(R.id.toolbar)
                .init();
    }


    @OnClick(R.id.btn_fragment)
    public void onClick(View view){

    }
}
