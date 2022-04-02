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
            <form>
                <select class="form-select" aria-label="Default select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
                <select class="form-select" aria-label="Default select example">
                    <option selected>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
                <button class="btn btn-primary" type="submit">Button</button>
            </form>
        </div>
        <div class="col-6">
            Pozostało Pieniędzy:
        </div>
    </div>
    <div class="row">
        <div class="col-10">
            <table class="table table-responsive{-sm|-md|-lg|-xl|-xxl}">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=dom">dom</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=kieszonkowe">kieszonkowe</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=media">media</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=oszczednosci">oszczednosci</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=podarunki">podarunki</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=podroze">podroze</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=potrzeby_codzienne">potrzeby_codzienne</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=technologia">technologia</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=transport">transport</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=ubezpieczenie">ubezpieczenie</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=zdrowia">zdrowia</a></th>
                    <th scope="col"><a href="/homebudget/dodajWydatek?kategoria=zobowiazania">zobowiazania</a></th>
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