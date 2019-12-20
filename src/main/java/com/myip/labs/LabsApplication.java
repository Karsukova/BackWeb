package com.myip.labs;

import com.myip.labs.repository.AdRepository;
import com.myip.labs.service.implementations.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabsApplication {
	@Autowired
	private AdServiceImpl adServiceImpl;
	private AdRepository adRepository;

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
	}




		//Ad ad = new Ad(1, "2", "2", "3", "4", 1);
		//Ad ad1 = adRepository.save(ad);
		/*EventListener(ApplicationReadyEvent.class)
		private void testJpaMethods () {
			Ad ad = new Ad();
			ad.setTelnum("Kiev");
			ad.setText("4");
			ad.setTopic("Main Street");
			ad.setPrice("5");
			ad.setUseid(1);
			ad.setId(2);

			adService.createAd(ad);

 */
			//userService.findAllByName("Smith").forEach(it-> System.out.println(it));

			//userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));

			//userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));


}
