package com.maplelabs.framework.guestbook.db.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SQLReader {

	public static String generateSqlScript(String sql) {
		
		StringBuffer sqlScript = new StringBuffer();
		
		try {
			sqlScript.append(FileUtils.readFileToString(new File(sql)));
			System.out.println(sqlScript.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sqlScript.toString();
	}
}
