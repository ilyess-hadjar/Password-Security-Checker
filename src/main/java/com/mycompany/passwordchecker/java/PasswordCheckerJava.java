package com.mycompany.passwordchecker.java;

import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordCheckerJava {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choix = 0;

        while (choix != 3) {

            afficherTitre();

            System.out.println("1. Analyser un mot de passe");
            System.out.println("2. Generer un mot de passe");
            System.out.println("3. Quitter");
            System.out.println();

            System.out.print("Choisissez une option : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {

                analyserMotDePasse(scanner);

            }
            else if (choix == 2) {

                genererMotDePasse(scanner);

            }
            else if (choix == 3) {

                System.out.println();
                System.out.println("Au revoir !");

            }
            else {

                System.out.println();
                System.out.println("Option invalide.");

            }

            System.out.println();
        }

        scanner.close();
    }


   

    public static void analyserMotDePasse(Scanner scanner) {

        System.out.println("Analyse d'un mot de passe");
        System.out.println();

        System.out.print("Entrez votre mot de passe : ");
        String password = scanner.nextLine();

        analyserMotdePasseGenere(password);
    }


    

    public static void analyserMotdePasseGenere(String password) {

        String[] commonPasswords = {
            "123456",
            "password",
            "azerty",
            "qwerty",
            "admin",
            "123456789",
            "12345678"
        };


        String[] sequences = {
            "123",
            "456",
            "789",
            "abc",
            "xyz",
            "azerty",
            "qwerty"
        };


        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        boolean isCommonPassword = false;
        boolean endsWithDigit = false;
        boolean endsWithThreeDigits = false;
        boolean containsSequence = false;
        boolean hasRepeatedCharacters = false;

        int score = 0;
        int penalite = 0;

        String niveau = "";


        

        for (int i = 0; i < commonPasswords.length; i++) {

            if (password.equals(commonPasswords[i])) {

                isCommonPassword = true;

            }
        }


        

        for (int i = 0; i < sequences.length; i++) {

            if (password.contains(sequences[i])) {

                containsSequence = true;

            }
        }


        

        for (int i = 0; i < password.length(); i++) {

            char caractere = password.charAt(i);


            if (Character.isUpperCase(caractere)) {

                hasUppercase = true;

            }


            if (Character.isLowerCase(caractere)) {

                hasLowercase = true;

            }


            if (Character.isDigit(caractere)) {

                hasDigit = true;

            }


            if (!Character.isUpperCase(caractere)
                    && !Character.isLowerCase(caractere)
                    && !Character.isDigit(caractere)) {

                hasSpecialCharacter = true;

            }
        }


       

        for (int i = 2; i < password.length(); i++) {

            if (password.charAt(i) == password.charAt(i - 1)
                    && password.charAt(i) == password.charAt(i - 2)) {

                hasRepeatedCharacters = true;

            }
        }


        

        if (password.length() > 0) {

            char dernierCaractere =
                    password.charAt(password.length() - 1);


            if (Character.isDigit(dernierCaractere)) {

                endsWithDigit = true;

            }
        }


        

        if (password.length() >= 3) {

            if (Character.isDigit(
                    password.charAt(password.length() - 1))

                    && Character.isDigit(
                    password.charAt(password.length() - 2))

                    && Character.isDigit(
                    password.charAt(password.length() - 3))) {

                endsWithThreeDigits = true;

            }
        }


        
        

        if (hasUppercase) {

            score = score + 1;

        }


        if (hasLowercase) {

            score = score + 1;

        }


        if (hasDigit) {

            score = score + 1;

        }


        if (hasSpecialCharacter) {

            score = score + 1;

        }


        if (password.length() >= 8) {

            score = score + 1;

        }


        if (password.length() >= 12) {

            score = score + 2;

        }


        

        if (isCommonPassword) {

            score = 0;

        }


        

        if (endsWithThreeDigits) {

            penalite = penalite + 1;

        }


        if (containsSequence && !endsWithThreeDigits) {

            penalite = penalite + 1;

        }


        if (hasRepeatedCharacters) {

            penalite = penalite + 1;

        }


        score = score - penalite;


        if (score < 0) {

            score = 0;

        }


        

        if (score >= 7) {

            niveau = "Tres fort";

        }
        else if (score >= 5) {

            niveau = "Fort";

        }
        else if (score >= 3) {

            niveau = "Faible";

        }
        else {

            niveau = "Tres faible";

        }


        

        System.out.println();

        afficherLigne();

        System.out.println("              RESULTATS");

        afficherLigne();

        System.out.println();


        System.out.println("Longueur                 : "
                + password.length());


        System.out.println("Majuscule                : "
                + hasUppercase);


        System.out.println("Minuscule                : "
                + hasLowercase);


        System.out.println("Chiffre                  : "
                + hasDigit);


        System.out.println("Caractere special        : "
                + hasSpecialCharacter);


        System.out.println("Mot de passe courant     : "
                + isCommonPassword);


        System.out.println("Se termine par chiffre   : "
                + endsWithDigit);


        System.out.println("3 chiffres a la fin      : "
                + endsWithThreeDigits);


        System.out.println("Contient une sequence    : "
                + containsSequence);


        System.out.println("Caracteres repetes       : "
                + hasRepeatedCharacters);


        System.out.println();

        afficherLigne();


        System.out.println("Score de base             : "
                + (score + penalite) + "/7");


        System.out.println("Penalites                 : -"
                + penalite);


        System.out.println("Score final               : "
                + score + "/7");


        System.out.println("Niveau                    : "
                + niveau);


        afficherLigne();

        System.out.println();


        // Analyse détaillée

        afficherConseils(
                hasUppercase,
                hasLowercase,
                hasDigit,
                hasSpecialCharacter,
                isCommonPassword,
                endsWithThreeDigits,
                containsSequence,
                hasRepeatedCharacters,
                password.length(),
                score
        );
    }


    

    public static void afficherConseils(
            boolean hasUppercase,
            boolean hasLowercase,
            boolean hasDigit,
            boolean hasSpecialCharacter,
            boolean isCommonPassword,
            boolean endsWithThreeDigits,
            boolean containsSequence,
            boolean hasRepeatedCharacters,
            int longueur,
            int score) {

        System.out.println();

        afficherLigne();

        System.out.println("              ANALYSE");

        afficherLigne();

        System.out.println();


        

        System.out.println("POINTS FORTS :");

        boolean aUnPointFort = false;


        if (hasUppercase) {

            System.out.println("  + Majuscule detectee");

            aUnPointFort = true;
        }


        if (hasLowercase) {

            System.out.println("  + Minuscule detectee");

            aUnPointFort = true;
        }


        if (hasDigit) {

            System.out.println("  + Chiffre detecte");

            aUnPointFort = true;
        }


        if (hasSpecialCharacter) {

            System.out.println("  + Caractere special detecte");

            aUnPointFort = true;
        }


        if (longueur >= 12) {

            System.out.println("  + Longueur importante");

            aUnPointFort = true;

        }
        else if (longueur >= 8) {

            System.out.println("  + Longueur suffisante");

            aUnPointFort = true;
        }


        if (!aUnPointFort) {

            System.out.println(
                    "  Aucun point fort detecte.");

        }


        System.out.println();


        

        System.out.println("POINTS FAIBLES :");

        boolean aUnPointFaible = false;


        if (isCommonPassword) {

            System.out.println(
                    "  ! Mot de passe tres courant");

            aUnPointFaible = true;
        }


        if (!hasUppercase) {

            System.out.println(
                    "  ! Aucune majuscule");

            aUnPointFaible = true;
        }


        if (!hasLowercase) {

            System.out.println(
                    "  ! Aucune minuscule");

            aUnPointFaible = true;
        }


        if (!hasDigit) {

            System.out.println(
                    "  ! Aucun chiffre");

            aUnPointFaible = true;
        }


        if (!hasSpecialCharacter) {

            System.out.println(
                    "  ! Aucun caractere special");

            aUnPointFaible = true;
        }


        if (longueur < 8) {

            System.out.println(
                    "  ! Mot de passe trop court");

            aUnPointFaible = true;
        }


        if (endsWithThreeDigits) {

            System.out.println(
                    "  ! Trois chiffres consecutifs a la fin");

            aUnPointFaible = true;
        }


        if (containsSequence) {

            System.out.println(
                    "  ! Sequence facile a deviner detectee");

            aUnPointFaible = true;
        }


        if (hasRepeatedCharacters) {

            System.out.println(
                    "  ! Trois caracteres identiques consecutifs");

            aUnPointFaible = true;
        }


        if (!aUnPointFaible) {

            System.out.println(
                    "  Aucun point faible detecte.");

        }


        System.out.println();

        afficherLigne();


        

        if (score >= 7) {

            System.out.println(
                    "  RESULTAT : MOT DE PASSE TRES FORT");

        }
        else if (score >= 5) {

            System.out.println(
                    "  RESULTAT : MOT DE PASSE FORT");

        }
        else if (score >= 3) {

            System.out.println(
                    "  RESULTAT : MOT DE PASSE MOYEN");

        }
        else {

            System.out.println(
                    "  RESULTAT : MOT DE PASSE FAIBLE");

        }


        afficherLigne();

        System.out.println();
    }


    

    public static void genererMotDePasse(Scanner scanner) {

        System.out.println("Generation d'un mot de passe");

        System.out.println();

        System.out.println(
                "===== GENERATEUR DE MOT DE PASSE =====");

        System.out.println();


        System.out.print("Quelle longueur voulez-vous ? ");

        int longueur = scanner.nextInt();

        scanner.nextLine();


        if (longueur < 4) {

            System.out.println();

            System.out.println(
                    "Erreur : la longueur minimale est de 4 caracteres.");

            return;
        }


        String majuscules =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        String minuscules =
                "abcdefghijklmnopqrstuvwxyz";


        String chiffres =
                "0123456789";


        String caracteresSpeciaux =
                "!@#$%^&*";


        String tousLesCaracteres =
                majuscules
                + minuscules
                + chiffres
                + caracteresSpeciaux;


        SecureRandom random =
                new SecureRandom();


        String motDePasse = "";


       

        motDePasse += majuscules.charAt(
                random.nextInt(majuscules.length()));


        

        motDePasse += minuscules.charAt(
                random.nextInt(minuscules.length()));


       

        motDePasse += chiffres.charAt(
                random.nextInt(chiffres.length()));


        

        motDePasse += caracteresSpeciaux.charAt(
                random.nextInt(caracteresSpeciaux.length()));


        

        for (int i = 4; i < longueur; i++) {

            int index =
                    random.nextInt(
                            tousLesCaracteres.length());


            motDePasse +=
                    tousLesCaracteres.charAt(index);
        }


        

        char[] caracteresMotDePasse =
                motDePasse.toCharArray();


        for (int i =
                caracteresMotDePasse.length - 1;
                i > 0;
                i--) {

            int indexAleatoire =
                    random.nextInt(i + 1);


            char temporaire =
                    caracteresMotDePasse[i];


            caracteresMotDePasse[i] =
                    caracteresMotDePasse[indexAleatoire];


            caracteresMotDePasse[indexAleatoire] =
                    temporaire;
        }


        motDePasse =
                new String(caracteresMotDePasse);


        

        System.out.println();

        System.out.println(
                "Mot de passe genere : "
                + motDePasse);

        System.out.println();


       

        System.out.print(
                "Voulez-vous analyser ce mot de passe ? (o/n) : ");

        String reponse =
                scanner.nextLine();


        if (reponse.equalsIgnoreCase("o")) {

            analyserMotdePasseGenere(motDePasse);

        }
    }


   

    public static void afficherLigne() {

        System.out.println(
                "------------------------------------------");
    }


    

    public static void afficherTitre() {

        System.out.println(
                "+=====================================+");

        System.out.println(
                "|       PASSWORD SECURITY CHECKER     |");

        System.out.println(
                "+=====================================+");

        System.out.println();
    }
}