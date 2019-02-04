package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.sql.Time;

public class tach {
    Table<Time, Integer, Integer> tachographTable = HashBasedTable.create();

    public void addElement(Time t, int a, int b){
        tachographTable.put(t, a, b);
    }

    public Table<Time, Integer, Integer> getTachographTable() {
        return tachographTable;
    }

    public boolean isEmptyTable(){
        if(tachographTable.isEmpty()) return true;
        return false;
    }
}
