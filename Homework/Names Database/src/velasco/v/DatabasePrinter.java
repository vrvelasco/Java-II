package velasco.v;

import java.util.List;

public class DatabasePrinter 
{
    public void print(List<Database> people) 
    {
    	System.out.printf("%n%s %27s %29s %n%s%n", "ID", "FIRST NAME", "LAST NAME",
				  "=================== ============================== ==============================");
    	people.forEach(p
            -> System.out.printf(
                "%-20d%-31s%s %n",
                p.getId(),
                p.getFirstName(),
                p.getLastName())
        );
    	
    	System.out.println();
    }
}
