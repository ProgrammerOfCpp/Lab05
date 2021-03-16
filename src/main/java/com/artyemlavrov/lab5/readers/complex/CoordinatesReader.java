package com.artyemlavrov.lab5.readers.complex;

import com.artyemlavrov.lab5.IOManager;
import com.artyemlavrov.lab5.types.Coordinates;
import com.artyemlavrov.lab5.readers.simple.number.DoubleReader;
import com.artyemlavrov.lab5.readers.simple.number.FloatReader;

public class CoordinatesReader extends ValueComplexReader<Coordinates> {
    public CoordinatesReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    protected Coordinates readFields() {
        float x = new FloatReader(ioManager).setNullable(false).read("x");
        double y = new DoubleReader(ioManager).setLowerBound(-268.0).setNullable(false).read("y");
        return new Coordinates(x, y);
    }

    @Override
    protected String getTypeName() {
        return Coordinates.class.getSimpleName();
    }
}
