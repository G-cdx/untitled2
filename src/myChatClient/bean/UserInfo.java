package myChatClient.bean;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    //用户id
    private String id;
    //用户名
    private String username;
    //优先级
    private int priority;
    //是否群组
    private boolean isGroup;
    //聊天列表
    private List<TalkItem> messages = new ArrayList<>();

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId(String id) {
        this.id = id;
    }


    public UserInfo(String id, String username, List<TalkItem> messages, int priority, boolean isGroup) {
        this.id = id;
        this.username = username;
        this.priority = priority;
        this.isGroup = isGroup;
        this.messages = messages;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public List<TalkItem> getMessages() {
        return messages;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessages(List<TalkItem> messages) {
        this.messages = messages;
    }
}
