$(function(){

    //让当前表单调用validate方法，实现表单验证功能
    $("#loginSystem").validate({
        debug:true, //调试模式，即使验证成功也不会跳转到目标页面
        rules:{     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
            username:{
                required:true, //必填。如果验证方法不需要参数，则配置为true
                rangelength:[4,12]
                // remote:{
                //     url:"ajax_check.action",
                //     type:"post"
                // }
            },
            password:{
                required:true,
                rangelength:[6,16]
            },
            password2:{
                required:true,
                equalTo:'#userpwd' //表示和id="userpwd"的值相同
            }
        },
        messages:{
            username:{
                required:"请输入用户名",
                rangelength:$.validator.format("用户名长度为{0}-{1}个字符")
                // remote:"该用户名已存在！"
            },
            password:{
                required:"请输入密码",
                rangelength:$.validator.format("密码长度为{0}-{1}个字符")
            },
            password2:{
                required:"请再次输入密码",
                equalTo:"两次密码必须一致" //表示和id="userpwd"的值相同
            }
        }
    });
});
