<%--
  Created by IntelliJ IDEA.
  User: LIUchang
  Date: 2020/9/28
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../baselist.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${ctx}/bootstrap-4.5.0-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<script src="${ctx}/webjars/jquery/3.3.1/jquery.js"></script>
<script src="${ctx}/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<body>
<div>
    <table class="table table-hover">
        <tr>
            <th class="font-weight-bolder">客户名称：</th>
            <td class="font-weight-bolder">${contractToviewId.customName}</td>
            <th class="font-weight-bolder">收购方：</th>
            <td class="font-weight-bolder">${contractToviewId.offeror}</td>
        </tr>
        <tr>
            <th class="font-weight-bolder">贸易条款：</th>
            <td class="font-weight-bolder">
                <div class="spinner-border" role="status">
                    <span class="sr-only">Loading...</span>
                </div>

            </td>
            <th class="font-weight-bolder">验货员：</th>
            <td class="font-weight-bolder">${contractToviewId.inspector}</td>
        </tr>
        <tr>
            <th class="font-weight-bolder">制单员：</th>
            <td class="font-weight-bolder">${contractToviewId.inputBy}</td>
            <th class="font-weight-bolder">审单员：</th>
            <td class="font-weight-bolder">${contractToviewId.checkBy}</td>
        </tr>
        <tr>
            <th class="font-weight-bolder">要求：</th>
            <td class="font-weight-bolder"><textarea class="form-control"
                                                     aria-label="With textarea">${contractToviewId.request}</textarea>
            </td>
            <th class="font-weight-bolder">说明：</th>
            <td class="font-weight-bolder"><textarea class="form-control"
                                                     aria-label="With textarea">${contractToviewId.remark}</textarea>
            </td>
        </tr>
    </table>
    <h3>货物列表</h3>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">序号</th>
            <th scope="col">厂家名</th>
            <th scope="col">货号</th>
            <th scope="col">数量</th>
            <th scope="col">包装单位</th>
            <th scope="col">装率</th>
            <th scope="col">箱数</th>
            <th scope="col">单价</th>
            <th scope="col">总金额</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${proAndExtFind}" var="pro" varStatus="ionw">
            <tr>
                <th scope="row" class="text-warning">${ionw.count}</th>
                <td>${pro.factoryId}</td>
                <td>${pro.productNo}</td>
                <td>${pro.cnumber}</td>
                <td>${pro.packingUnit}</td>
                <td>${pro.loadinfRate}</td>
                <td>${pro.boxNum}</td>
                <td>${pro.price}</td>
                <td>${pro.amount}</td>
            </tr>
            <c:if test="${pro.extCproductCList != null}">
                <c:forEach items="${pro.extCproductCList}" var="ext" varStatus="itow">
                    <tr>
                        <th scope="row" class="text-warning">附件：${itow.count}</th>
                        <td>${ext.factoryId}</td>
                        <td>${ext.productNo}</td>
                        <td>${ext.cnumber}</td>
                        <td>${ext.packingUnit}</td>
                        <td>${ext.loadingRate}</td>
                        <td>${ext.boxNum}</td>
                        <td>${ext.price}</td>
                        <td>${ext.amount}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
