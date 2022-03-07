package Day4.StreamAPI.GroupBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class BlogPostDemo {
    public static void main(String[] args) {
        List<BlogPost> posts = Arrays.asList();

        // To group the blog posts in the blog post list by their type:
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));
        postsPerType.forEach((key,value)-> System.out.println("Blog type: " + key + ", Posts: "+ value));
        /*
            // To group using two fields as keys, we can use the Pair class provided in the javafx.util or org.apache.commons.lang3.tuple packages.
        Map<Pair<BlogPostType, String>, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(Collectors.groupingBy(post -> new ImmutablePair<>(post.getType(), post.getAuthor())));

            // Similarly, we can use the Tuple class defined before, this class can be easily generalized to include more fields as needed.
            // The previous example using a Tuple instance will be:
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

            // The record feature provides us with a simpler, clearer, and safer way to do groupingBy than the Tuple
        */

        // for resources : https://www.baeldung.com/java-groupingby-collector

    }
}

class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}

enum BlogPostType {
    NEWS,
    REVIEW,
    GUIDE
}

class Tuple {
    BlogPostType type;
    String author;
}
