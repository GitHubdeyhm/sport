/**
 * Created by Administrator on 2017/11/12.
 */

function getXMLHttpRequest() {
    var request = null;
    //存在对象则直接new方式创建
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //IE浏览器下创建方式--IE7以前没有XMLHttpRequest()构造函数
        var msxmls = ['Msxml2.XMLHTTP', 'Microsoft.XMLHTTP'];//在Microsoft XML HTTP库的不同版本对象名字不同
        for (var i = 0; i < msxmls.length; i++) {
            try {
                request = new ActiveXObject(msxmls[i]);
                break;
            } catch (e) {
                //忽略异常
            }
        }
    }
    return request;
}
//发送post请求
function ajaxPost(param) {
    var param = {
        url : '',
        data: data,
        header: headers,
        success: function () {
        },
        error :function () {
        }
    }
    var request = getXMLHttpRequest();
    request.open("post", url, true);//异步请求
    //设置表单提交方式，不然对于一些特殊字符（比如百分号%）不能传递到后台
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    if (isEmptyObject(data)) {
        request.send(null);
    } else {
        var formData = '?';
        for (var name in data) {
            formData += name + data[name] + '&';
        }
        request.send(formData.substring(0, formData.length - 1))
    }
    request.onreadystatechange = function() {
        //以下判断请求完成，并且成功响应
        if (request.readyState == 4 && request.status == 200) {
            //response.responseText;
        }
    }
}

/**
 * 判断一个对象是否为空属性对象，即该对象里没有任何属性。
 * @param obj 对象
 * @return 对象为null或者没有属性字段返回true，否则返回false
 */
function isEmptyObject(obj) {
    if (!obj) return true;
    for (var name in obj) {
        return false;
    }
    return true;
}
