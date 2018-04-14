package cn.xyb100.zzqg;

import android.app.Application;

import com.zxy.recovery.callback.RecoveryCallback;
import com.zxy.recovery.core.Recovery;

import cn.xyb100.zzqg.logger.AndroidLogAdapter;
import cn.xyb100.zzqg.logger.Logger;

/**
 * Created by caoxuefeng on 2017/11/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
//        initCrash();
    }


    /**
     * 初始化logger日志库
     */
    private void initLogger(){
        AndroidLogAdapter ala = new AndroidLogAdapter();
//        ala.isLoggable(0,"test");
        Logger.addLogAdapter(ala);
    }


    /**
     * Argument    Type    Function
     debug   boolean 是否开启debug模式
     recoverInBackgroud  boolean 当应用在后台时发生Crash，是否需要进行恢复
     recoverStack    boolean 是否恢复整个Activity Stack，否则将恢复栈顶Activity
     mainPage    Class<? extends Activity>   回退的界面
     callback    RecoveryCallback    发生Crash时的回调
     silent  boolean,SilentMode  是否使用静默恢复，如果设置为true的情况下，那么在发生Crash时将不显示RecoveryActivity界面来进行恢复，而是自动的恢复Activity的堆栈和数据，也就是无界面恢复
     SilentMode
     RESTART - 重启应用
     RECOVER_ACTIVITY_STACK - 恢复Activity堆栈
     RECOVER_TOP_ACTIVITY - 恢复栈顶Activity
     RESTART_AND_CLEAR - 重启应用并清空缓存数据
     */
    private void initCrash(){
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(MainActivity.class)
                .callback(new RecoveryCallback() {
                    @Override
                    public void stackTrace(String stackTrace) {

                    }

                    @Override
                    public void cause(String cause) {

                    }

                    @Override
                    public void exception(String throwExceptionType, String throwClassName, String throwMethodName, int throwLineNumber) {

                    }

                    @Override
                    public void throwable(Throwable throwable) {

                    }
                })
                .init(this);
    }
}
