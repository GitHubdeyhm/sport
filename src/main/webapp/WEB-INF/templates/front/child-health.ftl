<#include "common/header.ftl" />

<div id="content" class="clearfix">

<#--
<#include "common/content-left.ftl" />
-->

    <div class="health-box"">
        <div class="health-topic">
            <h2>主题：运动快乐，享<em>瘦</em>生活</h2>
            <div style="text-align:center;"><img src="${webRoot}/resources/image/health.png" /></div>
            <div style="text-align:center;">BMI测试：<strong>BMI = 体重(公斤) / 身高(米)²</strong></div>
            <div style="text-align:center;color:#dc4bee;">快看看自己的BMI是否在理想范围吧！</div>
            <ul class="health-calc">
                <li>
                    <label>身高</label>
                    <input type="text" placeholder="请输入身高" id="height_input" /><em>cm</em>
                    <span class="clac-btn" id="bmi-btn">开始计算</span>
                </li>
                <li>
                    <label>体重</label>
                    <input type="text" placeholder="请输入体重" id="weight_input" /><em>kg</em>
                    <span class="clac-btn btn-clear" id="btn-clear-btn">清楚重算</span>
                </li>
                <li>
                    <span>你的BMI为</span>
                    <span id="health_bmi"></span>
                </li>
            </ul>
            <table class="par">
                <thead>
                <tr>
                    <th></th>
                    <th>身体质量指数（BMI）<br/>（kg/m²）</th>
                    <th>腰围（cm）</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>体重过轻</td>
                    <td>BMI&nbsp;&lt;&nbsp;18.5</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>正常范围</td>
                    <td>18.5&nbsp;≤&nbsp;BMI&nbsp;&lt;&nbsp;24</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>异常范围</td>
                    <td class="health-over" style="text-align:left;">
                        <div><span>过重：</span>24&nbsp;≤&nbsp;BMI&nbsp;&lt;&nbsp;27</div>
                        <div><span>轻度肥胖：</span>27&nbsp;≤&nbsp;BMI&nbsp;&lt;&nbsp;30</div>
                        <div><span>中度肥胖：</span>30&nbsp;≤&nbsp;BMI&nbsp;&lt;&nbsp;35</div>
                        <div><span>重度肥胖：</span>BMI&nbsp;≥&nbsp;35</div>
                    </td>
                    <td>-</td>
                </tr>
                </tbody>
            </table>
            <p class="note-text">
                <strong>训练方式：</strong>
                制定相应的训练计划，为孩子量身定制训练手段，安排相应的课时进行训练配合家庭健康饮食。
                促进孩子速度、力量、耐力、柔韧、协调各方面的身体素质发育。
            </p>
        </div>

        <div class="health-rules">
            <h2>招生简章</h2>
            <p>
                成都田径俱乐部隶属于四川伟业星恒体育文化传播有限公司，俱乐部成立于2004年，
                2009年开始转型，通过科学的体育训练帮助青少年减肥训练；2016年创建基地高端合作平台，
                成绩显著，得到业内好评，2017年与中国体育单招培训网达成合作战略，创建一站式高端服务平台，
                现在是西南地区一所专业开设全面、师资力量雄厚的体育培训俱乐部。2017年公司进行重组改革，
                地处四川省成都市成都体育学院校本部，旁临武侯祠、锦里。
            </p>
            <p>
                亚健康是一种临界状态，处于亚健康状态的人，虽然没有明确的疾病，但却出现精神活力和
                适应能力的下降，如果这种状态不能得到及时的纠正，非常容易引起心身疾病。
                亚健康即指非病非健康状态，这是一类次等健康状态，是界乎健康与疾病之间的状态，
                故又有“次健康”、“第三状态”、“中间状态”、“游移状态”、“灰色状态”等的称谓。
                世界卫生组织将机体无器质性病变，但是有一些功能改变的状态称为“第三状态”，
                中国称为“亚健康状态”。
            </p>
            <p class="note-text">
                <strong>本培训中的亚健康指：</strong>少儿及青少年不当生活习惯引起的肥胖、
                不自信、不开朗、协调差、
                驼背、自制力差、畏难等症状反应。通过体育训练来改善孩子各方面的身体和心理素质。
            </p>

            <p class="note-text">周末长期运动减肥训练：每周2天（6--14岁）。</p>
            <p class="note-text">假期减肥训练（健康减肥营）时间为1个月或者3周（6---14岁）。</p>

            <p>
                成都伟业青少年健康夏令营以体验式活动为载体，以健康生活习惯养成为目标，通过科学组织、
                合理安排有氧训练、减脂训练、户外训练、拓展训练、形体训练，素质训练、饮食训练及行为矫正
                、身体机能提升等模块，并根据科研医务人员开具的饮食处方，培养超体重少年儿童科学营养
                的饮食习惯和健康的生活方式，建立超体重中小学生群体健康教育的长效机制，逐步改善、
                提高超体重学生身心健康。
            </p>
            <ul style="text-indent:2em;">
                <li>1、全方面肥胖体质测试</li>
                <li>2、制定相应计划和合理安排膳食</li>
                <li>3、半军事化管理及训练</li>
                <li>4、优质高效丰富的减脂课程</li>
                <li>5、激励正能量课程</li>
                <li>6、互动趣味活动</li>
                <li>7、最后体质测试</li>
            </ul>

            <table class="par">
                <thead>
                <tr>
                    <th>班次</th>
                    <th>训练地点</th>
                    <th>时间</th>
                    <th>计划招生</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>周末长期运动减肥班</td>
                    <td>成都体育学院或外派1对1</td>
                    <td>长期报名</td>
                    <td>30人</td>
                </tr>
                <tr>
                    <td>寒假健康减肥营</td>
                    <td>成都基地</td>
                    <td>4周或3周</td>
                    <td>50人</td>
                </tr>
                <tr>
                    <td>暑假健康减肥营</td>
                    <td>成都基地</td>
                    <td>4周或3周</td>
                    <td>40人</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<#include "common/footer.ftl" />
<script type="text/javascript">
    //正整数
    var positiveNum = /^[1-9][0-9]*$/;
    $(function () {
        $("#bmi-btn").click(function () {
            $("#health_bmi").text("");
            var weight = $.trim($("#weight_input").val());
            var height = $.trim($("#height_input").val());
            var isWeightNum = positiveNum.test(weight);
            var isHeightNum = positiveNum.test(height);
            if (isWeightNum && isHeightNum) {
                var bmi = weight / (height * height) * 10000;
                $("#health_bmi").text(bmi.toFixed(2));
            }
        });

        $("#btn-clear-btn").click(function () {
            $("#weight_input").val("");
            $("#height_input").val("").focus();
        });
    });
</script>
</body>
</html>