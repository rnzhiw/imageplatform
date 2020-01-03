<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/16
  Time: 9:43
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
    <link href="/static/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="/static/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/static/css/ready.css" rel="stylesheet">
    <link href="/static/css/bootstrap-table.css">
    <link href="/static/css/bootstrap-select.min.css">
    <link href="/static/css/member.css">
    <link href="/static/css/member.css">


</head>

<body class="gray-bg">
<!--元素布局-->
<div class="content">
    <div class="search-bar" style="height: 30px;">

    </div>
    <table style="margin-left: 50px;" id="account_table" class="table table-striped table_list"></table>
</div>

<%-- 移除黑名单模态框 --%>
<div class="modal fade" id="delete_black_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalDelete">删除黑名单</h4>
            </div>
            <div class="modal-body">
                确定要移除黑名单吗？
                <input type="hidden" id="delete_black_id">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_delete_black_btn">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 全局js -->
<script src="/static/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="/static/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="/static/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/js/plugins/validate/messages_zh.min.js"></script>

<script src="/static/js/demo/form-validate-demo.js"></script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

<script src="/static/js/bootstrap-table.js"></script>
<script src="/static/js/bootstrap-table-zh-CN.js"></script>
<script src="/static/js/bootstrap-select.min.js"></script>
<script src="/static/js/defaults-zh_CN.min.js"></script>
<%--<script src="/static/js/member.js"></script>--%>

<%-- 列出所有用户 --%>
<script>
    var $table = $("#account_table");
    var editTree;
    var addTree;


    //移出黑名单（弹出模态框）
    function blackDelete(id) {
        $('#delete_black_modal').modal("show");
        $('#delete_black_id').val(id);
    }

    //移出黑明单（事件处理）
    $('#do_delete_black_btn').click(function () {
        $.ajax({
            url: "/system/black/delete.do",
            type: "post",
            data: {
                id: $("#delete_black_id").val()
            },
            success: function (res) {
                $("#delete_black_modal").modal("hide");
                $table.bootstrapTable('refresh');
            }
        });
    });

    //加载时渲染表格
    $(function () {
        $table.bootstrapTable({
            url: '/system/black/list.do',
            striped: true,
            idField: 'id',
            // toolbar: '#toolbar',
            sidePagination: 'server',
            pagination: true,
            pageNumber: 1,
            pageSize: 10,
            paginationVAlign: 'bottom',
            paginationHAlign: 'right',
            paginationDetailHAlign: 'left',
            paginationPreText: '上一页',
            paginationNextText: '下一页',
            queryParams: function (params) {
                return {
                    pageSize: params.limit,
                    pageNum: params.offset / params.limit + 1,
                    sort: params.sort,
                    sortOrder: params.order
                }
            },
            responseHandler: function (res) {
                return {
                    total: res.data.total,
                    rows: res.data.list
                };
            },
            columns: [
                {
                    field: 'username',
                    title: '姓名',
                    align: 'center'
                },
                {
                    field: 'province',
                    title: '来源地',
                    align: 'center'
                }, {
                    field: 'email',
                    title: '电子邮箱',
                    align: 'center'
                },
                {
                    field: 'explain',
                    title: '操作',
                    align: 'left',
                    formatter: function (value, row, index) {
                        return "<a type='button' onclick='blackDelete(" + row.id + ")' class='btn common-btn' >移除黑名单</a>"
                    }
                }
            ]
        });

        $table.bootstrapTable('resetView', {
            height: $(window).height() - 155
        });

        // $(window).resize(function () {
        //     　　$table.bootstrapTable('resetView');
        // });

        $(window).resize(function () {
            // console.log("innerHeight:"+$(window).innerHeight());
            // console.log("height:"+$(window).height());
            $table.bootstrapTable('resetView', {
                height: $(window).height() - 155
            });
        });

        $('.selectpicker').selectpicker('refresh');
    })
</script>

</body>

</html>

