<div>
    <form id="menu_input_form" method="post">
        <input type="hidden" name="id" id="menuId_input" />
        <input type="hidden" name="isEnable" id="isEnable_input" />
        <table cellspacing="0" class="input-table">
            <tbody>
            <#--<tr>
                <th><em>*</em><label>项目类型</label></th>
                <td>
                    <select name="mpc" id="mpc_input">
                        <option value="p000" selected="selected">基础平台</option>
                        &lt;#&ndash;<option value="p001">实际项目</option>&ndash;&gt;
                    </select>
                </td>
            </tr>-->
            <tr>
                <th><em>*</em><label>上级菜单</label></th>
                <td><input type="text" name="parentCode" id="parentCode_input" /></td>
            </tr>
            <tr>
                <th><em>*</em><label>菜单名称</label></th>
                <td><input type="text" name="menuName" id="menuName_input" /></td>
            </tr>
            <tr>
                <th><label>菜单标识</label></th>
                <td><input type="text" name="menuMark" id="menuMark_input" /></td>
            </tr>
            <#--<tr>
                <th><label>菜单类型</label></th>
                <td><input type="text" name="menuType" id="menuType_input" /></td>
            </tr>-->
            <tr>
                <th><label>排序号</label></th>
                <td><input type="text" name="menuOrder" id="menuOrder_input" /></td>
            </tr>
            <tr>
                <th><label>菜单地址</label></th>
                <td><input type="text" name="menuUrl" id="menuUrl_input" style="width:280px;" /></td>
            </tr>
            <#--<tr>
                <th><label>图标地址</label></th>
                <td><input type="text" name="menuIcon" id="menuIcon_input" style="width:280px;" /></td>
            </tr>-->
            <tr>
                <th><em>*</em><label>是否启用</label></th>
                <td>
                    <input type="radio" name="enableStr" value="1" checked="checked" id="enableStr_input1" />是
                    <input type="radio" name="enableStr" value="0" id="enableStr_input0" />否
                </td>
            </tr>
            <#--<tr>
                <th><label>菜单描述</label></th>
                <td>
                    <textarea name="menuNote" id="menu_note"></textarea>
                </td>
            </tr>-->
            </tbody>
        </table>
    </form>
</div>

<script type="text/javascript">
    $(function(){
        /**
         * 表单验证
        $("#menuName_input").validatebox({
            required: true,
            missingMessage: "请输入菜单名称",
            validType: ["CHSA_alphanum", "maxLength[20]"]
        });
        $("#menuNote_input").validatebox({
            validType: ["maxLength[200]"]
        });
        $("#menuType_input").validatebox({
            validType: ["positiveZ_num", "maxLength[6]"]
        });
        $("#menuOrder_input").validatebox({
            validType: ["positiveZ_num", "maxLength[6]"]
        });
        $("#menuMark_input").validatebox({
            validType: ["code_alphanum", "maxLength[10]"]
        });
        $("#menuUrl_input").validatebox({
            validType: ["maxLength[100]"]
        });
        $("#menuIcon_input").validatebox({
            validType: ["maxLength[100]"]
        });*/

        //项目类型下拉框

        //父级菜单
        $("#parentCode_input").combotree({
            url: "${webRoot}/uums/menu/showCodeTree",
            idField: "id",
            textField: "text",
            parentField: "parentId",
            value: "-1",//默认值
            onSelect: function(rec) {
                //新增时生成排序号
                $.ajax({
                    type: "POST",
                    url: "${webRoot}/uums/menu/showOrderNum",
                    data: {parentCode: rec.id},
                    dataType: "json",
                    success: function(data) {
                        if (data.code == 1) {
                            $("#menuOrder_input").val(data.data);
                        }
                    }
                });
            },
            onLoadSuccess: function(data) {
                $(this).tree("collapseAll");//关闭所有节点
                var node = $(this).tree("getRoot");//根节点;
                $(this).tree("expand", node.target);//展开根节点--得到第一级子节点
                /*var val = $("#parentCode_input").combotree("getValue");
                var node = null;
                if (val == "-1") {
                    node = $(this).tree("getRoot");//根节点
                    $(this).tree("expand", node.target);//展开根节点--得到第一级子节点
                } else {
                    node = $(this).tree("find", val);
                    $(this).tree("expandTo", node.target);//展开第指定子节点--不用展开所有节点
                }*/
            }
        });

        $('#menu_input_form').form({
            url: "${webRoot}/uums/menu/save",
            onSubmit: function(param) {
                var isValid = $(this).form('validate');
                //表单验证通过启用进度条
                if (isValid) {
                    et.progress();
                    $("#isEnable_input").val($("#menu_input_form input[type='radio']:checked").val());
                }
                return isValid;
            },
            success: function(data) {
                //表单验证通过且返回提交结果
                $.messager.progress('close');
                var json = $.parseJSON(data);
                //1：成功，0：失败
                if (json.code == 1) {
                    $("#dialogInput").dialog('destroy');//销毁对话框
                    menu_treegrid.treegrid('reload');//重新加载列表数据
                }
                et.showMsg(json.msg);
            }
        });
    });
</script>