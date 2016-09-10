package cn.hylstudio.android.calculator.viewinterface;

/**
 * 单位转换视图接口。
 * Created by HYL on 2016/9/9.
 */
public interface UnitConversionView extends TopView {
    double getValue1();
    double getValue2();
    int getUnit1();
    int getUnit2();
    void setValue2(String value2);
}
