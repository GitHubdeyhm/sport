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
            <div class="empty-tip">暂无组织架构图！敬请期待吧！</div>
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