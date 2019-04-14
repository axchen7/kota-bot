import java.util.Random;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Fortunes extends ModuleBase {

	public Fortunes(MessageReceivedEvent event) {
		super(event,"");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		Random r = new Random();
		int low = 1;
		int high = 102;
		int result = r.nextInt(high-low) + low;
		String fortune="";
		
		switch (result) { 
        case 1: 
            fortune = "If you eat something and nobody sees you eat it, it has no calories"; 
            break; 
        case 2: 
            fortune = "Don't look behind you..."; 
            break;
        case 3: 
            fortune = "You will marry a professional athelete.... if competitive eating can be considered a professional sport.";
            break;
        case 4: 
            fortune = "You will go on a date with a beautiful lady... she can do better."; 
            break;
        case 5: 
            fortune = "You will soon eat something... italian."; 
            break;
        case 6: 
            fortune = "I can not help you, for I am just a bot."; 
            break;
        case 7: 
            fortune = "You do not have to be faster than the bear. Just be faster than the slowest guy running from it."; 
            break;
        case 8: 
            fortune = "Behind every fat person is a beautiful person standing behind them. No seriously, get out of the way, you're blocking the view."; 
            break;
        case 9: 
            fortune = "You are not illeterate."; 
            break;
        case 10: 
            fortune = "Enjoy yourself while you can."; 
            break;
        case 11: 
            fortune = "I hope you have health insurance."; 
            break;
        case 12: 
            fortune = "I see money in your future... It's not yours though."; 
            break;
        case 13: 
            fortune = "You and Kevin will be happy together."; 
            break;
        case 14: 
            fortune = "Look up."; 
            break;
        case 15: 
            fortune = "If you think I'm going to sum up your life in one blurb, your crazy."; 
            break;
        case 16: 
            fortune = "Hell hath no fury like a women's scorn-Sherlock Holmes"; 
            break;
        case 17: 
            fortune = "Three can keep a secret, if you can get rid of two."; 
            break;
        case 18: 
            fortune = "It's only immoral if someone is alive to judge you."; 
            break;
        case 19: 
            fortune = "The person sitting next to you just farted."; 
            break;
        case 20: 
            fortune = "It's only illegal if someone catches you."; 
            break;
        case 21: 
            fortune = "FoRtUnE"; 
            break;
        case 22: 
            fortune = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"; 
            break;
        case 23: 
            fortune = "Never gonna give you up, never gonna let you down."; 
            break;
        case 24: 
            fortune = "People die when they are killed."; 
            break;
        case 25: 
            fortune = "If you think no one cares if you are alive, try missing a couple of car payments."; 
            break;
        case 26: 
            fortune = "I see UC De Anza in your future."; 
            break;
        case 27: 
            fortune = "Very cute and handsome and smart and... oh wait, I'm suppossed to give you your fortune not talk about myself."; 
            break;
        case 28: 
            fortune = "Catch on fire with Enthusiasm and people will come from miles around to watch you burn."; 
            break;
        case 29: 
            fortune = "You laugh now, wait till you get home."; 
            break;
        case 30: 
            fortune = "Your pet is planning to eat you."; 
            break;
        case 31: 
            fortune = "Pigeon poop burns the retina for 13 hours. You will learn this the hard way."; 
            break;
        case 32: 
            fortune = "You are about to finish reading a fortune."; 
            break;
        case 33: 
            fortune = "Life is a series of choices. Make better ones."; 
            break;
        case 34: 
            fortune = "Comfort zones are most often expanded through discomfort."; 
            break;
        case 35: 
            fortune = "Fortune not Found: Abort, Retry, Ignore?"; 
            break;
        case 36: 
            fortune = "Get your head out of your butt. This way life won't be so crappy."; 
            break;
        case 37: 
            fortune = "Be careful when walking alone in the dark."; 
            break;
        case 38: 
            fortune = "Blessed are the children for they shall inherit national debt."; 
            break;
        case 39: 
            fortune = "Tommorrow, wait 10 seconds before you step outside."; 
            break;
        case 40: 
            fortune = "Wear a blue bow today and good luck will come your way."; 
            break;
        case 41: 
            fortune = "Hot ramen isn't the only thing that can burn your insides.";
            break;
        case 42: 
            fortune = "If you are not on break, get back to work."; 
            break;
        case 43: 
            fortune = "Be gracious and professional and good fortune will come."; 
            break;
        case 44: 
            fortune = "Put more faith into your friends, they might trust you more this way."; 
            break;
        case 45: 
            fortune = "You shoulder too much work. Try to relax sometimes."; 
            break;
        case 46: 
            fortune = "You could be updating the engineering notebook right now. But instead, you choose to play with me instead. Good job."; 
            break;
        case 47: 
            fortune = "You are one in a million."; 
            break;
        case 48: 
            fortune = "You're sports team will win this year."; 
            break;
        case 49: 
            fortune = "An interesting medical opportunity is in your future."; 
            break;
        case 50: 
            fortune = "Life is a gift, don't waste it."; 
            break;
        case 51: 
            fortune = "Life is a gift, and in your case, maybe an accident."; 
            break;
        case 52: 
            fortune = "Join DUO code."; 
            break;
        case 53: 
            fortune = "Rules are meant to broken... Like Buildings!.. and People! OwO"; 
            break;
        case 54: 
            fortune = "The sun is shining! You should too!"; 
            break;
        case 55: 
            fortune = "To win you have to make a move."; 
            break;
        case 56: 
            fortune = "Life is like a sandwich! Birth as one slice, and death as the other. What you put in-between the slices is up to you."; 
            break;
        case 57: 
            fortune = "Don't listen to loud music while vacuming. I vacummed 3 rooms before realizing the vacuum wasn't on."; 
            break;
        case 58: 
            fortune = "Honesty. Respect. Responsibility."; 
            break;
        case 59: 
            fortune = "Be like a duck. Waddling and working your ass off underwater, but showing a calm face on the surface."; 
            break;
        case 60: 
            fortune = "Drinking can cause memory loss, or even worse, memory loss."; 
            break;
        case 61: 
            fortune = "Be a caterpillar. Eat alot. Sleep alot. Wake up beautiful."; 
            break;
        case 62: 
            fortune = "Drinking can cause memory loss, or even worse, memory loss."; 
            break;
        case 63: 
            fortune = "If you do not where your children are, turn off the internet and watch them magically appear."; 
            break;
        case 64: 
            fortune = "If there is no flashlight on your phone, take a picture of the sun and use it in the dark instead."; 
            break;
        case 65: 
            fortune = "Good glasses help you see well. Otherwise, you might fall into one."; 
            break;
        case 66: 
            fortune = "If you swim with a friend your odds of being eaten by a shark drop by 50%"; 
            break;
        case 67: 
            fortune = "Put coconut oil in the pan when cooking Kale. It makes scraping it into the trash easier."; 
            break;
        case 68: 
            fortune = "Don't let go of your spouse's hand at the mall, because they will start shopping. It might look romantic but its actually economic."; 
            break;
        case 69: 
            fortune = "If your dog blinks at you, blink back. It could be code."; 
            break;
        case 70: 
            fortune = "Marry Someone Who Has a Different Favorite Cereal than You So They Won't Eat All of Yours"; 
            break;
        case 71: 
            fortune = "For $1, you can buy a candy bar from a vending machine. For $2, you can buy a brick, and get all the candy in the vending machine."; 
            break;
        case 72: 
            fortune = "Dance like no one is watching. Because they're not. They're checking their phones."; 
            break;
        case 73: 
            fortune = "You Know You're Ugly when You Get Handed the Camera Every Time They Make a Group Photo."; 
            break;
        case 74: 
            fortune = "If You Cut the Tennis Balls in Half, You Can Fit 6 in a Container"; 
            break;
        case 75: 
            fortune = "You Can Inflate the the Word Count on Your Essays by Writing the the Word \"The\" Twice"; 
            break;
        case 76: 
            fortune = "Don't give up on dreams. Keep sleeping."; 
            break;
        case 77: 
            fortune = "Don't lick the bowl. Flush it like a normal person."; 
            break;
        case 78: 
            fortune = "Don't yell at your kids. Lean in and whisper, it's much scarier."; 
            break;
        case 79: 
            fortune = "No cop. No Stop"; 
            break;
        case 80: 
            fortune = "Don't Half-Ass Two Things, Whole-Ass One Thing"; 
            break;
        case 81: 
            fortune = "Be a Smart Feller, Not a Fart Smeller"; 
            break;
        case 82: 
            fortune = "Do NOT Read the Next Sentence.\n" + 
            		"You little rebel. I like you."; 
            break;
        case 83: 
            fortune = "Never Joke with a Kleptomaniac, They Will Take It, Literally."; 
            break;
        case 84: 
            fortune = "If You're Drinking to Forget, Pay in Advance"; 
            break;
        case 85: 
            fortune = "Study, Sleep, Socialize. Pick Two."; 
            break;
        case 86: 
            fortune = "When nothing goes right, go left."; 
            break;
        case 87: 
            fortune = "Don't Sweat the Petty Things and Don't Pet the Sweaty Things"; 
            break;
        case 88: 
            fortune = "Never run from an overweight cop, he's more likely to shoot than chase you"; 
            break;
        case 89: 
            fortune = "Only Trust People with Big Butts. They cannot lie."; 
            break;
        case 90: 
            fortune = "In case of fire, exit the building BEFORE tweeting about it"; 
            break;
        case 91: 
            fortune = "Don't make snow angels in a dog park"; 
            break;
        case 92: 
            fortune = "In a barbershop with two barbers, choose the barber with the worst haircut"; 
            break;
        case 93: 
            fortune = "If you don't want someone to ask you to do something again, do it terribly the first time"; 
            break;
        case 94: 
            fortune = "If you are not happy where you are, move. You're not a tree."; 
            break;
        case 95: 
            fortune = "The one who cries the hardest wins the argument."; 
            break;
        case 96: 
            fortune = "Don't use your favorite song as your alarm. You'll start to hate it."; 
            break;
        case 97: 
            fortune = "If you are running low on laundry, a bathing suit makes perfectly acceptable underwear."; 
            break;
        case 98: 
            fortune = "Do not think of yourself as an ugly person. Think of yourself as a beautiful monkey."; 
            break;
        case 99: 
            fortune = "The early bird gets the worm, but the second mouse gets the cheese."; 
            break;
        case 100: 
            fortune = "When you need to borrow money, borrow from a pessimist. He won't expect it back."; 
            break;
        case 101: 
            fortune = "You'll get everything you want in life if you lower your expectations."; 
            break;
        default: 
            fortune = "Your fortune is unclear right now, please try again"; 
            break; 
            
        } 
		new SendMessage(event,user.getAsMention()+" "+fortune);
	}

}
