package com.artyemlavrov.lab5.readers.simple;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.readers.ValueFormatException;

import java.time.LocalDate;

public class LocalDateReader extends ValueSimpleReader<LocalDate> {
    public LocalDateReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    protected LocalDate parseNotNull(String argument) throws ValueFormatException {
        try {
            return LocalDate.parse(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Не удаётся распознать формат даты!");
        }
    }
}
