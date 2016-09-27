<%--
  Created by IntelliJ IDEA.
  User: sushilmainali
  Date: 19/09/2016
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Basket Page</title>
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
  <script rel="javascript"  src="${pageContext.request.contextPath}/resources/js/basketDisplayController.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/site.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/site.css">

</head>

<body ng-app="skyApp" ng-controller="BasketController">
<h1>Basket Page</h1>


<div > User has selected
  <ul>
    <li ng-repeat="item in productList">
        {{item}}
    </li>
  </ul>
</div>

</body>
</html>
