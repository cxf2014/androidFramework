// Generated code from Butter Knife. Do not modify!
package cn.xyb100.zzqg;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.btn_fragment = Utils.findRequiredViewAsType(source, R.id.btn_fragment, "field 'btn_fragment'", Button.class);
    target.tv_content = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tv_content'", TextView.class);
    target.iv_image = Utils.findRequiredViewAsType(source, R.id.iv_image, "field 'iv_image'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btn_fragment = null;
    target.tv_content = null;
    target.iv_image = null;

    this.target = null;
  }
}
