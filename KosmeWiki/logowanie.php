
<?php
session_start();
$mysqli = mysqli_connect("localhost","root","");
mysqli_select_db($mysqli,"kosmewiki");
?>
 <link rel="stylesheet" href=".idea/Home_styles/login.css" type="text/css">

<form method="POST" action="logowanie.php">
    <div class="group">
        <input type="text" required="required" name="login"/><span class="highlight"></span><span class="bar"></span>
        <label>Login</label>
    </div>
    <div class="group">
        <input type="password" required="required" name="haslo"/><span class="highlight"></span><span class="bar"></span>
        <label>Login</label>
    </div>

    <input type="submit" value="Zaloguj" name="loguj" class="smieszek">
</form>

<?php
$mysqli = mysqli_connect("localhost","root","");
mysqli_select_db($mysqli,"kosmewiki");

if (isset($_POST['loguj']))
{
    $login = $_POST['login'];
    $haslo = $_POST['haslo'];
    $ip = $_SERVER['REMOTE_ADDR'];

    // sprawdzamy czy login i hasło są dobre
    if (mysqli_num_rows( mysqli_query($mysqli,"SELECT nick, haslo FROM uzytkownicy WHERE nick = '".$login."' AND haslo = '".md5($haslo)."';")) > 0)
    {

        $_SESSION['zalogowany'] = true;
        $_SESSION['login'] = $login;
        echo "<script language='javascript'>alert('Zostaniesz przeniesiony');</script>";
        header('Location: Account.html');
        // zalogowany

    }
    else
        echo "<script language='javascript'>alert('Wpisano złe dane');</script>";
}
?>