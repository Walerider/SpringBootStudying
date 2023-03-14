package Another.one.Main;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class MainApplication {

	private static final InetAddress address;//получение ip сервера(для реализации подключения телефона к серверу через код)

	static {
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		String ipaddress = address.toString().substring(address.toString().lastIndexOf('/')+1);
		System.out.println(ipaddress);
		SpringApplication.run(MainApplication.class, args);
	}
	@GetMapping("/hello")

	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}

