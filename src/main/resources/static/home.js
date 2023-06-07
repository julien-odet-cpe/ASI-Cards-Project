if(document.cookie.indexOf("userId") === -1){
    document.location = "http://localhost:8080/";
}

function redirectToBuy() {
    window.location.href = "market/buy.html";
}

function redirectToSell() {
    window.location.href = "market/sell.html";
}

function redirectToGame() {
    window.location.href = "game/game.html";
}