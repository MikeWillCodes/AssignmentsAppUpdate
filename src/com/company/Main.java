package com.company;


import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    public enum DaysOfTheWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

        private static final List<DaysOfTheWeek> daysOfTheWeeks = List.of(values());

        public static DaysOfTheWeek getADay() {
            return daysOfTheWeeks.get(random.nextInt(daysOfTheWeeks.size()));
        }
    }

    public enum CourseList {
        DATA_STRUCTURES, LINEAR_ALGEBRA, AFRICAN_AMERICAN_DISPORA_STUDIES, THEOLOGY, INTERCULTURAL_COMMUNICATIONS;

        private static final List<CourseList> courseLists = List.of(values());

        public static CourseList getACourse() {
            return courseLists.get(random.nextInt(courseLists.size()));
        }
    }

    public enum Category {
        QUIZZES, TEST, HOMEWORK, NOTES, PROJECT;
        private static final List<Category> categories = List.of(values());

        public static Category getACategory() {
            return categories.get(random.nextInt(categories.size()));
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("\nThe current date-time is " + today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println("Tomorrow's formatted date is " + formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksLater = today.plusWeeks(5);
        System.out.println("The five weeks, the date will be " + fiveWeeksLater);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime birthDate = LocalDateTime.of(1996, 9, 11, 12, 35);
        System.out.println("Your birthdate is " + birthDate);

        //Output the day of the week (Sunday-Saturday) that you were born.
        System.out.println("The day of the week of your birthdate was " + birthDate.getDayOfWeek());

        //Output the number of days you've been alive.
        System.out.println("The number of days you have been alive is " + ChronoUnit.DAYS.between(birthDate, today) + " days.");

        //Output the number of days between two dates.
        LocalDateTime obamaInauguration = LocalDateTime.of(2009, 2, 20, 12, 0);
        System.out.println("The number of days between your birthdate and Obama's inauguration is " + ChronoUnit.DAYS.between(birthDate, obamaInauguration) + " days.");

        //Given two dates, output the earlier.
        System.out.println("The earlier date is " + FindEarlierDate(today, obamaInauguration));

        //Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        ArrayList<LocalDateTime> hundredRandomDates = randomDateArray(100);
        hundredRandomDates.forEach(d -> System.out.println("Date is " + d));

        //Output the number of stored dates in the year [Y].
        System.out.print("\nWhat is the year you want to find the dates of? ");
        ArrayList<LocalDateTime> datesOfUserYear = searchByYear(hundredRandomDates, sc.nextInt());
        System.out.println("The number of dates with that year is " + datesOfUserYear.size());

        //Count the number of stored dates in the current year.
        ArrayList<LocalDateTime> datesOfCurrentYear = searchByYear(hundredRandomDates, today.getYear());
        System.out.println("\nThe number of dates in the current year is " + datesOfCurrentYear.size());

        //Count the number of duplicates.
        ArrayList<LocalDateTime> duplicatedDates = seekDuplicates(hundredRandomDates);
        System.out.println("\nThere are " + duplicatedDates.size() + " duplicated dates.");

        // Sort the dates in chronological order.
        Collections.sort(hundredRandomDates);
        System.out.println("\nThe sorted dates are as followed: ");
        hundredRandomDates.forEach(d -> System.out.println(d));

        //Count the number of duplicates in a sorted list without using a Java Set.
        System.out.println("\nWithout using a Set, the number of duplicated dates are " + countDuplicates(hundredRandomDates));

        //Count the number of evening (after 6pm) dates.
        ArrayList<LocalDateTime> eveningDates = searchDatesInTimeframe(hundredRandomDates, 18, 24);
        System.out.println("\nThe number of evening dates are " + eveningDates.size());

        //Count the number of dates in each of the individual 12 months without using a Java Map.
        System.out.print("\nWhat is the number of the month you are searching the dates for? ");
        int month = sc.nextInt();
        if (month > 12 || month < 1) System.out.println("That month value is not valid.");
        else {
            ArrayList<LocalDateTime> datesOfMonth = searchByMonth(hundredRandomDates, month);
            System.out.println("The number of dates in month " + month + " is " + datesOfMonth.size());
        }

        //Count the number of dates in each of the individual 12 months using a Java Map.
        if (month >= 1 && month <= 12) {
            System.out.println("Using a Java Map, the number of dates in month " + month + " is " + mapByMonthSearch(hundredRandomDates, month));
        }

        //Determine the index of the latest LocalDateTime.
        System.out.println("\nThe index of the latest LocalDateTime is " + indexLatestDate(hundredRandomDates));

        //Determine the indexes of the elements that have the earliest starting time, regardless of date.
        System.out.println("\nThe index of the date with the earliest starting time is " + indexEarliestTime(hundredRandomDates));

        //Output a date in the format "January 1st, 2018".
        System.out.print("\nWhat is the index of the date you want to be outputted in the format \"January 1st, 2018\"? ");
        System.out.println("The formatted date is " + formattedDate(hundredRandomDates.get(sc.nextInt())));

        //Generate 2 random assignments
        assignment assign1 = new assignment(DaysOfTheWeek.getADay(), CourseList.getACourse(), Category.getACategory(), random.nextInt(4));
        assignment assign2 = new assignment(DaysOfTheWeek.getADay(), CourseList.getACourse(), Category.getACategory(), random.nextInt(4));
        System.out.println("The random assignments are: \n" + assign1 + "\n" + assign2);

        //copy assign1 to assign3
        assignment assign3 = assign1;
        System.out.println("Copy of assignment 1: " + assign3);

        //override equals method
        System.out.println("T/F Is copy assign3 == to original assign1? : " + assign3.equals(assign1));

        //overrride compareTo method
        System.out.println("Compared assignments: " + comparedAssignments(assign1,assign2));

        //Which of assign1, assign2, or assign3 is the earliest?
        if (assign1.equals(earliestAssignment(assign1,assign2,assign3))) { System.out.println("Assign1 is the earliest assignment."); }
        else if (assign2.equals(earliestAssignment(assign1,assign2,assign3))) { System.out.println("Assign2 is the earliest assignment."); }
        else if (assign3.equals(earliestAssignment(assign1,assign2,assign3))) { System.out.println("Assign3 is the earliest assignment."); }

        // Write [x] randomly generated assignments to the file
        writeToFile("input.txt", 3);

        // Read assignments from file
        randomAssignments();

        // Remove any duplicate assignments
        removeDuplicates();

    }

    private static Set<assignment> removeDuplicates(){
        Set<assignment> assignmentSet = new HashSet<>();
        assignmentSet.add(randomAssignments());

        return assignmentSet;
    }

    private static assignment randomAssignments(){
        return new assignment(DaysOfTheWeek.getADay(),CourseList.getACourse(),Category.getACategory(), random.nextInt(4));
    }

    private static void writeToFile (String file, int numOfAssignments){
       File outfile = new File(file);
       int num = numOfAssignments;
        try (PrintWriter pw = new PrintWriter(outfile))
        {
            while (num != 0) {
                pw.println(randomAssignments());
                num--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static assignment earliestAssignment (assignment ... assignments){
        assignment earliest = new assignment(assignments[0]);
        for (assignment assign: assignments) {
            if (earliest.getDay().compareTo(assignment.getDay()) > 0){ earliest = new assignment(assign); }
        }
        return earliest;
    }

    private static String comparedAssignments (assignment assign1, assignment assign2) {
        int value = assign1.compareTo(assign2);
        if (value < 0) { return "BEFORE"; }
        else if (value > 0) { return "AFTER"; }
        else { return "EQUALS"; }
    }

    private static String formattedDate(LocalDateTime date) {
        String newDate = "";
        newDate += date.format(DateTimeFormatter.ofPattern("MMMM "));
        newDate += intToOrdinal(date.getDayOfMonth());
        newDate += date.format(DateTimeFormatter.ofPattern(", yyyy"));
        return newDate;
    }

    private static String intToOrdinal(int num) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        //I probably should have made this into a switch/case.
        if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13) {
            return num + "th";
        } else {
            return num + suffixes[num % 10];
        }
    }

    private static Integer indexEarliestTime(ArrayList<LocalDateTime> dateList) {
        LocalDateTime earliestDateTime = dateList.get(0);
        for (LocalDateTime date : dateList) {
            if (earliestDateTime.toLocalTime().isAfter(date.toLocalTime())) earliestDateTime = date;
        }
        return dateList.indexOf(earliestDateTime);
    }

    private static Integer indexLatestDate(ArrayList<LocalDateTime> dateList) {
        return dateList.indexOf(Collections.max(dateList));
    }

    private static Integer mapByMonthSearch(ArrayList<LocalDateTime> dateList, int month) {
        return mapByMonth(dateList).get(month);
    }

    private static Map<Integer, Integer> mapByMonth(ArrayList<LocalDateTime> dateList) {
        Map<Integer, Integer> returnMap = new HashMap<>();
        for (LocalDateTime date : dateList) {
            Integer count = returnMap.get(date.getMonthValue());
            returnMap.put(date.getMonthValue(), (count == null) ? 1 : count + 1);
        }
        return returnMap;
    }

    private static ArrayList<LocalDateTime> searchByMonth(ArrayList<LocalDateTime> dateList, int month) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getMonthValue() == month)
                .collect(Collectors.toList());
    }

    private static ArrayList searchDatesInTimeframe(ArrayList<LocalDateTime> dateList, int startHour, int endHour) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getHour() >= startHour && date.getHour() < endHour)
                .collect(Collectors.toList());
    }

    private static int countDuplicates(ArrayList<LocalDateTime> hundredRandomDates) {
        int count = 0;
        for (LocalDateTime date : hundredRandomDates) {
            if (Collections.frequency(hundredRandomDates, date) >= 2) count++;
        }
        return count;
    }


    private static ArrayList<LocalDateTime> seekDuplicates(ArrayList<LocalDateTime> userList) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        Set<LocalDateTime> dateSet = new HashSet<>();
        for (LocalDateTime date : userList) {
            if (dateSet.contains(date)) returnArray.add(date);
            dateSet.add(date);
        }
        return returnArray;
    }

    private static ArrayList<LocalDateTime> searchByYear(ArrayList<LocalDateTime> listOfLocalDateTimes, int year) {
        return (ArrayList) listOfLocalDateTimes.stream()
                .filter(date -> date.getYear() == year)
                .collect(Collectors.toList());
    }

    private static ArrayList<LocalDateTime> randomDateArray(int NumElements) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        for (int i = 0; i < NumElements; i++) {
            returnArray.add(randomDateGenerator());
        }
        return returnArray;
    }

    private static LocalDateTime randomDateGenerator() {
        long startOfTime = ChronoUnit.MINUTES.between(LocalDateTime.of(0, 1, 1, 0, 0), LocalDateTime.now());
        long minutes = random.nextInt((int) startOfTime);
        return LocalDateTime.now().minusMinutes(minutes);
    }

    private static LocalDateTime FindEarlierDate(LocalDateTime date1, LocalDateTime date2) {
        LocalDateTime earlyDate = date1;
        if (date2.isBefore(date1)) {
            earlyDate = date2;
        }
        return earlyDate;
    }
}


