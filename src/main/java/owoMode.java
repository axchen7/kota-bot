import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class owoMode extends ModuleBase {

	public owoMode(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		if (command.substring(10).equals("on")||command.substring(10).equals("true"))	{    		
    		ChatRefrences.owoMode(true);
    		} else {
    		ChatRefrences.owoMode(false);
    		}
    		
		new SendMessage(event,user.getAsMention()+" Owo Mode: "+ChatRefrences.owoMode);

	}

}
