"use strict";
let x_group = document.getElementsByClassName("X_group");
let r = document.getElementById("r");
let submit = document.getElementById("submitButton");
let field = document.getElementById("y");
let form = document.querySelector(".send_form");
field.addEventListener('input', () => {
    field.value = field.value.replace(/[^0-9\.\-\,]/g, '');
    field.value = field.value.replace(/[^0-9\.\-\,]/g, '');
});
form.addEventListener("submit", function (e) {
    field.value = field.value.replace(/[,]/, '.')
    if ((field.value > 3)||(field.value < -3)||(field.value == "")){
            alert("Y некорректно!");
            e.preventDefault();
        }
});
function getX(){
    for (let i = 0; i < 9; i++) {
        let radioButton = x_group.item(i);
        if (radioButton.checked) {
            return radioButton.value;
        }
    }
}