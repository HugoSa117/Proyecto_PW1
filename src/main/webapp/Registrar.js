function validar() {
    var nombres, apellidos, correo, usuario, password, Cpassword, expresion, expresion2, expresion3;

    nombres = document.getElementById("nombres").value;
    apellidos = document.getElementById("apellidos").value;
    correo = document.getElementById("correo").value;
    usuario = document.getElementById("usuario").value;
    password = document.getElementById("password").value;
    Cpassword = document.getElementById("confirmPassw").value;
    
    expresion = /\w+@\w+\.+[a-z]/;
    expresion2 = /^[a-zA-ZÀ-ÿ\s]/;
    expresion3 = /^[a-zA-Z0-9\_\-]/;

    if (nombres === "" || apellidos === "" || correo === "" || usuario === "" || password === "" || Cpassword === "") {
        alert("Es obligatorio llenar todos los campos");
        return false;
    } 
    else if (nombres.length > 30) {
        alert("El nombre no debe ser mayor a 30 caracteres");
        return false;
    } 
    else if (apellidos.length > 60) {
        alert("Los apellidos no deben ser mayor a 60 caracteres");
        return false;
    } 
     else if(!expresion2.test(nombres)){
        alert("El nombre no es valido");
        return false;
    }
     else if(!expresion2.test(apellidos)){
        alert("Los apellidos no son validos");
        return false;
    }
    
    else if (correo.length > 100) {
        alert("El correo es muy largo");
        return false;
    }
    else if(!expresion.test(correo)){
        alert("El correo no es valido");
        return false;
    }
   else if(usuario.length>20){
        alert("El usuario no debe ser mayor a 20 caracteres");
        return false;
    }
      else if(!expresion3.test(usuario)){
        alert("El usuario contiene caracteres no validos");
        return false;
    }
    
    else if(password.length>20 || password.length<8 || !/[a-z]/.test(password) || !/[A-Z]/.test(password) || !/[0-9]/.test(password) || !/[!"'.¿,#$%&()=?¡]/.test(password)){
        alert("La contraseña no debe ser mayor a 20 o menor a 8 caracteres, debe contener al menos una letra mayuscula, una letra minuscula, un digito y un signo de puntuacion");
        return false;
    }
    
    else if(password !== Cpassword){
        alert("Las contraseñas no coinciden");
        return false;
        
    }
}