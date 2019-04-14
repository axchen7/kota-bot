import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SendPM extends ModuleBase {
	
	String message;
	public static String msg;
	
	public SendPM(MessageReceivedEvent event, String s) {
		super(event, s);
	}
	
	public void process(String s) {
		msg=s;
		//tests for Neko mode
		if (ChatRefrences.nekoMode) {
			runNekoMode(s);
		} else
			//tests for Owo mode
			if (ChatRefrences.owoMode) {
				runOwoMode(s);
			} 
		//Respond
		{
			user.openPrivateChannel().queue((channel) ->
			      {
			            channel.sendMessage(msg).queue();
			      });
				
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
		msg=str;
	}
	
	//runs Owo Mode, converting message
	public void runOwoMode(String s) {
		String str =s;
		str=str.replace("r", "w");
		str=str.replace("l", "w");
		str=str.replace("R", "w");
		str=str.replace("L", "w");
		msg=str;
	}

}
