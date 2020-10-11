<%--
  Created by IntelliJ IDEA.
  User: LIUchang
  Date: 2020/9/24
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="hidden" name="contratProductId" value="${con.contratProductId}"/>
    <input type="hidden" name="contractId" value="${sessionScope.contractId}"/>
    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="save"><a href="#"
                                         onclick="formSubmit('${ctx}/productc/contractProductAndUpdateTwo','_self');">确定</a>
                        </li>
                        <li id="back"><a href="list.action">返回</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">

        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">
                    修改货物信息
                </div>
            </div>
        </div>
        <div>
            <div>
                <table class="commonTable" cellspacing="1">
                    <tr>
                        <td class="columnTitle_mustbe">厂家名称：</td>
                        <td class="tableContent">
                            <select name="factoryId" onchange="setFactoryName(this.options[this.selectedIndex].text);">
                                <option value="">--请选择--</option>
                                <c:forEach items="${sessionScope.factoryList}" var="f">
                                    <option value="${f.factoryId}"  ${f.factoryId eq con.factoryId?'selected':''}>${f.factoryName}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" id="factoryName" name="factoryName" value=""/>
                        </td>
                        <td class="columnTitle_mustbe">货号：</td>
                        <td class="tableContent"><input type="text" name="productNo" value="${con.productNo}"/></td>
                    </tr>
                    <tr>
                        <td class="columnTitle_mustbe">货物照片：</td>
                        <td class="tableContent"><input type="text" name="productImage"  value="${con.productImage}"/></td>
                    </tr>
                    <tr>
                        <td class="columnTitle_mustbe">数量：</td>
                        <td class="tableContent"><input type="text" name="cnumber" value="${con.cnumber}"/></td>
                        <td class="columnTitle_mustbe">包装单位：</td>
                        <td class="tableContent"><input type="text" name="packingUnit" value="${con.packingUnit}"/></td>
                    </tr>
                    <tr>
                        <td class="columnTitle_mustbe">装率：</td>
                        <td class="tableContent"><input type="text" name="loadinfRate" value="${con.loadinfRate}"/></td>
                        <td class="columnTitle_mustbe">箱数：</td>
                        <td class="tableContent"><input type="text" name="boxNum" value="${con.boxNum}"/></td>
                    </tr>
                    <tr>
                        <td class="columnTitle_mustbe">单价：</td>
                        <td class="tableContent"><input type="text" name="price" value="${con.price}"/></td>
                        <td class="columnTitle_mustbe">排序号：</td>
                        <td class="tableContent"><input type="text" name="orderNo" value="${con.orderNo}"/></td>
                    </tr>
                    <tr>
                        <td class="columnTitle_mustbe">货物描述：</td>
                        <td class="tableContent"><textarea name="productDesc" style="height:120px;">${con.productDesc}</textarea></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>
