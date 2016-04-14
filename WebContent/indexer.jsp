<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Bill Manager</title>
</head>
<body>

<s:actionerror/>

<s:iterator value="ebill" var="bil">
 </s:iterator>

 
<s:form action="add" method="post">
    <s:hidden name="bill.sno" value="%{#bil.sno}" />
    <s:textfield name="bill.invoice" label="Invoice(int)" value="%{#bil.invoice}"/>
    <s:textfield name="bill.item"  label="Item(String)" value="%{#bil.item}"/>
    <s:textfield name="bill.qty"   label="Quantity(int)" value="%{#bil.qty}"/>
    <s:textfield name="bill.price" label="Price(int)" value="%{#bil.price}"/>
    <s:submit value="Bill" align="center"/>
    
</s:form>


  
<h2>ALL BILLS</h2>
<table>
<tr>
    <th>Sno</th>
    <th>Invoice</th>
    <th>Item</th>
    <th>Quantity</th>
    <th>Price</th>
</tr>
<s:iterator value="billList" var="bill">
    <tr>
        <td><s:property value="sno"/></td>
        <td><s:property value="invoice"/></td>
        <td><s:property value="item"/></td>
        <td><s:property value="qty"/></td>
        <td><s:property value="price"/></td>
        <td><a href="delete?sno=<s:property value="sno"/>">delete</a></td>
        <td><a href="edit?sno=<s:property value="sno"/>">edit</a></td>
    </tr> 
</s:iterator>
</table>
</body>
</html>