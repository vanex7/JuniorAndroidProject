package vanex7.com.firstapp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import vanex7.com.firstapp.R;

public class ToastActivity extends Activity {
    private Button btnNormal;
    private Button btnShowLong;
    private Button btnShowCenter;
    private Button btnShowTop;
    private Button btnShowBottom;
    private Button btnBlend;

    private View.OnClickListener onClickListener = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                Context ctx = ToastActivity.this;
                if (id == btnNormal.getId()) {
                    Toast.makeText(ctx, "NORMAL SHOW", Toast.LENGTH_SHORT).show();
                } else if (id == btnShowBottom.getId()) {
                    Toast toast = Toast.makeText(ctx, "SHOW AT BOTTOM", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.show();
                } else if (id == btnShowCenter.getId()) {
                    Toast toast = Toast.makeText(ctx, "SHOW AT CENTER", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                } else if (id == btnShowLong.getId()) {
                    Toast.makeText(ctx, "LONG SHOW", Toast.LENGTH_LONG).show();
                } else if (id == btnShowTop.getId()) {
                    Toast toast = Toast.makeText(ctx, "SHOW AT TOP", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                } else if (id == btnBlend.getId()) {
                    Toast toast = Toast.makeText(ctx, "SHOW AT TOP AND LEFT", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                    toast.show();
                }
            }
        };

        btnNormal = findViewById(R.id.toast_btn_normal);
        btnShowLong = findViewById(R.id.toast_btn_long_time);
        btnShowCenter = findViewById(R.id.toast_btn_show_center);
        btnShowTop = findViewById(R.id.toast_btn_show_top);
        btnShowBottom = findViewById(R.id.toast_btn_show_bottom);
        btnBlend = findViewById(R.id.toast_btn_blend);

        btnNormal.setOnClickListener(onClickListener);
        btnShowLong.setOnClickListener(onClickListener);
        btnShowCenter.setOnClickListener(onClickListener);
        btnShowTop.setOnClickListener(onClickListener);
        btnShowBottom.setOnClickListener(onClickListener);
        btnBlend.setOnClickListener(onClickListener);
    }
}
