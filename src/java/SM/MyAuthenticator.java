package SM;

import com.infomedia.utils.PropertyLoader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

class MyAuthenticator extends Authenticator {
  protected PasswordAuthentication getPasswordAuthentication() {
    Properties prop = PropertyLoader.load("ConstantExtern.Default.properties");
      System.out.println(new PasswordAuthentication(prop.getProperty("USER"), prop.getProperty("PASSWORD").toCharArray()));
    return new PasswordAuthentication(prop.getProperty("USER"), prop.getProperty("PASSWORD").toCharArray());
  }
}
