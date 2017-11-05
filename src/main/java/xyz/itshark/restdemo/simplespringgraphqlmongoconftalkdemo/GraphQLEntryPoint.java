package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.AuthorRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.ql.PostResolver;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root.Query;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository, AuthorRepository authRepository) {
		super(buildSchema(postRepository,authRepository));
	}

	private static GraphQLSchema buildSchema(PostRepository postRepository, AuthorRepository authRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository),
						new PostResolver(authRepository))
				.build()
				.makeExecutableSchema();
	}	

}
