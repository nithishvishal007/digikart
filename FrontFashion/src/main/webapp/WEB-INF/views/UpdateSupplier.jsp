<%@include file="Header.jsp"%>
<form action="<c:url value="/updateSupplier"/>" method="post">
<table align="center" class="table-bordered">
	<tr>
		<td colspan="2"><center>Supplier Detail</center></td>
	</tr>
	<tr>
		<td>Supplier Name</td>
		<td><input type="text" name="suppliername" value="${supplierData.suppliername}"></td>
	</tr>
	<tr>
		<td>Supplier Id</td>
		<td><input type="text" name="supplierid" value="${supplierData.supplierid}"></td>
	</tr>
	<tr>
		<td>Supplier Address</td>
		<td><input type="text" name="address" value="${supplierData.address}"></td>
	</tr>
	<tr>
		<td colspan="2">
				<input type="submit" value="UpdateSupplier"/>
		</td>
	</tr>

	</table>
	</form>