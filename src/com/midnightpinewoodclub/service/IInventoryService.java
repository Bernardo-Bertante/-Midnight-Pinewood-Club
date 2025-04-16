package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Item;

import java.util.List;

public interface IInventoryService {
    void addItemToInventory(int serialCode, Item item);
    String showItens(int serialCode);
}
