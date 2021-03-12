let addUserButton = document.getElementById("addUserButton");
addUserButton.onclick = handleButtonClick;

function handleButtonClick() {
    let url = "/users";

    let nameValue = document.getElementById("inputName").value;
    let emailValue = document.getElementById("inputEmail").value;
    let phoneValue = document.getElementById("inputPhone").value;

    let user = { username: nameValue, email: emailValue, phoneNumber : phoneValue };

    let response = fetch(url, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    });

    response.then(response => response.ok ? response.json() : Promise.reject(response))
            .then(json => {
                console.log("added user with id = " + json);
                showMessage("added user with id = " + json);
            })
            .catch(response => {
                if(response.status == 400) {
                    showError("Incorrect data");
                } else {
                    showError("Error. Http status " + data.status);
                }
            });
}
