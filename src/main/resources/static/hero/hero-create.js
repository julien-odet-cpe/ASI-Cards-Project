let createHero = function () {
    console.log("createHero");
    const name = document.getElementById("form-name").value;
    const description = document.getElementById("form-description").value;
    const imgUrl = document.getElementById("form-imgUrl").value;
    const hp = document.getElementById("form-hp").value;
    const energy = document.getElementById("form-energy").value;
    const attack = document.getElementById("form-attack").value;
    const defense = document.getElementById("form-defense").value;
    if (name === "" || description === "" || imgUrl === "" || hp === "" || energy === "" || attack === "" || defense === "") {
        alert("Please fill in all fields");
        console.log('EKIP')
        return;
    }
    const hero = {
        name: name,
        description: description,
        imgUrl: imgUrl,
        hp: hp,
        energy: energy,
        attack: attack,
        defense: defense
    };

    fetch("http://localhost:8080/hero-rest", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(hero)
    }).then(response => {
        response.json().then(data => {
            if(data != null && data.id != null){
                window.location = "http://localhost:8080/hero/detail.html?id=" + data.id;
            }
        });
    })
}