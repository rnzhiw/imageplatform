<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/11
  Time: 9:19
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


    <title>简单图片管理系统 - 关注的人</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/static/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">

        <c:forEach var="concerner" items="${allConcerners}">
            <input type="hidden" id="id_value" value=${concerner.id}/>
            <div class="col-sm-4" onclick="showDetail(${concerner.id})">
                <div class="contact-box">
                    <%--<a href="profile.html">--%>
                        <div class="col-sm-4">
                            <div class="text-center">
                                <img alt="image" id="image" class="img-circle m-t-xs img-responsive" src="http://q28j7juj8.bkt.clouddn.com/${fn:substring(concerner.address,1 , -1)}">
                                <div class="m-t-xs font-bold">CTO</div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <h3><strong>${concerner.username}</strong></h3>
                            <p><i class="fa fa-map-marker"></i> ${concerner.province}·${concerner.city}</p>
                            <address>
                                <strong>Baidu, Inc.</strong><br>
                                E-mail:${concerner.email}<br>
                                QQ:<a href="">${concerner.QQ}</a><br>
                                <abbr title="Phone">Tel:</abbr> ${concerner.mobile}
                            </address>
                        </div>
                        <div class="clearfix"></div>
                    <%--</a>--%>
                </div>
            </div>
        </c:forEach>

    </div>
</div>

<!-- 全局js -->
<script src="/static/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/js/bootstrap.min.js?v=3.3.6"></script>



<!-- 自定义js -->
<script src="/static/js/content.js?v=1.0.0"></script>



<script>
    $(document).ready(function () {
        $('.contact-box').each(function () {
            animationHover(this, 'pulse');
        });
    });
</script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

<script>
    function showDetail(id) {
        // alert(id);
        $("#id_value").val(id);
        window.location.href = "/system/concerner/getdetail.do?id=" + id;
    }
</script>

<script>
    // $.ajax({
    //     url: "/system/member/getimage.do",
    //     method: "get",
    //     success: function (res) {
    //         res = res.data;
    //         var address = res.address;
    //         address = address.substr(1);
    //         $("#image").attr("src","http://q28j7juj8.bkt.clouddn.com/" + address);
    //     }
    // })
</script>

</body>

</html>
