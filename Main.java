import java . sql .*;
import java.util.Scanner;


// used https://www.javatpoint.com/example-to-connect-to-the-mysql-database
public class Main{
    public static void main ( String [] args ) {
        try (
                // Step 1: Allocate a database 'Connection' object

                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/PoiseM?useSSL=false", "lencoe", "#0724716711El");
                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement();
        ) {
            //give user options to choose from
            System.out.println("**********  choice what your want to do from the below list  ***********");
            System.out.println("1. Create a new project");
            System.out.println("2. Change the due date of the project");
            System.out.println("3. Change the total amount of  fee paid");
            System.out.println("4. Update contractors contact details");
            System.out.println("5. View incomplete projects");
            System.out.println("6. View completed projects");
            System.out.println("7. Finalise Project");
            System.out.println("0. exit");
            //create Scanner object
            Scanner input = new Scanner(System.in);
            // create object choice to take user options
            String choice = input.nextLine();
            int choice_Int = Integer.parseInt(choice);


            double totalFee = 0.0;
            double amountPaid = 0.0;


            //as along as option not zero do this
            while (choice_Int != 0) {

                //if choice is one allow user create a project
                if (choice_Int == 1) {

                    int projectNumber = 0;
                    while(true) {
                        try {
                            System.out.print("Enter Project Number\n");
                            projectNumber = input.nextInt();
                            input.nextLine();//clear buffer after taking the inputs before taking the strings
                            break;
                        } catch (Exception e) {
                            System.out.println("format not correct try again");
                            input.next();
                        }
                      }

                    System.out.println("Enter Project Name");
                    String projectName = input.nextLine();
                    System.out.println("Enter type of Building");
                    String buildingType = input.nextLine();
                    System.out.println("Enter address of Project");
                    String projectAddress = input.nextLine();


                    while(true) {
                        try {
                            System.out.println("Enter total Fee");
                            totalFee = input.nextDouble();
                            break;
                        } catch (Exception e) {
                            System.out.println("format not correct!!! please try again");
                            input.next();

                        }
                    }

                    while(true) {
                        try {
                            System.out.println("Enter total Amount Paid To Date");
                            amountPaid = input.nextDouble();
                            input.nextLine();//clear buffer after taking the inputs before taking the strings
                            break;
                        } catch (Exception e) {
                            System.out.println("Please enter correct format");
                            input.next();
                        }
                    }

                    System.out.println("Enter due date of the project");
                    String deadline = input.nextLine();
                    String projectStatus= "No";

                    //System.out.println("\nNew project has been created!");


                    System.out.println("Enter Architect Name");
                    String architectureName = input.nextLine();
                    System.out.println("Enter Architect Surname");
                    String architectureSurname = input.nextLine();
                    int architectureNumber = 0;

                    while(true){
                        try{
                            System.out.println("Enter Architect phone number");
                            architectureNumber = input.nextInt();
                            input.nextLine();//clear buffer after taking the inputs before taking the strings
                            break;
                        }catch (Exception e) {
                            System.out.println("format not correct try again");
                            input.next();
                        }
                    }

                    System.out.println("Enter Architect Email");
                    String architectureEmailAddress = (input.nextLine());
                    System.out.println("Enter Architect address");
                    String architecturePhysicalAddress = input.nextLine();

                    System.out.println("Enter Contractor Name");
                    String contractorName = input.nextLine();
                    System.out.println("Enter Contractor Surname");
                    String contractorSurname = input.nextLine();
                    int contractorNumber = 0;

                    while(true) {
                        try {
                            System.out.println("Enter Contractor phone number");
                            contractorNumber = input.nextInt();
                            input.nextLine();//clear buffer after taking the inputs before taking the strings
                            break;
                        } catch (Exception e) {
                            System.out.println("format not correct try again !!");
                            input.next();
                        }
                    }

                    System.out.println("Enter Contractor Email");
                    String contractorEmailAddress = input.nextLine();
                    System.out.println("Enter Contractor address");
                    String contractorPhysicalAddress = input.nextLine();



                    System.out.println("Enter Customer Name");
                    String customerName = input.nextLine();
                    System.out.println("Enter Customer Surname");
                    String customerSurname = input.nextLine();
                    int customerNumber = 0;
                    while(true){
                        try{
                            System.out.println("Enter Customer number");
                            customerNumber = input.nextInt();
                            input.nextLine();//clear buffer after taking the inputs before taking the strings
                            break;
                        }catch (Exception e) {
                            System.out.println("incorrect format try again !!! ");
                            input.next();
                        }
                    }

                    System.out.println("Enter Customer Email");
                    String customerEmailAddress = input.nextLine();
                    System.out.println("Enter Customer address");
                    String customerPhysicalAddress = input.nextLine();
                    if(projectName == "")
                    {
                        projectName = buildingType + " " + customerSurname;
                    }



                    //insert into table project
                    String sqlInsert = "insert into Project (projectNumber,projectName,buildingType,projectAddress,totalFee,amountPaid,deadline,projectStatus) values ("+" "+projectNumber+",'"+projectName+"','"+ buildingType+"','"+projectAddress+"',"+totalFee+","+amountPaid+",'"+deadline+"','"+projectStatus+"')";
                    int countInserted = stmt.executeUpdate(sqlInsert);
                    System.out.println ( countInserted + "" );

                    //insert into table Architect
                    String architectInsert = "insert into Architect(architectureName,architectureSurname,architectureNumber,architectureEmailAddress,architecturePhysicalAddress) values ("+" '"+architectureName+"', "+" '"+architectureSurname+"',  "+" "+ architectureNumber+",  "+" '"+architectureEmailAddress+"',  "+ " '"+architecturePhysicalAddress+"')";
                    int countArchitect = stmt.executeUpdate(architectInsert);
                    System.out.println (countArchitect + "" );

                    //insert into table Contractor
                    String contractorInsert = "insert into Contractor(contractorName,contractorSurname,contractorNumber,contractorEmailAddress,contractorPhysicalAddress) values ("+" '"+ contractorName+"', "+" '"+contractorSurname+"',  "+" "+ contractorNumber+",  "+" '"+contractorEmailAddress+"',"+ " '"+contractorPhysicalAddress+"')";
                    int contractorInserted = stmt.executeUpdate(contractorInsert);
                    System.out.println (contractorInserted  + "" );

                    //insert into table  Customer
                    String customerInsert = "insert into Customer(customerName,customerSurname,customerNumber,customerEmailAddress,customerPhysicalAddress) values ("+" '"+customerName+"', "+" '"+customerSurname+"',  "+" "+customerNumber+",  "+" '"+customerEmailAddress+"',"+ " '"+customerPhysicalAddress+"')";
                    int customerInserted = stmt.executeUpdate(customerInsert);
                    System.out.println (customerInserted  + "" );

                }

                // option 2 to edit the deadline for the project
                if(choice_Int == 2){

                    int update_number = 0;

                    while(true)

                     try{

                         System.out.println("Enter project number you want to edit");
                         update_number = input.nextInt();
                         input.nextLine();//clear the scanner after taking the number
                         System.out.println("Enter new Date");
                         String update_date = input.nextLine();

                         String sqlUpdate = "update Project set deadline = '"
                                 + update_date+
                                 "'where  projectNumber = " + update_number + " ";

                         int countUpdated = stmt.executeUpdate (sqlUpdate );
                         System.out.println ( countUpdated + " record changed" );
                         System.out.println ( countUpdated + " date sucesfully changed !!" );

                         break;

                     }catch(Exception e) {
                         System.out.println("wrong format");

                     }

                }

                //option 3 if want to edit the amount paid
                if(choice_Int == 3){

                    int update_number = 0;

                    while(true)

                        try{

                            System.out.println("Enter project number you want to edit");
                            update_number = input.nextInt();
                            input.nextLine();//clear the scanner after taking the number
                            System.out.println("new  amount  paid");
                            String update_amountPaid= input.nextLine();

                            String sqlUpdate = "update Project set amountPaid = "
                                    + update_amountPaid+
                                    " where  projectNumber = " + update_number + " ";

                            int countUpdated = stmt.executeUpdate (sqlUpdate );
                            System.out.println ( countUpdated + " record changed" );
                            System.out.println ( countUpdated + " date sucesfully changed !!" );

                            break;

                        }catch(Exception e) {
                            System.out.println("wrong format");

                        }

                }

                // option 4 to edit the contract details of the contractor
                if(choice_Int == 4){

                    int c = 0;

                    while(true)

                        try{

                            System.out.println("Enter contractor name you want to edit");
                            String update_name = input.nextLine();
                            System.out.println("enter new Telephone Numbers");
                            int update_contractorNumber = input.nextInt();

                            String sqlUpdate = "update Contractor set contractorNumber = "
                                    + update_contractorNumber+
                                    " where  contractorName = '" + update_name + "' ";

                            int countUpdated = stmt.executeUpdate (sqlUpdate );
                            System.out.println ( countUpdated + " record changed" );
                            System.out.println ( countUpdated + " date sucesfully changed !!" );

                            c =1;

                           //
                            break;

                        }catch(Exception e) {
                            System.out.println("wrong format");

                        }
                }

                //option 5 to view all the incomplete projects
                if(choice_Int == 5){


                    int x = 0;
                    while(true)

                        try{


                            String status = "No";
                            String sqlSelect  = "select *  from  Project  where projectStatus = '" +status +"'";

                           ResultSet rs = stmt.executeQuery(sqlSelect);

                           while (rs.next()){

                               int projectNumber = rs.getInt(2);
                               String projectName = rs.getString(3);
                               String  buildingType  =  rs.getString(4);
                               String  projectAddress  = rs.getString(5);
                               double  totalFeeS = rs.getDouble(6);
                               double  amountPaidS =rs.getDouble(7);
                               String  deadline = rs.getString(8);
                               String projectStatus =   rs.getString(9);

                               System.out.println("L i s t   o f   I n c o m p l e t e !!\n");
                               System.out.println("[projectNumber :"+projectNumber+"]  [projectName :"+projectName+"]  [buildingType :"+ buildingType+"]  [projectAddress :"+projectAddress+"]  [totalFeeS :"+totalFeeS+"]  [amountPaidS :"+amountPaidS+"]  [deadline :"+deadline+"]  [projectStatus :"+projectStatus+"]");

                           }

                             x = 1;
                            break;

                        }catch(Exception e) {
                            System.out.println("wrong format");

                        }
                }

                //view all the completed projects
                if(choice_Int == 6){

                    int x = 0;
                    while(true)

                        try{

                            String status = "Yes";
                            String sqlSelect  = "select *  from  Project  where projectStatus = '" +status +"'";

                            ResultSet rs = stmt.executeQuery(sqlSelect);

                            while (rs.next()){

                                int projectNumber = rs.getInt(2);
                                String projectName = rs.getString(3);
                                String  buildingType  =  rs.getString(4);
                                String  projectAddress  = rs.getString(5);
                                double  totalFeeS = rs.getDouble(6);
                                double  amountPaidS =rs.getDouble(7);
                                String  deadline = rs.getString(8);
                                String projectStatus =   rs.getString(9);

                                System.out.println("L i s t   o f   C o m p l e t e   P r o j e c t s !!\n");
                                System.out.println("[projectNumber :"+projectNumber+"]  [projectName :"+projectName+"]  [buildingType :"+ buildingType+"]  [projectAddress :"+projectAddress+"]  [totalFeeS :"+totalFeeS+"]  [amountPaidS :"+amountPaidS+"]  [deadline :"+deadline+"]  [projectStatus :"+projectStatus+"]\n");

                            }

                            x = 1;
                            break;

                        }catch(Exception e) {
                            System.out.println("wrong format");
                        }
                }

                // finalize project and print out an invoice
                if(choice_Int == 7) {

                    int x = 0;
                    while (true)

                        try {

                            System.out.println("Enter project Name");
                            String finalize = input.nextLine();
                            String projectStatus = "Yes";

                            String sqlUpdate = "update Project set projectStatus = '"
                                    + projectStatus+
                                    "'where  projectName = '" + finalize + "' ";

                            int countUpdated = stmt.executeUpdate (sqlUpdate );
                            System.out.println ( countUpdated + " record updated" );


                            x = 1;
                            break;


                        }catch(Exception e) {
                            System.out.println("error");

                        }


                    double total = 0.0;

                    while(true)

                        try{


                            System.out.println("What was the total amount ???");
                            total = input.nextDouble();

                            System.out.println("What was the amount  amountPaid ???");
                            double paid= input.nextDouble();
                            double amount = (total-paid);

                            if(amount == 0.0){

                                System.out.println("Customer has paid in full");
                            }

                            if(amount > 0.0){

                                System.out.println("Customer has an outstanding balance of R"+amount+"");
                            }

                            if(amount < 0.0){

                                System.out.println("Campany  owes the Customer R"+amount+" ");
                            }


                            break;


                        }catch (Exception e){

                            System.out.println("wrong format");

                        }


                }

                //give user options to choose from
                input.nextLine();
                System.out.println("**********  choice what your want to do from the below list  ***********");
                System.out.println("1. Create a new project");
                System.out.println("2. Change the due date of the project");
                System.out.println("3. Change the total amount of  fee paid");
                System.out.println("4. Update contractors contact details");
                System.out.println("5. View Incomplete projects");
                System.out.println("6. View Completed projects");
                System.out.println("7. Finalise Project");
                System.out.println("0. exit");


                choice = input.nextLine();
                choice_Int = Integer.parseInt(choice);
            }
           // input.close();

        }  catch ( SQLException ex ) {
            System.out.println("error occured");
            ex.printStackTrace ();
        }
    }

}
