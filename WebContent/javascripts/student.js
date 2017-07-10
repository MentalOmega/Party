$(function() {
    var $liList = $('nav ul li'),
        $studentShowDiv = $('.student-show-div'),
        $introLetterDiv = $('.intro-letter-div'),
        $introLetterInputs = $('.intro-letter-div input'),
        $returnReceiptDiv = $('.return-receipt-div'),
        $privateInfoDiv = $('.private-info-div'),
        $introSubmit = $('.intro-submit'),
        $returnSubmit = $('.return-submit'),
        $previewImg = $('.preview-img'),
        $imgInput = $('.img-input');

    // 选项列表点击
    $liList.on('click', function() {
        var $this = $(this),
            $that = $('.' + $(this).attr('class') + '-div');
        if (!$this.hasClass('active')) {
            // 切换下面窗口
            $that.removeClass('hide');
            $that.siblings().addClass('hide');

            // 改变按钮样式
            $this.siblings().removeClass('active');
            $this.addClass('active');

        }

    });
    // 检查有没有没填的，并提示
    $introLetterInputs.on('blur', function() {
        var $this = $(this);
        if ($this.val().trim() == '') {
            $this.parent().next().removeClass('hide');
        }
    });
    $introLetterInputs.on('focus', function() {
        var $this = $(this);
        $this.parent().next().addClass('hide');
    });

    // 介绍信提交
    $introSubmit.on('click', function() {
        var str = '{';
        for (var i = 0, len = $introLetterInputs.length; i < len; i++) {
            var $introLetterInput = $($introLetterInputs[i]),
                inputValue = $introLetterInput.val();
            if (inputValue.trim() == '') {
                alert('不能为空！');
                return;
            } else {
                if (i !== len - 1) { // 不是最后一个
                    str += '"' + $introLetterInput.attr("class") + '":"' + inputValue + '",';
                } else {
                    str += '"' + $introLetterInput.attr("class") + '":"' + inputValue + '"}';
                }
            }
        }

        REQ.submitIntro(JSON.parse(str), function() {
            console.log('介绍信提交返回的信息：', res);
        });
    });


    // 回执提交
    $returnSubmit.on('click', function() {
        if ($imgInput.get(0).files.length === 0) {
            console.log('图片不能为空');
        } else {
            // 上传图片
            REQ.upload($previewImg.attr('src'), function(res) {
                console.log('图片上传结果：' ,res);
            });
        }
    });

    // 预览上传的图片
    $imgInput.on('change', function() {
        handleImg(this.files, $previewImg[0]);
    });

    // 处理预览上传的图片
    function handleImg(files, previewImg) {
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var imageType = /^image\//;

            if (!imageType.test(file.type)) { // 判断是否为图片，不是跳过
                continue;
            }

            var reader = new FileReader();
            reader.onload = (function(aImg) {
                return function(e) {
                    aImg.src = e.target.result; // 将图片路径设置为base64
                };
            })(previewImg);
            reader.readAsDataURL(file);
        }
    }
});
