import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SendMessage extends ModuleBase {
	
	String message;
	
	public SendMessage(MessageReceivedEvent event, String s) {
		super(event, s);
	}
	
	public void process(String s) {
		
		//tests for Neko mode
		if (ChatRefrences.nekoMode) {
			runNekoMode(s);
		} else
			//tests for Owo mode
			if (ChatRefrences.owoMode) {
				runOwoMode(s);
			} else //default response
		{
			channel.sendMessage(s).queue();
		}

	}
	
	//runs Neko Mode on message, converting it
	public void runNekoMode(String s) {
		String str =s;
		str=str.replace("na", "nya");
		str=str.replace("Na", "Nya");
		str=str.replace("NA", "NYA");
		str=str.replace("nA", "nYA");
		str=str+" -nya!";
		channel.sendMessage(str).queue();
	}
	
	//runs Owo Mode, converting message
	public void runOwoMode(String s) {
		String str =s;
		str=str.replace("r", "w");
		str=str.replace("l", "w");
		str=str.replace("R", "w");
		str=str.replace("L", "w");
		channel.sendMessage(str).queue();
	}

}
