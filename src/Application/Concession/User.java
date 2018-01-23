package Application.Concession;

import java.util.Scanner;

public class User extends Account {
    // attributs
    protected int numClient = 100000;
    protected long numCarte;
    protected int nbAchat = 0;
    protected String password;

    // constructeur


    public User() {
    }

    public User (String pUsername, String pNom, String pPrenom, String pGenre, int pAge, long pNumCarte){
        super();
        this.numCarte = pNumCarte;
        this.numClient ++;
        this.username=pUsername;
        this.nom = pNom;
        this.prenom = pPrenom;
        this.genre = pGenre;
        this.age = pAge;
        System.out.println("\t Nouvel acheteur créé sous le pseudo : "+this.username);
    };
    public User (String pUsername,String pPassword, String pNom, String pPrenom, String pGenre, int pAge, long pNumCarte){
        super();
        this.numCarte = pNumCarte;
        this.password=pPassword;
        this.numClient ++;
        this.username=pUsername;
        this.nom = pNom;
        this.prenom = pPrenom;
        this.genre = pGenre;
        this.age = pAge;
        System.out.println("\t Nouvel acheteur créé sous le pseudo : "+this.username);
    };

    public User (String pUsername, String pPassword){
        super();
        this.username=pUsername;
        this.password=pPassword;

        System.out.println("\t Nouvel acheteur créé sous le pseudo : "+this.username);
    };

    // getters
    // setters

    public long getNumCarte() {
        return numCarte;
    }



    public int getNumClient() {
        return numClient;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumCarte(long numCarte) {
        this.numCarte = numCarte;
    }
        // autres


    @Override
    public String idYourself() {
        return super.idYourself() + " Numéro Client: "+this.numClient;
    }


    public void essayer(Vehicule target){                           // permet a l'USER d'essayer un véhicule
        target.getReservoir();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel % d'essence va tu uiliser?");
           int pourcentUtil = sc.nextInt();                          // récupère la valeur de l'input ^
        target.reservoir = target.reservoir-pourcentUtil;
        if  (target.reservoir<0){
            target.reservoir = 0;
            System.out.println("\t le réservoir est maintenant vide, il va falloir le remplir!");
            System.out.println("Voulez vous acheter ce véhicule? Oui/Non");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
        }else {
            System.out.println("\t le reservoir de " + target.getNom() + " est maintenant a " + target.getReservoir() + "% de son maximum");
        }
        }

    public void remplir(Vehicule target){                           // permet de remplir un véhicule / remonter résevoir
        target.getReservoir();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel % d'essence va tu remettre?");
        int pourcentRempl = sc.nextInt();                           // récupère la valeur de l'input ^
        target.reservoir = target.reservoir+pourcentRempl;
        if  (target.reservoir>100){
            target.reservoir = 100;
            System.out.println("\t AAAAHHH ça déborde! tu ne peux pas dépasser les 100% évidement alors arrête!");
        }else {
            System.out.println("\t le reservoir de " + target.nom + " est maintenant a " + target.reservoir + "% de son maximum");
        }
        }

    public void acheter (Produit target, Seller vendeur){              // l'user achète un produit, et demande la facture a un vendeur
        target.getNom();
        vendeur.getNom();
        System.out.println("\t "+this.username+" doit payer "+target.prix+" euro pour acquérir "+target.nom+" avec Mr "+vendeur.nom+ " comme vendeur");
        vendeur.editFacture(target,vendeur,this);
    }

    public void parcourirCatalogue(Seller vendeur){                 // affiche tout les choix possibles
        Scanner sc = new Scanner(System.in);
        System.out.println("Quels produits souhaitez vous voir? 'les véhicules' ou 'les assurances'?");
        String what = sc.nextLine();
        if (what.equals("les véhicules")){
                User.this.parcourirCatalogVehicule(vendeur);
            }else if (what.equals("les assurances")){
                User.this.parcourirCatalogAssurance(vendeur);
            }else {
                System.out.println("Réponse non prise ne compte, attentions aux majuscule.");
            };
    }

    public void parcourirCatalogVehicule(Seller vendeur){
        int choix2;

        for ( int parc = 0; parc < vendeur.nbCarAjout; parc ++  )
          {   int parcaffi = parc+1;
              System.out.println(
                 parcaffi + " |"+
                 vendeur.arrayVehicule[parc].type + " "+
                 vendeur.arrayVehicule[parc].marque + " "+
                 vendeur.arrayVehicule[parc].nom + " "+
                 vendeur.arrayVehicule[parc].place + " "+
                 vendeur.arrayVehicule[parc].prix + " "+
                 vendeur.arrayVehicule[parc].description + " "
             );
          };
          Scanner sc = new Scanner(System.in);
          System.out.println("Voulez vous acheter ou essayer?");
          String choix = sc.nextLine();
          if (choix.equals("essayer") )
                    {
                    System.out.println("Quel véhicule vous interesse?");
                    choix2 = sc.nextInt();
                    User.this.essayer(vendeur.arrayVehicule[choix2]);
             }
          else if  (choix.equals("acheter") )
                    {
                    System.out.println("Quel véhicule vous interesse?");
                    choix2 = sc.nextInt();
                    choix2 = choix2-1;
                    User.this.acheter(vendeur.arrayVehicule[choix2],vendeur);
            }
           else {
              System.out.println("Reponse incompréhensible");
                } ;
          sc.close();
    }

    public void parcourirCatalogAssurance(Seller vendeur){
        int choix2;

        for ( int parc = 0; parc < vendeur.nbAssuAjout; parc ++  )
        {   int parcaffi = parc+1;
            System.out.println(
                    parcaffi + " |"+
                            vendeur.arrayAssurance[parc].type + " "+
                            vendeur.arrayAssurance[parc].nom + " "+
                            vendeur.arrayAssurance[parc].dateSouscription + " "+
                            vendeur.arrayAssurance[parc].prix + " "+
                            vendeur.arrayAssurance[parc].description + " "
            );
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez vous en acheter une? Oui / Non");
       String choix = sc.nextLine();
      if  (choix.equals("Oui") )
        {
            System.out.println("Quelle assurance vous interesse?");
            choix2 = sc.nextInt();
            choix2 = choix2-1;
            User.this.acheter(vendeur.arrayAssurance[choix2],vendeur);
        }
        else if (choix.equals("Non"))
        {
            System.out.println("Au revoir!");
        }
        else  {
            System.out.println("Reponse incompréhensible");
        } ;
        sc.close();
    }



}