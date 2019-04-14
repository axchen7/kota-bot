import java.util.Random;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class shipIt extends ModuleBase {

	public shipIt(MessageReceivedEvent event) {
		super(event, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		Random r = new Random();
		int low = 1;
		int high = 17;
		String hold="";
		int result = r.nextInt(14);
		
		String[] names = {"Ryan Ngoon", "Ryan Niemi", "Madeleine", "Emily", "Terrence", "Deborah", "Jessica", "Andrea", "Ethan", "Ellen", "Daniel", "Alex", "Tom", "Kobe","Aroshi"};
		for (int i=0;i<names.length;i++ ) {
			result = r.nextInt(14);
			hold=names[i];
			names[i]=names[result];
			names[result]=hold;
		}
		
		result = r.nextInt(high-low) + low;
		String ship="";

		switch (result) { 
		case 1: 
			ship = "I saw "+names[3]+" and "+names[4]+" holding hands the other day~ hmm~"; 
			break; 
		case 2: 
			ship = names[3]+" and "+names[4]+" sitting in a tree. And you better just be holding hands or I'm telling!"; 
			break; 
		case 3: 
			ship = names[3]+" and "+names[4]+" sitting in a tree. K I S S I-- is that the engineering notebook??"; 
			break; 
		case 4: 
			ship = "My OTP is "+names[3]+" x "+names[4]+"~ :heart:"; 
			break; 
		case 5:
			ship = "I think "+names[3]+" and "+names[4]+" look cute together...";
			break;
		case 6:
			ship = "Do you think "+names[3]+" and "+names[4]+" are dating? They totally could be.";
			break;
		case 7:
			ship = "I've been trying to get "+names[3]+" and "+names[4]+" together for a while now...";
			break;
		case 8:
			ship = names[3]+"! Just ask "+names[4]+" out already! We can all see it!";
			break;
		case 9:
			ship = names[3] + " has a crush; don't tell anyone I told you but it's " + names[4];
			break;		
		case 10:
			ship = names[3]+" totally looks great with "+names[4]+".";
			break;
		case 11:
			ship = "Shipping "+names[3]+" and "+names[4]+" so hard rn! ";
			break;
		case 12:
			ship = "I can't get enough of "+names[3]+" and "+names[4]+"! They are like so perfect for each other! ";
			break;
		case 13:
			ship = names[3]+" and "+names[4]+" should just get a room already...";
			break;
		case 14:
			ship = names[3]+" x "+names[4]+" should be a thing";
			break;
		case 15:
			ship = "Let the "+names[3]+" x "+names[4]+" ship sail!";
			break;
		case 16:
			ship = "The S.S. "+names[3]+" x "+names[4]+" sets sail for open waters!";
			break;
		default: 
			ship = "Love is... not in the air right now."; 
			break; 
		}
		new SendMessage(event,user.getAsMention()+" "+ship);

	}

}
