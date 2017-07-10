var REQ = {};

// 发送登录请求
REQ.login = function(name, pass, cb) {
    $.ajax({
        type: 'POST',
        url: 'Login',
        dataType: 'json',
        data: {
            'username': name,
            'userpass': pass
        },
        success: function(res) {
            typeof cb === 'function' && cb(res);
        },
        error: function(xhr, textStatus, errThrow) {
            console.log('登录ajax失败！', errThrow);
        },
        async: true
    });
};

// 上传图片
REQ.upload = function(base64, cb) {
    $.ajax({
        type: 'POST',
        url: 'UploadPicture',
        dataType: 'json',
        data: {
            'introImg': base64
        },
        success: function(res) {
            typeof cb == 'function' && cb(res);
        },
        error: function(xhr, textStatus, errThrow) {
            console.log('图片上传ajax失败', errThrow);
        },
        async: true
    });
};

// 介绍信提交
REQ.submitIntro = function(jsonObj, cb) {
    $.ajax({
        type: 'POST',
        url: 'WriteLetter',
        dataType: 'json',
        data: jsonObj,
        success: function(res) {
            typeof cb == 'function' && cb(res);
        },
        error: function(xhr, textStatus, errThrow) {
            console.log('介绍信ajax失败', errThrow);
        },
        async: true
    });
}

// 查看个人信息
REQ.getPersonalInfo = function(username, cb) {
    $.ajax({
        type: 'POST',
        url: 'ShowInfo',
        dataType: 'json',
        data: {
            "username":username
        },
        success: function(res) {
            typeof cb == 'function' && cb(res);
        },
        error: function(xhr, textStatus, errThrow) {
            console.log('个人信息ajax失败', errThrow);
        },
        async: true
    });
}