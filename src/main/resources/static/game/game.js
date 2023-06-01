if (document.cookie.indexOf("userId") === -1) {
    document.location = "http://localhost:8080/";
}

let user;

fetch("http://localhost:8080/player-rest/" + document.cookie.split("=")[1])
    .then((response) => response.json()
        .then((data) => {
            if(data === null || data.id === null){
                return;
            }
            document.getElementById("money").innerHTML = data.money;
            document.getElementById("surname").innerHTML = data.surname;
            user = data;
        }))

let logout = () => {
    document.cookie = 'userId=; Max-Age=0'
    document.location = "http://localhost:8080/";
};

const userId = +document.cookie.split("=")[1];

/* TO DO

fetch("http://localhost:8080/hero-rest/player/" + userId, {
    method: "GET"
}).then(response => {
    response.json().then(data => {
        console.log(data);
        populateTable(data);
    });
});*/

function redirectToCreateRoom() {
    window.location.href = "create-room.html";
}

function redirectToGame() {
    window.location.href = "game.html";
}

function redirectToWaitingRoom() {
    window.location.href = "waiting-room.html";
}

function populateRoomTable(data) {
    const tableBody = document.querySelector("#gameTable"); // Assuming there is only one table on the page

    // Iterate over the data and create table rows"
    data.forEach(game => {
        const row = document.createElement("tr");

        // Create and populate cells for each field
        const nameCell = document.createElement("td");
        nameCell.textContent = hero.name;
        row.appendChild(nameCell);

        const descriptionCell = document.createElement("td");
        descriptionCell.textContent = hero.description;
        row.appendChild(descriptionCell);

        const hpCell = document.createElement("td");
        hpCell.textContent = hero.hp;
        row.appendChild(hpCell);

        const attackCell = document.createElement("td");
        attackCell.textContent = hero.attack;
        row.appendChild(attackCell);

        const defenseCell = document.createElement("td");
        defenseCell.textContent = hero.defense;
        row.appendChild(defenseCell);

        const energyCell = document.createElement("td");
        energyCell.textContent = hero.energy;
        row.appendChild(energyCell);

        row.addEventListener("click", () => {
            handleRowClick(hero);
        });

        tableBody.appendChild(row);
    });
}