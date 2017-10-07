<#include "common/easyui.ftl" />
<body class="easyui-layout">

    <div data-options="region:'center',title:'系统配置',border:false" style="overflow:hidden;">
        <iframe name="main-frame" id="main_frame" frameborder="0" style="width:100%;height:100%;padding:0;"></iframe>
    </div>

    <div data-options="region:'west',border:false,title:'菜单选项',iconCls:'icon-save',width:180">
        <div id="left-panel">
            <div class="nav-menu">
                <ul>
                <#list menuList as menu>
                    <#if "${menu_index == 0}">
                        <li class="selected">
                            <a href="${webRoot}${menu.menuUrl}" target="main-frame">
                                <span class="nav-icon"></span>
                                <span>${menu.menuName}</span>
                                <span class="nav-select"></span>
                            </a>
                        </li>
                    <#else>
                        <li>
                            <a href="${webRoot}${menu.menuUrl}" target="main-frame">
                                <span class="nav-icon"></span>
                                <span>${menu.menuName}</span>
                                <span class="nav-select"></span>
                            </a>
                        </li>
                    </#if>
                </#list>
                </ul>
            </div>
        </div>
    </div>


    <#--<div id="layout_panel">
        <div></div>

        <div id="left-panel">
            <div class="nav-menu">
                <ul>
                <#list menuList as menu>
                    <#if "${menu_index == 0}">
                        <li class="selected">
                            <a href="${webRoot}${menu.menuUrl}" target="main-frame">
                                <span class="nav-icon"></span>
                                <span>${menu.menuName}</span>
                                <span class="nav-select"></span>
                            </a>
                        </li>
                    <#else>
                        <li>
                            <a href="${webRoot}${menu.menuUrl}" target="main-frame">
                                <span class="nav-icon"></span>
                                <span>${menu.menuName}</span>
                                <span class="nav-select"></span>
                            </a>
                        </li>
                    </#if>
                </#list>
                </ul>
            </div>
        </div>

        <div id="center-panel">
            <iframe name="main-frame" frameborder="0" style="width:100%;height:100%;padding:0;"></iframe>
        </div>

    </div>-->
<script type="text/javascript">
   // $("#layout_panel").height($(window).height());
    //$("#center-panel").width($(window).width() - 184);


    $(function () {
        $("#left-panel a").click(function() {
            $(this).parent("li").siblings(".selected").removeClass("selected");
            $(this).parent("li").addClass("selected");
        });
    });
</script>
</body>
</html>



