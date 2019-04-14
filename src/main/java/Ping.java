import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Ping extends ModuleBase {

	public Ping(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
    		new SendMessage(event,user.getAsMention()+" Pong! "+event.getJDA().getPing()+" Ping");

	}

}
