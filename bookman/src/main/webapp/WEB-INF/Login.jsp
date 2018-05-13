<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta name="viewport" content="text">
<link href="src/main/webapp/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
<style type="text/css">
.container-fluid{
width:40%;
position:absolute;
left:50%;
top:50%;
margin-left:-304px;
margin-top: -123px;
}</style>
</head>

<body>
<div class="container-fluid well">
<div class="row">
<div class="col-md-12">
<form class="form-horizontal" role="form" method="post"
action="login">

<div class="form-group">
<%if(request.getAttribute("msg")!=null) {%>
<div class="alert alert-warning"
role="alert"><%=request.getAttribute("msg") %></div>
<%} %>
 <label for="inputName" class="col-sm-2 control-label">
 ⽤户名:
 </label>
 <div class="col-sm-10">
<input type="text" class="form-control" id="inputName"
name="name" value="
<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>"/>
 </div>
 </div>
 <div class="form-group">
 <label for="inputPwd" class="col-sm-2 control-label">
 密码
 </label>
<div class="col-sm-10">
<input type="password" class="form-control" id="inputPwd"
name="pwd"/>
 </div>
 </div>
 <div class="form-group">
 <label for="inputVcode" class="col-sm-2 control-label">
 验证码
 </label>
 <div class="col-sm-6">
<input type="text" class="form-control" id="inputVcode"
name="vcode" maxlength="4"/>
 </div>
 <div class="col-sm-4">
 <img alt="" src="vcode.png" id="vcodeImg" title="单击换图⽚">
 </div>
 </div>
 <div class="form-group">
 <div class="col-sm-offset-2 col-sm-10">
 <button type="submit" class="btn btn-default">
 </button>
</div>
 </div>
 </form>
 </div>
 </div>
</div>
<script type="text/javascript" src="../bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#vcodeimg").click(function(evt){
		this.src="vcode.png?t="+Math.random();
	})
})
</script>
</body>
</html>