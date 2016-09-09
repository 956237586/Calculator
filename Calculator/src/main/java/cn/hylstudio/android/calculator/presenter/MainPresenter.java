package cn.hylstudio.android.calculator.presenter;

import android.os.Handler;

import cn.hylstudio.android.calculator.model.Calculator;
import cn.hylstudio.android.calculator.model.Result;
import cn.hylstudio.android.calculator.viewinterface.MainView;

/**
 * 展示了多种方法计算表达式结果。
 * Created by HYL on 2016/9/8.
 */
public class MainPresenter {
    private MainView mainView;
    private Handler handler;
    private Calculator calculator;
    private Result ret;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        handler = new Handler();
        calculator = new Calculator();
    }

    public Result setNum1(double num1) {
        return calculator.setNum1(num1);
    }

    public Result setNum2(double num2) {
        return calculator.setNum2(num2);
    }

    public Result setOP(int op) {
        return calculator.setOP(op);
    }

    public Result calcu() {
        return calculator.calcu();
    }

    public int getOP() {
        return calculator.getOP();
    }

//    public Result calcu(String s) {
//        Log.d("s", "calcu: "+s);
//        ret = new Result();
//        AsyncHttpClient client = new AsyncHttpClient();
//        s = Uri.encode(s);
//        Log.d("s", "calcu: "+s);
//        client.get("http://android.hylstudio.cn/calcu.php?s=" + s, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onStart() {
//                // called b1efore request is started
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
//                Log.d("result", "onSuccess: " + new String(response));
//                ret.type = Result.SUCCESS;
//                ret.msg = new String(response);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
//                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//            }
//
//            @Override
//            public void onRetry(int retryNo) {
//                // called when request is retried
//            }
//        });
//        return ret;
//    }
}
