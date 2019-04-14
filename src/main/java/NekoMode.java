import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class NekoMode extends ModuleBase {
	public NekoMode(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		if (command.substring(11).equals("on")||command.substring(11).equals("true"))	{    		
    		ChatRefrences.nekoMode(true);
    		} else {
    		ChatRefrences.nekoMode(false);
    		}
    		
		new SendMessage(event,user.getAsMention()+" Neko Mode: "+ChatRefrences.nekoMode);

	}

}
