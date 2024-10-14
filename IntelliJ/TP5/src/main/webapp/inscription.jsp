<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Inscription</title>
</head>
<body>
<form action="valider.jsp" method="post" name="form" id="form" >
    <table border="1" cellpadding="3" cellspacing="2" width="66%" align="center">
        <tr>
            <td width="100"><b>Nom</b></td>
            <td><input type="text" name="nom" ></td>
        </tr>
        <tr>
            <td width="100"><b>Prénom</b></td>
            <td><input type="text" name="prenom"></td> <!-- Changed to prenom -->
        </tr>

        <tr>
            <td width="100"><b><strong>Adresse</strong></b></td>
            <td><input type="text" name="adresse" ></td>
        </tr>
        <tr>
            <td width="100"><b>Mot de passe</b></td>
            <td><input type="password" name="motDePasse"></td>
        </tr>
    </table>
    <p align="center"><input type="submit" value="Nouvel utilisateur" onClick="test()"></p>
</form>
<br>
<p><a href="index.html" title="aceuil">Aceuil</a></p>
</body>
</html>