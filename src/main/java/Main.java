
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {
    public static void main(String[] args) {
        JDA api = null;

        try {
            String token = ""; // TODO fix
            api = new JDABuilder(AccountType.BOT).setToken(token).build();
        } catch (LoginException e) {
            e.printStackTrace();
            System.exit(1);
        }

        api.addEventListener(new CommandHandler());
    }

}
