<#include "common/easyui.ftl" />
<body style="background-color:#F9F9F9" class="easyui-layout">

<div data-options="region:'center'">
    <div id="news_datagrid_toolbar" class="search-toolbar clearfix">
        <div style="float:left;">
            <form id="user_search_form" action="${ctx}/uums/user!exportExcel.action" method="post">
                <input type="hidden" name="unitCodes" id="unitCodes_search" />
                <label>用户名</label>
                <input type="text" name="userName" id="userName_search" maxlength="20" />
            </form>
        </div>
        <div style="float:right;">
            <a onclick="showInputDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
            <a onclick="showInputDialog(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
            <a onclick="del()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        </div>
    </div>
    <table id="news_datagrid">
        <thead>
        <tr>
            <th field="ck" checkbox="true"></th><!-- 显示复选框 -->
            <th field="newsTitle" width="150">新闻标题</th>
            <th field="newsSubTitle" width="150">副标题</th>
            <#--<th field="isEdit" width="50">新闻内容</th>-->
            <th field="isPublish" width="60" formatter="yesNoFmt">是否发布</th>
            <th field="publishTime" width="100">发布时间</th>
            <th field="createTime" width="100">创建时间</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/javascript">
    $(function () {
        news_datagrid = $('#news_datagrid').datagrid({
            toolbar: "#news_datagrid_toolbar",//工具栏--有助于页面布局
            url : '${webRoot}/manage/news/showList'
        });
    });

    function showInputDialog() {

    }

    function del() {

    }
</script>
</body>
</html>