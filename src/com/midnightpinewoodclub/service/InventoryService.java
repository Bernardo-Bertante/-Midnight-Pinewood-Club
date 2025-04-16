package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Item;

import java.util.List;

public class InventoryService implements IInventoryService{
    private final IMemberService memberService;

    public InventoryService(IMemberService memberService) {
        this.memberService = memberService;
    }

    public void addItemToInventory(int serialCode, Item item) {
        memberService.addItem(serialCode, item);
    }

    @Override
    public String showItens(int serialCode) {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════╗\n");
        sb.append("║         Member Inventory             ║\n");
        sb.append("╠══════════════════════════════════════╣\n");

        List<Item> items = memberService.getInventory(serialCode);
        if (items.isEmpty()) {
            sb.append("║   (No items in inventory yet...)     ║\n");
        } else {
            for (Item item : items) {
                sb.append(String.format("║ Name: %-28s ║\n", item.getName()));
                sb.append(String.format("║ Type: %-28s ║\n", item.getType()));
                sb.append(String.format("║ Desc: %-28s ║\n", item.getDescription()));
                sb.append("╠══════════════════════════════════════╣\n");
            }
        }

        sb.append("╚══════════════════════════════════════╝\n");
        return sb.toString();
    }



}
