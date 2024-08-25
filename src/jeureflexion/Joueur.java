/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeureflexion;

import java.util.Random;
import java.util.Scanner;

public class Joueur {

	private String pseudo;
	private int score=5;
	private String[][] grille;
	private int cptNbres;
	private int BUT=10;
	
	private int[][] proba=proba();
	private int difficult=1;
	
	public Joueur(String name,int cptNbres) throws InterruptedException {
		this.pseudo=name;
		this.cptNbres=cptNbres;
		this.grille=new String[this.cptNbres][this.cptNbres];
		rempGrille();
		affiche_objet();
		Thread.sleep(2400);
		
		
	}
	
	public Joueur(int difficult, int cptNbres) throws InterruptedException {
		this.pseudo="ordinateur";
		this.difficult=difficult;
		this.cptNbres=cptNbres;
		this.grille=new String[this.cptNbres][this.cptNbres];
		rempGrille();
		affiche_objet();
		Thread.sleep(2400);
	}
	
	public void affiche_objet() {
		System.out.println("Pseudo : " + this.pseudo);
		System.out.println("Votre Score est de  : " + this.score+"\n");
		afficher_grille();
	}
	
	
	private void rempGrille(){
		Integer[] different=new Integer[this.cptNbres*this.cptNbres];
		for(int i=0;i<different.length;i++) {	// Initialisation d'un tableau qui regroupera toutes les valeurs des cases de la grille afin de ne jamais générer les mêmes nombres
			different[i]=null;
		}
		int nbre;
		int cpt=0;
		boolean pareil=false;
		Random rand = new Random();
		for(int i=0;i<this.grille.length;i++) {  		// Première boucle for permettant de parcourir la ième ligne du tableau grille
			for(int j=0;j<this.grille.length;j++) {		// Deuxième boucle for permettant de parcourir la jème colonne du tableau grille
				while(true) {							// Boucle while afin de générer des nombres aléatoires différents
					pareil=false;
					nbre=rand.nextInt(-11,19);
					for(int a=0;a<different.length;a++) {
						if(different[a]!=null && nbre==different[a]) {
							pareil=true;				// Si le nombre généré est pareil qu'une valeur présente dans le tableau, alors le booléen pareil sera égale à true, et le code recommencera au début de la boucle while pour regénérer un nombre différent
							break;						// On casse ici la boucle for car cela ne sert a rien de continuer de parcourir le tableau puisque le nombre généré correspond déjà à une case du tableau
						}
					}
					if(pareil==false) {					// Si pareil est égale à false, cela veut dire que le nombre généré est différent de toutes les valeurs du tableau "different" et par conséquent différent de toutes les autres valeurs de la grille. On stop donc la boucle while afin d'ajouter le nombre généré dans la grille.
						break;
					}
				}
				this.grille[i][j]=""+nbre; 				// Ajout du nombre généré dans la grille
				different[cpt]=nbre;					// Ajout du nombre généré dans le tableau "different"
				cpt+=1;									// On indente cpt de 1 afin d'ajouter le prochain nombre généré dans la case suivante du tableau "different"
			}
		}
	}
	
	public String propCalcul(int dee1, int dee2, int dee3) {
		int result=0;
		String answer;
		int first=0;
		int second=0;
		int third=0;
		int last=0;
		boolean a= true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisissez la valeure de départ parmis les trois dées : "+"("+dee1+")"+" - "+"("+dee2+")"+" - "+"("+dee3+")");
		answer=sc.nextLine();
		while(a==true){
			System.out.println(answer);
			if(answer.equals(Integer.toString(dee1))) {
				first=dee1;
				second=dee2;
				third=dee3;
				a=false;
			}else if(answer.equals(Integer.toString(dee2))) {
				first=dee2;
				second=dee1;
				third=dee3;
				a=false;
			}else if(answer.equals(Integer.toString(dee3))) {
				first=dee3;
				second=dee1;
				third=dee2;
				a=false;
			}else {
				System.out.println("Choisissez la valeure de départ parmis les trois dées : "+"("+dee1+")"+" - "+"("+dee2+")"+" - "+"("+dee3+")");
				answer=sc.nextLine();
			}
				
		}
		System.out.println(" Vous avez choisis ("+ first+") \nQuel type d'opération souhaitez vous effectuer (+ ou -) et avec quelles valeurs restantes : "+"("+second+")"+" - "+"("+third+")");
		answer=sc.nextLine();
		while(a==false){
			
			if(answer.equals("+"+Integer.toString(second)) || answer.equals(Integer.toString(second))) {
				result=first+second;
				last=third;
				a=true;
			}else if(answer.equals("-"+Integer.toString(second))) {
				result=first-second;
				last=third;
				a=true;
			}else if(answer.equals("+"+Integer.toString(third)) || answer.equals(Integer.toString(third))) {
				result=first+third;
				last=second;
				a=true;
			}else if(answer.equals("-"+Integer.toString(third))) {
				result=first-third;
				last=second;
				a=true;
			}else {
				System.out.println("Erreur. Quel type d'opération souhaitez vous effectuer (+ ou -) et avec quelles valeurs restantes : "+"("+second+")"+" - "+"("+third+")");
				answer=sc.nextLine();
			}
		}
			
			
			System.out.println("Vous avez obtenu : "+result+"\nSouhaitez vous additionner (+) ou soustraire (-) le dernier nombre : "+last);
			answer=sc.nextLine();
			while(a==true) {
				if(answer.equals("+") || answer.equals("+"+last)) {
					result+=last;
					a=false;
				}else if(answer.equals("-") || answer.equals("-"+last)) {
					result-=last;
					a=false;
				}else {
					System.out.println("Erreur. Souhaitez vous additionner (+) ou soustraire (-)  "+last);
					answer=sc.nextLine();
				}
				
			}

	
			return (""+result);
			
		}
	
	
	public String propCalculIa(int dee1, int dee2, int dee3, int level) {
		Integer[][] result_similaire=new Integer[7][2];	//Initialisation d'un tableau remplis de null afin de stocker les valeurs des résultas qui fonctionnent pour par la suite comparer leur probabilités afin de choisir la plus faible
		for(int i=0;i<result_similaire.length;i++) {
			result_similaire[i][0]=null;
			result_similaire[i][1]=1000;
		}
		String[] result=new String[0];		// Tableau stockant les valeurs de tous les résultats possibles de calculs avec les trois dées
		
		switch(level) {					//Identifie le level choisi pour l'ordinateur
		case 1:							// Niveau 1 --> facile, on réduit alors le nombre de possibilités de calculs
			result=new String[3];
			result[0]=""+(dee3-dee1-dee2);
			result[1]=""+(dee1-dee2+dee3);
			result[2]=""+(dee1+dee2-dee3);
			break;
		
		case 2:								// Niveau 2 --> Moyen, on augmente le nombre de possibilités de calculs
			result=new String[5];
			result[0]=""+(dee1+dee2+dee3);
			result[1]=""+(dee1-dee2+dee3);
			result[2]=""+(dee1+dee2-dee3);
			result[3]=""+(dee1-dee2-dee3);
			
			result[4]=""+(dee2-dee1+dee3);
			break;
			
		case 3:								// Niveau 3 --> Extrême, l'ordinateur peut faire tous les calculs 
			result=new String[7];
			result[0]=""+(dee1+dee2+dee3);
			result[1]=""+(dee1-dee2+dee3);
			result[2]=""+(dee1+dee2-dee3);
			result[3]=""+(dee1-dee2-dee3);
			
			result[4]=""+(dee2-dee1+dee3);
			result[5]=""+(dee2-dee3-dee1);
		
			result[6]=""+(dee3-dee1-dee2);
			break;
		}
		
		
		
		for(int i=0;i<this.grille.length;i++) {		//Les deux premières boucles (i,j) permettent de parcourir la grille du joueur
			for(int j=0;j<this.grille.length;j++) {
				for(int nbr=0;nbr<result.length;nbr++) {		// La boucle for (nb) permet de parcourir le tableau result ainsi que result_similaire
					if(this.grille[i][j].equals(result[nbr])) {
						result_similaire[nbr][0] = Integer.parseInt(result[nbr]);	//Si le résultat des trois dées correspond à une case de la grille du joueur on stock alors le résultat dans le tableau result_similaire
					}
				}
			}
		}
		for(int nbr=0;nbr<result_similaire.length;nbr++) {
			if(result_similaire[nbr][0]!=null) {	//Garde toutes les valeurs où il y a un résultat du calcul avec les trois dées
				for(int a=0;a<this.proba.length;a++) {
					if(result_similaire[nbr][0]==this.proba[a][0]) {
						result_similaire[nbr][1]=this.proba[a][1];	//Récupère la probabilité du résultat et la place dans le sous tableau de résultat_similaire 
					}
				}
			}
		}
		Integer change[];
		for(int i=0;i<result_similaire.length;i++) {					//Tri à bulle afin que la sous liste du tableau sois le résultat avec la porbabilité la plus faible
			for(int j=0;j<(result_similaire.length-1-i);j++) {
				if(result_similaire[j+1][1]<result_similaire[j][1] && result_similaire[j+1][1]>=0 && result_similaire[j][1]>=0) {
					change=result_similaire[j+1];
					result_similaire[j+1]=result_similaire[j];
					result_similaire[j]=change;
				}
				
			}
		}
		
		
		if(result_similaire[0][0]!=null) {
			System.out.println("Le nombre choisis est : "+result_similaire[0][0]);
			return Integer.toString(result_similaire[0][0]);
		}else {
			return "-31";
		}
	}

	public void afficher_grille() {
		String ch;
		String[][] lst= {{""}};
		String ele1 = "──────┼";
		String ele2 = "──────┬";
		String ele3="──────┴";	
		String line="│";
		String line_haut="┌";
		String line_bas="└";
		
		if(this.cptNbres==3) {
			lst=new String[this.cptNbres+6][this.cptNbres];
		}else if(this.cptNbres==4) {
			lst=new String[this.cptNbres+7][this.cptNbres];
		}else if(this.cptNbres==5) {
			lst=new String[this.cptNbres+8][this.cptNbres];
		}
		
		for(int i=0; i<this.grille.length;i++) {
			if(i==this.grille.length-1) {
				line+="──────┤";
				line_haut+="──────┐";
				line_bas+="──────┘";
			}else {
				line+=ele1;
				line_haut+=ele2;
				line_bas+=ele3;
			}
		}
		
		int l=0;
		for(int i=0;i<this.grille.length;i++) {
			int c=0;
			for(int j=0;j<this.grille.length;j++) {
				if(j==(this.grille.length-1)){
					if (nombre(this.grille[i][j]) && Integer.parseInt(this.grille[i][j])>=0 && Integer.parseInt(this.grille[i][j])<=9) {
						lst[l+1][c]="│  "+this.grille[i][j]+"   │";
						c+=1;
					}else if(nombre(this.grille[i][j]) && Integer.parseInt(this.grille[i][j])<-9){
						lst[l+1][c]="│ "+this.grille[i][j]+"  │";
						c+=1;
					}else if(this.grille[i][j].equals("")) {
						lst[l+1][c]="│      │";
						c+=1;
					}else{
						lst[l+1][c]="│  "+this.grille[i][j]+"  │";
						c+=1;
					}
				}else if (nombre(this.grille[i][j]) && Integer.parseInt(this.grille[i][j])>=0 && Integer.parseInt(this.grille[i][j])<=9) {
					lst[l+1][c]="│  "+this.grille[i][j]+"   ";
					c+=1;
				}else if(nombre(this.grille[i][j]) && Integer.parseInt(this.grille[i][j])<-9){
					lst[l+1][c]="│ "+this.grille[i][j]+"  ";
					c+=1;
				}else if(this.grille[i][j].equals("")){
					lst[l+1][c]="│      ";
					c+=1;
				}else {
					lst[l+1][c]="│  "+this.grille[i][j]+"  ";
					c+=1;
				}
				
			}
			l+=2;
		}
		
		lst[0][0]=line_haut;
		
		
		for(int i=2;i<lst.length-1;i+=2) {
			for(int j=1;j<this.grille.length;j++) {
			if (i==lst.length-3) {
				lst[i][j]="";
				lst[i][j]=line_bas;
				j=this.grille.length;
			}else {
				lst[i][0]=line;
				lst[i][j]="";
			}
			}
		}
		for(int i=0;i<lst.length;i++) {
			ch="";
			for(int j=0;j<this.grille.length;j++) {
				if(lst[i][j]!=null) {
					ch+=lst[i][j];
				}
				
			}
			System.out.println(ch);
		}
	}


	public boolean verifNbre(String chiffre) { 
        for (int i = 0; i < this.grille.length; i++) {
        	for(int j=0;j<this.grille.length;j++) {
        		if (chiffre.equals(this.grille[i][j])) {
        			this.grille[i][j]="";
                    System.out.println("Vous avez bien une valeur dans votre grille !");
                    return true;
                }
        	}
            
        }

        System.out.println("Vous n'avez pas cette valeur dans votre grille !");
        return false;

    }
	
	
	private boolean nombre(String chaine) {
	    try {
	        Integer.parseInt(chaine);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	
	public void modifScore(boolean x) {           
        if(x == true) {
            score += 1 ;                         
        }
        else if(x==false) {
            score -= 1 ;
        }
        
    }


	public boolean verifGagnant() { 
        if (score >= BUT) {
            return true ;
        } else {
            for (int i=0 ; i < grille.length ; i++) {
                for (int j=0 ; j < grille[i].length ; j++) {   
                    if (nombre(grille[i][j]) && Integer.parseInt(grille[i][j]) != 0) {
                        return false ;
                }
            }
        } 
        return true ;
        }
    }
	
	
	public boolean verifPerdant() { 
        if (score == 0) {
            return true ;
        } else {
            return false ;
        }
        
    }
	
	
	public String verifFin(Joueur adversaire) {
		boolean gagne1 = verifGagnant();
		boolean perd1 = verifPerdant();
		
		boolean gagne2 = adversaire.verifGagnant();
		boolean perd2 = adversaire.verifPerdant();
		
		if(gagne1==true || perd2==true) {
			return this.pseudo;
		}else if(gagne2==true || perd1==true) {
			return adversaire.pseudo;
		}else {
			return null;
		}
	}

	private int[] lancer_dee() {
		Random rand = new Random();
		int[] dee=new int[3];
		dee[0]=rand.nextInt(1,7);
		dee[1]=rand.nextInt(1,7);
		dee[2]=rand.nextInt(1,7);
		return dee;
	}


	
	public int[][] proba(){
		int[] result=new int[7];
		int cpt=-11;
		int[][] tabl=new int[30][3];
		for(int i=0;i<tabl.length;i++) {
			tabl[i][0]=cpt;
			tabl[i][1]=0;
			tabl[i][2]=0;
			cpt+=1;
		}
		
		for(int i=0;i<1000;i++) {
			int[] dee=lancer_dee();
			result[0]=(dee[0]+dee[1]+dee[2]);
			result[1]=(dee[0]-dee[1]+dee[2]);
			result[2]=(dee[0]+dee[1]-dee[2]);
			result[3]=(dee[0]-dee[1]-dee[2]);
			
			result[4]=(dee[1]-dee[0]+dee[2]);
			result[5]=(dee[1]-dee[2]-dee[0]);
		
			result[6]=(dee[2]-dee[0]-dee[1]);
			
			for(int f=0;f<tabl.length;f++) {
				for (int h=0;h<result.length;h++) {
					if(tabl[f][0]==result[h]) {
						tabl[f][1]+=1;
					}
				}
			}
		}
		
		
		return tabl;
	}
	
	
	
	public int jouer(Joueur adversaire) throws InterruptedException{
		boolean a=true;
		boolean b=true;
		Scanner sc=new Scanner(System.in);
		String answer;
		String answer_2;
		System.out.println("A toi de jouer : "+this.pseudo+"\n\n");
		afficher_grille();
		Thread.sleep(1700);
		System.out.println("APPUYEZ SUR ENTREE POUR LANCER LES DEES");
		answer=sc.nextLine();
		System.out.println("\n\nLancement des trois dées... Voici les résultats :");
		Thread.sleep(900);
		int[] dee=lancer_dee();
		System.out.println("\n\nDée 1 : "+dee[0]+"\nDée 2 : "+dee[1]+"\nDée 3 : "+dee[2]);
		System.out.println("\n\nQue souhaitez vous faire : \n1 --> Proposer un calcul \n2 --> Passer votre tour ");
		answer=sc.nextLine();
		while(a) {
			switch(answer) {			// Création d'un switch permettant de de traiter les différentes possibilités de la variable answer
				case "1":				// Le joueur souhaite porposer un calcul
					String result=propCalcul(dee[0],dee[1],dee[2]);		//On effectue la calcul en appelant la fonction propCalcul que l'on stock dans une variable result
					Thread.sleep(1300);
					boolean nbr=verifNbre(result);						// On vérifie si le resultat du calcul est bien présente dans la grille du joueur,si c'est le cas on enlève le nombre de la case pour y mettre un espace, et on stock la réponse dans une variable booléénne
					modifScore(nbr);									// On modifie le score su joueur suivant la variable booléenne
					affiche_objet();									// On réaffiche la grille avec les modifications s'il y en a
					Thread.sleep(1300);
					System.out.println("\n\n         ────────────────────────────────────────\n\n");
					return 1;											//On retourne 1 pour savoir dans le fichier princial que c'est à l'adversaire de jouer
				case "2":				// Le joueur passe son tour
					System.out.println("\nVous avez choisis de passer votre tour.\n\n");
					System.out.println("\n\n         ────────────────────────────────────────\n\n");
					System.out.println("A toi de jouer : "+adversaire.pseudo+"\n\n");
					afficher_grille();
					Thread.sleep(1700);
					System.out.println("Souhaites-tu : \n\n1 --> Utiliser les dées de ton adversaire \n2 --> Effectuer un nouveau tirage de dées\n\n");
					answer_2=sc.nextLine();
					while(b) {							//Boucle while afin de choisir uniquement entre 1 et 2
						if(answer_2.equals("1")) {		//L'adversaire a chosis d'utiliser les dées de son adversaire.
							result=adversaire.propCalcul(dee[0],dee[1],dee[2]);
							Thread.sleep(1300);
							nbr=adversaire.verifNbre(result);
							adversaire.modifScore(nbr);
							adversaire.affiche_objet();
							Thread.sleep(1300);
							System.out.println("\n\n         ────────────────────────────────────────\n\n");
							return 0;								//On retourne 0 pour savoir dans le fichier princial que c'est au joueur 1 de commencer, et que donc un tour vient d'être effcetué
						}else if(answer_2.equals("2")){		//Le joueur décide de jouer en laçant de nouveaux dées.
							return 1;								//On retourne 1 pour savoir dans le fichier princial que c'est à l'adversaire de jouer
						}else {
							System.out.println("\nErreur. Veuillez choisir entre : \\n\\n1 --> Utiliser les dées de ton adversaire \\n2 --> Effectuer un nouveau tirage de dées\\n");
							answer_2=sc.nextLine();
						}
					}
				default:
					System.out.println("\n\nErreur, que souhaitez vous faire : \n1 --> Proposer un calcul \n2 --> Passer votre tour ");
					answer=sc.nextLine();
				}
		}
		
		return 5;			//Ce return permet d'éviter un problème dans la fonction qui renvoie forcément un nombre. Il ne sera jamais utilisé.
	}


	public int jouerIa(Joueur adversaire) throws InterruptedException{
		String answer;
		Scanner sc=new Scanner(System.in);
		System.out.println("A toi de jouer : "+this.pseudo+"\n\n");
		afficher_grille();
		Thread.sleep(1700);
		if(this.pseudo=="ordinateur") {		//  Le joueur est l'ordinateur
			System.out.println("\n\nLancement des trois dées... Voici les résultats :");
			Thread.sleep(900);
			int[] dee=lancer_dee();
			System.out.println("\n\nDée 1 : "+dee[0]+"\nDée 2 :"+dee[1]+"\nDée 3 : "+dee[2]);
			String resultIA=propCalculIa(dee[0],dee[1],dee[2],this.difficult);
			Thread.sleep(1300);
			boolean nbrIA=verifNbre(resultIA);
			modifScore(nbrIA);
			affiche_objet();
			Thread.sleep(1300);
			System.out.println("\n\n         ────────────────────────────────────────\n\n");
			return 1;						//On retourne 1 pour savoir dans le fichier princial que c'est à l'adversaire de jouer
		}else {								//Le joueur n'est pas l'ordinateur
			System.out.println("APPUYEZ SUR ENTREE POUR LANCER LES DEES");
			answer=sc.nextLine();
			System.out.println("\n\nLancement des trois dées... Voici les résultats :");
			Thread.sleep(900);
			int[] dee=lancer_dee();
			System.out.println("\n\nDée 1 : "+dee[0]+"\nDée 2 :"+dee[1]+"\nDée 3 : "+dee[2]);
			System.out.println("\n\nQue souhaitez vous faire : \n1 --> Proposer un calcul \n2 --> Passer votre tour ");
			answer=sc.nextLine();
			switch(answer) {
				case "1":					// Le joueur souhaite porposer un calcul
					String result=propCalcul(dee[0],dee[1],dee[2]);
					boolean nbr=verifNbre(result);
					modifScore(nbr);
					adversaire.affiche_objet();
					System.out.println("\n\n         ────────────────────────────────────────\n\n");
					return 1;				//On retourne 1 pour savoir dans le fichier princial que c'est à l'adversaire de jouer
				case "2":					// Le joueur passe sont tour, donc l'ordinateur joue avec ses dées
					System.out.println("\nVous avez choisis de passer votre tour.\n");
					System.out.println("\n\n         ────────────────────────────────────────\n\n");
					System.out.println("A toi de jouer : "+adversaire.pseudo+"\n\n");
					System.out.println("Voici les dées : \nDée 1 : "+dee[0]+"\nDée 2 :"+dee[1]+"\nDée 3 : "+dee[2]+"\n\n");
					adversaire.afficher_grille();
					Thread.sleep(1700);
					result=adversaire.propCalculIa(dee[0],dee[1],dee[2],this.difficult);
					Thread.sleep(1300);
					nbr=adversaire.verifNbre(result);
					adversaire.modifScore(nbr);
					adversaire.affiche_objet();
					Thread.sleep(1300);
					System.out.println("\n\n         ────────────────────────────────────────\n\n");
					return 0;				//On retourne 0 pour savoir dans le fichier princial que c'est au joueur 1 de commencer, et que donc un tour vient d'être effcetué
			}
		}
		
		return 5;						//Ce return permet d'éviter un problème dans la fonction qui renvoie forcément un nombre. Il ne sera jamais utilisé.
	}
}

