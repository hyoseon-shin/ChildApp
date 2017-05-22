package com.android.childapp.practice.ysj.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sjyoon on 2017-05-22.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ysj.db";
    private static final int DB_VERSION = 1;

    private static DatabaseOpenHelper _instance = null;

    public DatabaseOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public synchronized static DatabaseOpenHelper getInstance(Context context){
        if(_instance == null){
            _instance = new DatabaseOpenHelper(context.getApplicationContext());
        }
        return _instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("ysj", "onCreate");
        String sql = "CREATE TABLE TB_TEMP (SEQNO TEXT, TEMP1 TEXT, TEMP2 TEXT, TEMP3 TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("ysj", "onUpgrade oldVersion: " + oldVersion + ", newVersion: " + newVersion);
        if(oldVersion < 2) {
            String sql = "ALTER TABLE TB_TEMP ADD COLUMN TEMP4 TEXT;";
            db.execSQL(sql);
        }

        if(oldVersion < 3) {
            String sql = "ALTER TABLE TB_TEMP ADD COLUMN TEMP5 TEXT;";
            db.execSQL(sql);
        }
    }
}
