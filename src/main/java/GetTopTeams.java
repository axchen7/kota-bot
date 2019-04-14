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

public class GetTopTeams extends ModuleBase {

	private static final String SCORE_URL = "https://8404pals.azurewebsites.net/api/team-info/";



	public GetTopTeams(MessageReceivedEvent event) {
		super(event, "");
	}


	@Override
	public void process(String s) {
		String response = "**Ordered Teams: (By game Average)**";
		
		JSONObject server = null;
		try {
			server = readJsonFromUrl(SCORE_URL);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
		Map<Integer, String> teams = new HashMap<>();
		Map<Integer, Double> teamScores = new HashMap<>();
		for( String i : server.keySet() ) {
			teams.put( Integer.parseInt(i), server.getString(i) );
		}

		for( int i : teams.keySet() ) {
			try {
				server = readJsonFromUrl(SCORE_URL + i + "/");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Double auton = (double) 0;
			Double tele = (double) 0;
			try {
			    auton = server.getJSONObject("performance").getJSONObject("match").getDouble("auton");
			} catch( Exception e ) {}
			try {
			    tele= server.getJSONObject("performance").getJSONObject("match").getDouble("teleOp");
			} catch( Exception e ) {}

			teamScores.put(i, auton + tele);
		}
		
		// https://stackoverflow.com/a/22132422
		Map<Integer, Double> sortedTeamScores = teamScores.entrySet().stream()
			    .sorted(Entry.comparingByValue(Collections.reverseOrder()))
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
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

}