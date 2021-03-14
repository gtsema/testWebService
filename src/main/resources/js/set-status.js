let setStatusButton = document.getElementById("setStatusButton");
setStatusButton.onclick = handleButtonClick;

function handleButtonClick() {
    const idValue = document.getElementById("setStatusInputId").value;
    const url = `/users/${idValue}`;

    let status;

    let radioOnline = document.getElementById("radioOnline");
    let radioAway = document.getElementById("radioAway");
    let radioOffline = document.getElementById("radioOffline");


    if(radioOnline.checked) {
        status = "Online";
    } else if(radioAway.checked) {
        status = "Away";
    } else if(radioOffline.checked) {
        status = "Offline";
    }

    let response = fetch(url, {
        method: 'PUT',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({ Status : status })
    });

    response.then(response => response.ok ? response.json() : Promise.reject(response))
                .then(response => console.log(response))
                .catch(response => {
                    if(response.status == 400) {
                        showError("Empty id");
                        console.log("Empty id or invalid status");
                    } else if(response.status == 404) {
                        showError("User not found");
                    } else {
                        showError("Error. Http status " + response.status);
                    }
                });
}
