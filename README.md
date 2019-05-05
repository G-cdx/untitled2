# untitled2

*直接在客户端执行new Main().go(args);即可

*相关接口都在myChatClient\api包下

*登录功能暂时被我取消了，在myChatClient\api下的InitUtil类中添加初始化信息即可，包括个人信息和好友信息。

*发送信息接口都在myChatClient\api下的SendAPI,你在里面对应方法里添加发送即可

*接收信息处理都在myChatClient\api下的AcceptAPI,直接new然后调用对应的信息处理方法
