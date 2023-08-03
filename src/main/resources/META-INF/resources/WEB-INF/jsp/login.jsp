<html>
	<head>
	    <link href="webjars\bootstrap\5.3.0\css\bootstrap.min.css" rel="Stylesheet">
		<title> Login Page - JSP</title>
	</head>
	<body>
	   <div class="container">
            <div class="mt-3">
                <h4>Welcome</h4>
            </div>
            <div>
                <h3 style="color:red;">
                    ${errorMessage}
                </h3>
            </div>
            <form action="" method="post">
            <div>
                <div class="mt-3">
                    <label class="form-label" for="username">Username</label>
                    <input name="username" placeholder="username" id="username">
                </div>

                <div class="mt-3">
                    <label class="form-label" for="password">Password</label>
                    <input type="password" name="password" placeholder="password" id="password">
                </div>
            </div>

            <div class="mt-3">
                <button type= submit class="btn btn-primary">Submit</button>
            </div>

            </form>
	   </div>

	   <script src"webjars\bootstrap\5.3.0\js\bootstrap.min.js"></script>
       <script src"C:webjars\jquery\3.6.4\jquery.min.js"></script>
	</body>
</html>