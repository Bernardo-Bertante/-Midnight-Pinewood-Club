package com.midnightpinewoodclub.controller;

import com.midnightpinewoodclub.service.IInventoryService;
import com.midnightpinewoodclub.util.InputUtil;

public class InventoryController implements IInventoryController{
    private final IInventoryService inventoryService;

    public InventoryController(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @Override
    public void openInventory(int serialCode) {
        while (true) {
            System.out.println(inventoryService.showItens(serialCode));
            int response = InputUtil.readInt("[0] <--");
            if (response == 0) {
                return;
            }
        }
    }
}
