package consumer.rest.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

	@Override
	public void consummingExternalService() {
		System.out.println("** Consumming External Service **");

		String urL = "http://localhost:8080/";
		String method = "POST";
		Map<String, String> params = new HashMap<String, String>();
		params.put("Content-Type", "application/json");
		
		try {
			URL url = new URL(urL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod(method);

			for(Map.Entry<String, String> entry : params.entrySet()) {
				connection.setRequestProperty(entry.getKey(), entry.getValue());	
			}			

			String input = "{\"name\":\"Edwin Mendez\"}";
			
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : Http error code -> " + connection.getResponseCode());
			}
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String output;
			System.out.print("output from server -> " );
			
			while( (output = bufferedReader.readLine()) != null ) {
				System.out.println(output);
			}
			
			connection.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
