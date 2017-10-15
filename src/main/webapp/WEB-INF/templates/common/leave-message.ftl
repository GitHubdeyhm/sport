
<div id="leave-message-box">
    <div class="message-big-box">
        <div class="box-title clearfix">
            <span class="title-text">请您留言</span>
            <span class="small-box" title="缩小">—</span>
        </div>
        <div class="box-body">
            <form id="leave_message_form" action="${webRoot}/manage/message/save" method="post">
            <ul>
                <li>
                    <textarea name="message" placeholder="请输入留言内容，我们会尽快与你联系！（必填）" id="message_message"></textarea>
                </li>
                <li>
                    <input type="text" name="phone" placeholder="手机号码（必填）" id="phone_message">
                </li>
                <li>
                    <input type="text" name="userName" placeholder="姓名（选填）" id="userName_message">
                </li>
                <li>
                    <input type="text" name="adress" placeholder="所在地址（选填）" id="adress_message">
                </li>
                <li>
                    <input type="button" value="提交留言" id="message_button" class="btn-message" />
                </li>
            </ul>
            </form>
        </div>
    </div>
    <div class="message-small-box">
        <h2>请<br/>您<br/>留<br/>言</h2>
    </div>
</div>