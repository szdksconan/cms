package com.cms.service.userCenter.util;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public final class StringTokenizer2 extends Object implements Enumeration,
		Iterator {
	/**
	 * Create tokenizer with property <code>returnTokens</code> set to
	 * <code>false</code> and property <code>ignoreCase</code> set to
	 * <code>false</code>. Blank delimiter results in the entire text as a
	 * single token.
	 * 
	 * @param text
	 *            string to be parsed (must not be null)
	 * @param delimiter
	 *            to be be used to tokenize text (must not be null)
	 *  
	 */
	public StringTokenizer2(String text, String delimiter) {
		this(text, delimiter, false);
	}

	/**
	 * Create tokenizer with option for property <code>returnTokens</code> and
	 * property <code>ignoreCase</code> set to <code>false</code>. Blank
	 * delimiter results in the entire text as a single token.
	 * 
	 * @param text
	 *            string to be parsed (must not be null)
	 * @param delimiter
	 *            to be be used to tokenize text (must not be null)
	 * @param returnTokens
	 *            mimics <code>java.util.StringTokenizer</code> in that when
	 *            <code>true</code> delimiters are returned as tokens
	 */
	public StringTokenizer2(String text, String delimiter, boolean returnTokens) {
		this(text, delimiter, returnTokens, false);
	}

	/**
	 * Create tokenizer with options for properties <code>returnTokens</code>
	 * and <code>ignoreCase</code>. Blank delimiter results in the entire
	 * text as a single token.
	 * 
	 * @param text
	 *            string to be parsed (must not be null)
	 * @param delimiter
	 *            to be be used to tokenize text (must not be null)
	 * @param returnTokens
	 *            mimics <code>java.util.StringTokenizer</code> in that when
	 *            <code>true</code> delimiters are returned as tokens
	 * @param ignoreCase
	 *            delimiters not case sensitive when <code>true</code>
	 */
	public StringTokenizer2(String text, String delimiter,
			boolean returnTokens, boolean ignoreCase) {
		super();
		this.text = text;
		this.delimiter = delimiter;
		this.returnDelimiterTokens = returnTokens;
		parse(ignoreCase);
	}

	/**
	 * 
	 *  
	 */
	private void parse(boolean ignoreCase) {
		String matchText = null;
		String matchDelim = null;

		if (ignoreCase) {
			matchText = text.toUpperCase();
			matchDelim = delimiter.toUpperCase();
		} else {
			matchText = text;
			matchDelim = delimiter;
		}

		int startIndex = 0;
		int endIndex = matchText.indexOf(matchDelim, startIndex);
		while (endIndex != -1) {
			String token = text.substring(startIndex, endIndex);
			parsedTokens.add(token);
			if (returnDelimiterTokens)
				parsedTokens.add(delimiter);
			startIndex = endIndex + delimiter.length();
			endIndex = matchText.indexOf(matchDelim, startIndex);
		}

		parsedTokens.add(text.substring(startIndex));
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.hasNext()"
	 */
	public boolean hasNext() {
		return hasMoreTokens();
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.next()"
	 */
	public Object next() {
		return nextToken();
	}

	/**
	 * Feature not supported
	 *  
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.hasMoreTokens()"
	 */
	public boolean hasMoreTokens() {
		return tokenIndex < parsedTokens.size();
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.hasMoreElements()"
	 */
	public boolean hasMoreElements() {
		return hasMoreTokens();
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.countTokens()"
	 */
	public int countTokens() {
		return parsedTokens.size();
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.nextToken()"
	 */
	public String nextToken() {
		return (String) parsedTokens.get(tokenIndex++);
	}

	/**
	 * 
	 * @see "java.util.StringTokenizer.nextElement()"
	 */
	public Object nextElement() {
		return nextToken();
	}

	////////////////////////////////////////////////////////////////////////////////
	// Static utility methods
	////////////////////////////////////////////////////////////////////////////////

	/**
	 * Performs a classic string find and replace
	 * 
	 * @param str
	 *            original string to be modified
	 * @param findValue
	 *            text to be replaced throughout string (must not be null)
	 * @param replaceValue
	 *            text to replace found tokens (must not be null)
	 * @return modified string
	 */
	public static String replace(String str, String findValue,
			String replaceValue) {
		StringTokenizer2 tok = new StringTokenizer2(str, findValue, false);

		String result = "";
		for (int i = 0; i < tok.countTokens() - 1; i++)
			result += tok.nextToken() + replaceValue;
		result += tok.nextToken();

		return result;
	}

	/**
	 * Performs a classic string find & replace, optionally ignoring the case of
	 * the string
	 * 
	 * @param str
	 *            original string to be modified
	 * @param findValue
	 *            search text to be replaced throughout string (must not be
	 *            null)
	 * @param replaceValue
	 *            text to replace found tokens (must not be null)
	 * @param ignoreCase
	 *            search text case insensitive when <code>true</code>
	 * @return modified string
	 */
	public static String replace(String str, String findValue,
			String replaceValue, boolean ignoreCase) {
		StringTokenizer2 tok = new StringTokenizer2(str, findValue, false,
				ignoreCase);

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < tok.countTokens() - 1; i++)
			result.append(tok.nextToken()).append(replaceValue);
		result.append(tok.nextToken());

		return result.toString();
	}

	/**
	 * Shortcut to {@link #tokenize(String,String,boolean,boolean) generalized
	 * search method} with property <code>trim</code> set to <code>false
	 * </code>
	 * and property <code>ignoreCase</code> set to <code>false
	 * </code>
	 */
	public static String[] tokenize(String str, String findValue) {
		return tokenize(str, findValue, false);
	}

	/**
	 * Shortcut to {@link #tokenize(String,String,boolean,boolean) generalized
	 * search method} with property <code>ignoreCase</code> set to <code>false
	 * </code>
	 *  
	 */
	public static String[] tokenize(String str, String findValue, boolean trim) {
		return tokenize(str, findValue, trim, false);
	}

	/**
	 * Utility method to create array of string tokens with optional support for
	 * trimming results and ignoring case when searching.
	 * 
	 * @param str
	 *            text to be searched (must not be null)
	 * @param findValue
	 *            search string (must not be null)
	 * @param trim
	 *            flag indicating that resulting tokens should be trimmed
	 * @param ignoreCase
	 *            flag indicating that search should be case insensitive
	 * @return array of string tokens resulting from search
	 *  
	 */
	public static String[] tokenize(String str, String findValue, boolean trim,
			boolean ignoreCase) {
		StringTokenizer2 tok = new StringTokenizer2(str, findValue, false,
				ignoreCase);

		List result = new LinkedList();
		for (int i = 0; i < tok.countTokens(); i++) {
			if (trim)
				result.add(((String) tok.nextToken()).trim());
			else
				result.add(((String) tok.nextToken()));
		}

		return (String[]) result.toArray(new String[result.size()]);
	}

	/**
	 * Utility method to breakup larger string into array of strings, one string
	 * per line.
	 *  
	 */
	public static String[] tokenizeLines(String string) {
		StringTokenizer tok = new StringTokenizer(string, "\n\r", true);

		List result = new LinkedList();
		String previousToken = null;
		while (tok.hasMoreTokens()) {
			String token = tok.nextToken();
			if (token.equals("\r"))
				; //Discard
			else if (token.equals("\n")) {
				if (previousToken != null)
					result.add(previousToken);
				else
					result.add(""); // Add a blank line

				previousToken = null;
			} else
				previousToken = token;
		}

		// Make sure we get the last line, even if it didn't end
		// with a carriage return
		if (previousToken != null)
			result.add(previousToken);

		return (String[]) result.toArray(new String[result.size()]);
	}
	
    public static List split(String strSource, String strToken) {
        List v = new ArrayList();
        StringTokenizer st = new StringTokenizer(strSource, strToken);
        while (st.hasMoreTokens()) {
            v.add(st.nextToken());
        }
        return v;
    }

	////////////////////////////////////////////////////////////////////////////////
	// Instance variables
	////////////////////////////////////////////////////////////////////////////////

	private String text;

	private String delimiter;

	private boolean returnDelimiterTokens = false;

	private List parsedTokens = new ArrayList();

	private int tokenIndex = 0;

	
}