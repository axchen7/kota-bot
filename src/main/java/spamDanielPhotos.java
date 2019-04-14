import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class spamDanielPhotos extends ModuleBase {
	public spamDanielPhotos(MessageReceivedEvent event) {
		super(event, "");
	}


	@Override
	public void process(String s) {
		if (command.substring(19).equals("on")||command.substring(19).equals("true"))	{    		
    		ChatRefrences.spamDanielPhotos(true);
    		} else {
    		ChatRefrences.spamDanielPhotos(false);
    		}
    		
		new SendMessage(event,user.getAsMention()+" Spam Daniel Photos Mode: "+ChatRefrences.spamDanielPhotos);

	}

}
