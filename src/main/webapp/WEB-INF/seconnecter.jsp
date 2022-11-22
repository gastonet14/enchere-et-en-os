<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.EnchereEtEnOs.dal.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>se Connecter</title>
</head>
<body>

	<form method="post">

		<c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
				<strong>Erreur!</strong>
				<ul>
					<c:forEach var="code" items="${listeCodesErreur}">
						<li>${LecteurMessage.getMessageErreur(code)}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<label for="login">Identifiant (mail or pseudo)</label> <input type="text" id="login" name="login" />
		<label for="mdp">mot de passe</label> <input type="password" id="mdp" name="mdp" />

		<button type="submit">se connecter</button>

	</form>

</body>
</html>