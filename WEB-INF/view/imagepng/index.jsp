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
<h1>透過画像サンプル　重ね画像</h1>
</header>
<section id="main">
<div class="to-menu">
<a href="/itext-sample/" >メニューへ戻る</a><br/>
</div>
<form name="fileuploadform" action="/itext-sample/imagepng/png" method="post" enctype="multipart/form-data" onsubmit="tryOnce();" >
<div class="centering">
<p>
uploadfileOver <input type="file" name="uploadfileOver" accept="" style="width:500px;" required />
</p>
<p>
uploadfileUnder <input type="file" name="uploadfileUnder" accept="" style="width:500px;" required />
</p>
<p>
<input type="submit" name="uploadbtn" value="実行" />
</p>
<p>
<div id="retry" hidden="true">
<a href="/itext-sample/imagepng/" >リトライ</a><br/>
</div>
</p>
</div>
</form>
</section>
</body>
</html>
