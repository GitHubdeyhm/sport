<#include "common/easyui.ftl" />
<body style="background-color:#F9F9F9" class="easyui-layout">

<div data-options="region:'west'" style="width:400px;">
    <table id="dict_parent_datagrid">
        <thead>
        <tr>
            <th field="ck" checkbox="true"></th><!-- 显示复选框 -->
            <th field="dictKey" width="100">参数编码</th>
            <th field="dictValue" width="100">参数值</th>
            <th field="isEdit" width="50">是否编辑</th>
            <th field="dictDesc" width="120">参数说明</th>
        </tr>
        </thead>
    </table>
</div>
<div data-options="region:'center'">
    <div id="dict_datagrid_toolbar" class="search-toolbar clearfix">
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
    <table id="dict_datagrid">
        <thead>
        <tr>
            <th field="ck" checkbox="true"></th><!-- 显示复选框 -->
            <th field="dictKey" width="100">参数编码</th>
            <th field="dictValue" width="100">参数值</th>
            <th field="isEdit" width="50">是否编辑</th>
            <th field="dictDesc" width="120">参数说明</th>
        </tr>
        </thead>
    </table>
</div>
<script type="text/javascript">
    $(function () {
        dict_parent_datagrid = $('#dict_parent_datagrid').datagrid({
            //toolbar: "#user_datagrid_toolbar",//工具栏--有助于页面布局
            url : '${webRoot}/manage/dict/showList',
            onClickRow: function(index, row) {
                dict_datagrid.datagrid("load", {
                    parentId: row.id
                });
            }
        });

        dict_datagrid = $('#dict_datagrid').datagrid({
            toolbar: "#dict_datagrid_toolbar",//工具栏--有助于页面布局
            url : '${webRoot}/manage/dict/showList'
        });
    });
    
    function showInputDialog() {
        
    }
    
    function del() {
        
    }
</script>
</body>
</html>