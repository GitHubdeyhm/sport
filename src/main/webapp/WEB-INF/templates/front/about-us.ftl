<#include "common/header.ftl" />

<div id="content">

    <div class="aboutUs-box">
        <h2>公司简介</h2>
        <p>
            成都田径俱乐部隶属于四川伟业星恒体育文化传播有限公司，俱乐部成立于2004年，
            2017年公司进行重组改革，地处四川省成都市成都体育学院校本部，旁临武侯祠、
            锦里等，2016年创建基地高端合作平台，成绩显著，得到业内好评，2017年与中国
            体育单招培训网达成合作战略，创建一站式高端服务平台，现在是西南地区一所
            专业开设全面、师资力量雄厚的体育培训俱乐部，俱乐部凭借雄厚的师资力量，
            优良的教学方法，完善的训练设施，秉承诚信、专业、创新的经营理念开展相关培训。
            自开办培训班以来，俱乐部从学员管理、到专项训练、文化课教学逐步形成了正规、
            务实、严谨的办学特色。
        </p>
        <p>
            成都田径依托成都体育学院高等学府，由一批田径国家级裁判和田径专项研究生组成
            的一个推广田径运动的团队。以运动健康为第一要义，以推广体育发展为目的：
            始终坚持以“运动训练、康复训练、赛事策划、体育产品推广为服务主体：
            以合作共赢、诚信高效、服务一流”为服务理念。我们有着专业的团队和丰富的经历，
            立志成为西南片区首屈一指的专业化的体育知名公司。我们将全心全意为的运动爱好者提供服务。
        </p>
        <p>
            <strong>培训宗旨：</strong>
            为每一位学生的成长奠基
        </p>
        <p><strong>培训理念：</strong>大爱育人，责任于行</p>
        <p><strong>公司地址：</strong></p>

        <div id="map-container" style="width:800px;height: 400px;
                       border: 2px solid #E6E5E3;margin: 20px auto;">
        </div>
    </div>
</div>

<#include "common/footer.ftl" />
<script type="text/javascript"
        src="http://api.map.baidu.com/api?v=3.0&ak=uZ8uxuexXwaVrVmegxC5DoYD2dgI6BDt">
</script>
<script type="text/javascript">
    $(function () {
        //loadNavMenu("${code}");
    });
    var map = new BMap.Map("map-container");//标签的id或者对象
    // 创建地图实例
    var point = new BMap.Point(116.404, 39.915);
    // 创建点坐标
    map.centerAndZoom(point, 15);
    map.enableScrollWheelZoom(true);//开启鼠标滚轮缩放
    var myGeo = new BMap.Geocoder();
    // 将地址解析结果显示在地图上,并调整地图视野
    myGeo.getPoint("成都体育学院", function(point){
        if (point) {
            map.centerAndZoom(point, 16);
            map.addOverlay(new BMap.Marker(point));
        }else{
            alert("您选择地址没有解析到结果!");
        }
    }, "成都市");
</script>
</body>
</html>