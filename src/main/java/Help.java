import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help extends ModuleBase {

	public Help(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		new SendPM(event,"__**Commands:**__"+
				"\n**ping**: Pong!"+
				"\n**get.scoutURL**: Gets scouting sheet url."
				+ "\n**get.rooms**: Gets the current room assignments"+
				"\n**get.teamInfo (Team Number)**: Gets basic infomation on inserted team."+
				"\n**get.topTeams**: lists all teams in order from best to worst."
				+ "\n**get.seedteams**: lists all teams in order of seeds (ranking)."+
				"\n**NekoMode (on/off)**: Turns Neko mode on or off. (Automatically turns off other voice modes)"+
				"\n**OwoMode (on/off)**: Turns Owo mode on or off. (Automatically turns off other voice modes)"
				+ "\n**spamDanielPhotos (on/off)**: Turns spamming Daniel photos mode on or off."
				+ "\n**Wassup Kota**: Sup"
				+ "\n**get.fortune**: Gets a random fortune"
				+ "\n**sevenSeconds**: Plays Seven Seconds (Not yet implemented)");

	}

}
