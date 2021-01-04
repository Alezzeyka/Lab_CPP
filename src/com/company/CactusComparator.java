package com.company;

import com.company.entity.Cactus;

import java.util.Comparator;

public class CactusComparator implements Comparator<Cactus> {
    public int compare(Cactus a, Cactus b)
    {
        if (a.get_QuillLength()>b.get_QuillLength())
            return 1;
        else if (a.get_QuillLength()<b.get_QuillLength())
            return -1;
        else
            return 0;
    }
}