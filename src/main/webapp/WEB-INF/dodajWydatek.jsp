<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
    <style>
        .dodajWydatek{
            padding: 5px;
            margin: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/TopNavbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col">
            <form class="dodajWydatek" method="post" action="/homebudget/dodajWydatek">
                <input type="text" name="skrotWydatku" placeholder="skrót wydatku najpiej jedno słowo." class="form-control">
                <textarea name="opisWydatku" placeholder="opis Wydatku" class="form-control"></textarea>
                <input type="number" name="kwota" placeholder="kwota wydatku" class="form-control">
                <input type="hidden" name="kategoria" value="${kategoria}">
                <input type="hidden" name="nazwaBazy" value="${nazwaBazy}">
                <button class="btn btn-primary" type="submit">Dodaj Wydatek</button>
            </form>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>