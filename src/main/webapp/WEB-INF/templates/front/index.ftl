<#include "common/header.ftl" />

<div id="content">
    <div class="sports-box">
        <ul class="clearfix">
        <#list ["田径", "篮球", "足球", "跆拳道", "网球", "柔道", "摔跤", "散打", "武术", "排球"] as x >
            <li><a href="#">${x}</a></li>
        </#list>
        </ul>
    </div>

    <div class="teach-show">
        <div class="teach-title">教学展示</div>
        <div class="img-show"></div>
    </div>
</div>

<#include "common/leave-message.ftl" >

<#include "common/footer.ftl" />
<script type="text/javascript">
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
</script>
</body>
</html>