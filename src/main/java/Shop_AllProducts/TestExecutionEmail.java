package Shop_AllProducts;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestExecutionEmail {

	public static WebDriver driver;
	String MyEmail = "faizan.mamji@arpatech.com";
	String MyPassword = "Faizan10";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TestExecutionEmail(WebDriver driver) {
		TestExecutionEmail.driver = driver;
	}

	public void EmailFunction() {
		try {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(".\\test-output\\emailable-report.html");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Test Report Logs");
			attachment.setName("Report.html");

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(MyEmail, MyPassword));
			email.setSSLOnConnect(true);
			email.setFrom(MyEmail, "Faizan Mamji");
			email.addCc("faizanmamji1@gmail.com");
			email.setSubject("Report Logs");
			email.setMsg("Please find attached logs!");
			email.addTo(MyEmail, "Faizan Mamji");

			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
		}

		catch (Exception ex) {

			ex.getMessage();
			Assert.fail("Email failed to send");
		}
	}

}
