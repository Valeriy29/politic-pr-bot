package com.example.service;

import com.example.constant.Answer;
import com.example.constant.BotMessage;
import com.example.entity.ElectionsEntity;
import com.example.repository.ElectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.constant.BotMessage.*;

@Service
public class ElectionsService {

    @Autowired
    private ElectionsRepository electionsRepository;

    public String electionsInfoMessage(String region) {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR) + 1);

        List<String> regionsList = getElectionsType(region, year);

        if (regionsList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            regionsList.forEach(r -> sb.append(r).append("\n").append("\n"));
            return REGION_ELECTIONS_P1.getBotMessage() + " " + year + " " + REGION_ELECTIONS_P2.getBotMessage() + "\n" + sb.toString() + DECIDED_GO.getBotMessage();
        } else {
            return OTHER_REGION_ELECTIONS_2020.getBotMessage();
        }
    }

    private List<String> getElectionsType(String regionKeyword, String year) {
        return electionsRepository.findElectionsEntityByKeyword(regionKeyword, year)
                .stream()
                .map(ElectionsEntity::getTypeElections)
                .collect(Collectors.toList());
    }

}
