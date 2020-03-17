
# 图片管理系统

基于Spring+SpringMVC+JPA（Maven方式构建）rnzhiw/imageplatform



## 项目简介

本图片管理系统基于Spring,SpringMVC,JPA，数据库为MySql

前端使用了H+（基于LayUI）模版和bootstrap，界面简单简洁且大方

采用mvc架构，使代码易于管理和修改，合理的注解，使代码通俗易懂，具有较强的阅读性

上传图片采用七牛云+百度WebUploader插件，使得实现CDN快速存储

## 如何使用

```
$ git clone https://github.com/rnzhiw/imageplatform

$ idea配置maven项目，进入edit界面

$ input name imageplatform [clean,jetty:run...]

$ input Command line:clean jetty:run -Djetty.port=8080

$ http://localhost:8080/login.do

$ 需要注意的是我把数据库账号和密码删了，大家clone以后写上自己的数据库哦
```

## 编译环境

```
jdk 1.8
mysql 5.7
Jetty（插件已在pom里配好）
```

## 系统功能：

* 用户：
  * 关注的用户管理
  * 所有照片查看
  * 个人信息管理
  * 提交投诉
  * 查看黑名单
  * 上传图片
  * 修改密码和修改头像
  * 修改个人信息
* 管理员：
  * 用户管理
  * 资源管理
  * 投诉管理

## 完成进度

```
imageplatform_1.0.0版本已经基本完成，已达到一个完整系统的要求
```

## 说明

 	1. 如果项目遇到问题，可以联系我rnzhiw@qq.com
	2. 如果该项目对您有帮助，请star鼓励我

## 七牛云账号注册

```
$ 进入：https://www.qiniu.com/

$ 注册对象存储，免费使用，注册也很方便
```

## 项目截图

![1578036392523](/preview/1.png)

![1578036392523](/preview/2.png)

![1578036392523](/preview/3.png)

![1578036392523](/preview/4.png)

![1578036392523](/preview/5.png)

![1578036392523](/preview/6.png)

![1578036392523](/preview/7.png)

![1578036392523](/preview/8.png)

![1578036392523](/preview/9.png)

![1578036392523](/preview/10.png)

![1578036392523](/preview/11.png)

![1578036392523](/preview/12.png)

![1578036392523](/preview/13.png)

![1578036392523](/preview/14.png)



