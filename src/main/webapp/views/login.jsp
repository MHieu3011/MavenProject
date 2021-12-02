<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center form_container">
					<form action='<c:url value = "/dang-nhap?action=login"/>' method="post">
						<div class="alert alert-${alert}">
						  ${message}
						</div>
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control input_user" value=""
								placeholder="username" name="username">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control input_pass" value=""
								placeholder="password" name="password">
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
							<button type="submit" name="button" class="btn login_btn">Đăng nhập</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>