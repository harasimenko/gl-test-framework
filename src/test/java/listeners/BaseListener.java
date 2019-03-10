package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class BaseListener implements ITestListener {

    private static final Logger log = Logger.getLogger("logger");

    @Override
    public void onTestStart(ITestResult result) {
        log.info(String.format("Execute test '%s'", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(String.format("Test '%s' passed", result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(String.format("Test '%s' failed", result.getName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info(String.format("Test skipped '%s'", result.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info(String.format("Test failed '%s'", result.getName()));
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
