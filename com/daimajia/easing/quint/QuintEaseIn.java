package com.daimajia.easing.quint;

import com.daimajia.easing.BaseEasingMethod;

public class QuintEaseIn extends BaseEasingMethod {
    public QuintEaseIn(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return Float.valueOf((f5 * ((((f3 * f5) * f5) * f5) * f5)) + f2);
    }
}
