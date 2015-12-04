<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>iTextサンプル　QRCODE-PDF</title>
<link rel="stylesheet" type="text/css" href="/itext-sample/css/style.css">
</head>
<body>
<header id="header">
<h1>iTextサンプル　QRCODE-PDF</h1>
</header>
<section id="main">
<div class="to-menu">
<a href="/itext-sample/" >メニューへ戻る</a><br/>
</div>
<form name="fileuploadform" action="/itext-sample/qrcode/qrcode" method="post">
<div class="centering">
<p>
<input name="freetext" type="text" size="40" placeholder="文字を入力してください。" value="${freetext}" />
</p>
<p>
<input type="submit" name="uploadbtn" value="実行" />
</p>
</div>
</form>
</section>
</body>
</html>
