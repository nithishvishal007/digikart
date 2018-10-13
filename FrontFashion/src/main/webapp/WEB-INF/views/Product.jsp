<%@include file="Header.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${flag}">
	<form:form action="addProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table align="center">
	<tr>
		<td colspan="2"><center>Product Detail</center></td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td><form:input path="productname" /><form:errors path="productname" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr bgcolor="pink">
		<td>Price</td>
		<td><form:input path="price" /><form:errors path="price" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><form:input path="quantity" /><form:errors path="quantity" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr bgcolor="pink">
		<td>Category</td>
		<td><form:select path="categoryid">
				<form:option value="0" label="--Select List--" />
				<form:options items="${categoryList}" />
			</form:select></td>
	</tr>
	<tr>
		<td>Supplier</td>
		<td><form:input path="supplierid" /><form:errors path="supplierid" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr bgcolor="pink">
		<td>Product Description</td>
		<td><form:input path="productDesc" /><form:errors path="productDesc" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr>
		<td>Product Image</td>
		<td><form:input type="file" path="pimage"/></td>
	</tr>
	
	<tr>
		<td colspan="2"><center>
				<input type="submit" value="Insert Product" />
				<center>
		</td>
	</tr>
</table>
</form:form>
</c:if>
<c:if test="${!flag}">
	<form:form action="updateProduct" modelAttribute="product" method="post" enctype="multipart/form-data" >
	<table align="center">
	<tr>
		<td colspan="2"><center>Product Detail</center></td>
	</tr>
	<tr>
	<td><form:input path="productid" value="${productid}" required="true"/></td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td><form:input path="productname" value="${productname}" required="true"/>
		<form:errors path="productname"></form:errors>
		</td>
	</tr>
	<tr bgcolor="pink">
		<td>Price</td>
		<td><form:input path="price" value="${price}" required="true"/>
		<form:errors path="price" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><form:input path="quantity" value="${quantity}" required="true"/>
		<form:errors path="quantity" cssStyle="color:red"></form:errors></td>
	</tr>
	<tr bgcolor="pink">
		<td>Category</td>
		<td><form:select path="categoryid">
				<form:option value="0" label="--Select List--" />
				<form:options items="${categoryList}" />
			</form:select></td>
	</tr>
	<tr>
		<td>Supplier</td>
		<td><form:select path="supplierid">
				<form:option value="0" label="--Select List--" />
				<form:options items="${supplierList}" />
			</form:select></td>
	</tr>
	<tr bgcolor="pink">
		<td>Product Description</td>
		<td><form:input path="productDesc" required="true"/>
		<form:errors path="productDesc" cssStyle="color:red"></form:errors></td>
	</tr>
	
	<tr>
		<td colspan="2"><center>
				<input type="submit" value="Update Product" />
				<center>
		</td>
	</tr>

	</table>
	</form:form>
</c:if>


<table align="center" class="table">
<tr><td colspan="6"><center>Product Detail</center></td></tr>
<tr>
	<td> Product ID</td>
	<td> Product Name</td>
	<td> Price </td>
	<td> Stock</td>
	<td> Category</td>
	<td>Images</td>
	<td> Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>
		<td>${product.productid}</td>
		<td>${product.productname}</td>
		<td>${product.price}</td>
		<td>${product.quantity}</td>
		<td>${product.categoryid}</td>
		<td> <img src="<c:url value='/resources/images${product.productid}.jpg' ></c:url>" width="80 px" height="100 px"/></td>
		<td>
		<a href="<c:url value="/deleteProduct/${product.productid}"/>"> <button type="button" class="btn btn-danger">Delete</button></a>
		<a href="<c:url value="/editProduct-${product.productid}"/>"><button type="button" class="btn btn-primary">Edit</button></a>
		</td>
</tr>
</c:forEach>
</table>