package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ca extends Animation {
    final /* synthetic */ SwipeRefreshLayout f1652a;

    ca(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1652a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1652a.setAnimationProgress(f);
    }
}
