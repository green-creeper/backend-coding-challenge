package com.engagetech;

import com.engagetech.expensemanager.core.ExpenseDAO;
import com.engagetech.resource.ExpenseResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class ExpenseService extends Application<ServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExpenseService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/webapp/", "/", "index.html"));
        bootstrap.addBundle(new AssetsBundle("/webapp/js", "/js", null, "js"));
        bootstrap.addBundle(new AssetsBundle("/webapp/css", "/css", null, "css"));
        bootstrap.addBundle(new AssetsBundle("/webapp/fonts", "/fonts", null, "fonts"));

        bootstrap.addBundle(new MigrationsBundle<ServiceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        //environment.jersey().setUrlPattern("/api/*");
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgres");
        final ExpenseDAO dao = jdbi.onDemand(ExpenseDAO.class);
        environment.jersey().register(new ExpenseResource(dao));
    }
}
