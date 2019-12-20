package com.myip.labs.service.implementations;


import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.myip.labs.entity.Ad;
import com.myip.labs.entity.File;
import com.myip.labs.repository.AdRepository;
import com.myip.labs.repository.FileRepository;
import com.myip.labs.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepo;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private DbxClientV2 client;

    @Override
    public List<File> findAll() {
        return fileRepo.findAll()
                .stream()
                .map(file -> new File(file.getFileId(), file.getUrl(),file.getFilename()))
                .collect(Collectors.toList());
    }



    @Transactional
    public Optional<File> save(MultipartFile file, Integer adId) {
        Optional<Ad> ad = adRepository.findById(adId);
        try (InputStream in = file.getInputStream()) {
            if (!ad.isPresent()) {
                throw new Exception("Ивент не найден");
            }
            String path = "/" + file.getOriginalFilename();
            client.files()
                    .uploadBuilder(path)
                    .uploadAndFinish(in);
            SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings(path);
            File newFile = new File(sharedLinkMetadata.getId(), sharedLinkMetadata.getUrl(), sharedLinkMetadata.getName());
            newFile.setAd(ad.get());
            fileRepo.save(newFile);
            return Optional.of(new File(newFile.getUrl(), newFile.getFilename(), adId.toString()));
        } catch (IOException | DbxException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
