<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>iTextサンプルエラーページ</title>
<link rel="stylesheet" type="text/css" href="/macromill/admin/css/style.css">
</head>
<body>
<header id="header">
<h1>iTextサンプルエラーページ</h1>
</header>
<section id="main">
<div class="to-menu">
<a href="/itext-sample/" >メニューへ戻る</a><br/>
</div>
<p class="error-message">
<html:messages id="msg" message="false">
  ・<bean:write name="msg" ignore="true"/><br>
</html:messages>
</p>

<p>
<a href="/itext-sample/imagepdf/" >アンケート回答者情報取得ページへ戻る</a><br/>
</p>
</section>
</body>
</html>
