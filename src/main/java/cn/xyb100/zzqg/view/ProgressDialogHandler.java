package cn.xyb100.zzqg.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * Created by caoxuefeng on 2017/11/29.
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;

    private Context context;
    private boolean cancelable;

    public ProgressDialogHandler(Context context,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.cancelable = cancelable;
    }

    private void initProgressDialog(){
        if (pd == null) {
            pd = new ProgressDialog(context);

            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {

                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    private void dismissProgressDialog(){
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
