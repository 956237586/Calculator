package cn.hylstudio.android.calculator.model;

import android.util.Log;
import android.webkit.WebView;

import java.util.Stack;

/**
 * 计算器后台处理类
 * Created by HYL on 2016/9/8.
 */
public class Calculator {
    public static final String TAG = "calculator_Calculator";


    //操作符类型
    public static final int OP_ADD = 0;
    public static final int OP_SUB = 1;
    public static final int OP_MUL = 2;
    public static final int OP_DIV = 3;

    private double result;//运算结果
    private double num1;
    private double num2;

    public int getOP() {
        return op;
    }

    private int op;

    public Calculator() {
    }

    /**
     * 设置操作数1
     *
     * @param num1 操作数1
     * @return 操作结果
     */
    public Result setNum1(double num1) {
        this.num1 = num1;
        Result ret = new Result();
        ret.type = Result.SUCCESS;
        ret.msg = "set num1成功" + num1;
        Log.d(TAG, "setNum1: " + ret.msg);
        return ret;
    }

    /**
     * 设置操作数2
     *
     * @param num2 操作数2
     * @return 操作结果
     */
    public Result setNum2(double num2) {
        this.num2 = num2;
        Result ret = new Result();
        ret.type = Result.SUCCESS;
        ret.msg = "set num2成功" + num2;
        Log.d(TAG, "setNum2: " + ret.msg);
        return ret;
    }

    /**
     * 设置操作符
     *
     * @param op 操作符
     * @return 设置结果
     */
    public Result setOP(int op) {
        this.op = op;
        Result ret = new Result();
        ret.type = Result.SUCCESS;
        ret.msg = "set op成功" + op;
        Log.d(TAG, "setOP: " + ret.msg);
        return ret;
    }

    public Result Calcu(WebView w, String s) {
        s = "document.writeln(eval('1+1+5'))";
        w.getSettings().setJavaScriptEnabled(true);
        Log.d(TAG, "Calcu: javascript:" + s);
        w.loadUrl("javascript:" + s);
        Result ret = new Result();
        ret.type = Result.SUCCESS;
        ret.msg = "set op成功" + op;
        Log.d(TAG, "setOP: " + ret.msg);
        return ret;
    }

    /**
     * 计算动作
     *
     * @return 计算结果字符串
     */
    public Result calcu() {
        Result ret = new Result();
        ret.type = Result.SUCCESS;
        switch (op) {
            case OP_ADD:
                result = num1 + num2;
                break;
            case OP_SUB:
                result = num1 - num2;
                break;
            case OP_MUL:
                result = num1 * num2;
                break;
            case OP_DIV:
                result = num1 / num2;
                break;
        }

        ret.msg = result + "";
        Log.d(TAG, "calcu: " + ret.msg);
        return ret;
    }

}