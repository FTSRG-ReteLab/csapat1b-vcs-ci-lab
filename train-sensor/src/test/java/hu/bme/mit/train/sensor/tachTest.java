package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class tachTest {
    tach tachograph;
    @Before
    public void before() {
        tachograph = new tach();
    }

    @Test
    public void isEmptyTable() {
        org.junit.Assert.assertTrue(tachograph.isEmptyTable());

    }
}