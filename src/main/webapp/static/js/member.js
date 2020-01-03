var $table = $("#account_table");
var editTree;
var addTree;

$("#edit_organ").click(function () {
    if ($("#edit_organ_tree").is(":hidden")) {
        $("#edit_organ_tree").show();
    } else {
        $("#edit_organ_tree").hide();
    }
});

$("#add_organ").click(function () {
    if ($("#add_organ_tree").is(":hidden")) {
        $("#add_organ_tree").show();
    } else {
        $("#add_organ_tree").hide();
    }
});
/////////////////////////////////////////////////////////////////
//显示添加账户模态框数据
$('#add_member_btn').click(function () {
    $.ajax({
        url: '/system/organization/list',
        type: 'get',
        success: function (a) {

            a = a.data;

            var array = [];
            var iterator1 = function (treeNodes) {
                if (!treeNodes || !treeNodes.length) return;
                var parent, i = 0, obj = {};
                while (i < treeNodes.length) {
                    var node = treeNodes[i++];
                    obj[node.id] = node;
                    if (node.parentId) {
                        parent = obj[node.parentId];
                        if (parent.children) {
                            parent.children.push(node);
                        } else {
                            parent.children = [node];
                        }
                    } else {
                        array.push(node);
                    }
                }
                return array;
            };

            iterator1(a);

            // 初始化树状图
            addTree = $("#add_organ_tree").tree({
                uiLibrary: 'bootstrap',
                dataSource: array,
                primaryKey: 'id',
                iconsLibrary: 'materialicons',
                textField: "name"
            });

            $("#add_organ_tree").hide();
            addTree.expandAll();

            addTree.on('select', function (e, node, id) {
                $("#add_organ").val(node.children().find("span:last-child").html());
                $("#add_organ").attr('data-id', id);
                $("#add_organ_tree").hide();
            });
        }
    });
});

///////////////////////////////////////////////////////////
//添加账户
$('#do_add_member_btn').click(function () {
    $.ajax({
        url: "/system/member/save",
        type: 'post',
        data: {
            orgId: $("#add_organ").attr("data-id"),
            realName: $("#add_name").val(),
            gender: $("#add_gender").val(),
            email: $("#add_account").val(),
            phone: $("#add_phone").val(),
            roleIds: $("#add_role").val().toString(),
        },
        success: function (res) {
            if (res.success) {
                $("#add_member_modal").modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
            }
        },
        error: function () {
            alert("编辑失败!");
        }
    });
});

//模态框隐藏事件
$('#add_member_modal').on('hidden.bs.modal', function () {
    $("#add_organ").val("");
    $("#add_name").val("");
    $("#add_gender").val("");
    $("#add_account").val("");
    $("#add_phone").val("");
    $("#add_role").selectpicker('deselectAll');
    addTree.destroy();
});

////////////////////////////////////////////////////
//显示编辑成员模态框数据
function openMemberEditModel(id) {
    $.ajax({
        url: "/system/member/get?id=" + id,
        type: "get",
        success: function (res) {

            res = res.data;

            $("#edit_member_modal").modal("show");

            $("#member_edit_id").val(res.id);
            $("#edit_organ").val(res.orgName);
            $("#edit_organ").attr('data-id', res.orgId);
            $("#edit_name").val(res.realName);
            $("#edit_gender").val(res.gender);
            $("#edit_phone").val(res.phone);
            $("#edit_role").val(res.roleIds);
            $("#edit_role").selectpicker('refresh');
            $('#edit_role').selectpicker('render');

            $.ajax({
                url: '/system/organization/list',
                type: 'get',
                success: function (a) {

                    a = a.data;

                    var array = [];
                    var iterator1 = function (treeNodes) {
                        if (!treeNodes || !treeNodes.length) return;
                        var parent, i = 0, obj = {};
                        while (i < treeNodes.length) {
                            var node = treeNodes[i++];
                            obj[node.id] = node;
                            if (node.parentId) {
                                parent = obj[node.parentId];
                                if (parent.children) {
                                    parent.children.push(node);
                                } else {
                                    parent.children = [node];
                                }
                            } else {
                                array.push(node);
                            }
                        }
                        return array;
                    };

                    iterator1(a);

                    // 初始化树状图
                    editTree = $("#edit_organ_tree").tree({
                        uiLibrary: 'bootstrap',
                        dataSource: array,
                        primaryKey: 'id',
                        iconsLibrary: 'materialicons',
                        textField: "name"
                    });

                    $("#edit_organ_tree").hide();
                    editTree.expandAll();

                    editTree.on('select', function (e, node, id) {
                        $("#edit_organ").val(node.children().find("span:last-child").html());
                        $("#edit_organ").attr('data-id', id);
                        $("#edit_organ_tree").hide();
                    });
                }
            });

        }
    });
}

///////////////////////////////////////////////////////////////////////
//编辑成员
$('#do_edit_member_btn').click(function () {

    $.ajax({
        url: "/system/member/update",
        type: 'post',
        data: {
            id: $("#member_edit_id").val(),
            orgId: $("#edit_organ").attr("data-id"),
            realName: $("#edit_name").val(),
            gender: $("#edit_gender").val(),
            phone: $("#edit_phone").val(),
            roleIds: $("#edit_role").val().toString(),
        },
        success: function (res) {
            if (res.success) {
                $("#edit_member_modal").modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
            }
        },
        error: function () {
            alert("编辑失败!");
        }
    });
});

///////////////////////////////////////////////////////////
//成员删除
function memberDelete(id) {
    $('#delete_member_modal').modal("show");
    $('#delete_member_id').val(id);
}

$('#do_delete_member_btn').click(function () {
    $.ajax({
        url: "/system/member/delete",
        type: "post",
        data: {
            id: $("#delete_member_id").val()
        },
        success: function (res) {
            if (res.success) {
                $("#delete_member_modal").modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
                $("#delete_member_modal").modal("hide");
            }
        }
    });
});
////////////////////////////////////////////////////////
//列出成员
$(function () {
    $table.bootstrapTable({
        url: '/system/member/list',
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
                field: 'realName',
                title: '姓名',
                align: 'center'
            },
            {
                field: 'phone',
                title: '登录账号',
                align: 'center'
            },
            {
                field: 'orgName',
                title: '所属组织',
                align: 'center'
            },
            {
                field: 'roleNames',
                title: '角色',
                align: 'center'
            },
            {
                field: 'regTime',
                title: '创建时间',
                align: 'center'
            }, {
                field: 'email',
                title: '电子邮箱',
                align: 'center'
            },
            {
                field: 'status',
                title: '状态',
                align: 'center',
                formatter: function (value) {
                    if (value == 1) {
                        return "正常";
                    } else if (value == 0) {
                        return "待审核"
                    } else if (value == 0) {
                        return "已删除"
                    }
                }
            },
            {
                field: 'explain',
                title: '操作',
                align: 'center',
                formatter: function (value, row, index) {
                    return "<a type='button' onclick='openMemberEditModel(" + row.id + ")' class='btn common-btn'>编辑</a>" +
                        "<a type='button' onclick='memberDelete(" + row.id + ")' class='btn common-btn' >删除</a>"
                }
            }
        ]
    });

    // $table.bootstrapTable('resetView', {
    //     height: $(window).height() - 155
    // });

    // // $(window).resize(function () {
    // //     　　$table.bootstrapTable('resetView');
    // // });

    // $(window).resize(function () {
    //     // console.log("innerHeight:"+$(window).innerHeight());
    //     // console.log("height:"+$(window).height());
    //     $table.bootstrapTable('resetView', {
    //         height: $(window).height() - 155
    //     });
    // });

    $('.selectpicker').selectpicker('refresh');
})

$('#search_member_btn').click(function () {
    $table.bootstrapTable('refresh', {
        url: "/system/member/search",
        pageNumber: 1,
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                sort: params.sort,
                sortOrder: params.order,
                account: $("#search_member_text").val(),
                realName: $("#search_name_text").val(),
                orgId: $("#search_organization_text").val()
            }
        }
    })
})
// $(document).ready( function (){
//     $(".fixed-table-container").css({height:$(window).innerHeight()-285});
//     console.log($(window).innerHeight());
//  })