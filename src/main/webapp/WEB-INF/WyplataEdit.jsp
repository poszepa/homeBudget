<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Wypłata edit</title>
    <style>
        .dodajWydatek {
            padding: 5px;
            margin: 5px;
        }

        .flex-right{
            display: flex;
            align-content: end;
            justify-content: end;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/TopNavbar.jsp"></jsp:include>
<h1 style="text-align: center">${kategoria}</h1>
<div class="container">
    <div class="row">
        <div class="col">
            <form class="dodajWydatek" method="post" action="/homebudget/app/wyplataEdit">
                <input type="text" name="wyplataOpis" placeholder="Opis przychodu np. Kamila wypłata za marzec"
                       class="form-control" value="${wyplata.opis}">
                <input type="number" step="0.01" name="kwota" placeholder="Kwota wpływu" class="form-control" value="${wyplata.wyplata}">
                <input type="hidden" name="id" value="${wyplata.id}">
                <input type="hidden" name="data" value="${wyplata.dataDodania}">
                <button class="btn btn-primary" type="submit">Edytuj wpływ</button>
            </form>
            <form class="dodajWydatek flex-right" method="post" action="/homebudget/app/wyplataDelete">
                <input type="hidden" name="id" value="${wyplata.id}">
                <button class="btn btn-outline-danger" type="submit">Usuń Przychód</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>