package com.mmfront.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mmfront.R;
import com.mmfront.base.BaseActivity;
import com.mmfront.contract.LoginContract;
import com.mmfront.model.bean.User;
import com.mmfront.presenter.LoginPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter> implements LoginContract.View{
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    @Override
    public void result(User data) {
        Toast.makeText(this,"success",Toast.LENGTH_LONG);
    }

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

    }
    @OnClick(R.id.loginBtn)
    public void onViewClicked(View view) {

                HashMap<String,String> map = new HashMap<>();
                map.put("userName",username.getText().toString());
                map.put("userName",password.getText().toString());
                mPresenter.login(map);

    }
}
