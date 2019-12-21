package com.skit.sqlite.presenter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.skit.sqlite.contract.UserContract;
import com.skit.sqlite.model.User;
import com.skit.sqlite.sqlite.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.List;


public class UserDataPresenter implements UserContract.Presenter
{
	@Override
	public void insert(User user){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("sex",user.getSex());
		contentValues.put("name",user.getName());
		db.insert("User",null,contentValues);
		contentValues.clear();
		db.close();
		view.onUpdate();
	}
	
	private List<User> list = new ArrayList<User>();
	private MyDataBaseHelper dbHelper;
	UserContract.View view;
	public UserDataPresenter(UserContract.View view, MyDataBaseHelper dbHelper){
		this.view = view;
		this.dbHelper = dbHelper;
	}

	@Override
	public void getUsers(MyDataBaseHelper dbHelper){
		if(!list.isEmpty()) list.clear();
        SQLiteDatabase database = dbHelper.getReadableLink();
        Cursor user = database.query("User", null, null, null, null, null, null);
        if (user.moveToFirst()) {
            do {
                int id = user.getInt(user.getColumnIndex("id"));
                int sex = user.getInt(user.getColumnIndex("sex"));
                String name = user.getString(user.getColumnIndex("name"));
				User d = new User(id,name,sex);
                list.add(d);
            } while (user.moveToNext());
        }
        user.close();
		database.close();
		view.showData(list);
	}

	@Override
	public void upDate(int id, User user){
		SQLiteDatabase db = dbHelper.getWritableLink();
		ContentValues values = new ContentValues();
		values.put("sex", user.getSex());
		values.put("name",user.getName());
		//调用更新方法
		int i =db.update("User",values,"id = ?", new String[]{String.valueOf(id)});
		values.clear();
		db.close();
		if(i>0){
			view.onUpdate();
		}else{
			view.onError(new Exception("更新失败，没有这个记录"));
		}
	}

	@Override
	public void ondelete(){
		SQLiteDatabase db = dbHelper.getWritableLink();
		//使用SQL语句
		//db.execSQL("delete from User where id > ?", new String[]{"0"});

		//使用删除方法
		int i =db.delete("User","id > ?",new String[]{"0"});//删除id大于0的记录
		db.close();
		if(i>0){
			view.onUpdate();
		}else{
			view.onError(new Exception("删除失败，没有这个记录"));
		}
	}
}
