package org.apache.pig.pigunit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class CoverageReportFactory {
    private static volatile BufferedWriter cReport = null;
    public static BufferedWriter getTraceFileStream() throws IOException {
        if (cReport == null) {
            synchronized(CoverageReportFactory.class) {
                if (cReport == null) {
                    cReport = new BufferedWriter(
                            new FileWriter("Pigsty-coverage.xml") );

                    cReport.write("<coverage>\n");


                    Runtime.getRuntime().addShutdownHook(
                            new Thread() {
                                public void run() {
                                    try {
                                        cReport.write("</coverage>\n");
                                        cReport.flush();
                                        cReport.close();
                                        cReport = null;
                                    } catch (IOException e) {
                                        System.err.println("Failed to close coverage..");
                                    }
                                }

                            }
                    );

                }
            }
        }
        return cReport;
    }
}


