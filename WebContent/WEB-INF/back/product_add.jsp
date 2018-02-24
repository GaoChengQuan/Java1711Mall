<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<style type="text/css">
		.main_div{
			margin : 15px;
		}
	</style>
<title>- 商品添加</title>
</head>
<body>
	<div class="main_div">
		<form class="layui-form layui-form-pane" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">商品名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" autocomplete="off"
						placeholder="请输入商品名称" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品副标题</label>
				<div class="layui-input-block">
					<input type="text" name="subtitle" lay-verify="required"
						placeholder="请输入商品副标题" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品分类</label>
				<div class="layui-input-inline">
					<select name="quiz1">
						<option value="">请选一级分类</option>
						<option value="浙江" selected="">浙江省</option>
						<option value="你的工号">江西省</option>
						<option value="你最喜欢的老师">福建省</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="quiz2">
						<option value="">请选择市</option>
						<option value="杭州">杭州</option>
						<option value="宁波" disabled="">宁波</option>
						<option value="温州">温州</option>
						<option value="温州">台州</option>
						<option value="温州">绍兴</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品价格</label>
				<div class="layui-input-block">
					<input type="text" name="price" autocomplete="off"
						placeholder="请输入商品价格" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">商品库存</label>
				<div class="layui-input-block">
					<input type="text" name="stock" autocomplete="off"
						placeholder="请输入商品库存" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item" pane="">
				<label class="layui-form-label">商品状态</label>
				<div class="layui-input-block">
					<input type="radio" name="status" value="1" title="上架" checked="">
					<input type="radio" name="status" value="2" title="下架">
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">文本域</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea" name="detail"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<button class="layui-btn" lay-submit="" lay-filter="demo2">跳转式提交</button>
			</div>
		</form>
	</div>
	<script>
		layui.use(['form'], function(){
		  var form = layui.form;
		});
		
		$(function(){
			//加载一级分类
			$.ajax({
				url : '${ctx}/manager/category/selectTopCategory.action',
				type : "POST",
				dataType : "json",
				success : function(jsonObj){
					console.log(jsonObj);
					
				}
			});
		});
	</script>
</body>
</html>
