package com.shelfy;

import com.shelfy.model.FOOD_STATUS;
import com.shelfy.model.ItemDto;
import com.shelfy.service.ItemService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AlmostEpiredFoodScheduler {
    private final ItemService itemService;

    public AlmostEpiredFoodScheduler(ItemService itemService) {
        this.itemService = itemService;
    }

    @Scheduled(fixedRate = 1L, timeUnit = TimeUnit.DAYS)
    public void findAlmostExpiredItems(){
        for(ItemDto itemDto : itemService.getItems()){
            if(itemDto.foodStatus() == FOOD_STATUS.ALMOST_EXPIRED){
                //send email
            }
        }
    }
}
