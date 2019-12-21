package com.skit.sqlite.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


/**
 * Author: shuike,
 * Email: shuike007@126.com,
 * Date: 2019/11/19.
 * PS: 
 */
public class MyDataBaseHelper extends SQLiteOpenHelper {
	private SQLiteDatabase mDatabase;
	private static MyDataBaseHelper mHelper;

    private String CREATE_DATABASE = "create table User(" +
            "id integer primary key autoincrement ," +
            "name varchar(30) not null ," +
            "sex int not null)";


	private MyDataBaseHelper(Context context,String name,int version){
		this(context,name,null,version);
	}
	
    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version,null);
    }

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
	}
	
	public static MyDataBaseHelper getInstance(Context context, String name, int version){
		if(mHelper == null){
			mHelper = new MyDataBaseHelper(context,name,version);
		}
		return mHelper;
	}

	public SQLiteDatabase getReadableLink(){
		if(mDatabase == null || !mDatabase.isOpen()){
			mDatabase = mHelper.getReadableDatabase();
		}
		return mDatabase;
	}
	
	public SQLiteDatabase getWritableLink(){
		if(mDatabase == null || !mDatabase.isOpen()){
			mDatabase = mHelper.getWritableDatabase();
		}
		return mDatabase;
	}
	
	public void closeLink(){
		if(mDatabase != null && mDatabase.isOpen()){
			mDatabase.close();
			mDatabase = null;
		}
	}
	
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
