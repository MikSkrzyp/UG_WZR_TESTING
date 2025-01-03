package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {



    private int count = 0;
    private static final int RETRIES= 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < RETRIES) {
                count++;
                return true;
            }
        }
        return false;
    }
}