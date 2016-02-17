/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validaClavePresentacion() {

    var elem;
    var errores = 0;
// Ejecuta las validaciones en orden inverso para que el elemento con
// el enfoque sea el primero con error
    if (!validaClave(document.forms.frmCapturaClavePresentacion.claveP, 'txtClave'))
        errores += 1;

    return (errores == 0);
}
;