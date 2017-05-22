package com.android.childapp.practice.ysj;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.childapp.R;
import com.android.childapp.practice.ysj.database.DatabaseOpenHelper;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;

    private EditText mInputBox;
    private Button mInsertBtn;
    private Button mSelectBtn;
    private Button mDeleteAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_ysj_main);

        mInputBox = (EditText) findViewById(R.id.ysj_edittext);
        mInsertBtn = (Button) findViewById(R.id.ysj_insert);
        mSelectBtn = (Button) findViewById(R.id.ysj_select);
        mDeleteAllBtn = (Button) findViewById(R.id.ysj_deleteAll);

        mInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputData = mInputBox.getText().toString();
                if(inputData != null && inputData.length() > 0) {
                    createData(inputData);
                    Toast.makeText(MainActivity.this, inputData + " 값을 저장하였습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "값을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectData = selectData();
                Toast.makeText(MainActivity.this, selectData, Toast.LENGTH_SHORT).show();
            }
        });

        mDeleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllData();
                Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void createData(String inputData) {
        db = DatabaseOpenHelper.getInstance(this).getWritableDatabase();
        String sql = "insert into TB_TEMP (SEQNO, TEMP1) values ('seq1', '" + inputData + "')";
        db.execSQL(sql);
    }

    private String selectData() {
        db = DatabaseOpenHelper.getInstance(this).getWritableDatabase();
        String sql = "select TEMP1 FROM TB_TEMP";
        Cursor cursor = db.rawQuery(sql, null);

        StringBuffer sb = new StringBuffer();

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                String temp = cursor.getString(cursor.getColumnIndex("TEMP1"));
                sb.append(temp);
                sb.append("\n");
                cursor.moveToNext();
            }
        }
        cursor.close();

        return sb.toString();
    }

    private void deleteAllData() {
        db = DatabaseOpenHelper.getInstance(this).getWritableDatabase();
        String sql = "delete from TB_TEMP";
        db.execSQL(sql);
    }


}
