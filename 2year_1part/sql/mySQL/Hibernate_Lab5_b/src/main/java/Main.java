import com.ione.project.AvtosalonEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ione.project.*;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Scanner;


public class Main {

    private static SessionFactory ourSessionFactory;
    static {
        try { // Create the SessionFactory from hibernate.cfg.xml
            ourSessionFactory =  new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { throw new ExceptionInInitializerError(ex); }
    }
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession(); //return opened session
    }
    //---------------------------------------------------------------------------
    public static void main(final String[] args) throws Exception {
        // get opened session
        Session session = getSession();
        try {

            ReadAllTable(session);

//            ReadBookOfPerson(session);

//              ReadCityFilter(session);

//            ReadCityTable(session);
//            insertCity(session);
//            ReadCityTable(session);

//            insertPerson(session);

//            ReadCityFilter(session);

//            AddBookForPerson(session);
//            ReadAllTable(session);

//            ReadCityTable(session);
//            updateCity(session);
//            ReadAllTable(session);

//            ReadBookOfPerson(session);
//            AddPairPersonBookWithProcedure(session);
//            ReadBookOfPerson(session);

            System.out.println("Finish work!");
        } finally { session.close(); System.exit(0); }
    }

    private static void ReadAllTable(Session session){
        Query query = session.createQuery("from " + "AvtosalonEntity ");
        System.out.format("\nTable Avtosalon --------------------\n");
        System.out.format("%3s %-12s %s\n", "ID", "Name", "OwnerName");
        for (Object obj : query.list()) {
            AvtosalonEntity person = (AvtosalonEntity) obj;
            System.out.format("%3d %-12s  %s\n", person.getIdAvtosalon(),
                    person.getName(), person.getOwnerName());
        }

        query = session.createQuery("from " + "CarsEntity ");
        System.out.format("\nTable Cars --------------------\n");
        System.out.format("%3s %-18s  %s\n", "ID", "Sellers name", "IDAvtosalon");
        for (Object obj : query.list()) {
            CarsEntity cars = (CarsEntity) obj;
            System.out.format("%3d %-18s  %s\n", cars.getIdCars(), cars.getSeler(), cars.getAvtosalonIdAvtosalon());
        }

        query = session.createQuery("from " + "CarDetailEntity ");
        System.out.format("\nTable Car Details --------------------\n");
        System.out.format("%3s %-10s %-12s  %s\n", "ID", "Class", "Max Distance","Max Speed","Model");
        for (Object obj : query.list()) {
            CarDetailEntity detail = (CarDetailEntity) obj;
            System.out.format("%3s %-10s %-14s %s\n", detail.getIdCarDetail(),detail.getClazz(),detail.getMaxDistanc(),detail.getMaxSpeed(),detail.getModel());
        }

        query = session.createQuery("from " + "CarDetailHasCars1Entity ");
        System.out.format("\nConnection Table Car and Details --------------------\n");
        System.out.format("%3s   %s\n", "ID Detail", "ID Car");
        for (Object obj : query.list()) {
            CarDetailHasCars1Entity detail = (CarDetailHasCars1Entity) obj;
            System.out.format("%3s  %s\n", detail.getCarDetailIdCarDetail(),detail.getCarsIdCars());
        }

    }

//    private static void ReadCityFilter(Session session){
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Input name city for Person: ");
//        String city_in = input.next();
//
//        AvtosalonEntity avtosalon = (AvtosalonEntity) session.load( AvtosalonEntity.class, city_in);
//        if(avtosalon!=null){
//            System.out.format("\n%s: %s\n", city_in, "Surname");
//            for (CarsEntity obj : avtosalon.getName())
//                System.out.format("    %s\n", obj.getAvtosalonIdAvtosalon());
//        }
//        else System.out.println("invalid name of city");
//    }
//
//    private static void ReadBookOfPerson(Session session){
//        Query query = session.createQuery("from " + "PersonEntity");
//        System.out.format("\nTable Person --------------------\n");
//        System.out.format("%3s %-12s %-12s \n","ID", "Surname", "Name");
//        for (Object obj : query.list()) {
//            PersonEntity person = (PersonEntity) obj;
//            System.out.format("%3s %-12s %-12s->\n", person.getIdPerson(), person.getSurname(), person.getName());
//            for (BookEntity booky : person.getBooks()) {
//                System.out.format("\t\t%s // %s\n", booky.getBookName(),  booky.getAuthor());
//            }
//        }
//    }
//
//    private static void ReadCityTable(Session session){
//
//        Query query = session.createQuery("from " + "CityEntity");
//        System.out.format("\nTable City --------------------\n");
//        for (Object obj : query.list()) {
//            CityEntity city = (CityEntity) obj;
//            System.out.format("%s\n", city.getCity());
//        }
//    }
//
//    private static void insertCity(Session session){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Input a new name city: ");
//        String newcity = input.next();
//
//        session.beginTransaction();
//        CityEntity cityEntity=new CityEntity(newcity);
//        session.save(cityEntity);
//        session.getTransaction().commit();
//
//        System.out.println("end insert city");
//    }
//
//    private static void insertPerson(Session session){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Input new Person Surname: ");
//        String surname_new = input.next();
//        System.out.println("Input new Person Surname: ");
//        String name_new = input.next();
//        System.out.println("Input the City for Person: ");
//        String city = input.next();
//        System.out.println("Input new Person Email: ");
//        String email = input.next();
//
//        session.beginTransaction();
//        PersonEntity personEntity=new PersonEntity(surname_new,name_new,city,email);
//        session.save(personEntity);
//        session.getTransaction().commit();
//        System.out.println("end insert person");
//    }
//
//    private static void updateCity(Session session){
//        Scanner input = new Scanner(System.in);
//        System.out.println("\nInput a name city: ");
//        String city = input.next();
//        System.out.println("Input new name city: ");
//        String newCity = input.next();
//
//        CityEntity cityEntity = (CityEntity) session.load( CityEntity.class, city);
//        if(cityEntity!=null){
//            session.beginTransaction();
//            Query query = session.createQuery("update CityEntity set city=:code1  where city = :code2");
//            query.setParameter("code1", newCity);
//            query.setParameter("code2", city);
//            int result = query.executeUpdate();
//            session.getTransaction().commit();
//            System.out.println("end update city: "+ result);
//        }
//        else System.out.println("There is no the city");
//    }
//
//    private static void AddBookForPerson(Session session){
//        System.out.println("Give a book to person--------------");
//        Scanner input = new Scanner(System.in);
//        System.out.println("Choose Person Surname:");
//        String surname_in = input.next();
//        System.out.println("Choose Name Book:");
//        String book_in = input.next();
//
//        Query query = session.createQuery("from " + "PersonEntity where surname = :code");
//        query.setParameter("code", surname_in);
//
//        if(!query.list().isEmpty()){
//            //Give this person entity from query
//            PersonEntity personEntity = (PersonEntity)query.list().get(0);
//            //search the book entity  from query
//            query = session.createQuery("from " + "BookEntity where bookName = :code");
//            query.setParameter("code", book_in);
//            if(!query.list().isEmpty()){
//                //Give this book entity from query
//                BookEntity bookEntity = (BookEntity)query.list().get(0);
//                session.beginTransaction();
//                personEntity.addBookEntity(bookEntity);
//                session.save(personEntity);
//                session.getTransaction().commit();
//                System.out.println("end insert boor for person");
//            }
//            else {System.out.println("There is no the book");}
//        }
//        else {System.out.println("There is no this person");}
//
//    }
//
//    private static void AddPairPersonBookWithProcedure(Session session){
//        Scanner input = new Scanner(System.in);
//        System.out.println("\nInput Surname for Person: ");
//        String surname = input.next();
//        System.out.println("Input NameBook for Book: ");
//        String book = input.next();
//
//        //to JPA 2.0
////        Query query = session.createSQLQuery(
////                "CALL InsertPersonBook(:Person, :Book)")
////                .setParameter("Person", surname)
////                .setParameter("Book", book);
////        System.out.println(query.list().get(0));
//
//        //from JPA 2.1
//        StoredProcedureQuery query = session
//                .createStoredProcedureQuery("InsertPersonBook")
//                .registerStoredProcedureParameter("SurmanePersonIn", String.class, ParameterMode.IN)
//                .registerStoredProcedureParameter("BookNameIN", String.class, ParameterMode.IN)
//                .setParameter("SurmanePersonIn", surname)
//                .setParameter("BookNameIN", book);
//        query.execute();
//        String str = (String) query.getResultList().get(0);
//        System.out.println(str);
//
//        if(str.equals("OK")) {
//            Query query2 = session.createQuery("from " + "PersonEntity");
//            for (Object obj : query2.list()) {
//                session.refresh(obj);
//            }
//            query2 = session.createQuery("from " + "BookEntity ");
//            for (Object obj : query2.list()) {
//                session.refresh(obj);
//            }
//        }
//    }

}