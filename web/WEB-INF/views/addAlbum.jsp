<%--
  Created by IntelliJ IDEA.
  User: Антон
  Date: 30.03.2018
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Добавление альбома</title>


    <style>

        .out {
            margin: 20px;
        }

        .bottom {
            margin-bottom: 10px;
        }

    </style>

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
            <li class="nav-item">
                <a class="nav-link" href="/home">Альбомы</a>
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

<div class="container" align="center" style="width: 30%; margin-top: 20px">
    <div class="page-header">
        <h1>Добавить альбом</h1>
    </div>


    <form name="album" enctype="multipart/form-data" action="/addAlbum" method="post" style="margin-top: 20px">

        <div class="input-group aligntop">
            <input type="text" id="name" name="name" class="form-control" placeholder="Название альбома" required>
        </div>

        <div style="display: flex; justify-content:center;" class="aligntop">
            <select class="form-control" id="author" name="author" required style="margin-top: 10px">
                <option selected disabled value=''>Автор</option>
                <c:forEach items="${authorsList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="input-group aligntop">
            <input type="text" id="releaseDate" name="releaseDate" class="form-control" placeholder="Дата релиза (день-месяц-год)"
                   required
                   style="margin-top: 10px">
        </div>

        <div class="input-group aligntop">
            <input type="text" id="length" name="length" class="form-control" placeholder="Продолжительность" required
                   style="margin-top: 10px">
        </div>

        <div style="display: flex; justify-content:center;" class="aligntop">

            <select class="form-control" id="albumType" name="albumType" required style="margin-top: 10px">
                <option selected disabled value=''>Тип альбома</option>
                <c:forEach items="${albumTypesList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>

        </div>

        <div style="display: flex; justify-content:center;" class="aligntop">

            <select class="form-control" id="recordType" name="recordType" required style="margin-top: 10px">
                <option selected disabled value=''>Тип записи</option>
                <c:forEach items="${recordTypesList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>

        </div>


        <div style="display: flex; justify-content:center;" class="aligntop">

            <select multiple class="form-control" id="genre" name="genre" required style="margin-top: 10px">
                <option selected disabled value=''>Жанры</option>
                <c:forEach items="${genresList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>


        </div>

        <a href="#" class="btn btn-primary btn-sm active " data-toggle="modal" data-target="#addGenreModal"
           style="margin-right: 320px" role="button" aria-pressed="true">+ Жанр</a>


        <div style="display: flex; justify-content:center;" class="aligntop">

            <select multiple class="form-control" id="label" name="label" required style="margin-top: 10px">
                <option selected disabled value=''>Лейблы</option>
                <c:forEach items="${labelsList}" var="item">
                    <option value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>


        </div>

        <a href="#" class="btn btn-primary btn-sm active " data-toggle="modal" data-target="#addLabelModal"
           style="margin-right: 320px" role="button" aria-pressed="true">+ Лейбл</a>


        <div style="display: flex; justify-content:center;" class="aligntop">

            <select multiple class="form-control" id="producer" name="producer" required style="margin-top: 10px">
                <option selected disabled value=''>Продюсеры</option>
                <c:forEach items="${producersList}" var="item">
                    <option value="${item.id}">${item.firstName} ${item.lastName}</option>
                </c:forEach>
            </select>


        </div>

        <a href="#" class="btn btn-primary btn-sm active " data-toggle="modal" data-target="#addProducerModal"
           style="margin-right: 320px" role="button" aria-pressed="true">+ Продюсер</a>


        <div class="form-group">
            <label style="margin-right: 230px" for="cover">Загрузите обложку</label>
            <input formenctype="multipart/form-data" type="file" name="cover" class="form-control-file" id="cover"
                   required>
        </div>

        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">Описания альбома</span>
            </div>
            <textarea class="form-control" id="description" name="description" aria-label="With textarea"
                      required></textarea>
        </div>

        <div style="margin-top: 10px">
            <a href="/" class="btn btn-primary btn-md"
               style="margin-left: 20px" role="button" aria-pressed="true">Отмена</a>
            <input type="submit" value="Добавить" class="btn btn-success aligntop">

        </div>

    </form>
</div>


<!-- Modal -->
<div class="modal fade" id="addSongModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="songModalLabel">Добавление новой песни</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form name="genre" action="/addSong" method="post" style="margin-top: 20px">

                    <div class="input-group aligntop">
                        <input type="text" id="songName" name="songName" class="form-control"
                               placeholder="Название песни" required>
                    </div>

                    <div class="input-group aligntop">
                        <input style="margin-top: 20px" type="text" id="songNum" name="songNum" class="form-control"
                               placeholder="Номер в альбоме" required>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отменить</button>
                        <input type="submit" value="Добавить" class="btn btn-success">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="addGenreModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Добавление нового жанра</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form name="genre" action="/addGenre" method="post" style="margin-top: 20px">

                    <div class="input-group aligntop">
                        <input type="text" id="genreName" name="genreName" class="form-control"
                               placeholder="Название жанра" required>
                    </div>

                    <div class="input-group" style="margin-top: 20px">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Описания жанра</span>
                        </div>
                        <textarea class="form-control" id="genreDescription" name="genreDescription"
                                  aria-label="With textarea"
                                  required></textarea>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отменить</button>
                        <input type="submit" value="Добавить" class="btn btn-success">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="addLabelModal" tabindex="-1" role="dialog" aria-labelledby="labelModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="labelModalLabel">Добавление нового лейбла</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form name="genre" enctype="multipart/form-data" action="/addLabel" method="post"
                      style="margin-top: 20px">

                    <div class="input-group aligntop">
                        <input type="text" id="labelName" name="labelName" class="form-control"
                               placeholder="Название лейбла" required>
                    </div>

                    <div class="input-group" style="margin-top: 20px">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Описания лейбла</span>
                        </div>
                        <textarea class="form-control" id="labelDescription" name="labelDescription"
                                  aria-label="With textarea"
                                  required></textarea>
                    </div>

                    <div class="form-group">
                        <label style="margin-right: 230px" for="cover">Загрузите обложку</label>
                        <input formenctype="multipart/form-data" type="file" name="labelImage"
                               class="form-control-file" id="labelImage"
                               required>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отменить</button>
                        <input type="submit" value="Добавить" class="btn btn-success">
                    </div>


                </form>
            </div>

        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="addProducerModal" tabindex="-1" role="dialog" aria-labelledby="labelModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ProducerModalLabel">Добавление нового продюсера</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form name="genre" enctype="multipart/form-data" action="/addProducer" method="post"
                      style="margin-top: 20px">

                    <div class="input-group aligntop">
                        <input type="text" id="producerFirstName" name="producerFirstName" class="form-control"
                               placeholder="Имя продюсера" required>
                    </div>

                    <div class="input-group aligntop">
                        <input style="margin-top: 20px" type="text" id="producerLastName" name="producerLastName"
                               class="form-control"
                               placeholder="Фамилия продюсера" required>
                    </div>

                    <div class="input-group" style="margin-top: 20px">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Описания лейбла</span>
                        </div>
                        <textarea class="form-control" id="producerDescription" name="producerDescription"
                                  aria-label="With textarea"
                                  required></textarea>
                    </div>

                    <div class="form-group">
                        <label style="margin-right: 230px" for="cover">Загрузите обложку</label>
                        <input formenctype="multipart/form-data" type="file" name="producerImage"
                               class="form-control-file" id="producerImage"
                               required>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Отменить</button>
                        <input type="submit" value="Добавить" class="btn btn-success">
                    </div>


                </form>
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
