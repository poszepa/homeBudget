<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/TopNavbar.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col">
            <form action="/homebudget/listaWydatkow" method="post">
                <select class="form-select" aria-label="Default select example" name="miesiac">
                    <option selected>Open this select menu</option>
                    <c:forEach var="miesiac" items="${miesiacList}">
                    <option value="${miesiac.miesiac}">${miesiac.miesiac}</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" name="rok">
                    <option selected>Open this select menu</option>
                    <c:forEach var="rok" items="${rokList}">
                        <option value="${rok.rok}">${rok.rok}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-primary" type="submit">Szukaj</button>
            </form>
        </div>
        <div class="col-6">
            <p>Pozostało Pieniędzy:</p>
            <p>Aktualnie wybrana baza: ${nazwaBazy}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-10">
            <table class="table table-responsive{-sm|-md|-lg|-xl|-xxl}">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">dom</th>
                    <th scope="col">kieszonkowe</th>
                    <th scope="col">media</th>
                    <th scope="col">oszczednosci</th>
                    <th scope="col">podarunki</th>
                    <th scope="col">podroze</th>
                    <th scope="col">potrzeby_codzienne</th>
                    <th scope="col">technologia</th>
                    <th scope="col">transport</th>
                    <th scope="col">ubezpieczenie</th>
                    <th scope="col">zdrowia</th>
                    <th scope="col">zobowiazania</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <tr style="background-color: grey">
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                    <th scope="col">---</th>
                </tr>
                    <th scope="row">#</th>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=dom'" type="button" class="btn btn-outline-primary">${sumWydatkow.get(0)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=kieszonkowe'" type="button" class="btn btn-outline-secondary">${sumWydatkow.get(1)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=media'" type="button" class="btn btn-outline-success">${sumWydatkow.get(2)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=oszczednosci'" type="button" class="btn btn-outline-danger">${sumWydatkow.get(3)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=podarunki'" type="button" class="btn btn-outline-warning">${sumWydatkow.get(4)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=podroze'" type="button" class="btn btn-outline-info">${sumWydatkow.get(5)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=potrzeby_codzienne'" type="button" class="btn btn-outline-dark">${sumWydatkow.get(6)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=technologia'" type="button" class="btn btn-outline-primary">${sumWydatkow.get(7)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=transport'" type="button" class="btn btn-outline-secondary">${sumWydatkow.get(8)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=ubezpieczenie'" type="button" class="btn btn-outline-warning">${sumWydatkow.get(9)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=zdrowie'" type="button" class="btn btn-outline-warning">${sumWydatkow.get(11)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=zobowiazania'" type="button" class="btn btn-outline-info">${sumWydatkow.get(12)}</button>
                    </td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>