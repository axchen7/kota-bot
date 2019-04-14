import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.entities.*;

public abstract class ModuleBase {
	//Info needed later on
	String command;
	MessageReceivedEvent event;
	MessageChannel channel;
	User user;
	Member member;
	Guild guild;
	
	//Constructor gets all info	
	public ModuleBase(MessageReceivedEvent event, String s) {
		this.command = event.getMessage().getContentRaw();
		this.event= event;
		this.channel = event.getChannel();
		this.user = event.getAuthor();
		this.member = event.getMember();
		this.guild = event.getGuild();
		process(s);
	}

	public abstract void process(String s);

}
