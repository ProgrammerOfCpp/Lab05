package com.artyemlavrov.lab5.readers.simple.number;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.readers.ValueFormatException;

public class FloatReader extends NumberReader<Float> {
    public FloatReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    Float parseValue(String argument) throws ValueFormatException {
        try {
            return Float.parseFloat(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа!");
        }
    }

    @Override
    int compareValues(Float a, Float b) {
        return a.compareTo(b);
    }
}