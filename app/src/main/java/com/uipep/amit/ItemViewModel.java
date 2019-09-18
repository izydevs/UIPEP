package com.uipep.amit;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private MutableLiveData<List<Item>> myData;
    private ItemRepository repository;
    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
//        myData = repository.getAllItem(); i have create item repository but i have add data in view model
    }

    public MutableLiveData<List<Item>> getAllItems() {
        if (myData==null){
            myData = new MutableLiveData<>();
            getItems();
        }
        return myData;
    }

    private String fruitName[] = {"apple","guava","pine apple","grape","banana","mango","orange"};
    private void getItems() {
        List<Item> items = new ArrayList<>();
         for (int i=0;i<fruitName.length;i++){
             Item item = new Item();
             item.setId(i+1);
            item.setName(fruitName[i]);
            items.add(item);
        }
        myData.postValue(items);

    }
}
