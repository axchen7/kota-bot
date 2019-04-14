import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GetSeedTeams extends ModuleBase {

	private static final String BASE_URL = "https://8404pals.azurewebsites.net/api/match-results/";
	private static final String SCORE_URL = "https://8404pals.azurewebsites.net/api/team-info/";

	public GetSeedTeams(MessageReceivedEvent event) {
		super(event, "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(String s) {
		// TODO Auto-generated method stub

		String response = "**Ordered Teams: (By Seed)**";
		//server for team info
		JSONObject server = null;
		try {
			server = readJsonFromUrl(SCORE_URL);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		//server for match info
		JSONObject server2 = null;
		try {
			server2 = readJsonFromUrl(BASE_URL);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		//2 hashmaps; 1 for team number and names, other for team number and score
		Map<Integer, String> teams = new HashMap<>();
		Map<Integer, Double> teamScores = new HashMap<>();
		for( String i : server.keySet() ) {
			teams.put( Integer.parseInt(i), server.getString(i) );
		}

		//sets everyone's score to 0
		/*
		for( int i : teams.keySet()) {
			teamScores.put(i, 0.0);

		}
		 */

		for( String i : server2.keySet()) {
			for( String j : server2.getJSONObject(i).keySet() ) {
				teamScores.put(Integer.parseInt(j), 0.0);
			}
		}


		double blueScore=0;
		double redScore=0;
		String winner="";
		int errorsFound=0;

		for( String i : server2.keySet() ) {

			//reset placeholder variables
			blueScore=0;
			redScore=0;
			winner="";
			

			//First check who won
			for( String j : server2.getJSONObject(i).keySet() ) {
				if (server2.getJSONObject(i).getJSONObject(j).getString("alliance").equals("red")) {
					redScore += calcScore(server2, i, j);
				} else if (server2.getJSONObject(i).getJSONObject(j).getString("alliance").equals("blue")){
					blueScore += calcScore(server2, i, j);
				} else {
					System.out.println("Big oof, no alliance found: "+server2.getJSONObject(i).getJSONObject(j).getString("alliance"));
					errorsFound++;
				}

			}

			if (blueScore == redScore) {
				winner= "tie";
			}
			if (blueScore > redScore) {
				winner= "blue";
			}
			if (blueScore < redScore) {
				winner= "red";
			}

			//put in scores for teams (wins count as 2,000,000 points)
			for( String j : server2.getJSONObject(i).keySet() ) {
				if (server2.getJSONObject(i).getJSONObject(j).getString("alliance").equals("tie")) {
					teamScores.put(Integer.parseInt(j), teamScores.get(Integer.parseInt(j))+redScore+1000000);
				}
				if (server2.getJSONObject(i).getJSONObject(j).getString("alliance").equals(winner)) {
					if (winner.equals("red"))
						teamScores.put(Integer.parseInt(j), teamScores.get(Integer.parseInt(j))+blueScore+2000000);
					if (winner.equals("blue"))
						//teamScores.put(Integer.parseInt(j), teamScores.get(Integer.parseInt(j))+redScore+2000000);
					teamScores.put(Integer.parseInt(j), teamScores.get(Integer.parseInt(j))+calcScore(server2, i, j)+2000000);
				} else {
					if (winner.equals("red"))
						teamScores.put(Integer.parseInt(j), teamScores.get(Integer.parseInt(j))+blueScore);
					if (winner.equals("blue"))
						teamScores.put(Integer.parseInt(j), teamScores.get(Integer.parseInt(j))+redScore);
				}

			}
		}

		// https://stackoverflow.com/a/22132422
		Map<Integer, Double> sortedTeamScores = teamScores.entrySet().stream()
				.sorted(Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		response += "\n*Number of Discrepencies Found: "+errorsFound+"*\n------------------------";
		
		for( int i : sortedTeamScores.keySet() ) {
			response += "\n" + teams.get(i) + " " + i;
		}		

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
	private static double calcScore(JSONObject server2, String i, String j) {
		boolean land=false;
		boolean sample=false;
		boolean doubleSample=false;
		boolean marker=false;
		boolean park=true;
		double lander=0;
		double depot=0;
		String hang="nope";

		land =server2.getJSONObject(i).getJSONObject(j).getBoolean("auton_land");
		sample= server2.getJSONObject(i).getJSONObject(j).getBoolean("auton_sample");
		doubleSample= server2.getJSONObject(i).getJSONObject(j).getBoolean("auton_double_sample");
		marker= server2.getJSONObject(i).getJSONObject(j).getBoolean("auton_marker");
		park= server2.getJSONObject(i).getJSONObject(j).getBoolean("auton_park");
		lander=server2.getJSONObject(i).getJSONObject(j).getDouble("teleop_minerals_lander");
		depot=server2.getJSONObject(i).getJSONObject(j).getDouble("teleop_minerals_depot");
		hang=server2.getJSONObject(i).getJSONObject(j).getString("teleop_endgame");

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
		return score;

	}

}
