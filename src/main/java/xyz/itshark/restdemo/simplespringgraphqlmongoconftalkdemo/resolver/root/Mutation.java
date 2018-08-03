package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Post;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;

@RequiredArgsConstructor
public class Mutation implements GraphQLRootResolver {
	
	private final AuthorRepository authRepo;
	private final PostRepository postRepo;

	public Author addAuthor(String name) {
		return authRepo.save(new Author(null, name));
	}
	
	public Author removeAuthour(String id) {
		Author auth = authRepo.findOne(id);
		authRepo.delete(id);
		return auth;
	}
	
	public Post addPost(String title, String body, String authorId) {
		Author auth = authRepo.findOne(authorId);

		if(auth != null) {
			Post post = new Post(null,title,body);
			post.setAuthorId(authorId);
			return postRepo.save(post);
		}
		else 
			return null;
	}
}
