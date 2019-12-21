package com.skit.sqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skit.lib_common.base.BaseActivity;
import com.skit.sqlite.contract.UserContract;
import com.skit.sqlite.model.User;
import com.skit.sqlite.presenter.UserDataPresenter;
import com.skit.sqlite.sqlite.MyDataBaseHelper;

import java.util.List;

@Route(path = "/sqLite/main")
public class MainActivity extends BaseActivity implements View.OnClickListener, UserContract.View{
	private SQLiteDatabase db;
    private MyDataBaseHelper dbHelper;
    private TextView textView;
	private Gson gson;
	private UserContract.Presenter precenter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sq_activity_main);
        initView();//初始化控件
		//获取SQLiteHelper对象
		dbHelper = MyDataBaseHelper.getInstance(this, "User.db", 1);
		//Gson对象
		gson = new GsonBuilder().setPrettyPrinting().create();
		//设置presenter
		setPresenter(new UserDataPresenter(this,dbHelper));
		//获取数据库写连接
		db = dbHelper.getWritableLink();
		//查询数据
		dataBaseQuery();
    }

	private void initView(){
		findViewById(R.id.create_databases).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
		textView = findViewById(R.id.data);
	}

    @Override
    public void onClick(View view) {
		int id = view.getId();
		if (id == R.id.create_databases) {//创建数据库
			db = dbHelper.getWritableLink();
		} else if (id == R.id.insert) {//插入数据
			showAddDialog();//显示插入弹窗
		} else if (id == R.id.update) {//更新数据
			//更新id为2的数据
			precenter.upDate(2, new User("哈哈哈", 0));
			//查询
			dataBaseQuery();
		} else if (id == R.id.query) {//查询
			dataBaseQuery();
		} else if (id == R.id.delete) {//删除
			precenter.ondelete();
			Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
			//查询
			dataBaseQuery();
			//db.delete("delete from User where id > ?", null, new String[]{"0"});
		}
    }

	private void showAddDialog(){
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("插入数据");
		final EditText editText = new EditText(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		editText.setLayoutParams(params);
		editText.setHint("请输入名字");
		alertDialog.setView(editText);
		alertDialog.setNegativeButton("插入", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					if (TextUtils.isEmpty(editText.getText())) {
						Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
						return;
					}
					User user = new User(editText.getText().toString(),0);
					precenter.insert(user);
					//查询
					dataBaseQuery();
				}
			});
		alertDialog.show();
	}
	private void dataBaseQuery() {
		precenter.getUsers(dbHelper);
    }
	
	@Override
	public void onError(Exception e){
		Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onUpdate(){
		dataBaseQuery();
	}
	
	@Override
	public void showData(List<User> userList){
		textView.setText(gson.toJson(userList));
	}

	@Override
	public void setPresenter(UserContract.Presenter precenter){
		this.precenter = precenter;
	}
	
    

	@Override
	protected void onResume(){
		super.onResume();
		dbHelper = MyDataBaseHelper.getInstance(this,"User.db",1);
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		dbHelper.closeLink();
		dbHelper.close();
	}

	@Override
	protected void onPause(){
		super.onPause();
		dbHelper.closeLink();
	}
}
