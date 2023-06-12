package org.example.service;

public class MenuService {

    public static void printWelcome(){
        System.out.println("WELCOME:)");
    }

    public static void printMainMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. Login");
        System.out.println("\t 2. Register");
        System.out.println("\t 3. Quit");
    }

    public static void printUserMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. Show My Published Articles");
        System.out.println("\t 2. Show My Non Published Articles");
        System.out.println("\t 3. Edit My Articles");
        System.out.println("\t 4. Add a New Article");
        System.out.println("\t 5. Change My Password");
        System.out.println("\t 6. Quit");
    }

    public static void printEditArticleMenu(){
        System.out.println("\nPress:");
        System.out.println("\t 1. Change Article Title");
        System.out.println("\t 2. Change Article Content");
        System.out.println("\t 3. Change Article Published Status");
        System.out.println("\t 4. Quit");
    }

}
