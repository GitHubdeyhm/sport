<#include "common/header.ftl" />

<div id="content" class="clearfix">

    <#include "common/content-left.ftl" />

    <div class="right">
        <div id="nav-location">
            <#if menuList ??>
                <div class="location"><span>您所在的位置：</span>
                <#list menuList as menu>
                    <#if "${menu_index gt 0}">
                        <span>&gt;</span>
                    </#if>
                    <a href="${menu.menuUrl}?mc=${menu.menuCode}">${menu.menuName}</a>
                </#list>
                </div>
            </#if>
        </div>
        <div>
            <span style="margin-right: 32px;">联系人：何老师</span>
            <span>咨询电话：13739487852</span>
        </div>
        <div>
            <div>联系地址：成都市龙泉驿区忠北路（四川大学龙泉校区）</div>
            <div>公交路径：1路，104路</div>
        </div>
    </div>
</div>

<#include "common/footer.ftl" />
<script type="text/javascript">
    $(function () {
        //loadNavMenu("${code}");
    });
</script>
</body>
</html>