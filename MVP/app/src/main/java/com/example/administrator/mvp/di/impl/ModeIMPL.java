package com.example.administrator.mvp.di.impl;

import com.example.administrator.mvp.di.IMode;

public class ModeIMPL implements IMode {

    @Override
    public void requestData(final String userName, final String userPwd, final HomeCallBack homeCallBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if(userName.equals("bcs") && userPwd.equals("666")){
                        homeCallBack.getResponseData("登录成功！");
                    }else{
                        homeCallBack.getResponseData("登陆失败！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
