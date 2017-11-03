package test;

public class Parameters {
	
    static final String JDBC_DRILL_DRIVER = "org.apache.drill.jdbc.Driver";
    static final String DRILL_QUERY_SCHEMA = "dfs";
    static final String DRILL_CREATION_SCHEMA = "dfs.tmp";
    static final String DRILLBIT_HOST = "localhost"; 
   
    static final String DRILL_DB_URL = "jdbc:drill:schema="+DRILL_QUERY_SCHEMA+";drillbit="+DRILLBIT_HOST;
}
