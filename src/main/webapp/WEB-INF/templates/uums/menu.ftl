<#include "common/header.ftl" />

    <div class="right-panel">
        <form action="${webRoot}/manage/menu/save" id="menu_form" method="post" class="form-horizontal" role="form">
            <input type="hidden" name="menuProjectCode" value="front" />
            <div class="form-group">
                <label for="menuName_input" class="col-sm-2 control-label">菜单名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuName" id="menuName_input" placeholder="请输入菜单名称">
                </div>
            </div>
            <div class="form-group">
                <label for="menuUrl_input" class="col-sm-2 control-label">菜单地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuUrl" id="menuUrl_input" placeholder="请输入菜单地址">
                </div>
            </div>
            <div class="form-group">
                <label for="menuOrder_input" class="col-sm-2 control-label">菜单排序</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="menuOrder" id="menuOrder_input" placeholder="请输入菜单排序号">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="radio">
                        <label class="radio-inline">
                            <input type="radio" name="isEnable" id="isEnable_input_1" value="1" checked>是
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="isEnable" id="isEnable_input_0"  value="0">否
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">保存</button>
                </div>
            </div>
        </form>
    </div>
    <div style="clear: both"></div>
<script type="text/javascript">
    var leftWidth = $(".left-panel").width() + 20;
    $(".right-panel").width($(window).width() - leftWidth);


</script>
</body>
</html>