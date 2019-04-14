import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SevenSeconds extends ModuleBase {
	
	//Variables to track the non repeating number generator
	private static int randomNumCounter = 0;
	private static int max = 100;
	private static int min = 0;
	private static int[] randomNum = new int[100];
	private static boolean firstTime = true;	

	public SevenSeconds(MessageReceivedEvent event) {
		super(event, "");
	}

	//What actually runs when the command is called
	@Override
	public void process(String s) {
		randomGen();
		new SendMessage(event,user.getAsMention()+" "+response(randomNum[randomNumCounter]));
		randomNumCounter++;

	}
	
	//generates non repeating random numbers
	private static void randomGen() {
		//checks to see if it needs to be run for the first time
		if (firstTime) {
			//fills array
				for (int i=0; i<randomNum.length; i++) {
					randomNum[i]=i;
				}
				//shuffles array
				for (int i=0; i<randomNum.length; i++) {
					int rand= (int) (Math.random() * ( max - min ));
					int hold= randomNum[rand];
					randomNum[rand]=i;
					randomNum[i]=hold;
				}
				firstTime=false;
			}
		}
	
	//Possible responses for seven seconds 
	private String response(int x) {
		switch(x)
		{

		   case 0 :
			   return "Name 3 FTC Teams.";
		   
		   case 1 :
			   return "Name 3 ."; 
		   
		   default : 
		      return "Name 3 people you would date if you could.";
		}
	}

}
