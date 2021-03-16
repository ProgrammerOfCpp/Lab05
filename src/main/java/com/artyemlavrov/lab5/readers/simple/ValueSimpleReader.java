package com.artyemlavrov.lab5.readers.simple;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.readers.ValueReader;

/**
 * Класс, позволяющий определить правила чтения простых значений.
 */
public abstract class ValueSimpleReader<T> extends ValueReader<T> {
    protected ValueSimpleReader(IOManager ioManager) {
        super(ioManager);
    }
}
