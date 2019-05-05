package myChatClient.api;

import myChatClient.utils.SendMessage;

public class SendAPI {

    //TODO  发送单聊文字信息
    /**@param from    发送方id
     * @param to    接收方id
     * @param content   发送内容
     * */
    public void sendWordMessage(String from,String to,String content)
    {
        //new SendMessage().sendWordMessage(content,from,to);
    }

    //TODO  发送群聊信息
    /**@param from    发送方id
     * @param groupId    群id
     * @param content   发送内容
     * */
    public void sendGroupChatMessage(String from,String groupId,String content)
    {
        //new SendMessage().sendWordMessage(content,from,groupId);
    }

    //TODO  发送创建群信息
    /**@param ids   群成员id列表，以逗号分隔
     * */
    public void sendCreateGroupMessage(String ids)
    {
        //new SendMessage().sendGroupMessage(ids);
    }

    //TODO  发送登录信息
    /**@param id    用户id
     * @param pwd   密码
     * */
    public void sendLoginMessage(String id,String pwd)
    {
        //new SendMessage().sendLoginMessage(id,pwd);
    }
}
