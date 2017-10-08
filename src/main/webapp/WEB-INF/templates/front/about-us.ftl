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

        <div class="introduce-us">
            <h2>成都田径俱乐部</h2>
            <h4>专业·专注·专心</h4>
            <p style="margin-bottom:20px;"></p>
            <p>
                成都田径俱乐部隶属于四川伟业星恒体育文化传播有限公司，俱乐部成立于2004年，
                2017年公司进行重组改革，地处四川省成都市成都体育学院校本部，旁临武侯祠、锦里等，
                2016年创建基地高端合作平台，成绩显著，得到业内好评，2017年与中国体育单招培训网达成合作战略，
                创建一站式高端服务平台，现在是西南地区一所专业开设全面、师资力量雄厚的体育培训俱乐部，
                俱乐部凭借雄厚的师资力量，优良的教学方法，完善的训练设施，秉承诚信、专业、创新的经营理念开展
                相关培训。自开办培训班以来，俱乐部从学员管理、到专项训练、文化课教学逐步形成了正规、务实、
                严谨的办学特色。
            </p>
            <p>
                在学员管理方面，一切为了学生是俱乐部的宗旨，俱乐部有辅导员及管理人员全天跟踪管理，
                以保证良好的教学和生活秩序。
            </p>
            <p>
                在专项训练和文化教学方面，俱乐部拥有强大的教学背景和师资力量，参与培训的教练是俱乐部
                诚聘的成都体育学院培养的专业教师，经验丰富，有较强的职业精神，在多年的培训中，俱乐部受到
                了广大学生和家长的喜爱和信赖。
            </p>
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