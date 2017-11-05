package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import lombok.RequiredArgsConstructor;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.pojo.Author;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;

@RequiredArgsConstructor
public class Mutation implements GraphQLRootResolver {
	
	private final AuthorRepository authRepo;

	public Author addAuthor(String name) {
		return authRepo.save(new Author(null, name));
	}
	
	public Author removeAuthour(String id) {
		Author auth = authRepo.findOne(id);
		authRepo.delete(id);
		return auth;
	}
}
