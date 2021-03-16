package com.artyemlavrov.lab5.readers.simple.enumerable;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.types.Position;

public class PositionReader extends EnumReader<Position> {
    public PositionReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    Position[] getEnumValues() {
        return Position.values();
    }

    @Override
    Position valueOf(String name) {
        return Position.valueOf(name);
    }
}