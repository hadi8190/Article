package org.example.repository;

import org.example.model.Article;
import org.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ArticleRepo {
    private static final String INSERT_QUERY = "insert into article(title,user_id , is_published) values (?,?,?)";
    private static final String SELECT_QUERY = "select * from article inner join researcher r on r.id = article.user_id where article.id= ? ";
    private static final String UPDATE_TITLE_QUERY = "update Article set title = ? where id = ?";
    private static final String UPDATE_IS_PUBLISHED_QUERY = "update article set is_published = ? where id = ?";
    private static final String UPDATE_CONTENT_QUERY = "update article set content = ? where id = ?";
    private static final String SELECT_ALL_NON_PUBLISHED_QUERY = "select * from article inner join researcher r on r.id = article.user_id where r.id= ? and article.is_published = 'No'";
    private static final String SELECT_ALL_PUBLISHED_QUERY = "select * from article inner join researcher r on r.id = article.user_id where r.id= ? and article.is_published = 'Yes'";

    public static void createArticle(Article article) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setInt(2,article.getResearcher().getResearcherId());
            preparedStatement.setString(3,article.getIsPublished());

            preparedStatement.execute();
            System.out.println("Your article added Successfully");

            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Article findResearcherArticle(int articleId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setInt(1, articleId);


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                String isPublished = resultSet.getString("is_published");
                return new Article(articleId,title,brief,content, isPublished);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Article> findNonPublishedArticleForOneResearcher(int researcherId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NON_PUBLISHED_QUERY);
            preparedStatement.setInt(1, researcherId);

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Article> articles = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                String isPublished = resultSet.getString("is_published");
                articles.add(new Article(id,title,brief,content, isPublished));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
            return articles;

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Article> findPublishedArticleForOneResearcher(int researcherId) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PUBLISHED_QUERY);
            preparedStatement.setInt(1, researcherId);

            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Article> articles = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String brief = resultSet.getString("brief");
                String content = resultSet.getString("content");
                String isPublished = resultSet.getString("is_published");
                articles.add(new Article(id,title,brief,content, isPublished));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
            return articles;

        } catch (
                SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void updateArticleTitle(Article article, String newTitle){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TITLE_QUERY);
            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, article.getArticleId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void updateArticleContent(Article article, String newContent){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTENT_QUERY);
            preparedStatement.setString(1, newContent);
            preparedStatement.setInt(2, article.getArticleId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateArticlePublishStatus(Article article, int publishStatus){
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_IS_PUBLISHED_QUERY);

            if(publishStatus == 1)
                preparedStatement.setString(1, "Yes");
            else if (publishStatus == 2)
                preparedStatement.setString(1, "No");

            preparedStatement.setInt(2, article.getArticleId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }}
