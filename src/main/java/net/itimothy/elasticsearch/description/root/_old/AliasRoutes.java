package net.itimothy.elasticsearch.description.root._old;

import net.itimothy.rest.description.HttpMethod;
import net.itimothy.rest.description.ParamType;
import net.itimothy.rest.description.Route;
import org.elasticsearch.client.Client;
import net.itimothy.elasticsearch.description.ModelsCatalog;
import net.itimothy.elasticsearch.description.RoutesProvider;

import java.util.List;

import static java.util.Arrays.asList;

class AliasRoutes extends RoutesProvider {
    public AliasRoutes(ModelsCatalog modelsCatalog, Client client) {
        super("Alias management", client, modelsCatalog);
    }

    @Override
    public List<Route> getRoutesInternal() {
        return asList(
            Route.builder()
                .method(HttpMethod.GET)
                .apiPath("_alias")
                .model(ModelsCatalog.INDEX_ALIASES).build(),

            Route.builder()
                .method(HttpMethod.GET)
                .apiPath("_alias/{index}")
                .model(ModelsCatalog.INDEX_FEATURES)
                .parameters(
                    indexOrAliasSelectParam("index", ParamType.PATH).build()
                ).build()
        );
    }
}