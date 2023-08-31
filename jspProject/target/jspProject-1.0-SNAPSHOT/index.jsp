<%-- 
    Document   : index
    Created on : 23 ago 2023, 17:39:54
    Author     : guime
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.jspproject.Equipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                padding: 15px;
            }
            .mainContainer{
                display: flex;
                justify-content: space-between;
            }
            h1{
                text-align: center;
            }
            .leftContainer{
                width: 60%;
            }
            .rightContainer{
                width: 30%;
            }
            .rightContainer td{
                text-align: center;
            }
            table{
                padding: 10px;
                background-color: rgba(193, 102, 102, 0.667);
                box-shadow: 0 0 20px 0 black;
            }
            td{
                padding:5px;
            }
        </style>
    </head>
    <body>
        <h1>Campeonato baloncesto</h1>
        <div class="mainContainer">
            <div class="leftContainer">
                <h2>Jornada</h2>
                <form method="get" action="svEquipos">
                    <table border="0">
                        <tr>
                            <td width="40%"><label for="equipo1">Los Angeles Lakers</label></td>
                            <td width="5%"><input type="number" name="equipo1" id="equipo1"></td>
                            <td width="10%"><b> vs </b></td>
                            <td width="40%"><label for="equipo2">Real Madrid Baloncesto</label></td>
                            <td width="5%"><input type="number" name="equipo2" id="equipo2"></td>
                        </tr>
                        <tr>
                            <td width="30%"><label for="equipo3">CSKA Moscow</label></td>
                            <td width="15%"><input type="number" name="equipo3" id="equipo3"></td>
                            <td width="5%"><b> vs </b></td>
                            <td width="30%"><label for="equipo4">Perth Wildcats</label></td>
                            <td width="15%"><input type="number" name="equipo4" id="equipo4"></td>
                        </tr>
                        <tr>
                            <td width="30%"><label for="equipo5">Fenerbahçe Beko Istanbul</label></td>
                            <td width="15%"><input type="number" name="equipo5" id="equipo5"></td>
                            <td width="5%"><b> vs </b></td>
                            <td width="30%"><label for="equipo6">Boca Juniors</label></td>
                            <td width="15%"><input type="number" name="equipo6" id="equipo6"></td>
                        </tr>
                        <tr>
                            <td width="30%"><label for="equipo7">Guangdong Southern Tigers</label></td>
                            <td width="15%"><input type="number" name="equipo7" id="equipo7"></td>
                            <td width="5%"><b> vs </b></td>
                            <td width="30%"><label for="equipo8">Anadolu Efes Istanbul</label></td>
                            <td width="15%"><input type="number" name="equipo8" id="equipo8"></td>
                        </tr>
                    </table>
                
                    <input type="submit" name="button"  id="button" value="Publicar resultados">
                </form>
                
            </div>

            <div class="rightContainer">
                <h2>Clasificación:</h2>
                <table>
                    <tr>
                        <th>Equipo</th>
                        <th>Puntos</th>
                    </tr>
                <%
                    List<Equipos> clasificacion = (List) request.getSession().getAttribute("clasificacion");
                    if (clasificacion != null) {
                        for (Equipos equipo : clasificacion) {
                %>
                
                    <tr>
                        <td><%= equipo.getNombre()%></td>
                        <td><%= equipo.getPuntos()%></td>
                    </tr>
                <%
                        }
                    }
                %>
                </table>
            </div>
        </div>
    </body>
</html>
