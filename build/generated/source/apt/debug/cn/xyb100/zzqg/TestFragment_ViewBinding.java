// Generated code from Butter Knife. Do not modify!
package cn.xyb100.zzqg;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestFragment_ViewBinding<T extends TestFragment> implements Unbinder {
  protected T target;

  private View view2131427423;

  @UiThread
  public TestFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_fragment, "field 'btn_fragment' and method 'onClick'");
    target.btn_fragment = Utils.castView(view, R.id.btn_fragment, "field 'btn_fragment'", Button.class);
    view2131427423 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.btn_fragment = null;

    view2131427423.setOnClickListener(null);
    view2131427423 = null;

    this.target = null;
  }
}
