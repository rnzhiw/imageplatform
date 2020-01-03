<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>简单图片管理系统 - 投诉列表</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">

    <link href="/static/css/page.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight blog">
    <div class="row">

            <c:forEach var="complaint" items="${complaints.list}">
                <div class="ibox">

                    <div class="ibox-content">
                        <input type="hidden" id="id_value" value="${complaint.id}">
                        <a style="display: inline-block" type="button" onclick="showDetail(${complaint.id})" id="seeDetail" class="btn-link">
                            <h2>
                                ${complaint.title}
                            </h2>
                        </a>
                        <div style="float: right">
                            <strong>${complaint.complaintName}</strong> <span class="text-muted"><i class="fa fa-clock-o"></i> 不久前 </span>
                        </div>
                        <p>
                            ${complaint.content}
                        </p>
                        <div class="row">
                            <div class="col-md-6">
                                <h5>标签：</h5>
                                <button class="btn btn-primary btn-xs" type="button">用户投诉</button>
                                <button onclick="complaintDelete(${complaint.id})" id="delete-btn" class="btn btn-white btn-xs" type="button">删除该投诉</button>
                            </div>
                            <div class="col-md-6">

                                <div class="small text-right">

                                    <h5>状态：</h5>
                                    <div> <i class="fa fa-comments-o"> </i> 56 评论 </div>
                                    <i class="fa fa-eye"> </i> 144 浏览
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>
    </div>
</div>

<%-- 删除用户模态框 --%>
<div class="modal fade" id="delete_complaint_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalDelete">删除这条投诉</h4>
            </div>
            <div class="modal-body">
                确定要删除吗？
                <input type="hidden" id="delete_complaint_id">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_delete_complaint_btn">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 全局js -->
<script src="/static/js/jquery.min.js?v=2.1.4"></script>


<!-- 自定义js -->
<script src="/static/js/content.js?v=1.0.0"></script>


<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

<!-- 分页插件 -->
<script src="/static/js/page.js"></script>
<script src="/static/js/bootstrap.min.js?v=3.3.6"></script>

<script>
    function showDetail(id) {
        // alert(id);
        $("#id_value").val(id);
        window.location.href = "/system/complaintmanage/getdetail.do?id=" + id;
    }
</script>

<script>
    //弹出删除投诉模态框
    function complaintDelete(id) {
        $("#delete_complaint_modal").modal("show");
        $("#delete_complaint_id").val(id);
    }

    //处理删除投诉事件
    //删除用户（事件处理）
    $('#do_delete_complaint_btn').click(function () {
        $.ajax({
            url: "/system/complaintmanage/delete.do",
            type: "post",
            data: {
                id: $("#delete_complaint_id").val()
            },
            success: function (res) {
                $("#delete_member_modal").modal("hide");
                alert("删除投诉成功");
                window.location.href="/system/complaintmanage/list.do";
            }
        });
    });


</script>

</body>

</html>

