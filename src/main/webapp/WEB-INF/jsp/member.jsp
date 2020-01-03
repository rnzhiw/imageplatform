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
    <div class="search-bar">
        <%-- 添加账号 --%>
        <form class="form-inline">
            <div class="form-group col-sm-1" style="margin-top: 30px">
                <div class="col-sm-4 col-sm-offset-3">
                    <button class="btn btn-primary" id="add_member_btn" type="button">添加账号</button>
                </div>
            </div>
        </form>
    </div>
    <table style="margin-left: 50px;" id="account_table" class="table table-striped table_list"></table>
</div>

<%-- 新增用户模态框 --%>
<div class="modal fade" id="add_member_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增系统用户</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_account" class="col-sm-2 control-label">登录账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_account">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_province" class="col-sm-2 control-label">来源地</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_province">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电子邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="add_email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户角色</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="add_role">
                                <option value="2">用户</option>
                                <option value="1">管理员</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_add_member_btn">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<%--<#-- 编辑用户模态框 -->--%>
<div class="modal fade" id="edit_member_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabelEdit">编辑用户</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <input type="hidden" id="member_edit_id">
                        <label for="edit_name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit_account" class="col-sm-2 control-label">登录账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_account">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_province" class="col-sm-2 control-label">来源地</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_province">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">电子邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="edit_email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户角色</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="edit_role">
                                <option value="2">用户</option>
                                <option value="1">管理员</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn"  id="do_edit_member_btn">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<%--<#-- 删除用户模态框 -->--%>
<div class="modal fade" id="delete_member_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalDelete">删除账户</h4>
            </div>
            <div class="modal-body">
                确定要删除吗？
                <input type="hidden" id="delete_member_id">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_delete_member_btn">删除</button>
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

    //弹出资源添加框
    $("#add_member_btn").click(function () {
        $("#add_member_modal").modal("show");
    })

    //添加用户（事件处理）
    $("#do_add_member_btn").click(function () {
        $.ajax({
            url: '/system/member/save.do',
            type: 'post',
            data: {
                name: $("#add_name").val(),
                mobile: $("#add_account").val(),
                province: $("#add_province").val(),
                roleId: $("#add_role").val(),
                email: $("#add_email").val()
            },
            success: function (res) {
                // alert($("#add_role").val());
                $("#add_member_modal").modal("hide");
                $table.bootstrapTable('refresh');
            }
        })
    })

    //编辑用户弹出模态框
    function openMemberEditModel(id) {
        $("#edit_member_modal").modal("show");
        $("#member_edit_id").val(id);
    }

    //编辑用户（事件处理）
    $("#do_edit_member_btn").click(function () {
        $.ajax({
            url: "/system/member/update.do",
            type: "post",
            data: {
                id: $("#member_edit_id").val(),
                name: $("#edit_name").val(),
                mobile: $("#edit_account").val(),
                province: $("#edit_province").val(),
                roleId: $("#edit_role").val(),
                email: $("#edit_email").val()
            },
            success: function (res) {
                $("#edit_member_modal").modal("hide");
                $table.bootstrapTable('refresh');
            }
        })
    })



    //删除用户（弹出模态框）
    function memberDelete(id) {
        $('#delete_member_modal').modal("show");
        $('#delete_member_id').val(id);
    }

    //删除用户（事件处理）
    $('#do_delete_member_btn').click(function () {
        $.ajax({
            url: "/system/member/delete.do",
            type: "post",
            data: {
                id: $("#delete_member_id").val()
            },
            success: function (res) {
                $("#delete_member_modal").modal("hide");
                $table.bootstrapTable('refresh');
            }
        });
    });

    //加载时渲染表格
    $(function () {
        $table.bootstrapTable({
            url: '/system/member/list.do',
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
                    field: 'mobile',
                    title: '登录账号',
                    align: 'center'
                },
                {
                    field: 'roleNames',
                    title: '角色',
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
                    field: 'status',
                    title: '状态',
                    align: 'left',
                    formatter: function (value) {
                        if (value == 1) {
                            return "正常";
                        } else if (value == 0) {
                            return "正常";
                        }
                    }
                },
                {
                    field: 'explain',
                    title: '操作',
                    align: 'left',
                    formatter: function (value, row, index) {
                        return "<a type='button' onclick='openMemberEditModel(" + row.id + ")' class='btn common-btn'>编辑</a>" +
                            "<a type='button' onclick='memberDelete(" + row.id + ")' class='btn common-btn' >删除</a>"
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

