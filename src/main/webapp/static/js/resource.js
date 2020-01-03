var $table = $("#resource_table");
var addTree;
var editTree;

//列出资源列表
$(function () {
    $table.bootstrapTable({
        url: '/system/resource/list.do',
        striped: true,
        idField: 'id',
        // toolbar: '#toolbar',
        sidePagination: 'server',
        showToggle: true,
        responseHandler: function (res) {
            return res.result;
        },
        columns: [
            {
                field: 'resName',
                title: '资源名称',
                align: 'center',
                formatter: function (data) {
                    return "&nbsp;&nbsp;" + data;
                }
            }, {
                field: 'resKey',
                title: '资源标志',
                align: 'center',
                formatter: function (value) {
                    return value;
                }
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
                    // return val ? "可用" : "禁用";
                    return "可用";
                }
            }, {
                field: 'id',
                title: '操作',
                align: 'center',
                formatter: function (value, row, index) {
                    return "<button type='button' onclick='openEditModal(" + row.id + ")' class='btn default'>编辑</button>" +
                        "<button type='button' onclick='openDeleteModal(" + row.id + ")' class='btn default'>删除</button>"
                }
            }
        ],
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

})



$(window).resize(function () {
    $table.bootstrapTable('resetView', {
        height: $(window).height() - 155,
    });
});

//模态框隐藏事件
// $('#add_resource_modal').on('hidden.bs.modal', function () {
//     $("#add_parent_resource").val("");
//     $("#add_name").val("");
//     $("#add_resource_key").val("");
//     $("#add_select_type").val("FUNCTION");
//     $("#add_menu_url").val("");
//     $("#add_function_urls").val("");
//     $("#add_weight").val("0");
//     $("#add_select_status").val("true");
//     addTree.destroy();
// });


//添加资源

//确认添加按钮
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
});

//////////////////////////////////////////////////////////////////////////////////////////////////////
//编辑资源部分
function openEditModal(id) {

    $("#edit_resource_modal").modal("show");

    $.ajax({

        url: '/system/resource/get.do?id=' + id,
        type: 'get',
        success: function (res) {


            res = res.data;

            $.ajax({
                url: '/system/resource/list.do',
                type: 'get',
                success: function (res) {

                }
            });

            $("#edit_id").val(res.id);
            $("#edit_name").val(res.resName);
            $("#edit_resource_key").val(res.resKey);
            $("#edit_menu_url").val(res.menuUrl);
            $("#edit_select_status").val(res.status + "");
        }
    })
}

//模态框隐藏事件
$('#edit_resource_modal').on('hidden.bs.modal', function () {
    $("#edit_parent_resource").val("");
    $("#edit_name").val("");
    $("#edit_resource_key").val("");
    $("#edit_select_type").val("FUNCTION");
    $("#edit_menu_url").val("");
    $("#edit_function_urls").val("");
    $("#edit_weight").val("0");
    $("#edit_select_status").val("true");
    editTree.destroy();
});

//确认编辑按钮
$("#do_edit_resource_btn").click(function () {
    $.ajax({
        url: '/system/resource/update',
        type: 'post',
        data: {
            id: $("#edit_id").val(),
            parentId: $("#edit_parent_resource").attr("data-id"),
            resName: $("#edit_name").val(),
            resKey: $("#edit_resource_key").val(),
            resType: $("#edit_select_type").val(),
            menuUrl: $("#edit_menu_url").val(),
            funUrls: $("#edit_function_urls").val(),
            weight: $("#edit_weight").val(),
            status: $("#edit_select_status").val()
        },
        success: function (res) {
            if (res.success) {
                $("#edit_resource_modal").modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
                $("#edit_resource_modal").modal("hide");
            }
        }
    })
});

//点击上级资源框，显示下拉树
$("#edit_parent_resource").click(function () {
    if ($("#edit_parent_resource_tree").is(":hidden")) {
        $("#edit_parent_resource_tree").show();
    } else {
        $("#edit_parent_resource_tree").hide();
    }
});

// //////////////////////////////////////////////////////////////////////////////////////////////////////
// //删除资源部分
//
function openDeleteModal(id) {

    $("#delete_resource_modal").modal("show");
    $("#delete_resource_id").val(id);
}



