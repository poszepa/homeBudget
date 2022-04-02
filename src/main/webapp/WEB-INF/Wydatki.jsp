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
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=dom">dom</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=kieszonkowe">kieszonkowe</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=media">media</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=oszczednosci">oszczednosci</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=podarunki">podarunki</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=podroze">podroze</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=potrzeby_codzienne">potrzeby_codzienne</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=technologia">technologia</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=transport">transport</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=ubezpieczenie">ubezpieczenie</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=zdrowia">zdrowia</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?nazwaBazy=${nazwaBazy}&kategoria=zobowiazania">zobowiazania</a></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <tr style="background-color: grey">
                    <th scope="col">SUMA</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                    <th scope="col">zl</th>
                </tr>
                    <th scope="row">1</th>
                    <td>
                        <button type="button" class="btn btn-outline-primary">Primary</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-secondary">Secondary</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-success">Success</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-danger">Danger</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-warning">Warning</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-info">Info</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-dark">Dark</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-primary">Primary</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-secondary">Secondary</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-warning">Warning</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-warning">Warning</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-info">Info</button>
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