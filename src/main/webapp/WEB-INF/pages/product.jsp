<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<head>
	<title>Product Selection</title>
	<meta charset="UTF-8">
	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
	<meta name="viewport" content="width=device-width, initial-scale=1,
    maximum-scale=1, user-scalable=no">

	<script src="https://code.jquery.com/jquery-3.1.0.min.js"   integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s="   crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/resources/js/thirdparty/angular.min.js"></script>
	<!-- Latest compiled and minified CSS -->

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/app.js"></script>
	<script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/productFactory.js"></script>
	<script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/restService.js"></script>
	<script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/basketService.js"></script>
	<script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/productController.js"></script>
	<script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/helper.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/site.css">
</head>
<body ng-app="skyApp" ng-controller="ProductController">
<div class="container-fluid" >

	<div class="row">
		<div class="col-md-12 col-xs-12" style="background-image:url('http://placekitten.com/200/300')">
			<h1>Header</h1>
		</div>

	</div>

	<div class="row">
        <div class="col-md-2"> Select user
            <select ng-init = "userList[0]" ng-model= "selectedUser" ng-options="item.userId as item.userName for item in userList" ng-change="updateProduct()"></select>
        </div>
		<div class="col-md-8 col-xs-8">
			<div class="col-md-2" id ="ent">ENTERTAINMENT
				<div id="entCont"> </div>
			</div>
			<div class="col-md-2" id="mus">MUSIC
				<div id = "musCont"></div>
			</div>
			<div class="col-md-2" id="sport">SPORTS
				<div id = "sptCont"></div>
			</div>
			<div class="col-md-2" id="news">NEWS
				<div id = "newsCont"></div>
			</div>

		</div>
		<div id="productList" class="col-md-2 col-xs-2">
			<label>Basket</label>
			<ul id="shoppingItem">
				<li ng-repeat="item in shoppingList">
						{{item.value}}
				</li>
			</ul>
			<button ng-show="shoppingList.length > 0" ng-click="submitShopping()">Submit</button>
		</div>
	</div>

</body>
</html>