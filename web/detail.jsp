<%-- 
    Document   : detail
    Created on : 20-ene-2020, 9:28:08
    Author     : Alberto
--%>

<%@page import="pojos.Punto"%>
<%@page import="pojos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/mycss.css">
        <title>Foster Hollywood</title>
    </head>

    <body>
        <%

            Producto producto = (Producto) session.getAttribute("producto");
//            int puntos = (int) session.getAttribute("estrellasmedia");
        %>
        <div class="container shadow" style="background-image:url('<%=producto.getFondo()%>');  background-size: cover;" >
            <div class="row mb-5">

                <div class="col-12 position-relative">
                    <img class="img-fluid position-absolute" src="img/logo.png" alt="Logo" style="top:100; z-index: 10;">
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel"  >
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="img/slider1.png" alt="First slide">

                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="img/slider2.png" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="img/slider3.png" alt="Third slide">
                            </div>
                            <div class="carousel-caption d-none d-md-block">
                                <h1>Producto</h1>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                </div>
            </div>
            <div class="row mt-2 mb-5 justify-content-around ">
                <div class="col-8">
                    <div class="card justify-content-center text-center">

<!--                        <span class="rating2">
                            <% //for (int i = 0; i < puntos; i++) {%>  
                            <a>&#9733;</a>
                            <%//}%>
                        </span>-->

                        <img class="img-fluid" src="<%=producto.getImagen()%>" alt="Third slide">
                        <h1><%=producto.getTitulo()%></h1>
                        <p><%=producto.getBody()%></p>

                        <span class="rating ">
                            <a href="Controller?op=rating&rating=1&id=<%=producto.getId()%>">&#9733;</a>
                            <a href="Controller?op=rating&rating=2&id=<%=producto.getId()%>">&#9733;</a>
                            <a href="Controller?op=rating&rating=3&id=<%=producto.getId()%>">&#9733;</a>
                            <a href="Controller?op=rating&rating=4&id=<%=producto.getId()%>">&#9733;</a>
                            <a href="Controller?op=rating&rating=5&id=<%=producto.getId()%>">&#9733;</a>
                        </span>
                    </div>
                </div>
            </div>


            <div class="row fixed-bottom bg-dark text-white text-center">
                <div class="col">
                    <h2>Foster Hollywood</h2>
                </div>
            </div>
        </div>
    </div>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
</body>
</html>
