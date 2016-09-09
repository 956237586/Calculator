package cn.hylstudio.android.calculator.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.hylstudio.android.calculator.R;
import cn.hylstudio.android.calculator.viewinterface.UnitConversionView;

public class UnitConversionActivity extends AppCompatActivity implements UnitConversionView {
    private Button btn_toCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_conversion);
        initViews();
    }

    @Override
    public void initViews() {
        btn_toCalculator = (Button) findViewById(R.id.btn_conversion_to_calculator);
        btn_toCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
