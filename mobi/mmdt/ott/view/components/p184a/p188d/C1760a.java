package mobi.mmdt.ott.view.components.p184a.p188d;

import android.view.View;
import com.nineoldandroids.animation.ObjectAnimator;
import mobi.mmdt.ott.view.components.p184a.C1751i;

/* renamed from: mobi.mmdt.ott.view.components.a.d.a */
public class C1760a extends C1751i {
    public void m8706a(View view) {
        m8686d().playTogether(ObjectAnimator.ofFloat((Object) view, "rotationY", -90.0f, 0.0f), ObjectAnimator.ofFloat((Object) view, "alpha", 0.0f, 1.0f));
    }
}
