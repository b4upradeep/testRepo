package test.isrg.poc.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.prefs.Preferences;


public class RegistryDemo {
	
	public static final String PREF_KEY = "pradeep";
	public static void main(String[] args) {
		System.out.println(readRegistry("hkcu\\software\\google\\pradeep","key"));
	}
	
	private static void preferenceOption(){
		Preferences userPreferences = Preferences.userRoot();
		userPreferences.put(PREF_KEY, "pradeep is here");
		
		 System.out.println("Preferences = "
	                + userPreferences.get(PREF_KEY, PREF_KEY + " was not found."));
		 Preferences systemPref = Preferences.systemRoot();
	        systemPref.put(PREF_KEY, "www.javacoderanch.org");
	        System.out.println("Preferences = "
	                + systemPref.get(PREF_KEY, PREF_KEY + " was not found."));
	}
	
	public static final String readRegistry(String location, String key){
        try {
            // Run reg query, then read output with StreamReader (internal class)
            Process process = Runtime.getRuntime().exec("reg query " + 
                    '"'+ location + "\" /v " + key);

            StreamReader reader = new StreamReader(process.getInputStream());
            reader.start();
            process.waitFor();
            reader.join();
            
            String[] parsed = reader.getResult().split("\\s+");
            if (parsed.length > 1) {
                return parsed[parsed.length-1];
            }
        } catch (Exception e) {}

        return null;
    }

    static class StreamReader extends Thread {
        private InputStream is;
        private StringWriter sw= new StringWriter();

        public StreamReader(InputStream is) {
            this.is = is;
        }

        public void run() {
            try {
                int c;
                while ((c = is.read()) != -1)
                    sw.write(c);
            } catch (IOException e) { 
            }
        }

        public String getResult() {
            return sw.toString();
        }
    }

}
