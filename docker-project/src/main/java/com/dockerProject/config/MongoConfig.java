package com.dockerProject.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.dockerProject")
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final transient String connectionUri;

    private final transient String databaseName;
    private final transient String username;
    private final transient byte[] password;

    @Autowired
    public MongoConfig(
            @Value("${spring.data.mongodb.uri}") final String connectionUri,
            @Value("${spring.data.mongodb.database}") final String databaseName,
            @Value("${spring.data.mongodb.username}") final String username,
            @Value("${spring.data.mongodb.password}") final byte[] password) {

        this.connectionUri = connectionUri;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {

        /*
        * List<MongoCredential> allCred = new ArrayList<MongoCredential>();
        System.out.println("???????????????????"+username+" "+database+" "+password+" "+host+" "+port);
        allCred.add(MongoCredential.createCredential(username, database, password.toCharArray()));
        MongoClient client = new MongoClient((new ServerAddress(host, Integer.parseInt(port))), allCred);
        client.setWriteConcern(WriteConcern.ACKNOWLEDGED);*/
        final ConnectionString connectionString = new ConnectionString(connectionUri);
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
