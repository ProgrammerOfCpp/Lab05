package com.artyemlavrov.lab5.readers.simple.enumerable;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.types.Country;

public class CountryReader extends EnumReader<Country> {
    public CountryReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    Country[] getEnumValues() {
        return Country.values();
    }

    @Override
    Country valueOf(String name) {
        return Country.valueOf(name);
    }
}