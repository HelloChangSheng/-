package com.example.administrator.mvp.di;

public interface IMode {
    public void requestData(String userName, String userPwd,HomeCallBack homeCallBack);

    interface HomeCallBack{
        void getResponseData(String responseData);
    }
}
