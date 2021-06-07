<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--  ↓モデルをインポートする？ -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アンケートページ</title>
<link rel="stylesheet" href="./style.css">
</head>
	<body>
	<!-- InputquestionSevlet.javaにリクエスト送信 -->
	<form action="<%= request.getContextPath() %>/QuestionServlet" method = "post">
	<div class="wrapper">
            <h1>アンケートページ</h1>
            <label>ここはアンケートページです。<br>ご協力よろしくお願いします。</label>
        <div>
            <div class = "question" id = "myouji">
             <label>お名前（カナ)</label>
                 <input type="text" pattern="(?=.*?[\u30A1-\u30FC])[\u30A1-\u30FC\s]*"  title ="カナ文字で入力してください" id = "namae"  onBlur ="return check_myouji();" name="name" placeholder="例）スズキ　タロウ">
                 <br>
                 <p id="myouji-error" hidden="">※お名前(カナ)は必須入力です。</p>
            </div>
            <div class="question" id="nennrei">
            <label>年齢</label>
                <select id="age"   name ="age" onBlur ="return check_age();">
                <option value=""> </option>
                <script>
                var i;
                for(i=10; i<100; i++){
                document.write('<option value="' + i + '">'+i+'歳</option>');
                }
                </script>
                </select>
            </div>
            <div class ="question" id ="sex">
            <label>性別</label>
                <input type="radio" name="sex" value="male" id="otoko" onBlur ="return check_sex();">
                <label for="otoko" accesskey="m" >男</label>
                <input type="radio" name="sex" value="female" id="onna" onBlur ="return check_sex();">
                <label for="onna" accesskey="f" >女</label>
                <input type="radio" name="sex" value="else" id="else" onBlur ="return check_sex();">
                <label for="sonota" accesskey="e" >その他</label>
            </div>
            <div class="question" id ="kisetsu">
	            <label>好きな季節</label>
	            <select id="season" name="season" onBlur ="return check_season();">
	            <option value=""></option>
	            <option value="spring">春</option>
	            <option value="summer">夏</option>
	            <option value="autumn">秋</option>
	            <option value="winter">冬</option>
	            </select>
            </div>
            <div class="question">
            <label>自由入力</label>
            <textarea id="kanso"  name="memo" cols="40" rows="4" maxlength="20" placeholder="その他何かございましたら自由に記載してください"></textarea><br>
            </div>
            <div class ="reset-submit-button">
            <input type="button"  id = "button" value="クリア" onclick= "kakuninn()">
            <input type="submit"  id ="sousin" value ="送信"  onclick="location.href='./QuestionDone.jsp'">
           <!--  disabled  を最後につけると、全部入力してから送信できるようになる-->
            </div>
        </div>
       </div>
        <script type="text/javascript" src="./question.js"></script>
	     </form>
	     
	     <%@page import="java.util.ArrayList" %>
	     <% ArrayList<Integer> agesss = (ArrayList<Integer>)request.getAttribute("ageList"); %>
	     <select>
         <option value=""> </option>
 	     <%
	     	for(int age : agesss) {
//	     		out.println(String.format("<option value=%d> %d歳</option>", age, age));
	     		out.println("<option value=" + age + "> " + age + "歳</option>");
	     	}
	     %>
	     </select>
</body>
</html>