<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-compatible" content="IE=edge">
	<meta name="viewport" content="user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,width=device-width">
	<title>블로그</title>
    <script src="/js/login.js"></script>
	<#-- -->
    <#if message?exists><script type="text/javascript">alert('${message}');</script></#if>
</head>
<body>
	<div class="login_header">
		<h1 class="logo">
			<a href="/">BSTORY</a>
		</h1>
		<div class="join_area">
			<a href="/join">회원가입</a>
		</div>
	</div>
	<div class="login_bg">
		<div class="inner_login">
			<div class="login_bistory login_type2">
			<h2 class="screen_out">로그인</h2>
			<strong class="tit_login">
				비스토리에 로그인 하세요.
			</strong>
			<form method="post" id="frm">
				
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="loginId" class="screen_out">아이디</label>
							<input type="text" id="loginId" name="id" placeholder="ID">
						</div>
						<div class="inp_text">
							<label for="loginPw" class="screen_out">비밀번호</label>
							<input type="password" id="loginPw" name="password" placeholder="Password">
						</div>
					</div>
					<button type="submit" class="btn_login" onclick="login();">로그인</button>
					<div class="login_append">
						<span class="txt_find">
				 			<a href="#" class="link_find">아이디</a>
				 			 / 
				 			<a href="#" class="link_find">비밀번호 찾기</a>
				 		</span>
					</div>
					
				</fieldset>
			</form>
			</div>
		</div>
	</div>
	
</body>
</html>