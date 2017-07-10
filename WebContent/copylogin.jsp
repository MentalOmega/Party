




<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<meta name="save" content="history">
<meta name="renderer" content="webkit">
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="/favicon.ico" /> 
<title>广东工业大学教学管理系统</title>
<meta name="keywords" content="广东工业大学教务系统，广东工业大学">
<meta name="description" content="">

<!-- CSS -->
<link rel="stylesheet" href="/styles/css/supersized.css">
<link href="/styles/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/styles/css/login.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="/styles/js/login/html5.js"></script>
<![endif]-->

</head>
<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<img src="/styles/images/customize/logo_school1.png" >
			</div>
			
			<div class="login_form">
				<form action="" id="login_form" method="post">
					<div class="form-group">
						<label for="j_username" class="t">账　号：</label> 
						<input id="account" value="" name="account" type="text" class="form-control x319 in" 
						autocomplete="off" placeholder="请输入学号或工号">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password" value="" name="password" type="password" 
						class="password form-control x319 in" placeholder="请输入密码">
					</div>
					<div class="form-group" id="verifyDiv" style="display:none;">
						<label for="j_captcha" class="t">验证码：</label>
						 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in" placeholder="请输入验证码">
						<img id="captcha_img" alt="点击更换" title="点击更换" src="" onClick="changeVerifyCode(this)" class="j_captcha m" >
					</div>
					<div class="form-group">
						<label class="t"></label>
						<a href="javascript:;" onClick="showFetch();">忘记密码</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
					</div>
<!-- 					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
						<input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
					</div> -->
					<div class="form-group space">
						<label class="t"></label>　　　
<!-- 						<button type="button"  id="submit_btn"  -->
<!-- 						class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp; </button> -->
						<input type="submit" value="登  录" class="btn btn-primary btn-lg" id="submit_btn">
						&nbsp;&nbsp;&nbsp;&nbsp;
						在线人数：<font id="online"></font>
					</div>
				</form>
			</div>
		</div>
		<div class="bottom">Copyright &copy; 2015&nbsp;&nbsp;&nbsp; 
			
			<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=3472199170&site=qq&menu=yes"><img border="0" src="/styles/images/qq1.png" alt="在线咨询" title="在线咨询"/></a>
			
	</div>
</div>
</div>


<!-- Javascript -->
<script type="text/javascript" src="/styles/js/jquery-1.8.0.min.js"></script>
<script src="/styles/js/login/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="/styles/layer/layer.min.js"></script>
<script type="text/javascript" src="/styles/js/login/login.js"></script>

<script type="text/javascript">
if (self != top) {
	top.location = "/";
};
$(function() {
	if(''!=''){
		  layer.alert("", 8); 
	  }
	  
	  if(!isOK()){
		  layer.alert("您的浏览器版本过低,可能会导致部分功能异常,建议使用chrome浏览器或升级到更高版本!", 8); 
		}
		 
    //请求验证码
//     changeVerifyCode();
    isNeedVerify();
    
    //阻止登陆事件
    $("#login_form").bind("submit", function(e){
  	  e.preventDefault();
//   	    return false;  //也可以用e.preventDefault(); 
  	});

    //获取在线人数
    $.get(
    	"login!getOnlineCount.action",
    	function(data) {
    		$("#online").text(data);
    	},
    	"text"
    );
});


//检查浏览器是否满足要求
function isOK() {
	if ( $.browser.msie ) {
		    var bResult = document.implementation.hasFeature("org.w3c.svg", "1.0");
		    if(parseInt($.browser.version, 10) <= 7 && !bResult){
		        return false;
		    }
		}
	
	return true;
}

function isNeedVerify(){
    //判断是否显示验证码
    $.ajax({
    	url:'/login!isNeedVerify.action',
    	cache:false,
    	dataType:'text',
    	success:function(data) {
    		if(data == "1") {
            	changeVerifyCode();
            	$('.login_box').css("padding-top","0");
            	
                $verify_inpunt = $('#verifyDiv');
                if ($verify_inpunt.css('display') == 'none')
                    $verify_inpunt.show();

            }
    	}
    });

}

var currentTime = ''; //定义全局方便验证码同步
function changeVerifyCode(obj){
    currentTime = new Date().getTime();  
    if(obj)
	    obj.src = "/yzm?d=" + currentTime;  
    else
    	$("img.j_captcha").attr("src","/yzm?d=" + currentTime);
}

function showFetch(){
	$.layer({
	    type: 1,   //0-4的选择,（1代表page层）
	    area: ['500px', '300px'],
	    //shade: [0],  //不显示遮罩
	    border: [0], //不显示边框
	    title: [
	        '找回密码',
	        'border:none; background:#CAE1FF; color:#000;' 
	    ],
	    bgcolor: '#eee', //设置层背景色
	    page: {
	        html: '<div class="findMM" ><table>'
	        	+'<tr><td class="label">账号：</td><td><input type="text" id="f_account" value="" class="login_I" tabIndex="1" placeholder="请输入账号"></td></tr>'
	        	+'<tr><td class="label">凭据：</td><td><input type="text" id="f_mmtip" value="" class="login_I" tabIndex="2" placeholder="请输入凭据"></td></tr>'
	        	+'<tr><td class="label">验证码：</td><td><input id="f_verifycode" class="login_I verifycode" tabIndex="3"  value=""  type="text" maxlength=4 placeholder="请输入验证码">'
                +'<img src="yzm?d='+currentTime+'" class="j_captcha verifytxt" onClick="changeVerifyCode()"/></td></tr>'
	        	+'</table>凭据默认我身份证号或护照号<input type="button" onclick="fetch();" value="找回" class="btn btn-primary btn-lg" style="float:right;"></div>'
	    }
	}); 
}
function fetch(){
  
  var account = $("#f_account").val();
  var verifycode = $("#f_verifycode").val();
  var mmtip = $("#f_mmtip").val();
  
  if (account == "" ){
	  layer.msg('请输入账号！',1);	
	$('#f_account').focus();
    return false;
  }
  
  if (mmtip == "" ){
	layer.msg('请输入您的密码找回凭据(在个人基本信息中设定)!',1);	
	$('#f_mmtip').focus();
    return false;
  }
	
  if(verifycode == ""){
	  layer.msg('请输入验证码！',1);
	$('#f_verifycode').focus();
    return false;
  }
  
  var l_index = layer.load('处理中...');
  $.ajax({
		url:"/login!fetchMm.action",
		type:"POST",
		data:{
			account:account,
			mmtip:mmtip,
			verifycode:verifycode
		},
		dataType:"json",
		complete:function(){
			layer.close(l_index);
		},
		success:function(result){
			if(result.status == 'y'){//成功
				layer.alert("密码重置成功："+result.msg+"，<br>登陆后请尽快修改",7,function(){layer.closeAll();});
			}else{//失败
				changeVerifyCode();
				layer.alert(result.msg);
			}
		},
		error:function(){
			layer.alert("登录超时，请稍后重试！");
		}
	});
}
</script>
</body>
</html>