<%--
  Created by IntelliJ IDEA.
  User: 联想
  Date: 2019/12/10
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>简单图片管理系统 - 资源管理</title>

    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

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
    <link href="/static/css/resource.css" rel="stylesheet">
</head>
<body>
<%--元素布局--%>
<div class="content" style="margin-top: 30px">
    <div id="toolbar" class="form-group col-sm-1">
        <div class="col-sm-4 col-sm-offset-3">
            <button class="btn btn-primary" id="add_resource_btn" type="button" data-toggle="modal">添加资源</button>
        </div>
    </div>
    <table style="margin-left: 30px;" id="resource_table" class="table table-striped table_list"></table>
</div>

<%--添加资源 模态框--%>
<div class="modal fade" id="add_resource_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">添加资源</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="add_name" class="col-sm-2 control-label">资源名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="resName" id="add_name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_resource_key" class="col-sm-2 control-label">资源标识</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_resource_key">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add_menu_url" class="col-sm-2 control-label">菜单URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="add_menu_url">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="add_select_status" class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-10">
                            <select class="form-control item" id="add_select_status">
                                <option value="true">可用</option>
                                <option value="false">禁用</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_add_resource_btn">添加</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<%--&lt;%&ndash; 编辑资源 模态框 &ndash;%&gt;--%>
<div class="modal fade" id="edit_resource_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">编辑资源</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资源名称</label>
                        <div class="col-sm-10">
                            <input type="hidden" id="edit_id">
                            <input type="text" class="form-control" name="name" id="edit_name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资源标识</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_resource_key">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">菜单URL</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_menu_url">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-10">
                            <select class="form-control item" id="edit_select_status">
                                <option value="true">可用</option>
                                <option value="false">禁用</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_edit_resource_btn">编辑</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<%--&lt;%&ndash; 删除资源 模态框 &ndash;%&gt;--%>
<div class="modal fade" id="delete_resource_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalDelete">删除资源</h4>
            </div>
            <div class="modal-body">
                确定要删除吗？
                <input type="hidden" id="delete_resource_id">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn cancel-btn" data-dismiss="modal">关闭</button>
                <button type="button" class="btn common-btn" id="do_delete_resource_btn">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 全局js -->
<script src="/static/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="/static/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="/static/js/contabs.js"></script>

<!-- 第三方插件 -->
<script src="/static/js/plugins/pace/pace.min.js"></script>

<script src="/static/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>

<script src="http://cdn.bootcss.com/bootstrap-table/1.9.1/locale/bootstrap-table-zh-CN.min.js"></script>

<script src="/static/js/bootstrap-table.js"></script>
<script src="/static/js/bootstrap-table-zh-CN.js"></script>
<script src="/static/js/bootstrap-select.min.js"></script>
<script src="/static/js/defaults-zh_CN.min.js"></script>
<%--<script src="/static/js/resource.js"></script>--%>

<script>
    var $table = $("#resource_table");
    var addTree;
    var editTree;

     // 弹出资源添加框
    $("#add_resource_btn").click(function () {
        $("#add_resource_modal").modal("show");
    })

    //加载时渲染表格
    $(function () {

        $table.bootstrapTable({
            url: '/system/resource/list.do',
            striped: true,
            toolbar: '#toolbar',
            sidePagination: 'server',
            idField: 'id',
            columns: [
                {
                    field: 'resName',
                    title: '资源名称',
                    formatter: function (data) {
                        return "&nbsp;&nbsp;" + data;
                    }
                }, {
                    field: 'resKey',
                    title: '资源标志',
                    align: 'center'
                }, {
                    field: 'menuUrl',
                    title: '菜单URL',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var div = "<div style='overflow:hidden;text-overflow:ellipsis;white-space:nowrap;'>" + value + "</div>";
                        return div;
                    }
                }, {
                    field: 'status',
                    title: '状态',
                    align: 'center',
                    formatter: function (val, row) {
                        return val ? "可用" : "禁用";
                    }
                }, {
                    field: 'id',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        return "<button type='button' onclick='openEditModal(" + row.id + ")' class='btn common-btn'>编辑</button>" +
                            "<button type='button' onclick='openDeleteModal(" + row.id + ")' class='btn common-btn'>删除</button>"
                    }
                }
            ],

        });

        $table.bootstrapTable('resetView', {
            height: $(window).height() - 155
        });

    });
</script>

<%-- 更新资源（弹出模态框） --%>
<script>
    function openEditModal(id) {
        $("#edit_resource_modal").modal("show");
        $("#edit_id").val(id);
    }
</script>

<%-- 更新资源（事件处理） --%>
<script>
    $("#do_edit_resource_btn").click(function () {
        $.ajax({
            url: '/system/resource/update.do',
            type: 'post',
            data: {
                id: $("#edit_id").val(),
                resName: $("#edit_name").val(),
                resKey: $("#edit_resource_key").val(),
                menuUrl: $("#edit_menu_url").val(),
                status: $("#edit_select_status").val()
            },
            success: function (res) {
                $("#edit_resource_modal").modal("hide");
                $table.bootstrapTable('refresh');
            }
        })
    })
</script>

<%-- 添加资源（弹出模态框）--%>
<script>
    // 弹出资源添加框
    $("#add_resource_btn").click(function () {
        $("#add_resource_modal").modal("show");
        $("#delete_resource_id").val(id);
    })
</script>

<%-- 添加资源（事件处理） --%>
<script>
    $("#do_add_resource_btn").click(function () {
        $.ajax({
            url: '/system/resource/save.do',
            type: 'post',
            data: {
                resName: $("#add_name").val(),
                resKey: $("#add_resource_key").val(),
                menuUrl: $("#add_menu_url").val(),
                status: $("#add_select_status").val()
            },
            success: function (res) {
                $("#add_resource_modal").modal("hide");
                $table.bootstrapTable('refresh');
            }
        })
    })
</script>

<%-- 对资源进行删除的部分 --%>
<script>
    //删除资源部分(弹出模态框）
    function openDeleteModal(id) {

        $("#delete_resource_modal").modal("show");
        $("#delete_resource_id").val(id);
    }
</script>

<%-- 删除资源（事件处理） --%>
<script>
    $("#do_delete_resource_btn").click(function () {
        $.ajax({
            url: '/system/resource/delete.do',
            type: 'post',
            data: {
                id: $("#delete_resource_id").val()
            },
            success: function (res) {
                $("#delete_resource_modal").modal("hide");
                $table.bootstrapTable('refresh');

            }
        })
    })
</script>

</body>
</html>
