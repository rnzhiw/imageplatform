<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>简单图片管理系统</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="/static/css/upload.css" rel="stylesheet">
    <link href="/static/js/webuploader/webuploader.css">
    <link href="/static/js/webuploader/Uploader.swf">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改密码</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">请输入新密码：</label>
                            <div class="col-sm-8">
                                <input type="password" id="newpassword1" class="form-control" name="newpassword1" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">请重新输入：</label>
                            <div class="col-sm-8">
                                <input type="password" id="newpassword2" class="form-control" name="newpassword2" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-3">
                                <button class="btn btn-primary" id="sub-btn" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <p class="m-t">欢迎关注本站<a href="http://jqueryvalidation.org/files/demo/" target="_blank"></a>
                    </p>
                    <p>2019.12.11<a href="http://www.w3cschool.cc/jquery/jquery-plugin-validate.html" target="_blank">http://www.w3cschool.cc/jquery/jquery-plugin-validate.html</a>
                    </p>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改头像</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="signupForm">
                        <hr>
                        <div>
                            <ul class="upload-ul clearfix">
                                <li class="upload-pick" id="upload-pick">
                                    <div class="webuploader-container clearfix" id="picker"></div>
                                </li>
                            </ul>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" id="submit" type="submit">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- 全局js -->
<script src="/static/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="/static/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/js/plugins/validate/messages_zh.min.js"></script>

<script src="/static/js/demo/form-validate-demo.js"></script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

<script src="/static/js/jquery-3.4.1.min.js"></script>
<script src="/static/js/webuploader/webuploader.js"></script>
<script src="/static/js/upload2.js"></script>

<script>
    $("#sub-btn").click(function () {
        var newpassword1 = $("#newpassword1").val();
        var newpassword2 = $("#newpassword2").val();
        if(newpassword1 == null || newpassword2 == null || newpassword1 != newpassword2) {
            alert("两次密码输入不一致");
        } else {
            $.ajax({
                url: "/system/changepassword/update.do",
                method: "post",
                async: false,
                data: {
                    newpassword1: newpassword1,
                    newpassword2: newpassword2,
                },
                success: function (res) {
                    alert("密码修改成功");
                }

            })
        }
    })

</script>

</body>

</html>
