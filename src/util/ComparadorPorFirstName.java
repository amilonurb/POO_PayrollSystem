package util;

import java.util.Comparator;
import model.Employee;

/**
 *
 * @author 2016101533
 */
public class ComparadorPorFirstName implements Comparator<Employee>{
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getFirstName().compareToIgnoreCase(e2.getFirstName());
    }
}