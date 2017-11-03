package test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * For illustration only, DO NOT USE IN PRODUCTION.
 */
public class DataPrinter {

	public final void print(List<String> fields, String dataSourcePath) {
		
		String query = this.createQuery(fields, dataSourcePath);
		System.out.println("Executing query: "+query);
		
		try (Statement stmt = DrillConnection.getStatementForDefaultConnection();
			 ResultSet rs = stmt.executeQuery(query)) {
		
			int numColumns = rs.getMetaData().getColumnCount();
			
			for (int i = 1 ; i <= numColumns ; i++) {
				System.out.print(rs.getMetaData().getColumnLabel(i).toUpperCase() + "\t");
			}
			System.out.println();
			
			while (rs.next()) {
				for (int i = 1 ; i <= numColumns ; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private final String createQuery(List<String> fields, String dataSourcePath) {
		
		return new StringBuilder("SELECT ")
				.append(StringUtils.join(fields, ","))
				.append(" FROM ")
				.append(Parameters.DRILL_QUERY_SCHEMA)
				.append(".`")
				.append(dataSourcePath)
				.append("`")
				.toString();
	}
}
