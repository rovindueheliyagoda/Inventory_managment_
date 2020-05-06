<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.Inventory"  %>   
    
    
    <!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/inventory.js"></script>
<meta charset="ISO-8859-1">


</head>
<body>


<div class="container">
<div class="row">
<div class="col-6">

<h1>Inventory Management</h1>
<form id="formItem" name="formItem" method="post" action="inventory.jsp">
Product code:
<input id="itemCode" name="itemCode" type="text"
class="form-control form-control-sm">
<br> Product name:
<input id="itemName" name="itemName" type="text"
class="form-control form-control-sm">
<br> Product price:
<input id="itemPrice" name="itemPrice" type="text"
class="form-control form-control-sm">
<br> Product description:
<input id="itemDesc" name="itemDesc" type="text"
class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save"
class="btn btn-primary">
<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
</form>


<div id="alertSuccess" class="alert alert-success"></div>

<div id="alertError" class="alert alert-danger"></div>
  
   <br>
   
   <%
   
   Inventory itemobj = new Inventory();
      out.print(itemobj.readItems());
   %>
   
   
   </div>
   </div>
   </div>


</body>
</html>