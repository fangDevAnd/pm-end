
模块

文件上传（包括文件下载）　　

安全认证

邮件模块

短信模块

角色模块

视频截图模块

异常处理模块

maven　多模块的包管理工具

```
maven父工程
|==pom.xml(依赖所有的子工程)　
|   |== <dependency></dependency>
|       <module>service-cron</module>       
|        
|==service-base 基础库，管理相关依赖
|   |==pom.xml
|==service-upload　业务基础库，文件上传
|　 |==pom.xml
|==service-exception 异常处理库,
|   |==pom.xml
|==service-mail 邮件库    
     
```



