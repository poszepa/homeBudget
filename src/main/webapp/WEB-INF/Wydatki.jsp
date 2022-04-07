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
            <form action="/homebudget/app/listaWydatkow" method="post">
                <select class="form-select" aria-label="Default select example" name="nazwaBazy">
                    <option selected>Open this select menu</option>
                    <c:forEach var="element" items="${nazwyBazDanych}">
                    <option value="${element}">${element}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-primary" type="submit">Szukaj</button>
            </form>
        </div>
        <div class="col-6">
            <p>Pozostało Pieniędzy: <button onclick="location.href='/homebudget/app/wyplata'" type="button" class="btn btn-outline-success">${wyplata} zł</button></p>
            <p>Aktualnie wybrana baza: ${bazaDanych}</p>
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
                    <th scope="row">#</th>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=dom'" type="button" class="btn btn-outline-primary koszta">${sumWydatkow.get(0)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=kieszonkowe'" type="button" class="btn btn-outline-secondary koszta">${sumWydatkow.get(1)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=media'" type="button" class="btn btn-outline-success koszta">${sumWydatkow.get(2)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=oszczednosci'" type="button" class="btn btn-outline-danger koszta">${sumWydatkow.get(3)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=podarunki'" type="button" class="btn btn-outline-warning koszta">${sumWydatkow.get(4)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=podroze'" type="button" class="btn btn-outline-info koszta">${sumWydatkow.get(5)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=potrzeby_codzienne'" type="button" class="btn btn-outline-dark koszta">${sumWydatkow.get(6)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=technologia'" type="button" class="btn btn-outline-primary koszta">${sumWydatkow.get(7)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=transport'" type="button" class="btn btn-outline-secondary koszta">${sumWydatkow.get(8)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=ubezpieczenie'" type="button" class="btn btn-outline-warning koszta">${sumWydatkow.get(9)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=zdrowie'" type="button" class="btn btn-outline-warning koszta">${sumWydatkow.get(10)}</button>
                    </td>
                    <td>
                        <button onclick="location.href='/homebudget/app/dodajWydatek?nazwaBazy=${bazaDanych}&kategoria=zobowiazania'" type="button" class="btn btn-outline-info koszta">${sumWydatkow.get(11)}</button>
                    </td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col">
        </div>
        <div class="col">
            <div style="height: 400px; width: 600px;" class="chart">
                <canvas id="myChart" ></canvas>
            </div>
        </div>
        <div class="col">
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js@3/dist/chart.min.js"></script>
<script>
    const values = document.querySelectorAll('.koszta');
    const arrayValue = [];
    values.forEach(e => {
        arrayValue.push(e.innerText);
    })
    console.log(arrayValue)
    const ctx = document.getElementById('myChart').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: [
                'dom',
                'kieszonkowe',
                'media',
                'oszczednosci',
                'podarunki',
                'podroze',
                'potrzeby_codzienne',
                'technologia',
                'transport',
                'ubezpieczenie',
                'zdrowie',
                'zobowiazania'
            ],
            datasets: [{
                label: 'Wykres wydatków',
                data: [arrayValue[0], arrayValue[1], arrayValue[2], arrayValue[3], arrayValue[4], arrayValue[5], arrayValue[6], arrayValue[7], arrayValue[8], arrayValue[9], arrayValue[10], arrayValue[11]],
                backgroundColor: [
                    'rgb(117,66,66)',
                    'rgb(80,174,238)',
                    'rgb(255, 205, 86)',
                    'rgb(88,108,122)',
                    'rgb(121,93,203)',
                    'rgb(26,41,51)',
                    'rgb(80,76,162)',
                    'rgb(94,98,44)',
                    'rgb(108,120,128)',
                    'rgb(57,136,61)',
                    'rgb(235,54,54)',
                    'rgb(152,19,60)'
                ],
                hoverOffset: 4
            }]
        }
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>