package com.rish.tutorial.graphql.app.graphql_utilities;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.rish.tutorial.graphql.app.dataFetchers.AllUsersDataFetcher;
import com.rish.tutorial.graphql.app.dataFetchers.ArticlesDataFetcher;
import com.rish.tutorial.graphql.app.dataFetchers.UserDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQlUtility {

	@Value("classpath:schemas.graphqls")
	private Resource schemaResource;
	private GraphQL graphQL;
	private AllUsersDataFetcher allUsersDataFetcher;
	private UserDataFetcher userDataFetcher;
	private ArticlesDataFetcher articlesDataFetcher;

	@Autowired
	public GraphQlUtility(AllUsersDataFetcher allUsersDataFetcher, UserDataFetcher userDataFetcher,
			ArticlesDataFetcher articlesDataFetcher) {
		this.allUsersDataFetcher = allUsersDataFetcher;
		this.userDataFetcher = userDataFetcher;
		this.articlesDataFetcher = articlesDataFetcher;
	}

	@PostConstruct
	public GraphQL createGraphQlObject() throws IOException {
		File schemas = schemaResource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		return GraphQL.newGraphQL(schema).build();
	}

	public RuntimeWiring buildRuntimeWiring() {

		return RuntimeWiring.newRuntimeWiring()
			.type("Query", typeWiring -> typeWiring
				.dataFetcher("users", allUsersDataFetcher)
				.dataFetcher("user", userDataFetcher))
			.type("User", typeWiring -> typeWiring
				.dataFetcher("articles", articlesDataFetcher)
				.dataFetcher("friends", allUsersDataFetcher))
			.build();
	}
}
