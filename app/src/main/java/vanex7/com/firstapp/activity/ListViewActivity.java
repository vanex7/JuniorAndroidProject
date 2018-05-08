package vanex7.com.firstapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import vanex7.com.firstapp.R;

public class ListViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
    }
}
