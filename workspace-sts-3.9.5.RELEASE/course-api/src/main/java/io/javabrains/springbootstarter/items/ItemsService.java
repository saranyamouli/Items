package io.javabrains.springbootstarter.items;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;


@Service
public class ItemsService {
	
	List<Item> items =  new ArrayList<>(Arrays.asList(
			new Item("101", LocalDateTime.now()),
			new Item("102", LocalDateTime.now()),
			new Item("103", LocalDateTime.now())		
			));

	public List<Item> getItems() {
		// Get Items in the last 2 seconds.

		List<Item> myList = new ArrayList<>();
	
		for (Item item : items) {
			LocalDateTime ltd = LocalDateTime.now();			
			long minutes = ChronoUnit.MINUTES.between(item.getDateTime(), ltd );
			long hours = ChronoUnit.HOURS.between(item.getDateTime(), ltd);
			long seconds =  ChronoUnit.SECONDS.between(item.getDateTime(), ltd);				
			 if(minutes == 0 && hours == 0 && seconds < 2) 
				 myList.add(item);
			 }	
		
		List<Item> sortedItems = items.stream()
				  .sorted(Comparator.comparing(Item::getDateTime).reversed())
				  .collect(Collectors.toList());
		int count = myList.size();
		int sortCount = sortedItems.size();	
	
		if(count >= sortCount) {
			return myList;
		}
		else {
			if(sortCount > 100)
			{
				return new ArrayList<Item>(sortedItems.subList(0, 99));
			}			
			return sortedItems;
		}		
		
	}

	public void addItem(Item item) {
		items.add(item);
		
	}

}
