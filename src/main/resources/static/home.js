if(document.cookie.indexOf("userId") === -1){
    document.location = "http://localhost:8080/";
}

fetch("http://localhost:8080/a/" + document.cookie.split("=")[1])