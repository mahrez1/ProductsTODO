/*package spring.project.product.configuration;

import com.google.auth.oauth2.GoogleCredentials;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() throws IOException {
    	FileInputStream serviceAccount =
    			new FileInputStream("/Products/src/main/resources/credentials/producttodo-cd8ff-firebase-adminsdk-ml891-65fd4895ba.json");

    			@SuppressWarnings("deprecation")
				FirebaseOptions options = new FirebaseOptions.Builder()
    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    			  .setDatabaseUrl("https://firebasestorage.googleapis.com/v0/b/producttodo-cd8ff.appspot.com/o/productUploads")
    			  .build();

    			FirebaseApp.initializeApp(options);
    }
}
*/