<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>iTextサンプル　画像入りPDF</title>
<link rel="stylesheet" type="text/css" href="/itext-sample/css/style.css">
<script>
function tryOnce(){
	document.fileuploadform.elements["uploadbtn"].value = 'アップロードしました。ダウンロードが終了するまでお待ちください。';
	document.fileuploadform.elements["uploadbtn"].disabled=true;
	document.getElementById("retry").hidden=false;
}
</script>
</head>
<body>
<header id="header">
<h1>iTextサンプル　画像入りPDF</h1>
</header>
<section id="main">
<div class="to-menu">
<a href="/itext-sample/" >メニューへ戻る</a><br/>
</div>
<form name="fileuploadform" action="/itext-sample/photecard/pdf" method="post" enctype="multipart/form-data" onsubmit="tryOnce();" >
<div class="centering">
<p>
<input name="freetext" type="text" size="40" placeholder="文字を入力してください。" value="${freetext}" />
</p>
<p>
<input type="file" name="uploadfile" accept="" style="width:500px;" required />
</p>
<p>
<input type="submit" name="uploadbtn" value="実行" />
</p>
<p>
<div id="retry" hidden="true">
<a href="/itext-sample/photecard/" >リトライ</a><br/>
</div>
</p>
</div>
</form>
</section>
</body>
</html>
