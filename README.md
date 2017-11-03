## Apache Drill Example

This project is a VERY simple demonstration of how to use [Apache Drill](https://drill.apache.org/) in local mode to read [Parquet](https://parquet.apache.org/) files, generate views from them and also read those views. The same code also works for JSON files.

There are five classes in this demo:

* *Parameters.java* : contains JDBC URL, driver and other connection parameters.
* *DrillConnection.java* : contains code for opening/closing a connection to Drill and also to get an open `Statement` instance.
* *DataPrinter.java* : receives a data source and a list of fields and prints the source content in a tabular way.
* *ViewGenerator.java* : receives a data source and a list of fields to be projected onto the view, and generates the view.
* *Driver.java* : contains the example logic, just replace the paths.

This is a simple demonstration, NONE OF THE CLASSES ARE READY TO PRODUCTION.  