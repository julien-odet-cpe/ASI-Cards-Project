
if(document.cookie.indexOf("userId") !== -1){
    document.location = "http://localhost:8080/home.html";
}


let onLogin = () => {
    const username = document.getElementById("username")?.value;
    const password = document.getElementById("pwd")?.value;
    if(username == null || username === "" || password == null || password === ""){
        alert("Username and password are not valid!");
        return;
    }
    const data = {
        username: username,
        password: password
    }

    fetch("http://localhost:8080/player-rest/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(response => {
        response.json().then(data => {
            if(data != null && data.id != null){
                document.cookie = "userId=" + data.id + data.username + ";path=/";
                window.location = "http://localhost:8080/home.html";
            }
        });
    });
}