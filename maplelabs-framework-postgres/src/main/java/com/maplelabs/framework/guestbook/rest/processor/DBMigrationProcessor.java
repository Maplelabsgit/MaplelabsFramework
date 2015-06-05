package com.maplelabs.framework.guestbook.rest.processor;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import org.springframework.stereotype.Component;

import com.maplelabs.framework.guestbook.configuration.PropertyLoader;
import com.maplelabs.framework.guestbook.constants.GuestBookConstants;
import com.maplelabs.framework.guestbook.db.util.DBConnectionUtil;
import com.maplelabs.framework.guestbook.db.util.SQLReader;

@Component("dbMigrationProcessor")
public class DBMigrationProcessor extends RestProcessor<String> {
	
	private String headVersion;

	@Override
	protected void preProcess() {
		headVersion = GuestBookConstants.APP_SQL_DIR + PropertyLoader.loadproperties(GuestBookConstants.DB_UPGRADE_FILE).getProperty("head");
	}
	
	@Override
	protected void doProcess() {
		
		DBConnectionUtil dbConnUtil = new DBConnectionUtil();
		Connection conn = dbConnUtil.openConnection();
		
		if(conn != null) {
			try {
				Statement st = conn.createStatement();
				
				st.executeUpdate(SQLReader.generateSqlScript(headVersion));
				
				st.executeUpdate("COMMIT;");
				
				result = "success";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				result = "failure";
			}
		}
			
			
	}

}
