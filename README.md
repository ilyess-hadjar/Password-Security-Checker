# 🔐 Password Security Checker

## 📌 Présentation

Password Security Checker est une application Java permettant
d'analyser la robustesse d'un mot de passe et de générer
des mots de passe sécurisés.

Ce projet a été réalisé dans le but de mettre en pratique
des notions de programmation Java ainsi que des concepts
de base liés à la cybersécurité.

## 🚀 Fonctionnalités

### 🔎 Analyse d'un mot de passe

L'application analyse plusieurs caractéristiques :

- Longueur du mot de passe
- Présence de majuscules
- Présence de minuscules
- Présence de chiffres
- Présence de caractères spéciaux
- Détection des mots de passe courants
- Détection des séquences faciles à deviner
- Détection de trois chiffres consécutifs à la fin
- Détection de caractères répétés
- Calcul d'un score de sécurité
- Attribution d'un niveau de sécurité
- Affichage de conseils personnalisés

### 🔑 Générateur de mots de passe

Le programme permet également de générer automatiquement
des mots de passe.

Le générateur :

- Permet de choisir la longueur
- Utilise des majuscules
- Utilise des minuscules
- Utilise des chiffres
- Utilise des caractères spéciaux
- Garantit la présence de plusieurs types de caractères
- Mélange les caractères générés
- Utilise `SecureRandom`

### 📊 Analyse automatique

Après la génération d'un mot de passe, l'utilisateur peut
demander automatiquement son analyse.

## 🛠️ Technologies utilisées

- Java
- NetBeans
- SecureRandom
- Programmation orientée objet
- Algorithmique
- Manipulation de chaînes de caractères

## 🔐 Sécurité

Le générateur utilise `SecureRandom` afin de produire
des valeurs aléatoires adaptées à un contexte de sécurité.

L'application ne sauvegarde pas les mots de passe analysés.

## 💻 Exemple

```text
+=====================================+
|       PASSWORD SECURITY CHECKER     |
+=====================================+

1. Analyser un mot de passe
2. Generer un mot de passe
3. Quitter

Choisissez une option : 2

===== GENERATEUR DE MOT DE PASSE =====

Quelle longueur voulez-vous ? 16

Mot de passe genere : xVieoRgK&C1xSQc%
