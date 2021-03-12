let getUserButton = document.getElementById("getUserBtn");
getUserButton.onclick = handleButtonClick;

function handleButtonClick() {
    const idValue = document.getElementById("getUserId").value;
    const url = `/users/${idValue}`;

    fetch(url).then(response => response.ok ? response.json() : Promise.reject(response))
              .then(json => {
                document.getElementById("getName").value = json.username;
                document.getElementById("getEmail").value = json.email;
                document.getElementById("getPhone").value = json.phoneNumber;
                document.getElementById("getStatus").value = json.status;
              })
              .catch(response => {
                if(response.status == 404) {
                    showError("User not found");
                } else if(response.status == 400) {
                    showError("Empty id");
                } else {
                    showError("Error. Http status " + response.status);
                }
              });
}
