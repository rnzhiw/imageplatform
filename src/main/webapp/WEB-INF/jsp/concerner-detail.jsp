<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>简单图片管理系统 - 关注的用户详情页面</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/static/js/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

<%-- 关注的人的信息资料 --%>
<input type="hidden" id="id_value" value="${id}"/>

<div class="wrapper wrapper-content">
    <div class="row animated fadeInRight">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>个人资料</h5>
                </div>
                <div>
                    <div class="ibox-content no-padding border-left-right text-center">
                        <img id="image" alt="image" class="img-responsive; text-center" src="">
                    </div>
                    <div class="ibox-content profile-content">
                        <h4><strong><span id="username"></span></strong></h4>
                        <p><i class="fa fa-map-marker"></i> <span id="province"></span>&nbsp;&nbsp;<span id="city"></span> </p>
                        <h5>
                            关于我
                        </h5>
                        <p>
                            会点前端技术，div+css啊，jQuery之类的，不是很精；热爱生活，热爱互联网，热爱新技术；有一个小的团队，在不断的寻求新的突破。
                        </p>
                        <div class="row m-t-lg">
                            <div class="col-sm-4">
                                <span class="bar">5,3,9,6,5,9,7,3,5,2</span>
                                <h5><strong><span id="pictureSize"></span></strong> 图片</h5>
                            </div>
                            <div class="col-sm-4">
                                <span class="line">5,3,9,6,5,9,7,3,5,2</span>
                                <h5><strong><span id="conernerSize"></span></strong> 关注</h5>
                            </div>
                            <div class="col-sm-4">
                                <span class="bar">5,3,2,-1,-3,-2,2,3,5,2</span>
                                <h5><strong><span id="concernedSize"></span></strong> 关注者</h5>
                            </div>
                        </div>
                        <div class="user-button">
                            <div class="row">
                                <div class="col-sm-6">
                                    <button type="button" id="concernButton" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> <span id="showconcern"></span></button>
                                </div>
                                <div class="col-sm-6">
                                    <button type="button" id="blackButton" class="btn btn-default btn-sm btn-block"><i class="fa fa-coffee"></i> <span id="showblack"></span></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-12">
            <div>
                <form class="form-horizontal m-t" action=""  class="form-horizontal">
                    <div class="form-group col-sm-9">
                        <label class="col-sm-3 control-label">请输入照片名称查询：</label>
                        <div class="col-sm-9">
                            <input type="text" id="fname" class="form-control" name="fname" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <div class="col-sm-4 col-sm-offset-3">
                            <button id="button" class="btn btn-primary" type="button">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>该用户个人空间照片资料</h5>
                </div>
                <div id="images111">
                    <div class="ibox-content" id="images" >
                    </div>
                </div>

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


<!-- Peity -->
<script src="/static/js/plugins/peity/jquery.peity.min.js"></script>

<!-- Peity -->
<script src="/static/js/demo/peity-demo.js"></script>

<!-- Fancy box -->
<script src="/static/js/plugins/fancybox/jquery.fancybox.js"></script>

<script>
    $(document).ready(function () {
        $('.fancybox').fancybox({
            openEffect: 'none',
            closeEffect: 'none'
        });
    });
</script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

<script>
    $("#button").click(function () {
        var id = $("#id_value").val();
        var fname = $("#fname").val();
        // alert("111" + id + fname);
        if(fname == null) {
            alert("请先填入照片名称");
        } else {
            $.ajax({
                url: "/system/concerner/searchconcernpicture.do",
                method: "get",
                data: {
                    id: id,
                    fname: fname
                },
                success: function (res) {
                    $("#images").html("");
                    res = res.data;
                    var length = res.length;
                    for(var i = 0;i < length;i++) {
                        var address = res[i].address;
                        address = address.substr(1);
                        $("#images").html($("#images").html() + "<a class=\"fancybox\" style=\"width: 266px;height: 266px;\"" +
                            " href=\"http://q28j7juj8.bkt.clouddn.com/" + address + "\" title=\"中国风\">\n" +
                            "                            <img alt=\"image\" src=\"http://q28j7juj8.bkt.clouddn.com/" + address + "\" />\n" +
                            "                        </a>")
                    }
                }
            })
        }
    })
</script>



<%-- 详情页渲染 --%>
<script>
    var username;
    var province;
    var city;
    var pictureSize;
    var conernerSize;
    var concernedSize;
    var imageHashs;
    var email;
    var QQ;
    var mobile;

    $(function () {
        var id = $("#id_value").val();
        // alert(id);

        $.ajax({
            url: "/system/concerner/getpersondetail.do",
            method: "get",
            data: {
                id: id
            },
            success: function (res) {

                //动态渲染当前已关注该用户
                $("#showconcern").html("已关注");
                $("#showblack").html("拉黑");

                res = res.data;
                username = res.username;
                province = res.province;
                city = res.city;
                pictureSize = res.pictureSize;
                conernerSize = res.conernerSize;
                concernedSize = res.concernedSize;
                imageHashs = res.imageHashs;
                var address = res.address;
                address = address.substr(1);
                $("#image").attr("src","http://q28j7juj8.bkt.clouddn.com/" + address);
                $("#username").html(username);
                $("#province").html(province);
                $("#city").html(city);
                $("#pictureSize").html(pictureSize);
                $("#conernerSize").html(conernerSize);
                $("#concernedSize").html(concernedSize);
                for(var i = 0;i < imageHashs.length;i++) {
                        var address1 = imageHashs[i].substr(1);
                        $("#images").html($("#images").html() + "<a class=\"fancybox\" style=\"width: 266px;height: 266px;\"" +
                            " href=\"http://q28j7juj8.bkt.clouddn.com/" + address1 + "\" title=\"中国风\">\n" +
                            "                            <img alt=\"image\" src=\"http://q28j7juj8.bkt.clouddn.com/" + address1 + "\" />\n" +
                            "                        </a>")

                }

            }
        })
    })
</script>

<%-- 点击关注或者取消关注 --%>
<script>
    $("#concernButton").click(function () {
        var id = $("#id_value").val();
        var nowstatus = $("#showconcern").html();
        // alert(nowstatus);

        if(nowstatus == "关注") {
            $.ajax({
                url: "/system/concerner/addConcerner.do",
                method: "post",
                data: {
                    id: id,
                },
                success: function (res) {
                    $("#showconcern").html("已关注");
                }
            })
        } else {
            $.ajax({
                url: "/system/concerner/removeconcerner.do",
                method: "post",
                data: {
                    id: id,
                },
                success: function (res) {
                    var res = res.message;
                    $("#showconcern").html("关注");
                    // alert(res.message);
                }
            })
        }


    })
</script>

<script>
    $("#blackButton").click(function () {
        // alert("111");

        var id = $("#id_value").val();
        var showblack = $("#showblack").html();
        if(showblack == "拉黑") {
            $.ajax({
                url: "/system/black/addblack.do",
                method: "post",
                data: {
                    id: id,
                },
                success: function (res) {
                    $("#showblack").html("已拉黑");
                }
            })
        }


    })
</script>

</body>

</html>

