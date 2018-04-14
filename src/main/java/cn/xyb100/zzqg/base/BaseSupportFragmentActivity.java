package cn.xyb100.zzqg.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.xyb100.zzqg.R;
import cn.xyb100.zzqg.fragmentation.SupportFragment;
import cn.xyb100.zzqg.fragmentation.anim.FragmentAnimator;

/**
 * 支持fragment的activity基类
 * Created by caoxuefeng on 2017/11/16.
 */

public abstract class BaseSupportFragmentActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null && null != setFragment()) {
            loadRootFragment(R.id.fl_container, setFragment());
        }
    }

    public abstract SupportFragment setFragment();

    @Override
    public int getContentViewResId() {
        return R.layout.ac_base;
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置默认Fragment动画  默认竖向(和安卓5.0以上的动画相同)
        return super.onCreateFragmentAnimator();
        // 设置横向(和安卓4.x动画相同)
//        return new DefaultHorizontalAnimator();
        // 设置自定义动画
//        return new FragmentAnimator(enter,exit,popEnter,popExit);
    }
}
