package cn.xyb100.zzqg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import butterknife.BindView;
import cn.xyb100.zzqg.base.BaseActivity;
import cn.xyb100.zzqg.bean.BaseEventBusBean;
import cn.xyb100.zzqg.bean.SelectBean;
import cn.xyb100.zzqg.presenter.MvpPresenter;
import cn.xyb100.zzqg.presenter.SelectPresenter;
import cn.xyb100.zzqg.view.ISelectView;
public class MainActivity extends BaseActivity<MvpPresenter> implements ISelectView {

    @BindView(R.id.btn_fragment)
    Button btn_fragment;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.iv_image)
    ImageView iv_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Glide加载图片使用实例
         */
        Glide.with(this)
                .load("http://www.zhengzhousheji.com/wp-content/uploads/2012/08/baidulogo1.jpg")
                .asBitmap()
                .override(720, 500)
                .error(R.mipmap.ic_launcher)
                .into(iv_image);

        mBasePresenter.requestData(SelectBean.class);
    }

    @Override
    protected void createPresenter() {
        mBasePresenter = new SelectPresenter();
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar).init();
//        requestPermissions();
    }

    @Override
    public boolean openEventBus() {
        return false;
    }

    @Override
    public void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void EventBean(BaseEventBusBean event) {

    }

    public void start_fragment(View view){
        startActivity(new Intent(this,TestFragmentActivity.class));
    }

//    private void requestPermissions() {
//        RxPermissions rxPermission = new RxPermissions(this);
//        rxPermission.requestEach(Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.READ_CALENDAR,
//                        Manifest.permission.READ_CALL_LOG,
//                        Manifest.permission.READ_CONTACTS,
//                        Manifest.permission.READ_PHONE_STATE,
//                        Manifest.permission.READ_SMS,
//                        Manifest.permission.RECORD_AUDIO,
//                        Manifest.permission.CAMERA,
//                        Manifest.permission.CALL_PHONE,
//                        Manifest.permission.SEND_SMS)
//                .subscribe(new Consumer<Permission>() {
//                    @Override
//                    public void accept(Permission permission) throws Exception {
//                        if (permission.granted) {
//                            // 用户已经同意该权限
//                            Logger.e(permission.name + " 用户已经同意该权限");
//                        } else if (permission.shouldShowRequestPermissionRationale) {
//                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
//                            Logger.e(permission.name + " 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框");
//                        } else {
//                            // 用户拒绝了该权限，并且选中『不再询问』
//                            Logger.e(permission.name + "用户拒绝了该权限，并且选中『不再询问』");
//                        }
//                    }
//                });
//    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public <T> void showCurContent(T t) {
        if(t instanceof SelectBean){
            SelectBean sb = (SelectBean)t;
            tv_content.setText(new Gson().toJson(sb));
        }
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
