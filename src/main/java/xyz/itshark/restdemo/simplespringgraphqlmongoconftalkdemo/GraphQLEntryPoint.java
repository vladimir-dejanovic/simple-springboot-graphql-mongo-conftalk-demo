package xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo;

import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.repository.PostRepository;
import xyz.itshark.restdemo.simplespringgraphqlmongoconftalkdemo.resolver.root.Query;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {
	
	public GraphQLEntryPoint(PostRepository postRepository) {
		super(buildSchema(postRepository));
	}

	private static GraphQLSchema buildSchema(PostRepository postRepository) {
		return SchemaParser
				.newParser()
				.file("schema.graphqls")
				.resolvers(
						new Query(postRepository))
				.build()
				.makeExecutableSchema();
	}	

}
