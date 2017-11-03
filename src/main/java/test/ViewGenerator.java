package test;

import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * For illustration only, DO NOT USE IN PRODUCTION.
 */
public class ViewGenerator {
		
	public final boolean generate(String viewPath, List<String> projectionFields, String sourcePath) {
	
		StringBuilder query = new StringBuilder("CREATE VIEW ");
		query.append(Parameters.DRILL_CREATION_SCHEMA)
		.append(".`").append(viewPath).append("` ")
		.append("AS SELECT ").append(StringUtils.join(projectionFields, ","))
		.append(" FROM ").append(Parameters.DRILL_QUERY_SCHEMA).append(".`")
		.append(sourcePath).append("`");
		
		try (Statement stmt = DrillConnection.getStatementForDefaultConnection()) {
			stmt.executeUpdate(query.toString());
			System.out.println("Created view: "+query.toString());
			return true;
		}
		catch(Exception e) {
			System.err.println("Could not create view: "+query.toString());
			e.printStackTrace();
			return false;
		}
	}
}
