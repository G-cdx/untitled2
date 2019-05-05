package myChatClient.api;

import myChatClient.bean.TalkItem;
import myChatClient.bean.User;
import myChatClient.bean.UserInfo;
import myChatClient.utils.AcceptMessage;
import myChatClient.utils.GlobalState;

import java.util.ArrayList;
import java.util.List;

public class InitUtil {
    //TODO  初始化好友列表
    public void addFriends()
    {
        List<User> list = new ArrayList<>();
        //分配好友id和username
        list.add(new User("001","老大"));
        list.add(new User("002","老二"));
        new AcceptAPI().addUserHandle(list);
    }
    //TODO  初始化个人信息，包括id和username
    public void initMyInfo(){
        UserInfo userInfo = new UserInfo("003","老三",null,0,false);
        GlobalState.userManager.setMyInfo(userInfo);
    }
}
