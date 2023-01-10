package Collections;

import java.util.Comparator;

public class ComparatorClass implements Comparator<Students>{
	public int compare(Students stud1, Students stud2) {
		return stud1.name.compareTo(stud2.name);
	}

}
