package myChatClient.utils;

import client.Send;

public class SendMessage {
    /**
     * login：登录认证
     * word：文字信息
     * file：文件信息
     * */
    public void sendWordMessage(String message,String from,String to)
    {
        String data = "word#"+from+"#"+to+"#"+message;
        new Thread(new Send(data)).start();
    }
    public void sendLoginMessage(String account,String password)
    {
        String data = "login#"+0+"#"+0+"#"+account+"#"+password;
        new Thread(new Send(data)).start();
    }
    public void sendGroupMessage(String list)
    {
        String data = "group#"+GlobalState.userManager.getMyInfo().getId()+"#0#"+list;
        new Thread(new Send(data)).start();
    }
}
