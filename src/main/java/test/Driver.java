package test;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
	
		String dataSourcePath = "/tmp/workspace/DrillJDBCExample/data/part-00000-bbe23bf3-a109-4df8-a486-58f37a577388-c000.snappy.parquet";
		String viewDestinationPath = "/tmp/workspace/DrillJDBCExample/views/parquetView";
		
		DataPrinter printer = new DataPrinter();
		
		printer.print(Arrays.asList(new String[]{"*"}), dataSourcePath);
		
		ViewGenerator generator = new ViewGenerator();
		
		generator.generate(viewDestinationPath, Arrays.asList(new String[]{"page,count_views"}), dataSourcePath);
		
		printer.print(Arrays.asList(new String[]{"*"}), viewDestinationPath);
	}
}
