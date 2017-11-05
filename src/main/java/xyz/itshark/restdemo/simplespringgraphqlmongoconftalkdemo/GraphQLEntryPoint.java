package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.CommentRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql.AuthorResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql.CommentResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql.PostResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root.Mutation;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root.Query;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository, AuthorRepository authRepository, CommentRepository commentRepository) {
		super(buildSchema(postRepository,authRepository,commentRepository));
	}

	private static GraphQLSchema buildSchema(PostRepository postRepository, AuthorRepository authRepository, CommentRepository commentRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository,authRepository),
						new Mutation(authRepository),
						new PostResolver(authRepository,commentRepository),
						new AuthorResolver(postRepository),
						new CommentResolver(authRepository,postRepository))
				.build()
				.makeExecutableSchema();
	}	

}
