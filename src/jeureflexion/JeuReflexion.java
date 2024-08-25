/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jeureflexion;


import java.util.Scanner;
import java.util.Random;

public class JeuReflexion {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("──────────────────────────────────────────────\n\n\n\n");
		System.out.println("    BIENVENUE DANS UNE NOUVELLE PARTIE\n\n\n\n");
		System.out.println("──────────────────────────────────────────────\n\n\n\n");
		Joueur player_1=null;
		Joueur player_2=null;
		Scanner sc = new Scanner(System.in);
		String pseudo_1;
		String pseudo_2;
		int taille_grille;
		String answer;
		String difficult;
		boolean ordi=false;
		System.out.println("Souhaitez-vous jouer contre un ami ou contre un ordinateur ?\n\n1 --> Ami\n2 --> Ordinateur");
		while(true) {
			answer=sc.nextLine();
			if(answer.equals("1") || answer.equals("2")) {
				break;
			}else {
				System.out.println("Erreur, saisir 1 pour jouer contre un ami ou 2 pour jouer contre un ordinateur");
			}
		}
		
		
		switch(answer) {
		case "1":
			System.out.println("Veuillez saisir les pseudos des deux joueurs\n");
			System.out.print("Joueur 1 : ");
			pseudo_1=sc.nextLine();
			System.out.print("Joueur 2 : ");
			pseudo_2=sc.nextLine();
			
			System.out.println("\nQuelle taille de grille souhaitez avoir ?\n");
			System.out.print("Taille de la grille : ");
			taille_grille=sc.nextInt();
			while(true) {
				if(taille_grille>=3 && taille_grille<=5) {
					break;
				}else {
					System.out.println("\nErreur, veuillez saisir une valeur entre 3,4 et 5\n");
					System.out.print("Taille de la grille : ");
					taille_grille=sc.nextInt();
				}
			}
			System.out.print("\n\n");
			player_1=new Joueur(pseudo_1,taille_grille);
			player_2=new Joueur(pseudo_2,taille_grille);
			break;
		case "2":
			ordi=true;
			System.out.println("Veuillez saisir votre pseudo\n");
			System.out.print("Joueur 1 : ");
			pseudo_1=sc.nextLine();
			System.out.println("\nQuelle taille de grille souhaitez avoir ?\n");
			System.out.print("Taille de la grille : ");
			taille_grille=sc.nextInt();
			while(true) {
				if(taille_grille>=3 && taille_grille<=5) {
					break;
				}else {
					System.out.println("\nErreur, veuillez saisir une valeur entre 3,4 et 5\n");
					System.out.print("Taille de la grille : ");
					taille_grille=sc.nextInt();
				}
			}
			sc=new Scanner(System.in);	//Je réinitialise le scanner afin d'éviter une erreur
			System.out.println("Veuillez choisir le niveau de difficulté de l'ordinateur :\n\n1 --> Facile\n2 --> Moyen\n3 --> Extrême");
			while(true){
				difficult=sc.nextLine();
				if(difficult.equals("1")) {
					System.out.print("\n\n");
					player_1=new Joueur(pseudo_1,taille_grille);
					player_2=new Joueur(1,taille_grille);
					break;
				}else if(difficult.equals("2")) {
					System.out.print("\n\n");
					player_1=new Joueur(pseudo_1,taille_grille);
					player_2=new Joueur(2,taille_grille);
					break;
				}else if(difficult.equals("3")) {
					System.out.print("\n\n");
					player_1=new Joueur(pseudo_1,taille_grille);
					player_2=new Joueur(3,taille_grille);
					break;
				}else {
					System.out.println("Erreur, veuillez choisir entre 1,2 ou 3");
				}
			}
			break;
		}
		System.out.println("\n\n         ────────────────────────────────────────\n\n");
		String fin;
		Joueur premier=null;
		Joueur second=null;
		int change;
		int fin_tour=1;
		int nombre;
		Joueur switch_joueur;
		Random rand=new Random();
		nombre=rand.nextInt(0,2);
		switch(nombre) {
		case 0:
			premier=player_1;
			second=player_2;
			break;
		case 1:
			premier=player_2;
			second=player_1;
			break;
		}
		
		
		while(true) {
			
			if(ordi==true) {
				change = premier.jouerIa(second);
				if(change==0) {
					fin_tour=2;
				}else if(change==1) {
					switch_joueur=premier;
					premier=second;
					second=switch_joueur;
				}
			if(fin_tour==2) {
				fin=premier.verifFin(second);
				if(fin!=null) {
					System.out.println("Bravo a "+fin+" d'avoir gagné la partie");
					break;
				}
				fin_tour=1;
			}
			fin_tour+=1;
				
			
			
			}else {
				change = premier.jouer(second);
				if(change==0) {
					fin_tour=2;
				}else if(change==1) {
					switch_joueur=premier;
					premier=second;
					second=switch_joueur;
				}
			if(fin_tour==2) {
				fin=premier.verifFin(second);
				if(fin!=null) {
					System.out.println("Bravo a "+fin+" d'avoir gagné la partie");
					break;
				}
				fin_tour=1;
			}
			fin_tour+=1;
			}
		}
	
	
		
		
	}

}
