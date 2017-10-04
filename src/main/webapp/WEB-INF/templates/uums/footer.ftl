<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${webRoot}/resources/jslib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title>菜单信息</title>
</head>
<body>

    <div>
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">名字</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="firstname" placeholder="请输入名字">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">姓</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lastname" placeholder="请输入姓">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox">请记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                </div>
            </div>
        </form>
    </div>



<script src="${webRoot}/jslib/jquery-1.11.3.min.js"></script>
<script src="${webRoot}/jslib/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>