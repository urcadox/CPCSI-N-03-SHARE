<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div style="display: flex; height: 100%">
		<div style="flex-grow: 1"></div>
		<div
			style="display: flex; flex-basis: 200px; flex-direction: column; height: 100%">
			<div style="flex-grow: 1"></div>
			<div
				style="flex-basis: 200px; background-color: silver; padding: 10px;">
				<form method="POST">
					<div>
						<label>login</label><input type="text" name="login" />
					</div>
					<div>
						<label>passw</label><input type="text" name="passw" />
					</div>
					<button>log in</button>
				</form>
			</div>
			<div style="flex-grow: 1"></div>
		</div>
		<div style="flex-grow: 1"></div>
	</div>
</body>
</html>