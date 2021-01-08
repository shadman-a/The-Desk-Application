import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> expenses = new ArrayList<>();

    public static void main(String[] args) {

        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }

        private static void optionsSelection() {
            String[] theOptions = {
                    "1. I wish to review my expenditure",
                    "2. I wish to add my expenditure",
                    "3. I wish to delete my expenditure",
                    "4. I wish to sort the expenditures",
                    "5. I wish to search for a particular expenditure",
                    "6. Close the application"
            };
            for(String option : theOptions){
                System.out.println(option);
            }

            System.out.println("\nEnter your choice:\t");
            Scanner sc = new Scanner(System.in);
            int  options =  sc.nextInt();
            switch (options){
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses+"\n");
                    optionsSelection();
                    break;
                case 2:
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    System.out.println(expenses+"\n");
                    optionsSelection();
                    break;
                case 3:
                    System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if(con_choice==options){
                           expenses.clear();
                        System.out.println(expenses+"\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    optionsSelection();
                    break;
                case 4:
                    sortExpenses(expenses);
                    optionsSelection();
                    break;
                case 5:
                    System.out.println("Enter the expense you need to search:\t");
                    int searchValue = sc.nextInt();
                    searchExpenses(expenses, searchValue);
                    optionsSelection();
                    break;
                case 6:
                    closeApp();
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;
            }
        }

        private static void closeApp() {
            System.out.println("Closing your application... \nThank you!");
            System.exit(0);
        }

        private static void searchExpenses(ArrayList<Integer> arrayList, Integer value) {
            boolean foundResult = false;
            for (int expense : arrayList) {
                if (expense == value) {
                    foundResult = true;
                }
            }
            if (foundResult) {
                System.out.println("Found expense " + value);
            } else {
                System.out.println("Did not find expense " + value);
            }
        }

        private static void sortExpenses(ArrayList<Integer> arrayList) {
            Collections.sort(arrayList);
            System.out.println("Expenses In Order");
            System.out.println(arrayList+"\n");
        }

    }

