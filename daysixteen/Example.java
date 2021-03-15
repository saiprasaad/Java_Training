package daysixteen;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC1f50b87bb7c56d21d8df8afcecee9877";
  public static final String AUTH_TOKEN = "13e3e4aec985f8938393a7ce2befe3ca";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("8072868279"),
        new PhoneNumber("8946069629"), 
        "Hello").create();

    System.out.println(message.getSid());
  }
}
