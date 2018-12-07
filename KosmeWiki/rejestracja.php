<link rel="stylesheet" href=".idea/Home_styles/register.css" type="text/css">

<form method="POST" action="rejestracja.php">

    <div class="group">
        <input type="text" required="required" name="login"/><span class="highlight"></span><span class="bar"></span>
        <label>Login</label>
    </div>

    <div class="group">
        <input type="password" required="required" name="haslo1"/><span class="highlight"></span><span class="bar"></span>
        <label>Hasło</label>
    </div>

    <div class="group">
        <input type="password" required="required" name="haslo2"/><span class="highlight"></span><span class="bar"></span>
        <label>Powtórz Hasło</label>
    </div>
    <div class="group">
        <input type="password" required="required" name="email"/><span class="highlight"></span><span class="bar"></span>
        <label>E-Mail</label>
    </div>



    <input type="submit" value="Utwórz konto" name="rejestruj" class="smieszek">




</form>
<?php
 $mysqli = mysqli_connect("localhost","root", "", "kosmewiki");
mysqli_select_db($mysqli, "kosmewiki");



if (isset($_POST['rejestruj']))
{
    $login = $_POST['login'];
    $haslo1 = $_POST['haslo1'];
    $haslo2 = $_POST['haslo2'];
    $email = $_POST['email'];


    // sprawdzamy czy login nie jest już w bazie
    if (mysqli_num_rows(mysqli_query($mysqli,"SELECT nick FROM uzytkownicy WHERE nick = '".$login."';")) == 0)
    {
        if ($haslo1 == $haslo2) // sprawdzamy czy hasła takie same
        {
            mysqli_query($mysqli,"INSERT INTO `uzytkownicy` (`nick`, `haslo`, `email`)
            VALUES ('".$login."', '".md5($haslo1)."', '".$email."');");

            echo "Konto zostało utworzone!";
        }
        else echo "Hasła nie są takie same";
    }
    else echo "Podany login jest już zajęty.";
}
?>
