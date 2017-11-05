package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RequiredArgsConstructor
public class Query implements GraphQLRootResolver {

	private final PostRepository postRepository;
	private final AuthorRepository authRepo;

    public List<Post> allPosts() {
        return postRepository.findAll();
    }   
    
    public List<Author> allAuthors() {
    		return authRepo.findAll();
    }
}
