import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GetTeamInfo extends ModuleBase {

	private static final String BASEURL = "https://8404pals.azurewebsites.net/api/team-info/";
	private static final String SCORE_URL = "https://8404pals.azurewebsites.net/api/match-results/";

	public GetTeamInfo(MessageReceivedEvent event) {
		super(event, "");
	}

	@Override
	public void process(String s) {
		String teamNum = command.substring(15);
		String response = "Team: " + teamNum;
		JSONObject server = null;

		try {
			server = readJsonFromUrl(BASEURL + teamNum + "/");
		} catch (JSONException e) {
			channel.sendMessage("An error has occured! -_-\n Team number not in database!").queue();
			e.printStackTrace();
		} catch (IOException e) {
			channel.sendMessage("An error has occured! -_-\n Team number not in database!").queue();
			e.printStackTrace();
		}

		response += "/" + server.getJSONObject("generalInfo").getString("teamName");
		// "Team: 8404/Quixilver"
		response += "\n"+"https://8404pals.azurewebsites.net/team-info/" + teamNum+"/";
		// "https://8404pals.azurewebsites.net/team-info/[teamNumber]/"

		//Pre Game Average
		Double preTotal = (double) -1;
		try {
			preTotal = server.getJSONObject("performance").getJSONObject("preGame").getDouble("auton") + server.getJSONObject("performance").getJSONObject("preGame").getDouble("teleOp");
		} catch( Exception e ) {}
		response += "\nPREGAME: " + preTotal;

		//Post Game Average
		Double realTot = (double) -1;
		try {
			realTot = server.getJSONObject("performance").getJSONObject("match").getDouble("auton") + server.getJSONObject("performance").getJSONObject("match").getDouble("teleOp");
		} catch( Exception e ) {}		
		response += "\nMATCH: " + realTot;


		JSONObject server2 = null;
		try {
			server2 = readJsonFromUrl(SCORE_URL+ teamNum + "/");
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		boolean land=false;
		boolean sample=false;
		boolean doubleSample=false;
		boolean marker=false;
		boolean park=true;
		double lander=0;
		double depot=0;
		String hang="nope";
		String match="-1";

		for( String i : server2.keySet() ) {
			if(server2.getJSONObject(i).getDouble("teleop_minerals_lander")==0 && server2.getJSONObject(i).getBoolean("auton_land") && server2.getJSONObject(i).getBoolean("auton_sample") && server2.getJSONObject(i).getString("teleop_endgame").equals("nope")) {
			} else {
				if (Integer.parseInt(match)<Integer.parseInt(i)) {
					land =server2.getJSONObject(i).getBoolean("auton_land");
					sample= server2.getJSONObject(i).getBoolean("auton_sample");
					doubleSample= server2.getJSONObject(i).getBoolean("auton_double_sample");
					marker= server2.getJSONObject(i).getBoolean("auton_marker");
					park= server2.getJSONObject(i).getBoolean("auton_park");
					lander=server2.getJSONObject(i).getDouble("teleop_minerals_lander");
					depot=server2.getJSONObject(i).getDouble("teleop_minerals_depot");
					hang=server2.getJSONObject(i).getString("teleop_endgame");
					match=i;
				}
			}
		}

		double score=0;
		if (land) {
			score+=30;
		}
		if (doubleSample) {
			score+=50;
		} else if (sample) {
			score+=25;
		}
		if (marker) {
			score+=10;
		}
		if (park) {
			score+=10;
		}
		if (hang.equals("hang")) {
			score+=50;
		}
		if (hang.equals("partial")) {
			score+=15;
		}
		if (hang.equals("full")) {
			score+=25;
		}
		score+=depot*2+lander*5;

		response += "\n-----------------------------------------";
		response += "\n**Last Match Score: "+score+"**";
		response += "\n(Match Number " + match+")";
		response += "\nLand: " + land;
		response += "\nSample: " + sample;
		response += "\nDouble Sample: " + doubleSample;
		response += "\nMarker: " + marker;
		response += "\nPark: " + park;
		response += "\nMinerals in Lander: " + lander;
		response += "\nMinerals in Depot: " + depot;
		response += "\nEnd Game: " + hang;


		//Notes
		//response += "/nNOTES:" + server.getJSONObject("generalInfo").getString("notes");
		// "Team: 8404/Quixilver"

		channel.sendMessage(response).queue();
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

}
