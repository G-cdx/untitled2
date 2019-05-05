package myChatClient.utils;

import myChatClient.api.AcceptAPI;
import myChatClient.bean.User;

import java.util.ArrayList;
import java.util.List;

public class AcceptMessage {
    private AcceptAPI acceptAPI = new AcceptAPI();
    public void handlerMessage(String message)
    {
        String messageArray[] = message.split("#");
        String type = messageArray[0];
        String from =  messageArray[1];
        String to = messageArray[2];
        String data = messageArray[3];
        if(type.equals("login"))
            acceptAPI.loginHandle(messageArray[4],messageArray[5]);
        else if(type.equals("word"))
        {
            acceptAPI.chatMessageHandle(from,data);
        }else if(type.equals("group"))
        {
            acceptAPI.groupChatMessageHandle(messageArray[1],messageArray[2],messageArray[4]);
        }
        else if(type.equals("file"))
        {
            //chatHandle(from,1,data,messageArray[4]);
        }else if(type.equals("user"))
        {
            List<User> list = new ArrayList<>();
            for(int i = 3; i < messageArray.length; i += 2)
            {
                list.add(new User(messageArray[i],messageArray[i+1]));
            }
            if(list.size() == 1)
                acceptAPI.addGroupHandle(list.get(0).getId());
            else acceptAPI.addUserHandle(list);
        }
    }
}
