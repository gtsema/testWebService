function showMessage(text) {
    document.getElementById("toastText").textContent = text;
    document.getElementById("toastColor").setAttribute("fill", "#007aff");
    document.getElementById("toastType").textContent = "Information";
    $("#toast").toast('show');
};

function showError(text) {
    document.getElementById("toastText").textContent = text;
    document.getElementById("toastColor").setAttribute("fill", "#ff0000");
    document.getElementById("toastType").textContent = "Error";
    $("#toast").toast('show');
};
