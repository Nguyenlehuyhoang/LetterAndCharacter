MeetingRoom
public class MeetingRoom extends Room { 
private int capacity;   
public MeetingRoom(String id, String name, double baseCost, int capacity) { 
super(id, name, baseCost);
 this.capacity = capacity; 
}   
public int getCapacity() {
return capacity;              
}   
public void setCapacity(int capacity) {
 this.capacity = capacity; 
}  
public double calculateCost() {
 if (capacity > 50) {
 return getBaseCost() * 1.2;
 }
 return getBaseCost(); 
} 
public void displayDetails() {
 System.out.println("Room ID: " + getId());
 System.out.println("Room Name: " + getName());
 System.out.println("Base Cost: " + getBaseCost()); 
System.out.println("Room Type: Meeting Room");
 System.out.println("Capacity: " + capacity); 
System.out.println("Total Cost: " + calculateCost());
 }
 }

BedRoom
public class BedRoom extends Room {
    private int numberOfBeds;
    public BedRoom(String id, String name, double baseCost, int numberOfBeds) {
        super(id, name, baseCost);
        this.numberOfBeds = numberOfBeds;
    }
    public int getNumberOfBeds() {
        return numberOfBeds;
    }
    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
    public double calculateCost() {
        if (numberOfBeds >= 3) {
            return getBaseCost() * 1.1; // Tăng 10% nếu có >= 3 giường
        }
        return getBaseCost();
    }
    public void displayDetails() {
        System.out.println("Room ID: " + getId());
        System.out.println("Room Name: " + getName());
        System.out.println("Base Cost: " + getBaseCost());
        System.out.println("Room Type: Bedroom");
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Total Cost: " + calculateCost());
    }
}

RoomList
import java.util.ArrayList;
public class RoomList {
    private ArrayList<Room> roomList;
    public RoomList() {
        this.roomList = new ArrayList<>();
    }
    public ArrayList<Room> getRoomList() {
        return roomList;
    }
    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }
    public void addRoom(Room room) {
        roomList.add(room);
    }
    public boolean updateRoomById(String id, Room updatedRoom) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId().equals(id)) {
                roomList.set(i, updatedRoom);
                return true;
            }
        }
        return false;
    }
    public boolean deleteRoomById(String id) {
        return roomList.removeIf(room -> room.getId().equals(id));
    }
    public Room findRoomById(String id) {
        for (Room room : roomList) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }
    public void displayAllRooms() {
        for (Room room : roomList) {
            room.displayDetails();
            System.out.println("-------------------------");
        }
    }
    public Room findMostExpensiveRoom() {
        if (roomList.isEmpty()) {
            return null;
        }
        Room mostExpensive = roomList.get(0);
        for (Room room : roomList) {
            if (room.calculateCost() > mostExpensive.calculateCost()) {
                mostExpensive = room;
            }
        }
        return mostExpensive;
    }
    public void countRooms() {
        int meetingRoomCount = 0;
        int bedRoomCount = 0;
        for (Room room : roomList) {
            if (room instanceof MeetingRoom) {
                meetingRoomCount++;
            } else if (room instanceof BedRoom) {
                bedRoomCount++;
            }
        }
        System.out.println("Number of Meeting Rooms: " + meetingRoomCount);
        System.out.println("Number of Bedrooms: " + bedRoomCount);
    }
}



















Processor
import java.util.Scanner;
public class Processor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomList roomList = new RoomList();
        int choice;
        do {
            System.out.println("===== Room Management System =====");
            System.out.println("1. Add a new meeting room");
            System.out.println("2. Add a new bedroom");
            System.out.println("3. Update Room by ID");
            System.out.println("4. Delete Room by ID");
            System.out.println("5. Find Room by ID");
            System.out.println("6. Display all Rooms");
            System.out.println("7. Find the most expensive Room");
            System.out.println("8. Count the total number of meeting rooms and bedrooms");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1: {
                    System.out.print("Enter Meeting Room ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Meeting Room Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double baseCost = scanner.nextDouble();
                    System.out.print("Enter Capacity: ");
                    int capacity = scanner.nextInt();
                    roomList.addRoom(new MeetingRoom(id, name, baseCost, capacity));
                    System.out.println("Meeting Room added successfully!");
                    break;
                }
                case 2: {
                    System.out.print("Enter Bedroom ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Bedroom Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double baseCost = scanner.nextDouble();
                    System.out.print("Enter Number of Beds: ");
                    int numberOfBeds = scanner.nextInt();
                    roomList.addRoom(new BedRoom(id, name, baseCost, numberOfBeds));
                    System.out.println("Bedroom added successfully!");
                    break;
                }
                case 3: {
                    System.out.print("Enter Room ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter new Room Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new Base Cost: ");
                    double baseCost = scanner.nextDouble();
                    System.out.print("Enter new Capacity/Number of Beds: ");
                    int value = scanner.nextInt();
                    Room updatedRoom = null;
                    if (id.startsWith("M")) {
                        updatedRoom = new MeetingRoom(id, name, baseCost, value);
                    } else if (id.startsWith("B")) {
                        updatedRoom = new BedRoom(id, name, baseCost, value);
                    }
                    if (updatedRoom != null && roomList.updateRoomById(id, updatedRoom)) {
                        System.out.println("Room updated successfully!");
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter Room ID to delete: ");
                    String id = scanner.nextLine();
                    if (roomList.deleteRoomById(id)) {
                        System.out.println("Room deleted successfully!");
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter Room ID to find: ");
                    String id = scanner.nextLine();
                    Room room = roomList.findRoomById(id);
                    if (room != null) {
                        room.displayDetails();
                    } else {
                        System.out.println("Room not found!");
                    }
                    break;
                }
                case 6: {
                    roomList.displayAllRooms();
                    break;
                }
                case 7: {
                    Room mostExpensiveRoom = roomList.findMostExpensiveRoom();
                    if (mostExpensiveRoom != null) {
                        System.out.println("Most Expensive Room:");
                        mostExpensiveRoom.displayDetails();
                    } else {
                        System.out.println("No rooms found!");
                    }
                    break;
                }
                case 8: {
                    roomList.countRooms();
                    break;
                }
                case 9: {
                    System.out.println("Exiting the program...");
                    break;
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
