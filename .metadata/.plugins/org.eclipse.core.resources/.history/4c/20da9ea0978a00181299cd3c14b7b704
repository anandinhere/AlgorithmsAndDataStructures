package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*** Adding certificate ****/
// keytool -import -keystore "C:/Program Files/Java/jre7/lib/security/cacerts"
// -trustcacerts -alias "uscis cert" -file
// "C:/Program Files/Java/jre7/lib/security/usciscert.cer"

public class UscisStatus extends TimerTask {
	public static void main(String[] args) {

		TimerTask fetchMail = new UscisStatus();
		// perform the task once a day at 4 a.m., starting tomorrow morning
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(fetchMail, getTomorrowMorning4am(), fONCE_PER_DAY);
		System.out.println("Oh Yes, Running Baby!");

//		 try {
//		 checkStatus();
//		 } catch (IOException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }

		/*
		 * try { // get URL content
		 * 
		 * while (true) { try {
		 * 
		 * boolean flag = checkStatus(); if (flag == true) { //
		 * System.out.println("Status Changed"); while (true) {
		 * TimeUnit.SECONDS.sleep(5); playSound(); }
		 * 
		 * } TimeUnit.MINUTES.sleep(15);
		 * 
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 * 
		 * } catch (MalformedURLException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); }
		 */

	}

	private final static long fONCE_PER_DAY = 1000 * 60 * 60 * 12;

	private final static int fONE_DAY = 1;
	private final static int fFOUR_AM = 4;
	private final static int fSEVEN_AM = 7;
	private final static int fZERO_MINUTES = 0;

	private static Date getTomorrowMorning4am() {
		Calendar tomorrow = new GregorianCalendar();
		tomorrow.add(Calendar.DATE, fONE_DAY);
		Calendar result = new GregorianCalendar(tomorrow.get(Calendar.YEAR), tomorrow.get(Calendar.MONTH),
				tomorrow.get(Calendar.DATE), fSEVEN_AM, fZERO_MINUTES);
		return result.getTime();
	}

	private static boolean checkStatus() throws MalformedURLException, IOException {
		String tempUrl = "https://egov.uscis.gov/casestatus/mycasestatus.do?appReceiptNum=";

		String[] wacs = new String[] { "YSC1890238252", "EAC1714353932" };

		HashMap<String, String> wacMap = new HashMap<String, String>();
		wacMap.put("YSC1890238252", "OPT-Raga");
		wacMap.put("EAC1714353932", "H1B-Chinnu");

		for (String wac : wacMap.keySet()) {

			URL url = new URL(tempUrl + wac);
			URLConnection conn = url.openConnection();
			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			System.out.println(sdf.format(cal.getTime()));
			boolean flag = false;
			while ((inputLine = br.readLine()) != null) {

				if (inputLine.contains("Your Current Status:")) {
					new Emailer().sendEmail(br.readLine() + "  " + wacMap.get(wac), tempUrl + wac);
				}
			}

			if (flag == true) {
				System.out.println("Status changed for " + wac);
				return true;
			}

		}
		System.out.println("\n\n\n");

		return false;
	}

	private static void playSound() throws IOException {
		System.out.println("Status Changed");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));

		// Open an audio input stream.
		File soundFile = new File("Casio-MT-600-Synth-Bells-C3.wav");
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip;

			clip = AudioSystem.getClip();

			// Open audio clip and load samples from the audio input
			// stream.

			clip.open(audioIn);
			clip.start();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			checkStatus();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}