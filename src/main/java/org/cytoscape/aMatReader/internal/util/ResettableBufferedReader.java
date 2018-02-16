package org.cytoscape.aMatReader.internal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class ResettableBufferedReader extends BufferedReader {
	public Vector<String> readLines = new Vector<String>();
	int index = 0;

	public ResettableBufferedReader(InputStream is) {
		super(new InputStreamReader(is));

	}

	public void reset() {
		index = 0;
	}

	@Override
	public String readLine() throws IOException {
		String line;
		if (index < readLines.size()) {
			line = readLines.get(index);
		} else {
			line = super.readLine();
			readLines.add(line);
		}
		index++;
		return line;
	}

}
