<#include "common/header.ftl" />

<div class="show-area">
    <!-- 展示图片的布局 -->
    <div class="img-list" id="img-list">
        <ul>
        <#list 1..4 as x >
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/img${x}.jpg" />
                </a>
            </li>
        </#list>
        </ul>
    </div>

    <#-- 左右按钮和当前图片的位置 -->
    <div class="main-area" id="main-area">
        <#-- 左右按钮 -->
        <div class="button">
            <span class="last"></span>
            <span class="next"></span>
        </div>
    <#--<div class="dot-wrap">
        <!-- 小圆点 &ndash;&gt;
        <ul class="img-nav clearfix" id="img-nav"></ul>
    </div>-->
    </div>
</div>

<div id="content">
    <div class="sports-box">
        <div class="sports-title">
            <span>热门报名</span>
            <a href="#">更多&gt;&gt;</a>
        </div>
        <ul class="clearfix">
            <li>
                <a href="#">
                    <img src="${webRoot}/resources/image/a2.png" style="width:100px;height:100px;"/>
                    <div>足球</div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${webRoot}/resources/image/a1.png" style="width:100px;height:100px;"/>
                    <div>篮球</div>
                </a>
            </li>
            <li>
                <a href="#">
                    <img src="${webRoot}/resources/image/a3.png" style="width:100px;height:100px;"/>
                    <div>网球</div>
                </a>
            </li>
        <#list ["田径", "跆拳道", "柔道", "摔跤", "散打"] as x >
            <li><a href="#">
                <img src="${webRoot}/resources/image/a1.png" style="width:100px;height:100px;"/>
            <div>${x}</div>
            </a></li>
        </#list>
        </ul>
    </div>

    <div class="well-box">
        <div class="sports-title">
            <span>田径精品课程</span>
        </div>
        <ul class="clearfix">
            <li>
                <a class="well-item" href="${webRoot}/child/health/1008">
                    <div class="item-title">
                        <div><img src="${webRoot}/resources/image/course/sexqb.jpg" /></div>
                        <div class="title-note">少儿兴趣班</div>
                    </div>
                    <div class="item-body">
                        <div><span>对象：</span>6--12岁</div>
                        <div><span>内容：</span>身体素质训练</div>
                        <div><span>形式：</span>小班授课</div>
                        <div><span>报名：</span>马上报名</div>
                    </div>
                </a>
            </li>
            <li>
                <a class="well-item" href="${webRoot}/middle/exam/1009">
                    <div class="item-title">
                        <div><img src="${webRoot}/resources/image/course/zkty.jpg" /></div>
                        <div class="title-note">中考体育</div>
                    </div>
                    <div class="item-body">
                        <div><span>对象：</span>12--16岁</div>
                        <div><span>内容：</span>中考体育项目</div>
                        <div><span>形式：</span>小班授课</div>
                        <div><span>报名：</span>马上报名</div>
                    </div>
                </a>
            </li>
            <li>
                <div class="well-item">
                    <div class="item-title">
                        <div><img src="${webRoot}/resources/image/course/hsj.jpg" /></div>
                        <div class="title-note">寒暑假集训营</div>
                    </div>
                    <div class="item-body">
                        <div><span>对象：</span>12--18岁</div>
                        <div><span>内容：</span>高考体育训练</div>
                        <div><span>形式：</span>训练营</div>
                        <div><span>报名：</span>马上报名</div>
                    </div>
                </div>
            </li>
            <li>
                <div class="well-item">
                    <div class="item-title">
                        <div><img src="${webRoot}/resources/image/course/wpsj.jpg" /></div>
                        <div class="title-note">外派私教</div>
                    </div>
                    <div class="item-body">
                        <div><span>对象：</span>16--18岁</div>
                        <div><span>内容：</span>指定需求</div>
                        <div><span>形式：</span>1对1私教</div>
                        <div><span>报名：</span>马上报名</div>
                    </div>
                </div>
            </li>
            <li>
                <div class="well-item">
                    <div class="item-title">
                        <div><img src="${webRoot}/resources/image/course/ssch.jpg" /></div>
                        <div class="title-note">活动赛事策划</div>
                    </div>
                    <div class="item-body item-span">
                        <div><span>对象：</span>活动需求者</div>
                        <div><span>内容：</span>运动会、马拉松等</div>
                        <div><span>形式：</span>策划&bull;组织&bull;实施</div>
                        <div><span>微信：</span>13739487852</div>
                    </div>
                </div>
            </li>
        </ul>
    </div>

    <div class="video-news clearfix">
        <div class="video-box">
            <div class="video-title">
                <span>视频展示</span>
                <a href="#">更多&gt;&gt;</a>
            </div>
            <#--<h2>暂无视频展示</h2>-->
            <video id="video-show" class="video-js vjs-default-skin vjs-big-play-centered"
                   controls preload="none" width="550" height="280"
                   poster="${webRoot}/resources/image/show/img4.jpg"
                   data-setup="{}">
                <source src="${webRoot}/resources/upload/qsmy.mp4" type='video/mp4' />
            </video>
        </div>
        <div class="news-box">
            <div class="news-title">
                <span>新闻动态</span>
                <a href="#">更多&gt;&gt;</a>
            </div>
            <ul class="news-list">
                <li><a href="http://www.scsport.gov.cn/xwzx/qsnty/201712/t20171207_26956.html">攀枝花市三中顺利通过“四川省阳光体育示范学校” 复查验收</a></li>
                <li><a href="#">南充16岁中学生助中国队获亚军</a></li>
                <li><a href="#">中国足球基金会支持德阳奥校 开展青少年足球菁英人才培育计划</a></li>
                <li><a href="#">宜宾县举办第三届校园足球联赛</a></li>
                <li><a href="#">绵阳小学生机器人战队勇夺世界教育机器人大赛一等奖</a></li>
                <li><a href="#">三台县：2017年绵阳市校园“三大球”比赛漂亮收官</a></li>
                <li><a href="#">2017年“中国体育彩票杯”绵阳市青少年排球分区赛成功举行</a></li>
                <li><a href="#">宜宾市举办首届学生运动舞蹈大赛</a></li>
                <li><a href="#">宜宾筠连景阳小学举行教职工趣味运动会</a></li>
                <li><a href="#">德阳市第一届赛艇邀请赛在德阳旌湖开赛</a></li>
            </ul>
        </div>
    </div>

    <div class="teach-show">
        <div class="teach-title">
            <div>教学展示</div>
            <div class="english-text">Teaching display</div>
        </div>
        <div class="img-show"></div>
    </div>
</div>

<#include "common/leave-message.ftl" >

<#include "common/footer.ftl" />

<link href="${webRoot}/resources/jslib/video/css/video-js.css" rel="stylesheet" type="text/css">
<script src="${webRoot}/resources/jslib/video/js/video.min.js"></script>
<script type="text/javascript">
    videojs.options.flash.swf = "video-js.swf";
    $(function () {
        //海报展示区域
        /*var imgBaseUrl = "${webRoot}/resources/image/show/";
        var showImgStr = '<ul>';
        for (var i = 1; i <= 4; i++) {
            showImgStr += '<li>'+
                   '<a href="javascript:void(0);">'+
                        '<img src="'+imgBaseUrl+'img'+i+'.jpg" />'+
                    '</a></li>';
        }
        $("#img-list").html(showImgStr + '</ul>');*/





        //设置展示图片区域的动态样式
        var isMove = true;
        //var imgList = ["img1.jpg", "img2.jpg", "img3.jpg",];
        var firstLeft = 2;
        var imgStr = '', len = 8;
        for (var i = 0; i < len; i++) {
            imgStr += '<li style="left:'+firstLeft+'px">'+
                    '<div class="img-note">一句话描述这张图片</div>'+
                    '<a href="javascript:void(0);">'+
                    '<img src="${webRoot}/resources/image/teach/ts'+i+'.jpg" />'+
                    '</a></li>';
            firstLeft += 220;
        }
        $(".img-show").html('<ul>'+imgStr+'</ul>');

        $(".img-show li").hover(
            function () {
                isMove = false;
                $(this).children(".img-note").show();
            },
            function () {
                isMove = true;
                $(this).children(".img-note").hide();
            }
        );
        //定时器：当展示的图片多余5张时显示
        if (len > 5) {
            window.setInterval(function () {
                if (isMove) {
                    $(".img-show li").each(function () {
                        var left = parseInt($(this).css("left")) - 2;
                        var moveLeft = (left < -218) ? 1104 : left;
                        $(this).css({
                            left: moveLeft
                        });
                    });
                }
            }, 50);
        }
    });
    //视频播放
    videojs("video-show").ready(function(){
        var player = this;
        //myPlayer.play();
    });
</script>
</body>
</html>