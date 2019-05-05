package myChatClient.controller;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import myChatClient.bean.TalkItem;
import myChatClient.bean.UserInfo;
import myChatClient.bean.UserInfoVo;
import myChatClient.component.ChatItem;
import myChatClient.component.FriendItem;
import myChatClient.component.MessageItemFactory;
import myChatClient.enums.MessageSender;
import myChatClient.utils.GlobalState;


import javax.xml.soap.MessageFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserManager {
    //好友列表
    private List<UserInfoVo> userList = new ArrayList<>();
    //当前好友对象
    private UserInfoVo currentUser = new UserInfoVo();
    //聊天面板
    private VBox chatVBox;
    //前端好友列表模块
    private VBox friendsVBox;
    //本人信息
    private UserInfo myInfo;
    //聊天框名
    private Label chatNameLabel;
    /**
     * 根据当前点击好友渲染聊天列表
    * */
    public void renderChatList()
    {
        //清空当前列表
        chatVBox.getChildren().remove(0,chatVBox.getChildren().size());
        MessageItemFactory messageItemFactory = new MessageItemFactory();
        //获取当前聊天list
        List<TalkItem> chatList = currentUser.getUserInfo().getMessages();
        for(TalkItem s : chatList){
            System.out.println(chatVBox.getChildren().size());
           chatVBox.getChildren().add(messageItemFactory.getItem(s));
        }
    }

    /**
     * 渲染当前好友列表
     * **/
    public void renderFriendList(String id,String message)
    {
        //好友按优先级排序
        userList.sort(new Comparator<UserInfoVo>() {
            @Override
            public int compare(UserInfoVo o1, UserInfoVo o2) {
                return  o2.getUserInfo().getPriority() - o1.getUserInfo().getPriority();
            }
        });
        //清空当前列表
        friendsVBox.getChildren().remove(0,friendsVBox.getChildren().size());
        //渲染新列表
        for(UserInfoVo u : userList)
        {
            friendsVBox.getChildren().add(u.getUserInfoPane());
            if(id != null && message != null && u.getUserInfo().getId().equals(id))
            {
                //追加最新消息
                Label label = (Label)u.getUserInfoPane().getChildren().get(2);
                label.setText(message);
                //若当前没有聊天对象或聊天对象不是此id，则追加消息提示
                if(currentUser.getUserInfo() == null || !currentUser.getUserInfo().getId().equals(id))
                    u.getUserInfoPane().getChildren().get(3).setStyle("visibility: true");
            }
        }
    }
    /***
     * 根据id获取userInfo
     * **/
    public UserInfo getUserInfoById(String id)
    {
        for(UserInfoVo u : userList)
        {
            if(u.getUserInfo().getId().equals(id))
            {
                return u.getUserInfo();
            }
        }
        return null;
    }

    /**
     * getter & setter
     * **/
    public UserInfo getMyInfo() {
        return myInfo;
    }

    public void setMyInfo(UserInfo myInfo) {
        this.myInfo = myInfo;
    }

    public void setCurrentUser(UserInfoVo currentUser) {
        this.currentUser = currentUser;
    }

    public VBox getChatVBox() {
        return chatVBox;
    }

    public void setChatVBox(VBox chatVBox) {
        this.chatVBox = chatVBox;
    }

    public VBox getFriendsVBox() {
        return friendsVBox;
    }

    public void setFriendsVBox(VBox friendsVBox) {
        this.friendsVBox = friendsVBox;
    }

    public List<UserInfoVo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfoVo> userList) {
        this.userList = userList;
    }

    public UserInfoVo getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String id) {
        for(UserInfoVo u : userList)
        {
            if(u.getUserInfo().getId().equals(id))
            {
                currentUser = u;
                break;
            }
        }
        renderChatList();
    }

    public void setChatNameLabel(Label chatNameLabel) {
        this.chatNameLabel = chatNameLabel;
    }
    public Label getChatNameLabel()
    {
        return chatNameLabel;
    }
}
