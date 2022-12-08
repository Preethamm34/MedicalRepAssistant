<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.css" rel="stylesheet">
<title>Doctor Calls</title>
</head>
<style>
body{
	background-color: #F0FF42;
	}
body  
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
ul.menu {
    display: inline-block;
    list-style-type: none;
  float: left;
}
li.menu_list {
    height: 85px;
    width: 85px;
    position: relative;
}
li.menu_list .front,
a.side {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 86px;
    width: 100%;
    padding: 30px;
    position: absolute;
    top: 0;
    left: 0;
    text-decoration: none;
    text-transform: uppercase;
    transition: all .5s ease-out;
    cursor: pointer;
}
li.menu_list .front {
    background-color: #34465d;
    color: #FFFC00;
    transform-origin: 0 0;
}
a.side {
    background-color: #FFFC00;
    color: #34465d;
    transform-origin: 0 0 85px;
    transform: rotateY(-90deg);
}
li.menu_list:hover a.side {
    transform: rotateY(0deg);
}
li.menu_list:hover .front {
    transform: rotateY(90deg);
}
body{
	background-color: #F0FF42;
	}
body  
.login{  
        width: 550px;  
        overflow: hidden;  
        margin: 10px;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        background-color: #34465d;   
        border-radius: 20px ;  
  		float: left;
      }  
h2{ 
    padding: 20px;  
	font-family: "Roboto", sans-serif;
	text-align: center;
	font-size:30px ;
	background-color: #34465d;
 	color: #FFFC00;
 	font-size:3em ;
 	-webkit-text-stroke: 2px #FFFC00;
 	-webkit-text-fill-color:#34465d;
}  
p{
	color: #eef2e2;
	font-family: "Roboto", sans-serif;
	text-align: center;
}
label{  
    color: #eef2e2;  
    font-size: 20px; 
    displat: inline-block; 
}  
a{
color: #FFFC00;
}
#log{
	background-color:#F0FF42;
	color: #34465d;
	font-size: 20px;
}
input{
displat: inline-block; 
}

ul.menu {
    display: inline-block;
    list-style-type: none;
}
a{
	background-color: #34465d;
 	color: #FFFC00;
	font-size: 20px;
}
.search{
		width : 600px; 
        overflow: hidden;    
        padding: 10px;  
        background-color: #34465d;  
        border-radius: 20px ;       
}
.print{
	float: right;  
	font-family: "Roboto", sans-serif;
	font-size:20px ;
	color: #FFFC00;
	background-color: #34465d;
	border: 1px solid black;
}
</style>
<body>

<h2>DOCTOR CALLS</h2> 

<ul class="menu">
    <li class="menu_list">
        <span class="front fas fa-home"></span>
        <a href="Home.html" class="side">Home</a>
    </li>
    <li class="menu_list">
        <span class="front fas fa-info"></span>
        <a href="Signin.jsp" class="side">Signin</a>
    </li>
    <li class="menu_list">
        <span class="front fas fa-briefcase"></span>
        <a href="Login.jsp" class="side">Login</a>
    </li>
    <li class="menu_list">
        <span class="front fas fa-paper-plane"></span>
        <a href="About.html" class="side">About</a>
    </li>
</ul>
 
<div class="print">
<%   
out.print("Welcome ");
out.print(request.getParameter("username"));
%>
</div>
<br><br>

  
    <div class="login">    
    <form action="<%=request.getContextPath()%>/AddDocCalls" method="post">    
        <label><b>Doctor Name :</b></label>        
        <input type="text" name="doctorname" id=""doctorname"" placeholder="Enter Doctor Name " requested>    
        <br><br>    
        <label><b>Phone Number :</b></label>        
        <input type="text" name="phonenumber" id="phonenumber" placeholder="Enter Phone Number" requested>    
        <br><br> 
        <label><b>Address :</b></label>       
        <input type="text" name="address" id="address" placeholder="Enter Doctors Address" requested>    
        <br><br>
        <label><b>Location :</b></label>       
        <input type="text" name="location" id="location" placeholder="Enter Doctors Location" requested>    
        <br><br>  
        <label><b>Sample Details :</b></label>   
        <input type="text" name="sampledetails" id="sampledetails" placeholder="Enter Sample Details" requested>    
        <br><br>  
        <label><b>Doctor Call On:</b></label>   
        <input type="text" name="doctorcallon" id="doctorcallon" placeholder="Enter Next Doctor Call On" requested>    
        <br><br>
        <input type="submit" name="log" id="log" value="Add Details">       
        <br><br>  
        <% 
    if(request.getAttribute("msg")!=null)
    {%>
    <h4 style="color:red;"><%=(String)request.getAttribute("msg")%></h4>
    <% } %>         
    </form> 
    
    <form action="<%=request.getContextPath()%>/FetchDocCalls" method="get">   
        <input type="submit" name="log" id="log" value="View Details">   
        </form> 
    
</div>

<div class="search">
<center>
<form action="<%=request.getContextPath()%>/SortDocCall" method="get">
<input type="text" id="location" name="location" placeholder=" Location">
<input type="text" id="doctorcallon" name="doctorcallon" placeholder="Doctor Call On">
<input type="submit"  id="log" value="Search">
</form>
</center>
</div>
<br>


</body>
</html>