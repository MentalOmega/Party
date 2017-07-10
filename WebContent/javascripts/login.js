$(function() {
    var $username = $('.username'),
        $userpass = $('.userpass'),
        $loginBtn = $('.login-btn'),
        $usernameWarn = $('.username-warn');

    $username.on('focus', function() {
        $usernameWarn.addClass('hide');
    });

    $username.on('blur', function() {
        // 学号不正确的情况下
        // if(!XX.isStudentID($(this).val())) {
        //     $usernameWarn.removeClass('hide');
        // }
    });

    $loginBtn.on('click', function() {
        REQ.login($username.val(), $userpass.val(), function(res) {
            // 提交成功后
            console.log('登录成功后：', res);
            if (res.result == 'success') { // 登录成功
                window.location.href = 'Comment/success.jsp';
            }
            else { // 登录失败
                alert('账号或密码不正确');
            }
        });
    });
});
