package api.extentions;

import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Slf4j
public class TestLoggingListener implements ITestListener{

    private ByteArrayOutputStream responce = new ByteArrayOutputStream();
    private ByteArrayOutputStream request = new ByteArrayOutputStream();

    private PrintStream requestP = new PrintStream(request, true);
    private PrintStream responceP = new PrintStream(responce, true);

    public void onStart(ITestContext iTestContext) {
        RestAssured.filters
                (new ResponseLoggingFilter(LogDetail.ALL, responceP),
                        new RequestLoggingFilter(LogDetail.ALL, requestP));
    }

    public void onFinish(ITestContext iTestContext) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logRequest(request);
        logRequest(responce);
    }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Attachment(value = "request")
    public byte[] logRequest(ByteArrayOutputStream stream){
        return attach(stream);
    }

    @Attachment(value = "responce")
    public byte[] logResponce(ByteArrayOutputStream stream){
        return attach(stream);
    }

    public byte[] attach(ByteArrayOutputStream log){
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }

    public void onTestStart(ITestResult iTestResult){
    }

    public void onTestFinish(ITestResult context){
    }
}