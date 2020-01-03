var imageHashs = {};

$(function () {

    //操作进度条;
    function showDiyProgress(progress, $diyBar, text) {
        if (progress >= 100) {
            progress = progress + '%';
            text = text || '上传完成';
        } else {
            progress = progress + '%';
            text = text || progress;
        }

        var $diyProgress = $diyBar.find('.diyProgress');
        $diyProgress.width(progress).text(text);
    }

    //取消事件;
    function removeLi($li, file_id, webUploader) {
        webUploader.removeFile(file_id);
        $li.remove();
    }

    //创建文件操作div;
    function createBox($fileInput, file, webUploader) {
        var file_id = file.id;
        var $parentFileBox = $fileInput.parents(".upload-ul");

        //添加子容器;
        var li = '<li class="myhover" id="fileBox_' + file_id + '"><div class="viewThumb"><input type="hidden">' +
            '<div class="diyBar"><div class="diyProgress">0%</div></div><p class="diyControl"><span>' +
            '<i></i></span><span class="diyCancel"><i></i></span><span><i></i></span></p></div></li>';

        $parentFileBox.prepend(li);

        var $fileBox = $parentFileBox.find('#fileBox_' + file_id);

        //绑定取消事件;
        $fileBox.find('.diyCancel').one('click', function () {
            removeLi($(this).parents('.myhover'), file_id, webUploader);
            delete (imageHashs[file_id]);
            console.log(imageHashs);
        });

        //生成预览缩略图;
        webUploader.makeThumb(file, function (error, dataSrc) {
            if (!error) {
                $fileBox.find('.viewThumb').append('<img src="' + dataSrc + '" >');
            }
        });
    }

    $.fn.extend({

        diyUpload: function () {

            var $fileInput = $("#picker");
            var option = {
                server: 'https://upload.qiniup.com',
                accept: {
                    title: "Images",
                    extensions: 'gif,jpg,jpeg,bmp,png'
                },
                thumb: {
                    width: 120,
                    height: 90,
                    quality: 100,
                    allowMagnify: true,
                    crop: true,
                    type: "image/jpeg"
                },
                pick: {
                    id: "#picker",
                    label: ""
                },
                method: "POST",
                auto: true
            };

            $.ajax({
                url: '/cloud/uptoken.do',
                async: false,
                success: function (res) {
                    option.formData = {token: res.data};
                }
            });

            var webUploader = new WebUploader.Uploader(option);

            if (!WebUploader.Uploader.support()) {
                alert(' 上传组件不支持您的浏览器！');
                return false;
            }

            //绑定文件加入队列事件;
            webUploader.on('fileQueued', function (file) {
                createBox($fileInput, file, webUploader);
            });

            //进度条事件
            webUploader.on('uploadProgress', function (file, percentage) {
                var $fileBox = $('#fileBox_' + file.id);
                var $diyBar = $fileBox.find('.diyBar');
                $diyBar.show();
                percentage = percentage * 100;
                showDiyProgress(percentage.toFixed(2), $diyBar);
            });

            //全部上传结束后触发;
            webUploader.on('uploadFinished', function () {
                $fileInput.next('.parentFileBox').children('.diyButton').remove();
            });

            //上传成功后触发事件;
            webUploader.on('uploadSuccess', function (file, response) {
                var $fileBox = $('#fileBox_' + file.id);
                var $diyBar = $fileBox.find('.diyBar');
                $fileBox.removeClass('diyUploadHover');
                $diyBar.fadeOut(1000, function () {
                    $fileBox.children('.diySuccess').show();
                });
                imageHashs[file.id] = response.hash;
                console.log(imageHashs);
            });

            //上传失败后触发事件;
            webUploader.on('uploadError', function (file, reason) {
                var $fileBox = $('#fileBox_' + file.id);
                var $diyBar = $fileBox.find('.diyBar');
                showDiyProgress(0, $diyBar, '上传失败!');
            });

            //选择文件错误触发事件;
            webUploader.on('error', function (code) {
                var text = '';
                switch (code) {
                    case  'F_DUPLICATE' :
                        text = '该文件已经被选择了!';
                        break;
                    case  'Q_EXCEED_NUM_LIMIT' :
                        text = '上传文件数量超过限制!';
                        break;
                    case  'F_EXCEED_SIZE' :
                        text = '文件大小超过限制!';
                        break;
                    case  'Q_EXCEED_SIZE_LIMIT' :
                        text = '所有文件总大小超过限制!';
                        break;
                    case 'Q_TYPE_DENIED' :
                        text = '文件类型不正确或者是空文件!';
                        break;
                    default :
                        text = '未知错误!';
                        break;
                }
                alert(text);
            });
            return webUploader;
        }
    });

    //上传图片
    $('#goodsUpload').diyUpload();
    
    $("#submit").click(function () {
        var array = "";
        for (var i in imageHashs) {
            array = array + "," + imageHashs[i]
        }

        console.log(array);

        var name = $("#name").val();
        var tag = $("#tag").val();

        $.ajax({
            url: '/system/upload/add.do',
            method: 'post',
            data: {
                name: name,
                tag: tag,
                imageHashs: array
            },
            success: function (res) {
                alert(res.message);
                location.reload();
            }
        })

    })

});
