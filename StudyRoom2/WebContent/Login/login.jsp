<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String M_MemCode = (String)session.getAttribute("M_MemCode");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
 <style>
	*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

    body{
    font-family: 'Noto Sans KR', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #166cea;
    background: url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDEwMjRfMjY3%2FMDAxNjAzNTQwOTQwNDYw.1SiFWi0B7Oks6DaTTUcttBqVYZtEaQPSuopnYs65xvAg.X4AWSbu8rZ7LLPi6EIYduRpAlNBJLSFzNfy0WVOeHZwg.JPEG.baeeunhye13%2FEcnipXmU0AEXYoe.jpg&type=sc960_832") no-repeat center;
    background-size: 100% 100%;
    
    }
    body::before{
        content: "";
        position: absolute;
        z-index: 1;
        top: 0; right: 0; bottom: 0; left: 0;
        background-color: rgba(0, 0, 0, .7);
    }
    
    .login-form{
        position: relative;
        z-index: 2;
    }
    
    .login-form h1{
        font-size: 32px;
        color: #FFF;
        text-align: center;
        margin-top: 60px;
    }
    
    .int-area{
        width: 400px;
        position: relative;
        margin-top: 20px;
    }
    .int-area:first-child{
        margin-top: 0;
    }
    .int-area input{
        width: 100%;
        padding: 20px 10px 10px;
        background-color: transparent;
        border: none;
        border-bottom: 1px solid #999;
        font-size: 18px;
        color: #fff;
        outline: none;
    }
    .int-area label{
        position: absolute;
        left: 10px;
        top: 17px;
        font-size: 18px;
        color: #999;  
        transition: top .5s ease;
    }

    .int-area label.warning{
        color: red !important;
        animation: warning .3s ease;
        animation-iteration-count: 3;
    }


    @keyframes warning{
        0%{transform: translateX(-8px);}
        25%{transform: translateX(8px);}
        50%{transform: translateX(-8px);}
        75%{transform: translateX(8px);}
    }


    .int-area input:focus + label,
    .int-area input:valid + label{
        top: -2px;
        font-size: 13px;
        color: #166cea;
    }

    .btn-area{
        margin-top: 30px;
    }
    
    #btn{
        color: #fff;
    }
    
    .btn-area button{
        width: 100%;
        height: 50px;
        background: #166cea;
        font-size: 20px;
        border: none;
        border-radius: 25px;
        cursor: pointer;
    }
    
    .caption{
        margin-top: 20px;
        text-align: center;
    }
    .caption a{
        font-size: 15px;
        color: #999;
        text-decoration: none;
    }
  
    
    
 </style>
</head>
<body>
	    <section class="login-form">
        <h1><ion-icon name="desktop-outline"></ion-icon></h1>
        <form action="loginProc.jsp" method="post">
            <div class="int-area">
                <input type="text" name="M_Name" id="id" autocomplete="off" required>
                <label for="id">USER NAME</label>
            </div>
            <div class="int-area">
                <input type="password" name="M_MemCode" id="pw" autocomplete="off" required>
                <label for="pw">PASSWORD</label>
            </div>
            <div class="btn-area">
               <button id="btn" type="submit" >LOGIN</button>
            </div>
        </form>
        <div class="caption">
            <!-- <a href="">Forgot Password</a> -->
        </div>
    </div>
    </section>
</body>
</html>