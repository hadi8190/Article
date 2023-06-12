package org.example.service;

import org.example.model.Researcher;
import org.example.repository.ResearcherRepo;

public class ResearcherService {

    private Researcher loggedInUser = null;


    public Researcher getLoggedInUser() {
        return loggedInUser;
    }

    public boolean register(String username, String nationalCode) {
        if (ResearcherRepo.findResearcherByNationalCode(nationalCode) == null) {
            Researcher researcher = new Researcher(username, nationalCode);
            ResearcherRepo.createResearcher(researcher);
            System.out.println("Account Created Successfully!");
            System.out.println("Your Password Set to your National Code!");
            return true;
        }
        System.out.println("You Signed up with this National Code Before!");
        return false;
    }

    public boolean login(String nationalCode, String password) {
        Researcher researcher = ResearcherRepo.findResearcher(nationalCode,password);
        if (researcher != null) {
            if (researcher.getPassword().equals(password)){
                this.loggedInUser = researcher;
                System.out.println(researcher.getUserName()+" with [National Code: "+ nationalCode
                        + "] Logged in Successfully");
                return true;
            }
        }
        System.out.println("National Code or Password is Incorrect!");
        return false;
    }

    public void changePassword(String oldPassword,String newPassword){
        if (getLoggedInUser().getPassword().equals(oldPassword)) {
            loggedInUser.setPassword(newPassword);
            ResearcherRepo.updateResearcherPassword(this.loggedInUser, newPassword);
            System.out.println("Your Password Changed Successfully. New Password is: " + newPassword);
        } else
            System.out.println("Your Old Password is Incorrect!");
    }
    public void addArticle(String title){
        ArticleService.createArticle(loggedInUser,title);
    }

    public void changeArticleTitle(int articleId,String title){
        if(loggedInUser!= null)
            ArticleService.changeArticleTitle(articleId,title);
        else
            System.out.println("Request is Invalid!");
    }

    public void changeArticlePublishStatus(int articleId,int publishStatus){
        if(loggedInUser!= null)
            ArticleService.changeArticlePublishStatus(articleId,publishStatus);
        else
            System.out.println("Request is Invalid!");
    }

    public void changeArticleContent(int articleId,String content){
        if(loggedInUser!= null)
            ArticleService.changeArticleContent(articleId,content);
        else
            System.out.println("Request is Invalid!");
    }

    public void showNonPublishedArticle(){
        if(loggedInUser!= null) {
            int researcherId = loggedInUser.getResearcherId();
            ArticleService.showNonPublishedArticle(researcherId);
        }
        else
            System.out.println("Request is Invalid!");
    }
    public void showPublishedArticle(){
        if(loggedInUser!= null) {
            int researcherId = loggedInUser.getResearcherId();
            ArticleService.showPublishedArticle(researcherId);
        }
        else
            System.out.println("Request is Invalid!");
    }

}
