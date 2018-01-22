package Application.Concession;

public class Account {
// attributs
    protected String username;
    protected String  nom;
    protected String  prenom;
    protected String  genre;
    protected int     age;
    public static int nombreAcc;

    public Account (){
        nombreAcc++;};

// constructeur
    public Account (String pUsername, String pNom, String pPrenom, String pGenre, int pAge){
        username = pUsername;
        nom = pNom;
        prenom = pPrenom;
        genre = pGenre;
        age = pAge;
        nombreAcc++;

    }

// getters

    public String getUsername() {
        return username;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getGenre() {
        return genre;
    }

    public int getAge() {
        return age;
    }

    public static int getNombreAcc() {
        return nombreAcc;
    }




    // setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
// autres

    public String idYourself (){
        return "\t username: "+ this.username +" , nom: "+this.nom +" , prénom: "+ this.prenom +" genre: "+this.genre +" age: "+this.age ;
    }

}
