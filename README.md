# 1. 创建服务端Server
    ![创建server端AIDL文件](https://github.com/idealcn/AIDLStudy/blob/master/img/img1.png)
   - 创建自定义类型的对象Student,,需要实现Parcelable序列化接口,因为AIDL传递数据类型不支持charsequence.
        并且Student.java与Student.aidl包名一致.
        将Server端创建的Student.java和Student.aidl同时拷贝到客户端,记住,前后包名要一致.