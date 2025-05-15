package com.example.toodoolist;

import java.util.ArrayList;


import java.util.ArrayList;
import java.util.List;

public class ManageItem {
    private final List<String> items = new ArrayList<>();

    public void addTask(String task) {
        items.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public void editTask(int index, String newTask) {
        if (index >= 0 && index < items.size()) {
            items.set(index, newTask);
        }
    }

    public List<String> getTasks() {
        return new ArrayList<>(items); // Renvoie une copie
    }
}


