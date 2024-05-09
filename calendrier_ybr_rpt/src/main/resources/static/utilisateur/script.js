const apiAjoutUtilisateurURL = "/api/utilisateurs";
const connexionUrl = "/"

function ajouterUtilisateur(){
    const nom = document.getElementById("nom").value;
    const prenom = document.getElementById("prenom").value;
    const email = document.getElementById("email").value;
    const motDePasse = document.getElementById("motDePasse").value;
    const idTheme = document.getElementById("theme").value;

    const utilisateur = {
        "nom": nom,
        "prenom": prenom,
        "email": email,
        "motDePasse": motDePasse,
        "idTheme": idTheme,
    }
    
    try{
        fetch(apiAjoutUtilisateurURL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(utilisateur),
        }).then(response =>{
            if(response.ok){
                document.location = connexionUrl;    
            }
        });
    }catch(err){
        console.log(err)
    }
}