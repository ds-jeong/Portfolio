<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


   <style>
                #topMenu {           
                        height: 100px; 
                        width: 1290px;
                        margin: 0 auto;
                }
                #topMenu ul li {                     
                        list-style: none;          
                        color: white;               
                        background-color: #2d2d2d; 
                        float: left;                
                        line-height: 30px;       
                        vertical-align: middle;     
                        text-align: center;         
                }
                #topMenu .menuLink {                               
                        text-decoration:none;                     
                        color: white;                              
                        display: block;                          
                        width: 250px;                             
                        font-size: 20px;                         
                        font-weight: bold;                       
                        font-family: "Trebuchet MS", Dotum, Arial; 
                }
                #topMenu .menuLink:hover {           
                        color: #ffd21c;             
                        background-color: #4d4d4d;  
                }
        </style>
        
        
	<nav id="topMenu">
	<ul>
		<li class="menuLink"><a onclick="location='home'">PORTFOLIO</a></li>
		<li class="menuLink"><a onclick="location='list.kangwondo'">BOARD</a></li>
		<li class="menuLink"><a onclick="location='list.tr'">TRIP INFO</a></li>
		<li class="menuLink"><a onclick="location='login2'">LOGIN</a></li>
		<li class="menuLink"><a onclick="location='member'">JOIN</a></li>

	</ul>
</nav>
