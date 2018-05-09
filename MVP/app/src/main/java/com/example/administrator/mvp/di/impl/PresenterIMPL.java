package com.example.administrator.mvp.di.impl;

import com.example.administrator.mvp.di.IMode;
import com.example.administrator.mvp.di.IPresenter;
import com.example.administrator.mvp.di.IView;

public class PresenterIMPL implements IPresenter{
    IView iView;
    private final ModeIMPL modeIMPL;

    public PresenterIMPL(IView iView) {
        this.iView = iView;
        modeIMPL = new ModeIMPL();
    }

    @Override
    public void login(String userName, String userPwd) {
        modeIMPL.requestData(userName, userPwd, new IMode.HomeCallBack() {
            @Override
            public void getResponseData(String responseData) {
                iView.updateUI(responseData);
            }
        });
    }
}
