package myChatClient.api;

import myChatClient.bean.User;
import myChatClient.utils.AcceptMessage;
import myChatClient.utils.MessageHandler;

import java.util.ArrayList;
import java.util.List;

public class AcceptAPI {
    private MessageHandler messageHandler = new MessageHandler();

    //TODO  接收单聊文字信息处理
    /**@param fromId    发送方id
     * @param content   发送内容
     * */
    public void chatMessageHandle(String fromId,String content)
    {
        messageHandler.chatHandle(fromId,fromId,0,content,"");
    }

    //TODO  接收群聊文字信息处理
    /**@param groupId    群id
     * @param fromId    发送方id
     * @param content   发送内容
     * */
    public void groupChatMessageHandle(String groupId,String fromId,String content)
    {
        messageHandler.chatHandle(groupId,fromId,0,content,"");
    }

    //TODO  群创建消息处理
    /**@param groupId    群id
     * */
    public void addGroupHandle(String groupId)
    {
        List<User> list = new ArrayList<>();
        list.add(new User(groupId,"群聊"));
        messageHandler.userHandler(list,true);
    }

    //TODO  新增用户处理
    /**@param list    新增用户列表
     * */
    public void addUserHandle(List<User> list)
    {
        messageHandler.userHandler(list,false);
    }

    //TODO  登录成功后接收返回信息处理
    /**@param   id    本用户id
     * @param   username    本用户名称
     * */
    public void loginHandle(String id,String username)
    {
        messageHandler.loginHandle(id,username);
    }
}
