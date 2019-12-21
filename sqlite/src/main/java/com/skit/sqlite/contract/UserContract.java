package com.skit.sqlite.contract;


import com.skit.sqlite.model.User;
import com.skit.sqlite.sqlite.MyDataBaseHelper;
import com.skit.sqlite.view.BaseView;

import java.util.List;

public interface UserContract
{
	interface Presenter{
		void getUsers(MyDataBaseHelper dbHelper);
		void ondelete();
		void upDate(int id, User user);
		void insert(User user);
	}

	interface View extends BaseView<Presenter> {
		void showData(List<User> userList);
		void onUpdate();
		void onError(Exception e);
	}
}
