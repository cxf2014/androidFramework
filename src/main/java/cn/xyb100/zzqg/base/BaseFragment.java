package cn.xyb100.zzqg.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

import cn.xyb100.zzqg.bean.BaseEventBusBean;
import cn.xyb100.zzqg.fragmentation.SupportFragment;

/**
 * Created by caoxuefeng on 2017/11/16.
 */

public abstract class BaseFragment extends SupportFragment {

    protected View mRootView;

    /**
     * 是否加载完成
     * 当执行完onViewCreated方法后即为true
     */
    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;
    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (openEventBus()) {
            EventBus.getDefault().register(this);
        }
        if (null != getArguments()) {
            getBundleExtras(getArguments());
        }
        mRootView = inflater.inflate(getLayoutResource(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, mRootView);
        if (isImmersionBarEnabled())
            initImmersionBar();
        initView();
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
        } else {
        }
    }

    /**
     * 是否在Fragment使用沉浸式
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(false).init();
    }

    /**
     * 找到activity的控件
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the t
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T findActivityViewById(@IdRes int id) {
        return (T) mActivity.findViewById(id);
    }

    /**
     * mvp架构的初始化
     */
    public abstract void mvpCreate();

    /**
     * 是否开启eventBus
     */
    public abstract boolean openEventBus();

    /**
     * 获取布局文件
     */
    protected int getLayoutResource() {
        return getLayoutRes();
    }

    /**
     * 获取布局文件
     */
    protected abstract int getLayoutRes();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * eventbus在主线程接收方法
     *
     * @param event
     */
    public void onEventMainThread(BaseEventBusBean event) {
        if (event != null) {
            EventBean(event);
        }
    }

    /**
     * EventBus接收信息的方法，开启后才会调用
     *
     * @param event
     */
    protected abstract void EventBean(BaseEventBusBean event);

    /**
     * 获取bundle信息
     *
     * @param bundle
     */
    protected abstract void getBundleExtras(Bundle bundle);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (openEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }
}
