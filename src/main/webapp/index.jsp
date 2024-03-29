<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Strona główna</title>
    <style>
        .dodajWydatek {
            padding: 5px;
            margin: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/TopNavbarBeforeLogin.jsp"></jsp:include>

<div class="container">
    <div class="row">
    </div>
    <div class="row">
        <div class="col">
        </div>
        <div class="col">
            <form method="post" action="/homebudget/login">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                <div class="col">
                    <input type="email" class="form-control" id="inputEmail3" name="email">
                </div>
                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                <div class="col">
                    <input type="password" class="form-control" id="inputPassword3" name="password">
                </div>
                <div class="col">
                    <button type="submit" class="btn btn-primary">zaloguj się</button>
                    <a class="btn btn-primary" href="/homebudget/register">zarejestruj się</a>
                </div>
            </form>
            <c:choose>
                <c:when test="${login.equals('wrong')}">
                    <div class="alert alert-danger col-2" role="alert">
                        Zły login lub hasło !
                    </div>
                </c:when>
            </c:choose>
        </div>
        <div class="col">
        </div>
    </div>
    <div class="row">
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>