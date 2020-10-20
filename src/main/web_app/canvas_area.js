"use strict";

let canvasContainer = document.getElementById("graphic_container");
let canvas = document.getElementById("graphic");
let ctx = canvas.getContext("2d");
let width = 320;
let canvasR = 122;

canvas.addEventListener("click", function (e) {
    let canvasX = e.pageX - this.offsetLeft,
        canvasY = e.pageY - this.offsetTop;
    sendDataToForm(canvasX - width / 2, width / 2 - canvasY);
});

window.onload = function () {
    let coordX = document.querySelectorAll(".x_col");
    let coordY = document.querySelectorAll(".y_col");
    let coordR = document.querySelectorAll(".r_col");
    for (let i = 0; i < coordX.length; i++) {
        drawPoints(coordX[i].innerHTML * canvasR / coordR[i].innerHTML + width / 2, width / 2 - coordY[i].innerHTML * canvasR / coordR[i].innerHTML);
    }
};

function sendDataToForm(xVal, yVal) {
    let x = Math.round(xVal * r.value / canvasR);
    let y = document.getElementById("y");
    document.getElementById("x" + getX()).classList.remove("checked");
    document.getElementById("x" + x).classList.add("checked");
    y.value = (yVal * r.value / canvasR + 0.850).toString().substr(0, 6);
    form.submit();
}

function drawPoints(canvasX, canvasY) {
    ctx.beginPath();
    ctx.arc(canvasX, canvasY, 3, 0, 2 * Math.PI);
    ctx.fillStyle = "#E40045";
    ctx.fill();
    console.log(`${canvasX - width / 2} ${width / 2 - canvasY}`);
    ctx.closePath();
}