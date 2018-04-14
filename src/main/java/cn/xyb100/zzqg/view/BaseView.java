package cn.xyb100.zzqg.view;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public interface BaseView {
    /**
     * 展示错误信息
     */
    void showErrorMessage(String msg);

    /**
     * 显示当前数据
     * @param t
     */
    <T> void showCurContent(T t);

    /**
     * 显示当前dialog
     */
    void showDialog();

    /**
     * 隐藏当前dialog
     */
    void hideDialog();
}
