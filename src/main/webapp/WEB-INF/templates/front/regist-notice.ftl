<#include "common/header.ftl" />

<#include "common/leave-message.ftl" >

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
            <p>1. 培训类别、报名班次等信息详情请查看俱乐部当年招生简章，并如实填写。</p>
            <p>2. 田径专项：务必在其他信息填写小项名称 ( 比如：100米、200米、跳远等各小项 )。</p>
            <p>3.体育运动爱好者：请填写爱好专项，其他信息视情况填写。</p>
            <p>4.因上传专项不够完整，若无该专项选项或者考生无体育基础者请在培训专项选其他，
                然后在其他信息中填写专项名称或填写“体育无基础者”，其他个人情况可在其他信息中填写
                （比如年龄、个人身体条件、运动经历、体育单招或全国高考专项和文化成绩等详细信息）。</p>
            <p>5.为了保护各位同学的权益，请各位同学放心认真填写，您所提交的报名资料本 俱乐部绝对保密。</p>
            <p>6.咨询电话： 18581868484 办公室电话：028-69582364  联系人：孙老师  QQ：909589364</p>
            <p>注：使用QQ的同学可以将QQ号码填写在备注信息中，方便联系。</p>
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