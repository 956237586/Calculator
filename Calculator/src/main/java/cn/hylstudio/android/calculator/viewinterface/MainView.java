package cn.hylstudio.android.calculator.viewinterface;

/**
 * Created by HYL on 2016/9/8.
 */
public interface MainView extends TopView{
    /**
     * 更新界面
     * @param op
     */
    void update(char op);
    void update(int digit);
    void update(String result);

    /**
     * 删除一位
     */
    void del();

    /**
     * 设置所有符号输入
     */
    void setOPInputEnable(boolean isEnable);
    /**
     * 设置小数点输入
     */
    void setDotInputEnable(boolean isEnable);

}
