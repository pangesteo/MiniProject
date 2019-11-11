<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<section class="content-header">
	<h1>Asset Form Update</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-book"></i> Home</a></li>
		<li class="active">Master</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">

	<div class="box">

		<div class="form-container">



			<form:form method="POST" modelAttribute="asset"
				class="form-horizontal" action="update">

				<%-- 		<form action="#" th:action="@{/update}" th:object="${asset}" --%>
				<%--             method="post"> --%>
				<div class="box-body">
					<div class="form-group">
						<label class="col-md-3" for="assetid">AssetID</label>
						<div class="col-md-7">
							<form:input type="text" path="assetid" id="assetid"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="assetid" class="help-inline" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3" for="assetnumber">AssetNumber</label>
						<div class="col-md-7">
							<form:input type="text" path="assetnumber" id="assetnumber"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="assetnumber" class="help-inline" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3" for="assetname">AssetName</label>
						<div class="col-md-7">
							<form:input type="text" path="assetname" id="assetname"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="assetname" class="help-inline" />
							</div>
						</div>
					</div>
					
					<div class="form-group">
							<label class="col-md-3" for="category">Category</label>
							<div class="col-md-7" >
									<select class="form-control" name="category" id="category th:field="*{category}">
										<option value="pilih">Kategori</option>
		                    			<option value="Assettetap">Asset tetap</option>
		                    			<option value="Assetbergerak">Asset Bergerak</option>
		                    		</select>
							</div>
						</div>


					</div>

					<div class="box-footer">
						<input type="submit" value="Register"
							class="btn btn-primary btn-sm">
						<a href="/asset" class="btn btn-danger btn-sn">Back</a>
					</div>


			</form:form>
		</div>
	</div>
</section>
