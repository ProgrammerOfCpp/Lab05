package com.artyemlavrov.lab5.readers.simple.enumerable;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.types.Status;

public class StatusReader extends EnumReader<Status> {
    public StatusReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    Status[] getEnumValues() {
        return Status.values();
    }

    @Override
    Status valueOf(String name) {
        return Status.valueOf(name);
    }
}
