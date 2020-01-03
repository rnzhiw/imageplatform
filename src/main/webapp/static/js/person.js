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
            load.stop();
            res = res.data;

            var length = res.length;

            for(var i = 0;i < length;i++) {
                var address = res[i].address;
                var fname = res[i].fname;
                var uploadTime = res[i].uploadTime;
                var username = res[i].username;
                var intro = res[i].intro;
                $("#result").html($("result").html() + "<div class=\"ibox-content\">\n" +
                    "                    <div>\n" +
                    "                        <a class=\"fancybox\" href=\"/static/img/p1.jpg\" title=\"中国风\">\n" +
                    "                            <img alt=\"image\" style=\"width: 600px\" src=\"/http://q28j7juj8.bkt.clouddn.com/" + address + "\" />\n" +
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
                    "                                <button type=\"button\" class=\"btn btn-primary btn-sm\">删除该图片</button>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <hr>")
            }
        }
    })
}
