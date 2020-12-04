import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface Environment extends Config {
    //@DefaultValue("https://github.com/sergeynedaikhleb")
    @Key("url")
    String myUrl();

    //@DefaultValue("sergey.nedaikhleb@i.ua")
    @Key("login")
    String login();

    //@DefaultValue("testEnvironment")
    @Key("password")
    String password();

    //@DefaultValue("sergeynedaikhleb")
    @Key("name")
    String accountOwner();

    Environment testEnvironment = ConfigFactory.create(Environment.class);
    //Environment BASE_CONFIG = ConfigFactory.create(Environment.class, System.getenv(), System.getProperties());
}
