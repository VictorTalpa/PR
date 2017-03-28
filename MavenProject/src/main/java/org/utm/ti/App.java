package org.utm.ti;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        SummaryStatistics summaryStatistics = new SummaryStatistics();

        summaryStatistics.addValue(10);
        summaryStatistics.addValue(20);
        summaryStatistics.addValue(30);
        System.out.println("Nr. of elements: " + summaryStatistics.getN());
        System.out.println("Max number: " + summaryStatistics.getMax());
        System.out.println("Min number: " + summaryStatistics.getMin());
        System.out.println("Sum: " + summaryStatistics.getSum());
        System.out.println("Average: " + summaryStatistics.getMean());
        summaryStatistics.clear();
    }
}
