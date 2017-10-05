<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${webRoot}/resources/jslib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${webRoot}/resources/css/common/manage.css" rel="stylesheet">
    <script src="${webRoot}/resources/jslib/jquery-1.11.3.min.js"></script>
    <script src="${webRoot}/resources/jslib/bootstrap/bootstrap.min.js"></script>
    <title>${html_title}</title>
</head>
<body>
<div class="left-panel">
    <div class="nav-menu">
        <ul>
        <#list menuList as menu>
            <li>
                <a class="selected" href="${webRoot}${menu.menuUrl}">
                    <span class="nav-icon"></span>
                    <span>${menu.menuName}</span>
                    <span class="nav-select"></span>
                </a>
            </li>
        </#list>
        </ul>
    </div>
</div>



