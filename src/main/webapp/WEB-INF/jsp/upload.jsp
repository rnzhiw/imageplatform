<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 表单验证 jQuery Validation</title>
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
                    <h5>照片上传界面</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" id="signupForm">

                        <div class="form-group">
                            <label class="col-sm-3 control-label">照片名称：</label>
                            <div class="col-sm-8">
                                <input id="name" name="name" class="form-control" type="text" aria-required="true" aria-invalid="true" class="error">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">照片标签：</label>
                            <div class="col-sm-8">
                                <input id="tag" name="tag" class="form-control" type="text">
                            </div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">上传图片：</label>
                        </div>
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
<script src="/static/js/upload.js"></script>
<script>
    // alert("图片上传成功");
</script>

</body>

</html>
