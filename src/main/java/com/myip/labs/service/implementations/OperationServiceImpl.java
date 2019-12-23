package com.myip.labs.service.implementations;

import com.myip.labs.dto.OperationDTO;
import com.myip.labs.entity.Operation;
import com.myip.labs.entity.Pocket;
import com.myip.labs.repository.OperationRepository;
import com.myip.labs.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public List<OperationDTO> findAll() {
        return operationRepository.findAll()
                .stream()
                .map(operation -> new OperationDTO(operation.getId(), operation.getSum(), operation.getIsplus(),
                        operation.getText(), operation.getDate()))
                .collect(Collectors.toList());
    }
 @Override
    public void createOperation(OperationDTO operation, Pocket pocket){
        Operation newOperation =
                Operation.builder()
                        .sum(operation.getSum())
                        .isplus(operation.getIsplus())
                        .text(operation.getText())
                        .date(operation.getDate())
                        .pocket(pocket)
                        .build();
        operationRepository.save(newOperation);
    }

    @Override
    public void delete(Integer id) {
        operationRepository.deleteById(id);
    }
    @Override
    public List<OperationDTO> findByTextContainingIgnoreCase(String text) {
        return operationRepository.findByTextContainingIgnoreCase(text)
                .stream()
                .map(operation -> new OperationDTO(operation.getId(), operation.getSum(),
                        operation.getIsplus(),  operation.getText(), operation.getDate()))
                .collect(Collectors.toList());
    }
}
