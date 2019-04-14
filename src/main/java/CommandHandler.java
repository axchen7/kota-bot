import java.util.Arrays;

import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandHandler extends ListenerAdapter{
	 public void onMessageReceived(MessageReceivedEvent evt) {
		 if (evt.getAuthor().isBot()) return;
	    			
	    	//Objects
	    	User objUser = evt.getAuthor();
	    	Message objMsg= evt.getMessage();
	    	MessageChannel objChn=evt.getChannel();

	    	
	    	//Variables
	    	String message = objMsg.getContentRaw();
	    	
	    	
	    	//screwing around
	    	if (ChatRefrences.spamDanielPhotos&&evt.getAuthor().getName().equals("Daniel.Noronha")) {
	    		
	    		objUser.openPrivateChannel().queue((channel) ->
			      {
			            channel.sendMessage("Daniel, upload your photos! D:<<").queue();
			      });
	    		
	    		//evt.getChannel().sendMessage("Daniel, upload your photos! D:<<").queue();
	    	}
	    	
	    	
	    	//Commands
	    	
	    	//Commands with a separate class
	    	//Help command: lists commands
	    	if(message.equalsIgnoreCase(Reference.prefix+"help")) {
	    		new Help(evt);
	    	}
	    	
	    	//Help command: lists commands
	    	if(message.equalsIgnoreCase(Reference.prefix+"get.fortune")) {
	    		new Fortunes(evt);
	    	}
	    	
	    	//NekoMode command: Turns on and off Neko mode
	    	if(message.startsWith(Reference.prefix+"nekomode")) {
	    		new NekoMode(evt);
	    	}
	    	
	    	//OwoMode command: Turns on and off owo mode
	    	if(message.startsWith(Reference.prefix+"owomode")) {
	    		new owoMode(evt);
	    	}
	    	
	    	//OwoMode command: Turns on and off spamDanielPhotos mode
	    	if(message.startsWith(Reference.prefix+"spamDanielPhotos")) {
	    		new spamDanielPhotos(evt);
	    	}
	    	
	    	//Ping: displays ping
	    	if(message.equalsIgnoreCase(Reference.prefix+"ping")) {
	    		new Ping(evt);
	    	}
	    	
	    	//PrintData: prints file "AttendanceDatabase"
	    	if(message.equalsIgnoreCase(Reference.prefix+"printattendance")) {
	    		new PrintAttendance(evt);
	    	}
	    	
	    	//SevenSeconds: plays a game of Seven Seconds
	    	if(message.equalsIgnoreCase(Reference.prefix+"sevenseconds")) {
	    		new SevenSeconds(evt);
	    	}
	    	
	    	//get 8ball
	    	if(message.startsWith(Reference.prefix+"8ball")) {
	    		new EightBall(evt);
	    	}
	    	
	    	//get ships
	    	if(message.startsWith(Reference.prefix+"ship")) {
	    		new shipIt(evt);
	    	}
	    	
	    	//get poop
	    	if(message.startsWith(Reference.prefix+"shit")) {
	    		new SendMessage(evt,objUser.getAsMention()+" :poop: ");
	    	}
	    	
	    	//get info about a certain team
	    	if(message.startsWith(Reference.prefix+"get.teaminfo")) {
	    		new GetTeamInfo(evt);
	    	}
	    	
	    	//get teams in order of score
	    	if(message.startsWith(Reference.prefix+"get.topteams")) {
	    		new GetTopTeams(evt);
	    	}
	    	
	    	//get teams in order of seed
	    	if(message.startsWith(Reference.prefix+"get.seedteams")) {
	    		new GetSeedTeams(evt);
	    	}
	    	
	    	//get teams in order of score and compatibility
	    	if(message.startsWith(Reference.prefix+"get.compteams")) {
	    		//new GetCompTeams(evt);
	    	}

	    	//Commands that don't have a separate class
	    	//Wassup Kota command
	    	if(message.equalsIgnoreCase("Wassup Kota")) {
	    		new SendMessage(evt,"Sup "+objUser.getAsMention());
	    	}
	    	
	    	//? command
	    	if(message.equalsIgnoreCase("?")) {
	    		new SendMessage(evt,"?");
	    	}
	    	
	    	//Pancake Kota command response
	    	if(message.contains("pancake")) {
	    		new SendMessage(evt,objUser.getAsMention()+" I like pancakes! ^-^ :pancakes: ");
	    	}
	    	
	    	//Get.scoutURL: gets scouting sheet URL
	    	if(message.equalsIgnoreCase(Reference.prefix+"get.scouturl")) {
	    		new SendMessage(evt,objUser.getAsMention()+" https://8404pals.azurewebsites.net");
	    	}

	    	
	    	//Get.rooms: gets hotel rooms
	    	if(message.equalsIgnoreCase(Reference.prefix+"get.rooms")) {
	    		new SendMessage(evt,objUser.getAsMention()+Reference.buddies);
	    	}
	    	
	    	
	    }
}
