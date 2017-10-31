<div>
    <form id="input_form" method="post">
        <input type="hidden" name="id" id="id_input" />
        <table cellspacing="0" class="input-table">
            <tbody>
            <tr>
                <th><em>*</em><label>新闻标题</label></th>
                <td><input type="text" name="newsTitle" id="newsTitle_input" /></td>
            </tr>
            <tr>
                <th><em>*</em><label>副标题</label></th>
                <td><input type="text" name="newsSubTitle" id="newsSubTitle_input" /></td>
            </tr>
            <tr>
                <th><label>新闻内容</label></th>
                <td><input type="text" name="menuMark" id="menuMark_input" /></td>
            </tr>
            <tr>
                <th><em>*</em><label>是否发布</label></th>
                <td>
                    <input type="radio" name="isPublish" value="1" checked="checked" id="isPublishStr_input1" />是
                    <input type="radio" name="isPublish" value="0" id="isPublishStr_input0" />否
                </td>
            </tr>
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

        $('#input_form').form({
            url: "${webRoot}/manage/news/save",
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