<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>HMS Log in</title>

    <style>
body{ background-image: url('https://pngimage.net/wp-content/uploads/2018/06/hospital-background-images-png-1.png');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;}
 .center{
  padding: 70px 0;
  text-align: center;
  }
  </style>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

<div class="container">

    <form method="POST" action="/login" class="form-signin" autocomplete="off">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group">
            
            <fieldset class="form-group">
            <span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
                   </span>
             </fieldset>
             
             <fieldset class="form-group">
             <span>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            </span>
           </fieldset>
            <button class="btn btn-success" type="submit">Log In</button>
            
        </div>

    </form>
    
    <h2 cssClass="text-warning">${msg}</h2>
    <h2 cssClass="text-warning">${errorMsg}</h2>

</div>
<!-- /container -->
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script></body>
</html> --%>



<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Comic+Neue:wght@700&display=swap" rel="stylesheet">
		<style>

		::-webkit-input-placeholder { /* Firefox, Chrome, Opera */ 
			    color: #ffffff; 
		} 
		
		.wrap input:focus::-webkit-input-placeholder{ /* Firefox, Chrome, Opera */ 
			    color: #000000; 
		}
		::placeholder { /* Firefox, Chrome, Opera */ 
			    color: #ffffff ; 
			font-size: 15px;
		} 

		}
		.wrap input:focus ::placeholder{ /* Firefox, Chrome, Opera */ 
			    color: #000000 ; 
			font-size: 15px;
		} 
  

		body{
			margin:0;
			height:965px;
			padding:0;
			font-family: 'Arial';
			background-color: #000000;
background-image: linear-gradient(315deg, #000000 0%, #5e5368 74%);

			}
		.wrap {
			
			width: 430px;
				height:340px;
				overflow: hidden;
				margin: auto;
				margin-top: 185px;
				
			background: #fff;
			border: 1px solid silver;
			border-radius: 15px;
			background-color: #373837;
			}


		.wrap h2{
			
			margin-top:26px;
			height:35px;
			margin-bottom:8px;
			font-family: 'Ubuntu', sans-serif;
			color:#fff;
			background-color: #000000; 
			
	 		padding-top: 5px; 

			}

	

		.wrap h3{
			margin-top:10px;
			margin-bottom:20px;
			font-size:24px;
			font-family: 'Comic Neue';
			font-weight:bold;
			}

		.wrap input:focus{
  			background-color: #fff;
			color:#000000;
			}
		.wrap input{
			color:#ffffff;
			background:#1B1C1C;
			width: 350px;
			height: 35px;
			margin-left: 29px;
			margin-bottom: 10px;
			border-radius: 30px;
			border: 1px solid #ffffff;
			padding:5px 15px;
			font-size:20px;
			}



		.wrap .btn-login {
			margin-top:11px;
			width:150px;
			height:35px;
			background-color: #000000;
			background-image: linear-gradient(315deg, #000000 0%, #5e5368 74%);
			
  			 padding-top: 8px ;
  			 padding-bottom: 25px;
  			 padding-left: 25px;
  			 padding-right: 25px;
			margin-left: 54px;
			color: #fff;
			border-radius: 30px;
			border: 0;
			font-size:18px;
			box-shadow: 0 4px #999;
			}

		.btn-login:hover {
				background-color: #000000;
				background-image: linear-gradient(35deg, #000000 0%, #5e5368 74%);
				}

		.btn-login:active {
			  background-color: #3e8e41;
			  box-shadow: 0 1px #666;	
			  transform: translateY(4px);
			}
		.wrap .ref_reg {
 			 background-image: linear-gradient(315deg, #000000 0%, #5e5368 74%);
  			 color: white;
  			 padding-top: 8px ;
  			 padding-bottom: 12px;
  			 padding-left: 25px;
  			 padding-right: 25px;
		         text-align: center;
  			 text-decoration: none;
  			 display: inline-block;
  			 height:12px;
			 width:95px;
			margin-top:15px;
			margin-left: 22px;
			border-radius: 30px;
			border: 0;
			font-size:18px;
			box-shadow: 0 4px #999;
			}

			.ref_reg:hover {
  			background-color: #000000;
				background-image: linear-gradient(35deg, #000000 0%, #5e5368 74%);
			}

			 .ref_reg:active {
  			background-color: #3e8e41;
  			box-shadow: 0 1px #666;
  			transform: translateY(4px);
			}

		

				ul {
					  list-style-type: none;
					  
width:54%;
height:6%;margin-top:0px;
 					 padding-top: 10px;
padding-left:860px;
		
 						
					  background-color: #222;
				}
				
				li {
					  float: none;
				}

				li a {
 					 display: block;
					  color: #DCDCDC;
					font-size:25px;
 					 
					  padding: 8px 8x;
					  text-decoration: none;
					border-radius:30px;
					 transition:font-size 12s;
     -moz-transition:font-size 12s; /* Firefox 4 */
     -webkit-transition:font-size 12s; /* Safari and Chrome */
     -o-transition:font-size 12s;
     transition:color 12s;
     -moz-transition:color 12s; /* Firefox 4 */
     -webkit-transition:color 12s; /* Safari and Chrome */
     -o-transition:color 12s;
					
					}

					li a:hover {
					color:white;
					font-size:26px;
					
				}
			</style>
		</head>
	<body>

			<ul>
  			<li><a class="active" style="width:45%; height:35%;" href="#">Hospital Management System</a></li>
</ul>
		
	
		<div class="wrap">
			<center>
			<h2>Admin Login</h2>
			<p style="font-weight:600;"><font color=red>${errorMsg}</font></p>
			</center>
		
			
			<form method="POST" action="/login"  autocomplete="off">
			<input type="text" name="username"   placeholder=" User ID..."/><br>
			<input type="password" name="password"  placeholder=" Password..."/>   
		
			<input class="btn-login" type="submit" value="Login"/>
			<a class="ref_reg" href="#">Register</a></form>
			
<div class="frg10">
			
			 <p style="margin-left:282px;color:#fff;font-weight:400;">Forgot <a class="forgot" style="font-weight:600;color: #40E0D0;font-size: 15px;" href="#">Password?</a></p>
		</div>	
		</div>
	</body>
</html> --%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HMS HOME</title>
</head>

<style>
body{
background-image: url('https://images.pexels.com/photos/48604/pexels-photo-48604.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500');
background-repeat: no-repeat;
background-size: cover;
}

.buttons {
  background-color: skyblue;
  border: none;
  color: black;
  padding: 12px 12px;
  font-family: TimesNewRoman;
  text-align: center;
  font-size: 16px;
  margin: 6px 15px;
  transition: 0.3s;
  cursor :pointer;
  width: 200px;
}

.buttons:hover {
  background-color: white;
  color: black;
}

.button {
  background-color: #f1f1f1;
  border: none;
  color: black;
  padding: 12px 12px;
  font-family: TimesNewRoman;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  transition: 0.3s;
  cursor :pointer;
}

.button:hover {
  background-color: white;
  color: black;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #f1f1f1;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 12px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: white;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  text-align: center;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: white;
  padding: 12px 16px;
  text-decoration: none;
  border-collapse: collapse;
  display: inline-block;
  text-align: left;
}

.dropdown-content a:hover {
background-color: silver;
}

.dropdown:hover .dropdown-content {
  display: block;
  
}


.wrap {
			
			width: 430px;
				height:340px;
				overflow: hidden;
				margin: auto;
				margin-top: 175px;
				margin-right: 50px;
				float:right;
				
			background: #fff;
			border: 1px solid silver;
			border-radius: 15px;
			background-color: #99bbff;
			}
			
			
			.wrap h2{
			
			margin-top:26px;
			height:35px;
			margin-bottom:8px;
			font-family: 'Ubuntu', sans-serif;
			color:#fff;
			background-color: #b3b3b3; 
			
	 		padding-top: 5px; 

			}

	

		.wrap h3{
			margin-top:10px;
			margin-bottom:20px;
			font-size:24px;
			font-family: 'Comic Neue';
			font-weight:bold;
			}

		.wrap input:focus{
  			background-color: #fff;
			color:#000000;
			}
		.wrap input{
			color:black;
			background:#cccccc;
			width: 350px;
			height: 35px;
			margin-left: 29px;
			margin-bottom: 10px;
			border-radius: 15px;
			border: 1px solid #ffffff;
			padding:5px 15px;
			font-size:20px;
			}



		.wrap .btn-login {
			margin-top:11px;
			width:110px;
			height:35px;
			background-color: #000000;
			background-image: linear-gradient(315deg, #000000 0%, #5e5368 74%);
			
  			 padding-top: 8px ;
  			 padding-bottom: 25px;
  			 padding-left: 10px;
  			 padding-right: 10px;
			margin-left: 40px;
			color: #fff;
			border-radius: 15px;
			border: 0;
			font-size:18px;
			box-shadow: 0 4px #999;
			}

		.btn-login:hover {
				background-color: #000000;
				background-image: linear-gradient(35deg, #000000 0%, #5e5368 74%);
				}

		.btn-login:active {
			  background-color: #3e8e41;
			  box-shadow: 0 1px #666;	
			  transform: translateY(4px);
			}
</style>

<body>
<div class="body"></div>

<ul>
   
   <li><form><button type="submit" formaction="" class="button" >Hospital | Management System</button></form></li>
   
      
 
   <li style="float:right"><form> <button type="submit" formaction="#" class="button" >Support</button></form></li>
   
   <li style="float:right"><form> <button type="submit" formaction="#" class="button" >Home</button></form></li>
  
</ul>
<div class="wrap">
			<center>
			<h2>Admin Login</h2>
			<h3 id="message" style="color:red"> ${errorMsg}</h3>
			
			</center>
		
			
			<form method="POST" onsubmit="return check(this)" action="/login"  autocomplete="off">
			<input type="text" name="username" id="username"  placeholder=" User Name..."/><br>
			<input type="password" name="password"  id="password" placeholder=" Password..."/>   
			<input class="btn-login" type="submit" value="Login"/>
			
			</form>
		</div>
<div style="text-align: right; font-family: TimesNewRoman; ">
  <h1 style="color: blue;"><i>THE BEST DOCTOR</i></h1>
  <h1 style="color: blue;"><i>GIVES THE LEAST</i></h1>
  <h1 style="color: blue;"><i>MEDICINES<i></i></h1>
  
</div>
  
  
  <script>
  function check(form) 
  { 
  	
  	
  	var username=document.getElementById('username').value;
  	var password=document.getElementById('password').value;
  	

  	
  	
  		if(username == ""&&password=="")
  	{ 

  		document.getElementById("message").innerHTML = "Enter user name and password to login";

  		
  		form.username.focus(); 
  		return false; 
  	} 	


  		if(username != ""&&password=="")
  	{ 

  		document.getElementById("message").innerHTML ="Enter password to login!" ;

  		
  		form.username.focus(); 
  		return false; 
  	} 	
  		if(username == ""&&password!="")
  	  	{ 

  	  		document.getElementById("message").innerHTML = "Enter user name to login!";

  	  		
  	  		form.username.focus(); 
  	  		return false; 
  	  	} 
  	  	
  		
  }
  </script>
  
  
</body>
</html>
