package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> posts = new ArrayList<Post>();

//        Post post1 = new Post();
//        post1.setTitle("Post 1");
//        post1.setBody("Post Body 1");
//        post1.setDate(new Date());
//
//        Post post2 = new Post();
//        post2.setTitle("Post 2");
//        post2.setBody("Post Body 2");
//        post2.setDate(new Date());
//
//        posts.add(post1);
//        posts.add(post2);
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","himanshu");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return posts;

    }

    public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();

//        Post post1 = new Post();
//        post1.setTitle("This is your Post");
//        post1.setBody("--- It has some valid content ---");
//        post1.setDate(new Date());
//        posts.add(post1);
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","himanshu");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id = 3");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return posts;

    }
    public void createPost (Post newPost){
    }
}
