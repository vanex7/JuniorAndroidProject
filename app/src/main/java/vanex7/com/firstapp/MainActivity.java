package vanex7.com.firstapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView = null;
    private MyAdapter adapter = null;
    private List<Data> data = null;
    private Context context = null;
    private Button btnAdd = null;
    private Button btnInsert5 = null;
    private static int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        this.context = MainActivity.this;
        bindViews();

        this.data = new LinkedList<Data>();
        this.adapter = new MyAdapter(this.context, this.data);
        this.listView.setAdapter(this.adapter);

        TextView txt = findViewById(R.id.emptyText);
        txt.setText("暂无数据");
        this.listView.setEmptyView(txt);

        this.btnAdd = findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnAdd:
                        MainActivity.this.adapter.add(new Data(R.drawable.ic_19131609, "给华哥跪了~~ x " + flag++), flag - 1);
                        break;
                }
            }
        });
        this.btnInsert5 = findViewById(R.id.btnInsert5);
        this.btnInsert5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.adapter.add(new Data(R.drawable.ic_19131609, "我是插入的数据，插入位置是5"), 5);
            }
        });
    }

    private void bindViews() {
        this.listView = findViewById(R.id.listview);
    }


}
