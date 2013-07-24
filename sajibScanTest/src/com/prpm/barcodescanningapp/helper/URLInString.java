package com.prpm.barcodescanningapp.helper;

import java.net.URL;
import java.net.MalformedURLException;

// Replaces URLs with html hrefs codes
public class URLInString {

	// URL
	String address;

	public boolean isURLInString(String s) {
		// separate input by spaces ( URLs don't have spaces )
		String[] parts = s.split("\\s");

		// Attempt to convert each item into an URL.
		for (String item : parts)
			try {
				URL url = new URL(item);
				// If possible then replace with anchor...
				// System.out.print("<a href=\"" + url + "\">" + url + "</a> ");

				this.address = url.toString();

				return true;
			} catch (MalformedURLException e) {
				// If there was an URL that was not it!...
				System.out.print(item + " ");
			}

		return false;
	}

	public String getAddress() {
		return address;
	}

}