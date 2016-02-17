/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//
// Funciones de validacion de formularios de Javascript.
//
var nbsp = 160; // caracter de espacio
var node_text = 3; // Tipo de nodo de texto de DOM
var cadenaVacia = /^\s*$/;
var campoEnfocarGlobal; // Variable global para almacenar el
// campoEnfocar
// enfocaAtrasado()
//
// Hace que el elemento almacenado en la variable global
// campoValidarGlobalDelayed obtenca el foco. Ajuste para
// remediar un bug de IE y otros
function enfocaAtrasado() {
    campoEnfocarGlobal.focus();
}
// enfoca()
//
// Hace que el elemento del parametro obtenga el foco
//
// Parametros:
// - campoEnfocar: Elemento a obtener el foco
function enfoca(campoEnfocar) {
    // Guarda campoEnfocar en la variable global para conservar el valor
    // cuando la funcion termine
    campoEnfocarGlobal = campoEnfocar;
    setTimeout('enfocaAtrasado()', 100);
}
// trim()
//
// Elimina los caracteres blancos al principio o final
// de la cadena del parametro
//
// Parametros
// - str: Cadena a procesar
function trim(str) {
    return str.replace(/^\s+|\s+$/g, '');
}
// despliegaMensaje()
//
// Despliega un mensaje de error o aviso
//
// Parametros
// - idMensaje: id del elemento en que se desplegara el mensaje
// - claseMensaje: Clase asociada al mensaje para usarse en CSS,
// warn/error.
// - mensaje: Mensaje a desplegar
//
// Debe llamarse antes a la funcion validacionComun
function despliegaMensaje(idMensaje, claseMensaje, mensaje) {
    var mensajeDesplegar;
    // Si el mensaje a desplegar es una cadena vacía
    if (cadenaVacia.test(mensaje))
        // Hacer que la cadena a desplegar sea el caracter de espacio
        mensajeDesplegar = String.fromCharCode(nbsp);
    else
        // Hacer que la cadena a desplegar sea el mensaje
        mensajeDesplegar = mensaje;
    // Despliega el mensaje
    var elem = document.getElementById(idMensaje);
    elem.firstChild.nodeValue = mensajeDesplegar;
    // Establece la clase CSS para establecer las propiedades del mensaje
    elem.className = claseMensaje;
}
// validacionComun()
//
// Codigo comun para todas las funciones de validacion:
// Si la version del navegador es vieja, pasa la validacion
// para que la validacion la haga el servidor
//
// Parametros:
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// - true: Pasa la validacion
// - false: Falla la validation
// - prosigue: Continua con la siguiente validacion
var prosigue = 2;
function validacionComun(campoValidar, idMensaje, requerido) {
    // Si el navegador es viejo
    if (!document.getElementById)
        // Deja la validacion al servidor
        return true;
    var elem = document.getElementById(idMensaje);
    // Si el navegador es viejo, deja la validacion al servidor
    if (!elem.firstChild)
        return true;
    // El elemento en que se desplegara el mensaje no es el correcto
    if (elem.firstChild.nodeType != node_text)
        return true;
    // Si el campo a validar esta vacio
    if (cadenaVacia.test(campoValidar.value)) {
        // Si el campo esta vacio y es obligatorio
        if (requerido) {
            despliegaMensaje(idMensaje, "error",
                    "Error: Se requiere un valor");
            enfoca(campoValidar);
            return false;
        }
        // Si el campo esta vacio y no es obligatorio
        else {
            // Borra un posible mensaje de error previo
            despliegaMensaje(idMensaje, "warn", "");
            return true;
        }
    }
    return prosigue;
}
// validaPresente()
//
// Valida si se ha teclaeado algo en el campo de texto
//
// Parametros:
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
//
// Regresa:
// true si se ha tecleado algo, falso en caso contrario
//
function validaPresente(campoValidar, idMensaje) {
    var stat = validacionComun(campoValidar, idMensaje, true);
    if (stat != prosigue)
        return stat;
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "warn", "");
    return true;
}
// validaCadena()
//
// Valida una cadena. Una cadena esta formada de caracteres alfanuméricos
// y tiene una extension maxima
//
// Parametros:
// - longMax: Longitud maxima de una cadena
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// true si es una clave valida, false en caso contrario
//
function validaCadena(longMax, campoValidar, idMensaje, requerido) {
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var cadena = trim(campoValidar.value);
    var reCadena = new RegExp('^\\w{1,' + longMax + '}$');
    if (!reCadena.test(cadena)) {
        despliegaMensaje(idMensaje, "msjError", "Error: Cadena muy larga");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}
// validaClave()
//
// Valida una clave. Una clave esta formada de 3 letras mayusculas y 4
// digitos
//
// Parametros:
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
//
// Regresa:
// true si es una clave valida, false en caso contrario
//
function validaClave(campoValidar, idMensaje) {
    var stat = validacionComun(campoValidar, idMensaje, true);
    if (stat != prosigue)
        return stat;
    var clave = trim(campoValidar.value);
    var reClave = /^[A-Z]{3}[0-9]{4}$/;
    if (!reClave.test(clave)) {
        despliegaMensaje(idMensaje, "msjError", "Error: Clave no valida");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}
// validaEntero()
//
// Valida un entero. Formado de n dígitos
//
// Parametros:
// - numDigitos: Número máximo de digitos
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// true si ok
//
function validaEntero(campoValidar, idMensaje, requerido) {
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var entero = trim(campoValidar.value);
    var reEntero = /^\d+$/;
    if (!reEntero.test(entero)) {
        despliegaMensaje(idMensaje, "msjError", "Error: No es un entero");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}
// validaEnteroMaxDigitos()
//
// Valida un entero. El entero tiene de 1 a maxDigitos dígitos
//
// Parametros:
// - maxDigitos: Número máximo de digitos
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// true si ok
//
function validaEnteroMaxDigitos(maxDigitos, campoValidar, idMensaje,
        requerido) {
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var entero = trim(campoValidar.value);
    var reEntero = /^\d+$/;
    if (!reEntero.test(entero)) {
        despliegaMensaje(idMensaje, "msjError", "Error: No es un entero");
        enfoca(campoValidar);
        return false;
    }
    reEntero = new RegExp('^\\d{1,' + maxDigitos + '}$');
    if (!reEntero.test(entero)) {
        despliegaMensaje(idMensaje, "msjError", "Error: Numero muy largo");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}
// validaEnteroRango()
//
// Valida un entero en el rango [min, max].
//
// Parametros:
// - min: Limite inferior del entero
// - max: Limite superior del entero
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// true si ok
//
function validaEnteroRango(min, max, campoValidar, idMensaje, requerido)
{
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var entero = trim(campoValidar.value);
    var reEntero = /^\d+$/;
    if (!reEntero.test(entero)) {
        despliegaMensaje(idMensaje, "msjError", "Error: No es un entero");
        enfoca(campoValidar);
        return false;
    }
    if (entero < min || entero > max) {
        despliegaMensaje(idMensaje, "msjError",
                "Error: Entero fuera de rango");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}
// validaFecha()
//
// Valida una fecha en el formato dd/mm/aaaa.
//
// Parametros:
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// true si ok
//
function validaFecha(campoValidar, idMensaje, requerido) {
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var fecha = trim(campoValidar.value);
    var reFecha = /^(([0-2]?\d)|([3][0-1]))\/(([0]?\d)|([1][0-2]))\/\d{4}$/
    if (!reFecha.test(fecha)) {
        despliegaMensaje(idMensaje, "msjError", "Error: Fecha no valida");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}
// validaEmail()
//
// Valida una direccion de correo
//
// Parametros:
// - campoValidar: Elemento a validar
// - idMensaje: id del elemento en que se desplegara el mensaje
// - requerido: Campo requerido
//
// Regresa:
// true si ok
//
function validaEmail(campoValidar, idMensaje, requerido) {
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var email = trim(campoValidar.value);
    var reEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    if (!reEmail.test(email)) {
        despliegaMensaje(idMensaje, "msjError", "Error: E-mail no válido");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}

//validaCaracter(caracteres, campoValidar, idMensaje,
//requerido) 
//que valide un carácter sea uno de los caracteres de caracteres.
//validaFlotante(campoValidar, idMensaje, requerido) que valida
//que el campo sea flotante. 

function validaCaracter(caracteres, campoValidar, idMensaje, requerido) {
    var stat = validacionComun(caracteres, campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var email = trim(campoValidar.value);
    var reEmail = /^[a-z áéíóúñüàè]+$/i;
    if (!reEmail.test(email)) {
        despliegaMensaje(idMensaje, "msjError", "Error:  Caracteres no válidos");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}

function validaFlotante(campoValidar, idMensaje, requerido) {
    var stat = validacionComun(campoValidar, idMensaje, requerido);
    if (stat != prosigue)
        return stat;
    var email = trim(campoValidar.value);
    var reEmail = /^([0-9])*[.]?[0-9]*$/;
    if (!reEmail.test(email)) {
        despliegaMensaje(idMensaje, "msjError", "Error: Número no válido");
        enfoca(campoValidar);
        return false;
    }
    // Borra un posible mensaje de error previo
    despliegaMensaje(idMensaje, "msjAviso", "");
    return true;
}