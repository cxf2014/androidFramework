package cn.xyb100.zzqg;

import android.os.Bundle;

import cn.xyb100.zzqg.base.BaseSupportFragmentActivity;
import cn.xyb100.zzqg.bean.BaseEventBusBean;
import cn.xyb100.zzqg.fragmentation.SupportFragment;

/**
 * Created by caoxuefeng on 2017/11/16.
 */

public class TestFragmentActivity extends BaseSupportFragmentActivity {
    @Override
    public SupportFragment setFragment() {
        String s = "测试传递数据";
        return TestFragment.newInstance(s);
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public boolean openEventBus() {
        return false;
    }

    @Override
    public void getBundleExtras(Bundle extras) {

    }
    @Override
    protected void EventBean(BaseEventBusBean event) {

    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void showCurContent(Object obj) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
