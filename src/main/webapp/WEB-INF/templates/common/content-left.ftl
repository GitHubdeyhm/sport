
<#-- 中心内容的左侧部分 -->
<div class="left">
    <#if childMenuList ??>
        <ul>
            <#list childMenuList as menu>
                <#if "${menu.menuCode?length == 9}">
                    <li><a href="${menu.menuUrl}?mc=${menu.menuCode}">${menu.menuName}</a></li>
                </#if>
            </#list>
        </ul>
    </#if>

    <div class="barcode">
        <img src="${webRoot}/resources/image/barcode.png" />
    </div>
</div>