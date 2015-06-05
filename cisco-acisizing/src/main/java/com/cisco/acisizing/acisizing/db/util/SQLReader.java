package com.cisco.acisizing.acisizing.db.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SQLReader {

	public static String generateSqlScript(String sql) {
		
		StringBuffer sqlScript = new StringBuffer();
		
		try {
			sqlScript.append("BEGIN;\n" + FileUtils.readFileToString(new File(sql)) + "\nEND;");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlScript.toString();
	}
}
