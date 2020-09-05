package session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Session {
	private static final String CURRENT = "session.txt";
	private static final String PERMANENT = "date_time_calculator.txt";
	private BufferedWriter perm;
	private BufferedWriter temp;

	public Session() throws IOException {
		openFiles();
	}

	public void write(String s) {
		try {
			this.perm.write(s);
			this.temp.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void closeFiles() throws IOException {
		this.perm.close();
		this.temp.close();
		new File(CURRENT).deleteOnExit();
	}

	public void openFiles() throws IOException {
		this.perm = new BufferedWriter(new FileWriter(CURRENT, true));
		this.temp = new BufferedWriter(new FileWriter(PERMANENT, true));
	}

	public ArrayList<String> getSessionsHistory(int i) throws IOException, FileNotFoundException {
		closeFiles();
		openFiles();
		BufferedReader reader = (i == 0) ? new BufferedReader(new FileReader(CURRENT))
				: new BufferedReader(new FileReader(PERMANENT));
		String s;
		ArrayList<String> res = new ArrayList<String>();
		while ((s = reader.readLine()) != null) {
			res.add(s);
		}
		return res;

	}

}
