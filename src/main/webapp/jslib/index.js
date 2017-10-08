/**
 * Created by Administrator on 2017/10/8.
 */
$(function () {
    $.ajax({
        type: "POST",
        url: "/uums/menu/showMenu",
        dataType: 'json',
        success: function(data) {
            if (data.code == 1) {
                //$("#roleOrder_input").val(data.msg);
                var menuData = data.data;
                var menu1 = [], menu2 = [];
                for (var i = 0; i < menuData.length; i++) {
                    var codeLen = menuData[i].menuCode.length;
                    if (codeLen == 6) {
                        menu1.push(menuData[i]);
                    } else if (codeLen == 9) {
                        menu2.push(menuData[i]);
                    }
                }
                var menuStr = '<ul class="nav-ul clearfix">';
                for (var i = 0; i < menu1.length; i++) {
                    var m1 = menu1[i];
                    menuStr += '<li class="nav-li">'+
                        '<a class="nav-a" href="'+m1.menuUrl+'?mc='+m1.menuCode+'">'+m1.menuName+'</a>';
                    var childMenuStr = '';
                    for (var j = 0; j < menu2.length; j++) {
                        var m2 = menu2[j];
                        var menuCode = m2.menuCode;
                        if (m1.menuCode == menuCode.substring(0, menuCode.length-3)) {
                            childMenuStr += '<li class="">'+
                                '<a href="'+m2.menuUrl+'?mc='+m2.menuCode+'">'+m2.menuName+'</a></li>';
                        }
                    }
                    if (childMenuStr == '') {
                        menuStr += '</li>';
                    } else {
                        menuStr = menuStr + '<ul>' + childMenuStr + '</ul></li>';
                    }
                }
                $(".nav-menu").html(menuStr+'</ul>');

                $(".nav-menu .nav-li").hover(
                    function(){
                        $(this).children("ul").slideToggle();
                        //changeIcon($(this).children("span"));
                    }
                );
            }
        }
    });

    //加载小圆点导航
    var slideObj = $("#img-list").children("ul");
    var imgLen = slideObj.children("li").length;
    /*var imgNav = $("#img-nav");
    for (var i = 0; i < imgLen; i++) {
        if (i == 0)	{
            imgNav.append('<li class="select"><a href="javascript:void(0);">'+i+'</a></li>');
        } else {
            imgNav.append('<li><a href="javascript:void(0);">'+i+'</a></li>');
        }
    }*/

    var page = 0;//当前图片的位置
    var imgWidth = $("#img-list").width();
    //下一张
    $("#main-area .next").click(function(){
        if(!slideObj.is(":animated")) {
            page++;
            if (page == imgLen) {
                page = 0;
            }
            imgSlide(slideObj, page);
        }
    });
    //上一张
    $("#main-area .last").click(function(){
        if(!slideObj.is(":animated")) {
            page--;
            if (page == -1) {
                page = imgLen - 1;
            }
            imgSlide(slideObj, page);
        }
    });
    //设置年份
    $("#footer .current-year").text(getCurrentYear());
});
//图片滑动的方法
function imgSlide(slideObj, index) {
    var imgWidth = $("#img-list").width();
    //nav.eq(index).addClass("select").siblings().removeClass("select");
    slideObj.animate({left: -index * imgWidth}, 200);
}
//加载导航菜单
function loadNavMenu(code) {
    $.ajax({
        type: "POST",
        url: "/uums/menu/nav",
        data: {code: code},
        dataType: 'json',
        success: function (data) {
            if (data) {
                var navStr = '<div class="location"><span>您所在的位置：</span>';
                for (var i = 0; i < data.length; i++) {
                    navStr += '<a href="'+data[i].menuUrl+'">'+data[i].menuName+'</a><span>&gt;</span>';
                }
                $("#nav-location").html(navStr+'</div>');
            }
        }
    });
}
//获取当前年份
function getCurrentYear() {
    var dateObj = new Date();
    return dateObj.getFullYear();//年份
}


