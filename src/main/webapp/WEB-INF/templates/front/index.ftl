<#include "common/header.ftl" />

<div class="show-area">
    <!-- 展示图片的布局 -->
    <div class="img-list" id="img-list">
        <ul>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_1.jpg" />
                </a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_2.jpg" />
                </a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_3.jpg" />
                </a>
            </li>
            <li>
                <a href="javascript:void(0);">
                    <img src="${webRoot}/resources/image/show/image_4.jpg" />
                </a>
            </li>
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
        <#list ["田径", "篮球", "足球", "跆拳道", "网球", "柔道", "摔跤", "散打", "武术", "排球"] as x >
            <li><a href="#">${x}</a></li>
        </#list>
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
                   poster="${webRoot}/resources/image/show/image_1.jpg"
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
                <li><a href="#">新闻标题体育新闻</a></li>
                <li><a href="#">新闻标题体育新闻</a></li>
                <li><a href="#">新闻标题体育新闻</a></li>
                <li><a href="#">新闻标题</a></li>
                <li><a href="#">新闻标题</a></li>
                <li><a href="#">新闻标题</a></li>
                <li><a href="#">新闻标题</a></li>
                <li><a href="#">新闻标题</a></li>
                <li><a href="#">新闻标题</a></li>
                <li><a href="#">新闻标题</a></li>
            </ul>
        </div>
    </div>

    <div class="teach-show">
        <div class="teach-title">教学展示</div>
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
        //设置展示图片区域的动态样式
        var isMove = true;
        var imgList = ["/resources/image/show/image_1.jpg", "/resources/image/show/image_2.jpg",
            "/resources/image/show/image_3.jpg", "/resources/image/show/image_4.jpg", "/resources/image/show/image_4.jpg",
            "/resources/image/temp/1.jpg"];
        var firstLeft = 2;
        var imgStr = '', len = imgList.length;
        for (var i = 0; i < len; i++) {
            imgStr += '<li style="left:'+firstLeft+'px">'+
                    '<div class="img-note">一句话描述这张图片</div>'+
                    '<a href="javascript:void(0);">'+
                    '<img src="${webRoot}'+imgList[i]+'" />'+
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
            }, 200);
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