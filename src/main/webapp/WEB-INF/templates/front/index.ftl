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
        <div class="img-show">
            <ul class="clearfix">
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
                <li>
                    <a href="javascript:void(0);">
                        <img src="${webRoot}/resources/image/temp/1.jpg" />
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

<#include "common/leave-message.ftl" >

<#include "common/footer.ftl" />
</body>
</html>