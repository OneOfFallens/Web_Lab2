package beans;

import java.util.ArrayList;
import java.util.List;

public class MyBean {
    private List<TableRow> tableRows = new ArrayList<>();
    public List<TableRow> getTableRows() {
        return tableRows;
    }

    public void setTableRows(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public void addRow(TableRow row) {
        tableRows.add(row);
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "tableRows=" + tableRows +
                '}';
    }
}
