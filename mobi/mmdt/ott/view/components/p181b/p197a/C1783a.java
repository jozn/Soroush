package mobi.mmdt.ott.view.components.p181b.p197a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* renamed from: mobi.mmdt.ott.view.components.b.a.a */
public class C1783a extends LinearLayoutManager {
    private int[] f5766a;

    public C1783a(Context context) {
        super(context);
        this.f5766a = new int[2];
    }

    private void m8736a(Recycler recycler, int i, int i2, int i3, int[] iArr) {
        View viewForPosition = recycler.getViewForPosition(i);
        if (viewForPosition != null) {
            LayoutParams layoutParams = (LayoutParams) viewForPosition.getLayoutParams();
            viewForPosition.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), layoutParams.height));
            iArr[0] = (viewForPosition.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
            iArr[1] = layoutParams.topMargin + (viewForPosition.getMeasuredHeight() + layoutParams.bottomMargin);
            recycler.recycleView(viewForPosition);
        }
    }

    public boolean canScrollVertically() {
        return false;
    }

    public void onMeasure(Recycler recycler, State state, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < getItemCount()) {
            int i6;
            int i7;
            m8736a(recycler, i3, MeasureSpec.makeMeasureSpec(i3, 0), MeasureSpec.makeMeasureSpec(i3, 0), this.f5766a);
            if (getOrientation() == 0) {
                i6 = i5 + this.f5766a[0];
                i7 = i3 == 0 ? this.f5766a[1] : i4;
            } else {
                i7 = this.f5766a[1] + i4;
                i6 = i3 == 0 ? this.f5766a[0] : i5;
            }
            i3++;
            i4 = i7;
            i5 = i6;
        }
        switch (mode) {
            case 1073741824:
                i5 = size;
                break;
        }
        switch (mode2) {
            case 1073741824:
                i4 = size2;
                break;
        }
        setMeasuredDimension(i5, i4);
    }
}
