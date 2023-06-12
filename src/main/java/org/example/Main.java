package org.example;

import org.example.model.Article;
import org.example.service.MenuService;
import org.example.service.ResearcherService;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Article article = new Article("NO");

        ResearcherService researcher = new ResearcherService();
        MenuService.printWelcome();
        MenuService.printMainMenu();

        boolean quit = false;
        boolean quit2 = false;
        boolean quit3 = false;

        while (!quit) {

            System.out.println("Please Enter the Number of your choice (0 for Main Menu): ");
            int choice = scanner.nextByte();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    MenuService.printMainMenu();
                    break;
                case 1:
                    System.out.print("Please Enter Your National Code: ");
                    String  nationalCode = scanner.nextLine();
                    System.out.print("Please Enter Your Password: ");
                    String  password = scanner.nextLine();
                    researcher.login(nationalCode,password);

                    while(!quit2) {
                        System.out.println("Please Enter the Number of your choice (0 for User Menu): ");
                        int choice2 = scanner.nextByte();
                        scanner.nextLine();
                        switch (choice2) {
                            case 0:
                                MenuService.printUserMenu();
                                break;
                            case 1:
                                researcher.showPublishedArticle();
                                break;
                            case 2:
                                researcher.showNonPublishedArticle();
                                break;
                            case 3:

                                while (!quit3) {
                                    System.out.println("Please Enter the Number of your choice (0 for Edit Article Menu): ");
                                    int choice3 = scanner.nextByte();
                                    scanner.nextLine();
                                    switch (choice3) {
                                        case 0:
                                            MenuService.printEditArticleMenu();
                                            break;
                                        case 1:
                                            System.out.print("Please Enter your Article ID: ");
                                            int articleID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Please Enter your New Title: ");
                                            String newTitle = scanner.nextLine();
                                            researcher.changeArticleTitle(articleID, newTitle);
                                            break;
                                        case 2:
                                            System.out.print("Please Enter your Article ID: ");
                                            articleID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Please Enter your New Title: ");
                                            String newContent = scanner.nextLine();
                                            researcher.changeArticleContent(articleID, newContent);
                                            break;
                                        case 3:
                                            System.out.print("Please Enter your Article ID: ");
                                            articleID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Do you Want to Publish Your Article: 1.Yes  2.No ");
                                            int chosenStatus = scanner.nextInt();
                                            researcher.changeArticlePublishStatus(articleID, chosenStatus);
                                            break;
                                        case 4:
                                            quit3 = true;
                                            break;
                                    }
                                }
                            case 4:
                                System.out.print("Please Enter a Title for your Article: ");
                                String articleTitle = scanner.nextLine();
                                researcher.addArticle(articleTitle);
                                break;
                            case 5:
                                System.out.print("Please Enter Your Old Password: ");
                                String oldPassword = scanner.nextLine();
                                System.out.print("Please Enter Your new Password: ");
                                String newPassword = scanner.nextLine();
                                researcher.changePassword(oldPassword, newPassword);
                                break;
                            case 6:
                                quit2 = true;
                                break;
                        }
                    }
                case 2:
                    System.out.print("Please Enter Your User Name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Please Enter Your National Code: ");
                    nationalCode = scanner.nextLine();
                    researcher.register(userName,nationalCode);
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
    }
}