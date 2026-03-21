package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }
//    int[][] input = {
//            {1, 2},
//            {3, 4}
//    };

    @Override
    public boolean hasNext() {
        while (row < data.length && column >= data[row].length) {
            row++;
            column = 0; // переходим к следующей строке
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++]; // берём текущий элемент и двигаем column
    }

}