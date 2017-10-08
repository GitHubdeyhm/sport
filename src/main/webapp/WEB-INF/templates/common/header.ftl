<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <#-- 解决IE9出现的页面兼容问题-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${html_title}</title>
    <link href="${webRoot}/resources/css/common/base.css" type="text/css" rel="stylesheet" />
    <link href="${webRoot}/resources/css/index.css" type="text/css" rel="stylesheet" />
    <script src="${webRoot}/resources/jslib/easyui-1.5.2/jquery.min.js"></script>
    <script src="${webRoot}/resources/jslib/index.js"></script>
</head>
<body>
<div class="header">
    <div class="logo_pos clearfix">
        <div style="float:left;"><h2 class="logo_name">成都伟业星恒体育文化传播有限公司</h2></div>
        <div style="float:right;margin-right: 16px;border: 1px solid red;">
            <div class="barcode">
                <img src="${webRoot}/resources/image/barcode.png" />
            </div>
            <div style="border: 1px solid red;">
                <span class="teacher">何老师：</span>
                <span class="phone">13739487852</span>
            </div>
        </div>
    </div>

    <div class="nav-bg" style="background: #f33634 url('${webRoot}/resources/image/menu-bg.png') repeat-x">
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

<div class="show-area">
    <!-- 展示图片的布局 -->
    <div class="img-list" id="img-list">
        <ul>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_1.jpg" />
                </a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_2.jpg" />
                </a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_3.jpg" />
                </a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_4.jpg" />
                </a>
            </li>
        </ul>
    </div>

    <#-- 左右按钮和当前图片的位置 -->
    <div class="main-area" id="main-area">
        <#-- 左右按钮 -->
        <div class="button">
            <span class="last">&lt;</span>
            <span class="next">&gt;</span>
        </div>
        <#--<div class="dot-wrap">
            <!-- 小圆点 &ndash;&gt;
            <ul class="img-nav clearfix" id="img-nav"></ul>
        </div>-->
    </div>
</div>
