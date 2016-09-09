
package cn.hylstudio.android.calculator.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import cn.hylstudio.android.calculator.R;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.hylstudio.android.calculator.presenter.MainPresenter;
import cn.hylstudio.android.calculator.viewinterface.MainView;

/**
 * Created by HYL on 2016/8/30.
 */

public class MainActivity extends Activity implements MainView {
    public static final String TAG = "calculator_Main";

    //所有视图控件
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_dot;
    private Button btn_enter;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_mul;
    private Button btn_div;
    private Button btn_del;

    private TextView tv_result;

    boolean isDotPressed = false;
    boolean isOPPressed = false;

    //控件数据
    private List<Button> buttons;

    private Handler handler;
    private WebView calcu;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);

//        calcu.loadUrl("javascript:handler.calcu(eval('1+2*3'))");
        setContentView(R.layout.activity_main);
        initViews();
        handler = new Handler();
    }


    /**
     * 初始化所有控件
     */

    @Override
    public void initViews() {
        buttons = new ArrayList<>();
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_enter = (Button) findViewById(R.id.btn_enter);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_del = (Button) findViewById(R.id.btn_del);
        buttons.add(btn_0);
        buttons.add(btn_1);
        buttons.add(btn_2);
        buttons.add(btn_3);
        buttons.add(btn_4);
        buttons.add(btn_5);
        buttons.add(btn_6);
        buttons.add(btn_7);
        buttons.add(btn_8);
        buttons.add(btn_9);
        buttons.add(btn_dot);
        buttons.add(btn_enter);
        buttons.add(btn_add);
        buttons.add(btn_sub);
        buttons.add(btn_mul);
        buttons.add(btn_div);
        buttons.add(btn_del);
        for (Button b : buttons) {
            b.setOnClickListener(new ButtonClickListener());
        }

        tv_result = (TextView) findViewById(R.id.tv_calcu_result);
        calcu = (WebView) findViewById(R.id.wv_calcu);
        calcu.getSettings().setJavaScriptEnabled(true);
        calcu.getSettings().setDomStorageEnabled(true);
        calcu.addJavascriptInterface(new MyHandler(), "handler");
    }

    @Override
    public void update(char op) {
        tv_result.setText(tv_result.getText().toString() + op);
    }

    @Override
    public void update(int digit) {
        tv_result.setText(tv_result.getText().toString() + digit);
    }

    @Override
    public void update(String result) {
        tv_result.setText(result);
    }

    @Override
    public void del() {
        tv_result.setText("");
//        String num = tv_result.getText().toString();
//        if (!num.equals("")) {
//            char lastChar = num.charAt(num.length() - 1);
//            if (lastChar == '.') {
//                setDotInputEnable(true);
//            } else {
//                if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
//                    setOPInputEnable(true);
//                }
//            }
//            tv_result.setText(num.substring(0, num.length() - 1));
//        }
    }

    @Override
    public void setOPInputEnable(boolean isEnable) {
        btn_add.setEnabled(isEnable);
        btn_sub.setEnabled(isEnable);
        btn_mul.setEnabled(isEnable);
        btn_div.setEnabled(isEnable);
        this.isOPPressed = !isEnable;
    }

    @Override
    public void setDotInputEnable(boolean isEnable) {
        btn_dot.setEnabled(isEnable);
        this.isDotPressed = !isEnable;
    }

    public class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_0:
                    update(0);
                    break;
                case R.id.btn_1:
                    update(1);
                    break;
                case R.id.btn_2:
                    update(2);
                    break;
                case R.id.btn_3:
                    update(3);
                    break;
                case R.id.btn_4:
                    update(4);
                    break;
                case R.id.btn_5:
                    update(5);
                    break;
                case R.id.btn_6:
                    update(6);
                    break;
                case R.id.btn_7:
                    update(7);
                    break;
                case R.id.btn_8:
                    update(8);
                    break;
                case R.id.btn_9:
                    update(9);
                    break;
                case R.id.btn_dot:
//                    if (!isDotPressed) {
//                        setDotInputEnable(false);
//                    }
                    update('.');
                    break;
                case R.id.btn_enter:
                    calcu.loadUrl("javascript:handler.calcu(eval('" + tv_result.getText() + "'))");

//                    Result r = presenter.calcu(tv_result.getText() + "");
//                    if (r.type == Result.SUCCESS) {
//                        tv_result.setText(r.msg);
//                    } else {
//
//                    }
//                    int index = 0;
//                    String s = tv_result.getText() + "";
//                    Log.d(TAG, "s = " + s);
//                    switch (presenter.getOP()) {
//                        case Calculator.OP_ADD:
//                            index = s.indexOf('+');
//                            break;
//                        case Calculator.OP_SUB:
//                            index = s.indexOf('-');
//                            break;
//                        case Calculator.OP_MUL:
//                            index = s.indexOf('*');
//                            break;
//                        case Calculator.OP_DIV:
//                            index = s.indexOf('/');
//                            break;
//                    }
//                    Log.d(TAG, "index = " + index);
//                    if (index != 0) {
//                        s = s.substring(index + 1);
//                        Log.d(TAG, "s = " + s);
//                        setOPInputEnable(true);
//                        presenter.setNum2(Double.parseDouble(s));
//                        Result result = presenter.calcu();
//                        if (result.type == Result.SUCCESS) {
//                            tv_result.setText(result.msg);
//                            presenter.setNum1(Double.parseDouble(result.msg));
//                        }
//                    }
                    break;
                case R.id.btn_add:
//                    presenter.setNum1(Double.parseDouble(tv_result.getText().toString()));
                    update('+');
//                    presenter.setOP(Calculator.OP_ADD);
//                    setOPInputEnable(false);
//                    setDotInputEnable(true);
                    break;
                case R.id.btn_sub:
//                    presenter.setNum1(Double.parseDouble(tv_result.getText().toString()));
                    update('-');
//                    presenter.setOP(Calculator.OP_SUB);
//                    setOPInputEnable(false);
//                    setDotInputEnable(true);
                    break;
                case R.id.btn_mul:
//                    presenter.setNum1(Double.parseDouble(tv_result.getText().toString()));
                    update('*');
//                    presenter.setOP(Calculator.OP_MUL);
//                    setOPInputEnable(false);
//                    setDotInputEnable(true);
                    break;
                case R.id.btn_div:
//                    presenter.setNum1(Double.parseDouble(tv_result.getText().toString()));
                    update('/');
//                    presenter.setOP(Calculator.OP_DIV);
//                    setOPInputEnable(false);
//                    setDotInputEnable(true);
                    break;
                case R.id.btn_del:
                    del();
                    break;
            }
        }
    }

    private class MyHandler {
        @JavascriptInterface
        public void calcu(String data) {
            Log.d(TAG, "result: " + data);
            handler.post(new UpdateThread(data));
        }
    }

    private class UpdateThread implements Runnable {
        String data;

        public UpdateThread(String data) {
            this.data = data;
        }

        @Override
        public void run() {
            update(data);
        }
    }

}
