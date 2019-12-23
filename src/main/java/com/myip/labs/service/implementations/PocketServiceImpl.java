package com.myip.labs.service.implementations;


import com.myip.labs.dto.OperationDTO;
import com.myip.labs.dto.PocketDTO;
import com.myip.labs.entity.Pocket;
import com.myip.labs.entity.User;
import com.myip.labs.repository.PocketRepository;
import com.myip.labs.repository.UserRepository;
import com.myip.labs.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PocketServiceImpl implements PocketService {
    @Autowired
    private PocketRepository pocketRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<PocketDTO> findAll() {
        return pocketRepository.findAll()
                .stream()
                .map(pocket -> new PocketDTO(pocket.getId(), pocket.getName(),
                        pocket.getBalance(), pocket.getOperations().stream().map(operation ->
                        new OperationDTO(operation.getId(), operation.getSum(), operation.getIsplus(),
                                operation.getText(), operation.getDate())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
    @Override
    public void createPocket(PocketDTO pocket, User user){
        Pocket newAd =
                Pocket.builder()
                        .name(pocket.getName())
                        .balance(pocket.getBalance())
                        .user(user)
                        .build();
        pocketRepository.save(newAd);
    }

    @Override
    public List<PocketDTO> findAllByUser(User user) {
        return pocketRepository.findAllByUser(user)
                .stream()
                .map(pocket -> new PocketDTO(pocket.getId(), pocket.getName(), pocket.getBalance(),
                        pocket.getOperations().stream().map(operation -> new OperationDTO(
                                operation.getId(), operation.getSum(), operation.getIsplus(),
                                operation.getText(), operation.getDate()
                        )).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PocketDTO pocket, User user) {
        Pocket newEvent =
                Pocket.builder()
                        .name(pocket.getName())
                        .balance(pocket.getBalance())
                        .build();
        pocketRepository.save(newEvent);
        user.getPockets().add(newEvent);
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id, User user) {
        pocketRepository.deleteById(id);
    }
}
