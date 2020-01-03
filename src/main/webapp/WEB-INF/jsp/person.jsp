<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link href="/static/js/webuploader/webuploader.css">
    <link href="/static/js/webuploader/Uploader.swf">

</head>

<body class="gray-bg">

<%-- 关注的人的信息资料 --%>
<input type="hidden" id="type" value="${type}"/>

<div class="wrapper wrapper-content">
    <div class="row animated fadeInRight">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>个人资料</h5>
                </div>
                <div>
                    <div class="ibox-content no-padding border-left-right text-center">
                        <img id="image" alt="image" class="img-responsive; text-center" src="/static/img/a7.jpg">
                    </div>
                    <div class="ibox-content profile-content">
                        <h4><strong>${user.username}</strong></h4>
                        <p><i class="fa fa-map-marker"></i> ${user.province}&nbsp;&nbsp;${user.city}</p>
                        <h5>
                            关于我
                        </h5>
                        <p>
                            会点前端技术，div+css啊，jQuery之类的，不是很精；热爱生活，热爱互联网，热爱新技术；有一个小的团队，在不断的寻求新的突破。
                        </p>
                        <div class="row m-t-lg">
                            <div class="col-sm-4">
                                <span class="bar">5,3,9,6,5,9,7,3,5,2</span>
                                <h5><strong>${user.pictureSize}</strong> 图片</h5>
                            </div>
                            <div class="col-sm-4">
                                <span class="line">5,3,9,6,5,9,7,3,5,2</span>
                                <h5><strong>${user.conernerSize}</strong> 关注</h5>
                            </div>
                            <div class="col-sm-4">
                                <span class="bar">5,3,2,-1,-3,-2,2,3,5,2</span>
                                <h5><strong>${user.concernedSize}</strong> 关注者</h5>
                            </div>
                        </div>
                        <div class="user-button">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="/system/changepassword.do" type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> 修改密码</a>
                                </div>
                                <div class="col-sm-6">
                                    <a href="/system/modifyperson.do" type="button"  class="btn btn-default btn-sm btn-block"><i class="fa fa-coffee"></i> 修改个人信息</a>
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
                    <div class="form-group col-sm-2">
                        <div class="col-sm-4 col-sm-offset-3">
                            <button class="btn btn-primary" id="searchall" type="button">查看所有照片</button>
                        </div>
                    </div>
                    <div class="form-group col-sm-8">
                        <label class="col-sm-3 control-label">请输入照片名称查询：</label>
                        <div class="col-sm-9">
                            <input type="text" id="fname" class="form-control" name="fname" required="" aria-required="true">
                        </div>
                    </div>
                    <div class="form-group col-sm-2">
                        <div class="col-sm-4 col-sm-offset-3">
                            <button class="btn btn-primary" id="button" type="button">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="col-sm-12">
            <div class="ibox-content">
                <div class="ibox-title">
                    <h5>用户照片</h5>
                </div>
                <div class="ibox-content">
                    <div id="result"
                         style=" text-align: center;">
                        <c:forEach var="pictureDTO" items="${pictureDTOS}">
                            <div>
                                <a class="fancybox" href="http://q28j7juj8.bkt.clouddn.com/${fn:substring(pictureDTO.address,1 , -1)}" title="中国风">
                                    <img alt="image" style="width: 600px;height: 300px;" src="http://q28j7juj8.bkt.clouddn.com/${fn:substring(pictureDTO.address,1 , -1)}" />
                                </a>
                                <%--<input type="hidden" id="id_value" value="${pictureDTO.userId}">--%>
                                <input type="hidden" id="picture_id" value="${pictureDTO.id}">
                                <div style="display: inline-block;padding-left: 150px;padding-top: 50px;" class="text-center">
                                    <div>
                                        <h3 style="text-overflow: ellipsis">照片名称：${pictureDTO.fname}</h3>
                                    </div>
                                    <div>
                                        <h3 style="text-overflow: ellipsis">上传时间：<fmt:formatDate value='${pictureDTO.uploadTime}'></fmt:formatDate> </h3>
                                    </div>
                                    <div>
                                        <a type="button" onclick="showPerson(${pictureDTO.userId})" style="text-overflow: ellipsis">上传人：${pictureDTO.username}</a>
                                    </div>
                                    <div>
                                        <h3 style="text-overflow: ellipsis">图片简介：${pictureDTO.intro}</h3>
                                    </div>
                                    <div style="padding-top: 20px">
                                        <button type="button" onclick="pictureDelete(${pictureDTO.id})" id="deletebutton" class="btn btn-primary btn-sm">删除该图片</button>
                                    </div>
                                </div>
                                    <%--<a href="http://q28j7juj8.bkt.clouddn.com/${fn:substring(pictureDTO.address,1 , -1)}">123</a>--%>
                            </div>
                            <hr>
                        </c:forEach>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
    </div>

</div>
</div>

<%--<#-- 删除用户模态框 -->--%>
<div class="modal fade" id="delete_picture_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalDelete">删除图片</h4>
            </div>
            <div class="modal-body">
                确定要删除吗？
                <input type="hidden" id="delete_picture_id">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_delete_picture_btn">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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

<script src="/static/js/webuploader/webuploader.js"></script>
<script src="/static/js/upload.js"></script>
<%--<script src="/static/js/person.js"></script>--%>

<script>
    $("#button").click(function () {
        var fname = $("#fname").val();
        if(fname == null) {
            alert("请输入图片名称");
        } else {
            $.ajax({
                url: "/system/person/searchoneperson.do",
                method: "get",
                data: {
                    fname: fname
                },
                success: function (res) {
                    $("#result").html("");
                    res = res.data;

                    var length = res.length;

                    for(var i = 0;i < length;i++) {
                        var address = res[i].address;
                        var fname = res[i].fname;
                        var uploadTime = res[i].uploadTime.toString();
                        var username = res[i].username;
                        var intro = res[i].intro;
                        var pictureId = res[i].id;
                        // var useraddress = res[i].userAddress;
                        address = address.substr(1);
                        // useraddress = useraddress.substr(1);
                        // $("#image").attr("src","http://q28j7juj8.bkt.clouddn.com/" + useraddress);
                        $("#result").html($("#result").html() +
                            "                    <div>\n" +
                            "                        <a class=\"fancybox\" href=\"http://q28j7juj8.bkt.clouddn.com/" + address + "\" title=\"中国风\">\n" +
                            "                            <img alt=\"image\" style=\"width: 600px;height: 300px;\" src=\"http://q28j7juj8.bkt.clouddn.com/" + address + "\" />\n" +
                            "                        </a>\n" +
                            "                        <div style=\"display: inline-block;padding-left: 150px;padding-top: 50px;\" class=\"text-center\">\n" +
                            "                            <div>\n" +
                            "                                <h3 style=\"text-overflow: ellipsis\">照片名称：" +fname + "</h3>\n" +
                            "                            </div>\n" +
                            "                            <div>\n" +
                            "                                <h3 style=\"text-overflow: ellipsis\">上传时间：" + uploadTime + "</h3>\n" +
                            "                            </div>\n" +
                            "                            <div>\n" +
                            "                                <h3 style=\"text-overflow: ellipsis\">上传人：" + username + "</h3>\n" +
                            "                            </div>\n" +
                            "                            <div>\n" +
                            "                                <h3 style=\"text-overflow: ellipsis\">图片简介：" + intro + "</h3>\n" +
                            "                            </div>\n" +
                            "                            <div style=\"padding-top: 20px\">\n" +
                            "                                <button type=\"button\" onclick=\"pictureDelete(" + pictureId + ")\"  class=\"btn btn-primary btn-sm\">删除该图片</button>\n" +
                            "                            </div>\n" +
                            "                        </div>\n" +
                            "                    </div>\n" +
                            "                    <hr>")
                    }
                }
            })
        }
    })
</script>

<script>
    var pageNum = 1;

    $("#searchall").click(function () {
        dosearch();
    })

    function resetSearch() {
        pageNum = 1;
        $("#result").html("");
    }

    function dosearch() {
        // var load = new Loading();
        // load.init();
        // load.start();

        $.ajax({
            url: "/system/person/search.do",
            method: "get",
            success: function (res) {
                // load.stop();
                res = res.data;

                var length = res.length;

                for(var i = 0;i < length;i++) {
                    var address = res[i].address;
                    var fname = res[i].fname;
                    var uploadTime = res[i].uploadTime;
                    var username = res[i].username;
                    var intro = res[i].intro;
                    address = address.substr(1);

                    var pictureId = res[i].id;

                    $("#result").html($("#result").html() +
                        "                    <div>\n" + "<input type=\"hidden\" id=\"type\" value=\"pictureId\"/>" +
                        "                        <a class=\"fancybox\" href=\"http://q28j7juj8.bkt.clouddn.com/" + address + "\" title=\"中国风\">\n" +
                        "                            <img alt=\"image\" style=\"width: 600px;height: 300px;\" src=\"http://q28j7juj8.bkt.clouddn.com/" + address + "\" />\n" +
                        "                        </a>\n" +
                        "                        <div style=\"display: inline-block;padding-left: 150px;padding-top: 50px;\" class=\"text-center\">\n" +
                        "                            <div>\n" +
                        "                                <h3 style=\"text-overflow: ellipsis\">照片名称：" +fname + "</h3>\n" +
                        "                            </div>\n" +
                        "                            <div>\n" +
                        "                                <h3 style=\"text-overflow: ellipsis\">上传时间：" + uploadTime + "</h3>\n" +
                        "                            </div>\n" +
                        "                            <div>\n" +
                        "                                <h3 style=\"text-overflow: ellipsis\">上传人：" + username + "</h3>\n" +
                        "                            </div>\n" +
                        "                            <div>\n" +
                        "                                <h3 style=\"text-overflow: ellipsis\">图片简介：" + intro + "</h3>\n" +
                        "                            </div>\n" +
                        "                            <div style=\"padding-top: 20px\">\n" +
                        "                                <button type=\"button\" id=\"deletebutton\" class=\"btn btn-primary btn-sm\">删除该图片</button>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                    <hr>")
                }
            }
        })
    }
</script>

<script>
    function showPerson(id) {
        // alert(id);
        $("#id_value").val(id);
        window.location.href = "/system/concerner/getdetail.do?id=" + id;
        console.log(id);
    }
</script>

<script>
    //删除个人照片（弹出模态框）
    function pictureDelete(id) {
        $('#delete_picture_modal').modal("show");
        $('#delete_picture_id').val(id);
        // alert(id);
    }

    //删除个人照片（事件处理）
    $("#do_delete_picture_btn").click(function () {
        $.ajax({
            url: "/system/person/deletepicture.do",
            method: "post",
            data: {
                id: $("#delete_picture_id").val()
            },
            success: function (res) {
                alert("图片删除成功");
                window.location.href="/system/person/list.do";
            }
        })
    })
    
    
</script>

</body>

</html>

