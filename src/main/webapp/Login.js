function validar() {
    var usuario, password, expresion3;

    
    usuario = document.getElementById("usuario").value;
    password = document.getElementById("password").value;
  
    
 
    expresion3 = /^[a-zA-Z0-9\_\-]/;

    if (usuario === "" || password === "") {
        alert("Es obligatorio llenar todos los campos");
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
    
    else if(password.length>20 || password.length<8 || !/[a-z]/.test(password) || !/[A-Z]/.test(password) || !/[0-9]/.test(password) || !/[!"#$%&()=?¡]/.test(password)){
        alert("La contraseña no debe ser mayor a 20 o menor a 8 caracteres, debe contener al menos una letra mayuscula, una letra minuscula, un digito y un signo de puntuacion");
        return false;
    }
    
  
}
