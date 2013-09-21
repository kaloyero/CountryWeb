<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload='document.login.j_username.focus();'>
	<h3>Bienvenido a Red de countries. Alex chupala</h3>

	<form name='LoginForm' action="" method='POST'>

		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type='text' name='userName' value=''>
				</td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><input type='password' name='password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" />
				</td>
			</tr>

		</table>

	</form>
</body>
</html>