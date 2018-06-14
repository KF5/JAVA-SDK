KF5  
=====================================
#初始化方法  
    KF5Support kf5Support = new KF5Support();  
    //第一种初始化方式：平台名称，用户邮箱，通信秘钥  
    kf5Support.initWithApiToken("your domain", "username", "api token");  
    //第二种初始化方式：平台名称，用户邮箱，登录密码  
    kf5Support.initWithPassword("your domain", "username", "password");  
#主要接口  
####工单（客服）  
####工单（普通用户）  
####工单回复  
####工单自定义字段  
####工单查看分类  
####用户  
####用户自定义字段  
####客服组  
####公司组织  
####文档分类  
####文档  
####社区话题  
####社区问题  
####附件  
####导入  
####导出


Download
--------

Download [the latest JAR][1] or Maven:
```xml
<dependency>
  <groupId>com.kf5</groupId>
  <artifactId>java-client</artifactId>
  <version>1.0.3</version>
</dependency>
```

License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
    
 [1]: https://search.maven.org/remote_content?g=com.kf5&a=java-client&v=LATEST
