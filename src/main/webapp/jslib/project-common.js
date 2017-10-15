/**
 * 定义项目常用js常量
 */
var Constant = {
	emptyTipMsg : "请选择要操作的记录！",//编辑或删除未选择行的提示信息
	editFirstRow: "您选中了多条记录，默认编辑第一条选中的记录！",//easyui编辑时选中了多条记录，则默认选择编辑第一行
	inputWidth: 170,//设置easyui控件的默认宽度和高度
	inputHeight: 24,
	width: 140,
	height: 24,
	emptyContent: "--"
};

//设置下拉框和下拉树的默认宽度和高度
$.fn.combobox.defaults.width = Constant.inputWidth;
$.fn.combotree.defaults.width = Constant.inputWidth;
$.fn.datebox.defaults.width = Constant.inputWidth;
$.fn.datetimebox.defaults.width = Constant.inputWidth;
$.fn.combobox.defaults.height = Constant.inputHeight;
$.fn.combotree.defaults.height = Constant.inputHeight;
$.fn.datebox.defaults.height = Constant.inputHeight;
$.fn.datetimebox.defaults.height = Constant.inputHeight;

/**
 * 用于easyui表格的默认formatter，当不存在值时表格列显示的默认值
 */
function defaultFmt(value) {
	//值为数字0
	if (value === 0) {
		return 0;
	}
	return value ? value : Constant.emptyContent;
}
/**
 * 用于0：否，1：是的格式化列
 * @Date 2016-10-22下午2:29:45
 * @returns
 */
function yesNoFmt(value) {
	if (value == 1) {
		return "是";
	}
	if (value == 0) {
		return "否";
	}
	return Constant.emptyContent;
}

//获取当前年份
function getCurrentYear() {
    var dateObj = new Date();
    return dateObj.getFullYear();//年份
}

/**
 * 屏蔽退格键(backspace)，防止按backspace键刷新页面。
 * <p>只对密码框、可输入文本框、可输入多行文本框开启backspace键</p>
 * @param e 事件对象
 * @returns 禁用返回true,否则为false
 */
function banBackSpace(e) {
    var ev = e || window.event;//获取event对象
    //backspace键，其它键不监听
    if (ev.keyCode == "8") {
        //获取触发事件的元素
        var target = ev.target || ev.srcElement;
        //得到标签的名称
        var tagName = target.nodeName;
        //如果不是input标签或textarea标签，屏蔽backspace键
        if ((tagName == "INPUT") || (tagName == "TEXTAREA")) {
            //得到input标签的type属性
            var inputType = target.getAttribute("type");
            //得到input标签的readonly属性，将其属性值设置为readonly代表只读，不可输入。
            var inputReadonly = target.getAttribute("readonly");
            //1、对可输入的单行文本框启用backspace键，readonly属性值不是readonly
            if ((tagName == "INPUT") && (inputType == "text") && (inputReadonly != "readonly")) {
                return false;
            }
            //2、对可输入的密码框启用backspace键，readonly属性值不是readonly
            if ((tagName == "INPUT") && (inputType == "password") && (inputReadonly != "readonly")) {
                return false;
            }
            //3、对可输入的多行文本标签启用backspace键，readonly属性值不是readonly
            if ((tagName == "TEXTAREA") && (inputReadonly != "readonly")) {
                return false;
            }
        }
        return true;
    }
    return false;
}
/**
 * 此方法是在文档加载完成后屏蔽浏览器上的某些按键事件，防止按下这些按键刷新整个页面
 * 只能是keydown事件，对于keypress和keyup事件在IE和谷歌浏览器上backspace键和F5键无效
 * <p>enter键是13、backspace键是8、F5键是116</p>
 */
window.onload = function() {
    //屏蔽F5刷新键和backspace键
    document.onkeydown = function(event) {
        var code = event.keyCode;
        //屏蔽F5刷新键
        if (code == 116) {
            return false;
        }
        //屏蔽backspace键
        if (banBackSpace(event)) {
            return false;
        }
    };
    //只读文本框鼠标指针不可聚焦文本框
    inputReadBlur();
};
/**
 * 让只读文本框鼠标指针不可聚焦文本框
 * @Date 2016-8-13下午11:45:22
 * @param eleObj html标签对象
 */
function inputReadBlur(eleObj) {
    var ele = eleObj ? eleObj : window.document;
    //得到所有的input标签
    var inputTags = ele.getElementsByTagName("input");
    for (var i = 0; i < inputTags.length; i++) {
        var input = inputTags[i];
        //只读文本框
        if (input.getAttribute("readonly") == "readonly") {
            //绑定聚焦事件
            input.onfocus = function() {
                this.blur();//失去焦点
            }
        }
    }
}

