$(function() {
    // 注册登录方法
    $("#loginForm").ajaxForm({
        success: function(data, statusText) {
            var result = data.result;
            if ("SUCCESS" != result) {
                $("#showMsg").text(data.showMsg);
                return false;
            } else {
                return true;
            }
        },
        error: function (data) {
            $("#showMsg").text(data.showMsg);
            return false;
        }
    });
});