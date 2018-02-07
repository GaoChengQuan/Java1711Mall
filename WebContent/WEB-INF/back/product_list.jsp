<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title> - 商品列表</title>
</head>
<body>
	<div class="demoTable">
	  名称：
	  <div class="layui-inline">
	    <input class="layui-input" name="id" id="searchName" autocomplete="off">
	  </div>
	  子标题：
	  <div class="layui-inline">
	    <input class="layui-input" name="id" id="searchSubtitle" autocomplete="off">
	  </div>
	  <button class="layui-btn" data-type="reload">搜索</button>
	</div>
	<table class="layui-hide" id="datagrid"></table>
	
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#datagrid', //要渲染哪个表格
		    url:'${ctx}/manager/product/pageList.action', //异步数据接口
		    cellMinWidth: 50, //列宽自动分配，全局定义常规单元格的最小宽度
		    cols: [[
		      {field:'id', title: 'ID', sort: true},
		      {field:'name', title: '名称', sort: true},
		      {field:'subtitle', title: '标题', sort: true},
		      {field:'price', title: '价格', sort: true},
		      {field:'stock', title: '库存', sort: true},
		      {field:'status', title: '状态', sort: true},
		      {field:'createTime', title: '创建时间', sort: true},
		      {field:'updateTime', title: '更新时间', sort: true},
		    ]],
		    page: true,
		    id : "listReload" //设定容器唯一ID，id值是对表格的数据操作方法上是必要的传递条件，它是表格容器的索引
		  });
		  
		  active = {
		    //这里的表格重载是指对表格重新进行渲染，包括数据请求和基础参数的读取
		    reload: function(){
		      //执行重载
		      table.reload('listReload', {//参数 ID 即为基础参数id对应的值,容器唯一ID 
	    	  	where: { //设定异步数据接口的额外参数，任意设
	    		    name : $('#searchName').val(),
	    		    subtitle : $('#searchSubtitle').val(),
	    		},
	    		page: {
	    		   curr: 1 //重新从第 1 页开始
	    		}
		      });
		    }
		  };
		  
		  //触发搜索按钮点击事件
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		});
	</script>
</body>
</html>
