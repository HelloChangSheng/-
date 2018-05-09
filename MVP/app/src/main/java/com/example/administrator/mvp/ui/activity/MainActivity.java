package com.example.administrator.mvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvp.R;
import com.example.administrator.mvp.di.IView;
import com.example.administrator.mvp.di.impl.PresenterIMPL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView{

    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_userPsw)
    EditText etUserPsw;
    @BindView(R.id.btn)
    Button btn;
    private PresenterIMPL presenterIMPL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenterIMPL = new PresenterIMPL(this);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        String userName = etUserName.getText().toString();
        String userPwd = etUserPsw.getText().toString();
        presenterIMPL.login(userName,userPwd);
    }

    @Override
    public void updateUI(final String responseData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, responseData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
