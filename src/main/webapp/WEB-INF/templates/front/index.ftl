<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <#-- 解决IE9出现的页面兼容问题-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${html_title}</title>
    <link href="${webRoot}/resources/css/common/base.css" type="text/css" rel="stylesheet" />
    <script src="${webRoot}/resources/jslib/easyui-1.5.2/jquery.min.js"></script>
    <style type="text/css">
        .logo_name {
            color: #ec2008;
            font-size: 26px;
            font-weight: bold;
        }
        .logo_pos {
            margin: 20px auto 15px auto;
            width: 924px;
        }
        .logo_pos .teacher {
            font-size: 18px;
            color: #ec2008;
            font-weight: bold;
            font-style: italic;
        }
        .logo_pos .phone {
            font-size: 16px;
            font-weight: bold;
            color: #ec2008;
            font-style: italic;
        }
        .nav-bg {
            background-color: #ec2008;
            color: #fff;
            overflow: hidden;
        }
        .nav-menu {
            position: relative;
            left: 50%;
            float: left;
        }
        .nav-menu .nav-ul {
            position: relative;
            left: -50%;
        }
        .nav-menu .nav-li {
            float: left;
            padding: 8px 10px;
            /*border: 1px solid blue;*/
        }
        .nav-menu .nav-li a {
            color: #fff;
            font-size: 14px;
        }
        .nav-menu .nav-li ul {
            display: none;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="logo_pos clearfix">
            <div style="float:left;"><h2 class="logo_name">成都伟业星恒体育文化传播有限公司</h2></div>
            <div style="float:right;margin-right: 16px;">
                <span class="teacher">何老师：</span>
                <span class="phone">13739487852</span>
            </div>
        </div>

        <div class="nav-bg">
            <div class="nav-menu">
                <#--<ul class="clearfix">
                    <#list menuList as menu>
                        <li>
                            <a href="#">${menu.menuName}</a>
                        </li>
                    </#list>
                </ul>-->
            </div>
        </div>
    </div>

    <div class="container"></div>

<script type="text/javascript">
    $(function () {
        $.ajax({
            type: "POST",
            url: "${webRoot}/uums/menu/showMenu",
            dataType: 'json',
            success: function(data) {
                if (data.code == 1) {
                    //$("#roleOrder_input").val(data.msg);
                    var menuData = data.data;
                    var menu1 = [], menu2 = [];
                    for (var i = 0; i < menuData.length; i++) {
                        var codeLen = menuData[i].menuCode.length;
                        if (codeLen == 6) {
                            menu1.push(menuData[i]);
                        } else if (codeLen == 9) {
                            menu2.push(menuData[i]);
                        }
                    }
                    var menuStr = '<ul class="nav-ul">';
                    for (var i = 0; i < menu1.length; i++) {
                        menuStr += '<li class="nav-li">'+
                                '<a class="nav-a" href="'+menu1[i].menuUrl+'">'+menu1[i].menuName+'</a>'+
                                '<ul class="">';
                        for (var j = 0; j < menu2.length; j++) {
                            var menuCode = menu2[j].menuCode;
                            if (menu1[i].menuCode == menuCode.substring(0, menuCode.length-3)) {
                                menuStr += '<li class="">'+
                                        '<a href="'+menu2[j].menuUrl+'">'+menu2[j].menuName+'</a></li>';
                            }
                        }
                        menuStr += '</ul></li>';
                    }
                    $(".nav-menu").html(menuStr+'</ul>');

                    $(".nav-menu .nav-li").hover(
                        function(){
                            $(this).children("ul").slideToggle();
                            //changeIcon($(this).children("span"));
                        }
                    );
                }
            }
        });
    });
</script>
</body>
</html>