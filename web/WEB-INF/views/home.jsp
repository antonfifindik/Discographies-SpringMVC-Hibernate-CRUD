<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <style>

        .out {
            margin: 20px;
        }

        .bottom {
            margin-bottom: 10px;
        }

    </style>


    <title>Альбомы</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <!-- Navbar content -->
    <a class="navbar-brand" href="/home">Discographies</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Альбомы<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Авторы</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Жанры</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/test">Тест</a>
            </li>
        </ul>
    </div>

</nav>
<div class="out">
    <h2>Альбомы</h2>
</div>

<a href="#" class="btn btn-primary btn-md active " data-toggle="modal" data-target="#exampleModal"
   style="margin-left: 20px" role="button" aria-pressed="true">Добавить
    альбом</a>

<div class="out">
    <table id="myTable" class="table table-bordered table-hover">

        <thead class="thead-dark">
        <tr>
            <th width="3%">#</th>
            <th width="1%">Обложка</th>
            <th width="7%">Название</th>
            <th width="7%">Автор</th>
            <th width="7%">Релиз</th>
            <th width="13%">Жанры</th>
            <th width="8%">Лейблы</th>
            <th width="6%">Длина</th>
            <th width="8%">Тип</th>
            <th width="11%"></th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="album" items="${albumsList}" varStatus="status">
            <tr>
                <th scope="row">${album.id}</th>
                <td><a href="/infoAlbum?id=${album.id}"><img alt="img"
                                                             src="data:image/jpeg;base64,${album.toEncodeBase64()}"
                                                             width="50px" height="50px"></a></td>
                <td><a href="/infoAlbum?id=${album.id}">${album.name}</a></td>
                <td><a href="/infoAuthor?id=${album.author.id}">${album.author.name}</a></td>
                <td>${album.releaseDate}</td>
                <td style="font-size: small">
                    <c:forEach var="genre" items="${album.genres}" varStatus="i">
                        <c:if test="${i.index < album.genres.size() - 1}">
                            <a href="/infoGenre?id=${genre.id}">${genre.name}/</a>
                        </c:if>
                        <c:if test="${i.index == album.genres.size() - 1}">
                            <a href="/infoGenre?id=${genre.id}">${genre.name}</a>
                        </c:if>
                    </c:forEach>
                </td>
                <td style="font-size: small">
                    <c:forEach var="label" items="${album.labels}" varStatus="i">
                        <c:if test="${i.index < album.labels.size() -1}">
                            <a href="/infoLabel?id=${label.id}">${label.name}/</a>
                        </c:if>
                        <c:if test="${i.index == album.labels.size() - 1}">
                            <a href="/infoLabel?id=${label.id}">${label.name}</a>
                        </c:if>
                    </c:forEach>
                </td>
                <td style="font-size: small">
                        ${album.length}<br>${album.songs.size()} треков
                </td>

                <td style="font-size: small"><a
                        href="/infoAlbumType?id=${album.albumType.id}">${album.albumType.name}/<a
                        href="/infoRecordType?id=${album.recordType.id}">${album.recordType.name}</a></td>

                <td>
                    <a href="/editAlbum?id=${album.id}" class="btn btn-sm btn-warning"
                       style="width: 75px" role="button" aria-pressed="true">Изменить</a>
                    <a href="/deleteAlbum?id=${album.id}" class="btn btn-sm btn-danger"
                       style="width: 75px" role="button" aria-pressed="true">Удалить</a>
                </td>


            </tr>
        </c:forEach>

        </tbody>

    </table>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Добавление нового альбома</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h2>Тест</h2>
                Йорк полагал, что его музыка стала, своего рода, частью постоянного фонового шума, который он называл
                «жужжанием холодильника» и при этом стал ещё более враждебно относиться к музыкальным СМИ. Он также
                говорил, что стал ещё более разочаровываться в «мифологии» рок-музыки, чувствуя при этом, что сам жанр
                изжил себя. Исходя из своих утверждений, Йорк начал слушать исключительно электронную музыку таких
                исполнителей как Aphex Twin и Autechre: "Это было глотком свежего воздуха для меня. Структура этой
                музыки совсем не имела в себе человеческого голоса. Но я чувствовал себя также эмоционально, так как я
                никогда не чувствовал себя слушая исключительно гитарную музыку".
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отменить</button>
                <button type="button" class="btn btn-primary">Добавить</button>
            </div>
        </div>
    </div>
</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
