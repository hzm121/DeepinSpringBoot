<%--
  Created by IntelliJ IDEA.
  User: huangzhenmin
  Date: 2019-10-23
  Time: 00:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>

</head>
<body>
<h1>抢购产品测试</h1>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="javascript">
    var params = {
        userId :1,
        productId:1,
        quantity:3
    };
    $.post("./purchase",params,function (result) {
        alert(result.message);
    });
</script>
</html>
