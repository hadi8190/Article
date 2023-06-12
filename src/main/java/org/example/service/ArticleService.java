package org.example.service;

import org.example.model.Article;
import org.example.model.Researcher;
import org.example.repository.ArticleRepo;

import java.util.ArrayList;

public class ArticleService {

    private Article chosenArticle = null;

    public Article getChosenArticle() {
        return chosenArticle;
    }

    public void setChosenArticle(Article chosenArticle) {
        this.chosenArticle = chosenArticle;
    }

    public static void createArticle(Researcher researcher, String title) {
        Article articles = new Article(researcher, title);
        ArticleRepo.createArticle(articles);
    }

    public boolean findArticle(int articleId) {
        Article article = ArticleRepo.findResearcherArticle(articleId);
        if (article != null) {
            this.chosenArticle = article;
            return true;
        }
        return false;
    }

    public static void changeArticleTitle(int articleId, String newTitle) {
        Article article = ArticleRepo.findResearcherArticle(articleId);
        if (article != null) {
            String oldTitle = article.getTitle();
            article.setTitle(newTitle);
            ArticleRepo.updateArticleTitle(article, newTitle);
            System.out.println("Your Article title:[" + oldTitle + "],changed to [" + newTitle + "].");
        } else
            System.out.println("Article Not Found!");
    }

    public static void changeArticleContent(int articleId, String newContent) {
        Article article = ArticleRepo.findResearcherArticle(articleId);
        if (article != null) {
            String oldContent = article.getContent();
            article.setContent(newContent);
            ArticleRepo.updateArticleContent(article, newContent);
            System.out.println("Your Article Content Updated Successfully.");
        } else
            System.out.println("Article Not Found!");
    }

    public static void changeArticlePublishStatus(int articleId, int publishStatus) {

        Article article = ArticleRepo.findResearcherArticle(articleId);
        article.setArticleId(articleId);
        if (article != null) {
            if (publishStatus == 1) {
                //               if (article.getIsPublished().equals("YES")) {
                article.setIsPublished("Yes");
                ArticleRepo.updateArticlePublishStatus(article, 1);
                System.out.println("Article Publish Status Changed to 'Yes'");
            } else {
                System.out.println("Published Status for this Article is Already 'Yes'!");
            }
        } else if (publishStatus == 2) {
            //               if (article.getIsPublished().equals("NO")) {
            article.setIsPublished("No");
            ArticleRepo.updateArticlePublishStatus(article, 2);
            System.out.println("Article Publish Status Changed to 'No'");
        } else {
            System.out.println("Published Status for this Article is Already 'No'!");
        }
    } //else

 //   {
//        System.out.println("Article Not Found!");


    public static void showNonPublishedArticle(int researcherId) {
        ArrayList<Article> articles = ArticleRepo.findNonPublishedArticleForOneResearcher(researcherId);
        System.out.println("Non Published Article(s):");
        for (int i = 0; i < articles.size(); i++) {
            System.out.println("\t" + (i+1) + "."+ articles.get(i).getTitle()+" [Article ID: "+articles.get(i).getArticleId()+"]");
        }
    }

    public static void showPublishedArticle(int researcherId) {
        ArrayList<Article> articles = ArticleRepo.findPublishedArticleForOneResearcher(researcherId);
        System.out.println("Published Article(s):");
        for (int i = 0; i < articles.size(); i++) {
            System.out.println("\t" + (i+1) + "."+ articles.get(i).getTitle()+" [Article ID: "+articles.get(i).getArticleId()+"]");
        }
    }
}
