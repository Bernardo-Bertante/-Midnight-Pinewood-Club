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
        sb.append("╔═════════════════════════════════════════════════════════════════════╗\n");
        sb.append("║                         Member Inventory                            ║\n");
        sb.append("╚═════════════════════════════════════════════════════════════════════╝\n");

        List<Item> items = memberService.getInventory(serialCode);
        if (items.isEmpty()) {
            sb.append("║   (No items in inventory yet...)     ║\n");
        } else {
            for (Item item : items) {
                sb.append("╔═════════════════════════════════════════════════════════════════════╗\n");
                sb.append(String.format("║ %-67s ║\n", formatText(item.getName(), 67)));
                sb.append("╠═════════════════════════════════════════════════════════════════════╣\n");
                sb.append(String.format("║ %-67s ║\n", formatText(item.getType().name(), 67)));
                sb.append(String.format("║ You will get: %-53s ║\n", formatText(item.getDescription(), 53)));
                sb.append("╚═════════════════════════════════════════════════════════════════════╝\n");
            }
        }
        return sb.toString();
    }

    private String formatText(String text, int length) {
        if (text.length() > length) {
            return text.substring(0, length - 3) + "...";
        } else {
            return String.format("%-" + length + "s", text);
        }
    }



}
