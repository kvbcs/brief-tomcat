<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Ajouter un utilisateur</title>
	</head>
	<body>
		<h2>Ajouter un utilisateur</h2>
		<form
			action="users"
			method="post">
			<input
				type="text"
				name="name"
				placeholder="Nom"
				required /><br />
			<input
				type="email"
				name="email"
				placeholder="Email"
				required /><br />
			<input
				type="text"
				name="phone"
				placeholder="Téléphone"
				required /><br />
			<input
				type="date"
				name="dateNaissance"
				required /><br />
			<button type="submit">Ajouter</button>
		</form>

		<hr />

		<a href="users">Voir tous les utilisateurs</a>
	</body>
</html>
