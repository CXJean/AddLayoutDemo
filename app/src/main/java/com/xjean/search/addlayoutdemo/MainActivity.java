package com.xjean.search.addlayoutdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button btn_add;
    private Button btn_delete;
    private int i=-1;
    private LinearLayout my_layout;
    private EditText editText1;
    private ArrayList<EditText> editTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexts = new ArrayList<>();

        initView();

    }


    public void addView() {
        my_layout = findViewById(R.id.My_layout);
        editText1 = new EditText(this);
        i++;
        Log.d(TAG, "addView: -----------"+editText1.toString());
        editText1.setHintTextColor(Color.BLUE);
        editText1.setWidth(300);
        editText1.setHeight(100);
        editText1.setHint("第几个"+i);
        editText1.setTop(10);
        editText1.setSingleLine(true);//只有一行
        editText1.setEllipsize(TextUtils.TruncateAt.valueOf("END"));//动隐藏尾部溢出数据，一般用于文字内容过长一行无法全部显示时
        editText1.setMovementMethod(LinkMovementMethod.getInstance());//设置textview滚动事件的
        editTexts.add(i,editText1);
        Log.d(TAG, "addView: -----------"+i);
        my_layout.addView(editText1);
    }
    public void deleteView() {
        EditText editText = editTexts.get(i);
        my_layout.removeView(editText);
        editTexts.remove(i);
        i--;
        Log.d(TAG, "deleteView: --------"+i);
    }

    private void initView() {
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                addView();
                break;
            case R.id.btn_delete:
                if (i>-1){
                    deleteView();
                }else{
                    Toast.makeText(this,"没有了---下标"+i,Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}
