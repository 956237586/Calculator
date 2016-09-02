package cn.hylstudio.android.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HYL on 2016/8/30.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 初始化所有控件
     */
    private void init() {
        Button btn_test = (Button) findViewById(R.id.btn_unit_conversion_convert);
    }
}
