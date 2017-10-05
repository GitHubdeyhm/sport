<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${html_title}</title>
    <link href="${webRoot}/resources/css/common/base.css" type="text/css" rel="stylesheet" />
    <script src="${webRoot}/resources/jslib/jquery-1.11.3.min.js"></script>
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
        .nav-menu ul {
            position: relative;
            left: -50%;
        }
        .nav-menu ul li {
            float: left;
            padding: 8px 10px;
            border: 1px solid blue;
        }
        .nav-menu ul a {
            color: #fff;
            font-size: 14px;
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
                <ul class="clearfix">
                    <#list menuList as menu>
                        <li>
                            <a href="#">${menu.menuName}</a>
                        </li>
                    </#list>
                </ul>
            </div>
        </div>
    </div>

    <div class="container"></div>



</body>
</html>