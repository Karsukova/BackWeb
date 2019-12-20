package com.myip.labs.service.implementations;

import com.myip.labs.dto.AdDTO;
import com.myip.labs.entity.Ad;
import com.myip.labs.repository.AdRepository;
import com.myip.labs.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private  AdRepository adRepository;

    @Override
    public List<AdDTO> findAll() {
        return adRepository.findAll()
                .stream()
                .map(ad -> new AdDTO(ad.getId(), ad.getPrice(),
                        ad.getTelnum(), ad.getText(), ad.getTopic()))
                .collect(Collectors.toList());
    }
 @Override
    public void createAd(AdDTO ad){
        Ad newAd =
                Ad.builder()
                        .price(ad.getPrice())
                        .telnum(ad.getTelnum())
                        .text(ad.getText())
                        .topic(ad.getTopic())
                        .build();
        adRepository.save(newAd);
    }

    @Override
    public void delete(Integer id) {
        adRepository.deleteById(id);
    }
    @Override
    public List<AdDTO> findByTextContainingIgnoreCase(String text) {
        return adRepository.findByTextContainingIgnoreCase(text)
                .stream()
                .map(ad -> new AdDTO(ad.getId(), ad.getPrice(), ad.getTelnum(), ad.getText(), ad.getTopic()))
                .collect(Collectors.toList());
    }
}
