<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>简单图片管理系统 - 投诉列表详情</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight article">
    <input type="hidden" id="id_value" value="${id}"/>
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="ibox">
                <div class="ibox-content">
                    <div class="pull-right">
                        <button class="btn btn-white btn-xs" type="button">700BIKE</button>
                        <button class="btn btn-white btn-xs" type="button">BeginOne</button>
                        <button class="btn btn-white btn-xs" type="button">乐视超级自行车</button>
                    </div>
                    <div class="text-center article-title">
                        <h1 id="title">

                        </h1>
                    </div>
                    <p id="content">

                    </p>

                    <hr>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- 全局js -->
<script src="/static/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/js/bootstrap.min.js?v=3.3.6"></script>



<!-- 自定义js -->
<script src="/static/js/content.js?v=1.0.0"></script>


<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

<script>
    var title;
    var content;
    $(function () {
        var id = $("#id_value").val();
        // alert(id);

        $.ajax({
            url: "/system/complaintmanage/getcomplaintdetail.do",
            method: "get",
            data: {
                id: id
            },
            success: function (res) {
                title = res.data.title;
                content = res.data.content;
                $("#title").html(title);
                $("#content").html(content);
            }

        })

    })
</script>

</body>

</html>

