package myChatClient.utils;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import myChatClient.Main;
import myChatClient.bean.TalkItem;
import myChatClient.bean.User;
import myChatClient.bean.UserInfo;
import myChatClient.bean.UserInfoVo;
import myChatClient.component.FriendItem;
import myChatClient.component.MessageItemFactory;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {

    /**
     * 新增好友信息
     * List<User> list：待新增的好友列表
     * **/
    public void userHandler(List<User> list,boolean isGroup)
    {
        //取得当前列表
        List<UserInfoVo> userList = GlobalState.userManager.getUserList();
        FriendItem friendItem = new FriendItem();
        //根据待增列表，创建userInfoVo并加入当前list
        for(User u : list)
        {
            UserInfoVo tmp = new UserInfoVo();
            UserInfo userInfo = new UserInfo(u.getId(),u.getUsername(),new ArrayList<TalkItem>(),GlobalState.cnt++,isGroup);
            Pane leftPane = friendItem.getSimpleFriendItem("img/profile"+u.getId()+".jpg",u.getUsername(),u.getId(),true);
            Pane rightPane = friendItem.getSimpleFriendItem("img/profile"+u.getId()+".jpg",u.getUsername(),u.getId(),false);
            Pane pane = friendItem.getFriendItem("img/profile"+u.getId()+".jpg",u.getUsername(),"",u.getId());
            tmp.setRightUserInfoPane(rightPane);
            tmp.setLeftUserInfoPane(leftPane);
            tmp.setUserInfoPane(pane);
            tmp.setUserInfo(userInfo);
            userList.add(tmp);
        }
        //把最新的list渲染到页面
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                GlobalState.userManager.renderFriendList(null,null);
            }
        });
    }

    /**
     * 处理聊天信息
     * @param paneId    发送方id，若为单聊，为发送方id；若是群聊，为群组id
     * @param fromId    发送方id，若为单聊，为发送方id；若是群聊，为发送者id
     * @param type      消息类型，0表示文字消息，1表示文件
     * @param content   消息内容
     * @param fileURL   若为文字消息，传入空串即可；若为文件消息，需传入文件路径
     * **/
    public void chatHandle(String paneId,String fromId, int type,String content,String fileURL)
    {
        //解析信息
        String avatorURL = "img/profile"+paneId+".jpg";
        //找到目标对象
        UserInfo targetUserInfo = GlobalState.userManager.getUserInfoById(paneId);
        //追加信息到聊天list
        TalkItem talkItem = new  TalkItem(type,paneId,fromId,content,avatorURL,fileURL);
        targetUserInfo.getMessages().add(talkItem);
        targetUserInfo.setPriority(GlobalState.cnt++);
        //重新渲染好友列表
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //更新JavaFX的主线程的代码放在此处
                GlobalState.userManager.renderFriendList(paneId,content);
            }
        });
        //如果是当前聊天对象，追加到聊天框
        UserInfo currentUserInfo = GlobalState.userManager.getCurrentUser().getUserInfo();
        if(currentUserInfo != null && currentUserInfo.getId().equals(paneId))
        {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    //更新JavaFX的主线程的代码放在此处
                    GlobalState.chatVBox.getChildren().add(new MessageItemFactory().getItem(talkItem));
                }
            });
            //刷新滚动条
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    GlobalState.scrollerPane.setVvalue(1);
                }
            }).start();
        }
    }
    /***
     * 登录成功调用处理函数
     * @param id    此用户的id
     * @param username  此用户的username
     * */
    public void loginHandle(String id,String username)
    {
        //添加此用户信息
        GlobalState.userManager.setMyInfo(new UserInfo(id,username,null,0,false));
        //调出主界面
        Main.stage.getScene().setRoot(Main.root);
        Main.stage.setWidth(920);
        Main.stage.setHeight(600);
    }
}
