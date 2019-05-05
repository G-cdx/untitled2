package myChatClient.component;

import javafx.scene.layout.HBox;
import myChatClient.bean.TalkItem;
import myChatClient.enums.MessageSender;
import myChatClient.enums.MessageType;
import myChatClient.utils.GlobalState;

public class MessageItemFactory{
    private FileItem fileItem;
    private ChatItem chatItem;
    public MessageItemFactory()
    {
        fileItem = new FileItem();
        chatItem = new ChatItem();
    }
    /**
     * 根据传入的类型渲染对应聊天项
     * type：信息类型，0为一般信息，1为文件信息
     * avatorUrl：发送方头像
     * message：信息内容
     * flag：对方还是自己
     * **/
    public HBox getItem(TalkItem talkItem)
    {
        String paneId = talkItem.getPaneId();
        String fromId = talkItem.getFromId();
        String myId = GlobalState.userManager.getMyInfo().getId();
        String name = "";
        boolean flag = false;
        if(paneId.equals(myId) && fromId.equals(myId))
        {
            flag = true;
        }
        if(!paneId.equals(fromId))
        {
            name = GlobalState.userManager.getUserInfoById(fromId).getUsername();
        }
        if(talkItem.getType() == 0)
            return chatItem.getChatItem(name,talkItem.getAvatorURL(),talkItem.getContent(),flag);
        else if(talkItem.getType() == 1)
            return fileItem.getFileItem(name,talkItem.getAvatorURL(),talkItem.getContent(),flag);
        return null;
    }
}
