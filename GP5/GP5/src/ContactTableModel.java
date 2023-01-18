import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ContactTableModel extends AbstractTableModel {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private int numRows;
    private int numCols;

    public ContactTableModel(Connection con) {
        connection = con;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("SELECT * FROM Contacts");
            resultSet.last();
            numRows = resultSet.getRow();
            numCols = resultSet.getMetaData().getColumnCount();
            fireTableStructureChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return numRows;
    }

    @Override
    public int getColumnCount() {
        return numCols;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(col + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        try {
            return resultSet.getMetaData().getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void update() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Contacts");
        resultSet.last();
        numRows = resultSet.getRow();
        fireTableDataChanged();
    }

    public void updateData(ResultSet rs) throws SQLException {
        resultSet = rs;
        resultSet.last();
        numRows = resultSet.getRow();
        fireTableDataChanged();
    }
}
