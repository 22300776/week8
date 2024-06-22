package pstudio.j071;

import java.util.*;

public class TodoCRUD implements iCRUD {
    private ArrayList<TodoItem> list;

    public TodoCRUD() {
        this.list = new ArrayList<TodoItem>();
    }

    @Override
    public int addItem() {
        String title, desc;
        Scanner sc = new Scanner(System.in);
        System.out.print("Add a Todo item\nEnter the title: ");
        title = sc.nextLine().trim();
        if (isDuplicated(title)) {
            System.out.println("Title can't be duplicated.");
            return 1;
        }
        System.out.print("Enter the detail: ");
        desc = sc.nextLine().trim();
        TodoItem t = new TodoItem(title, desc);
        this.list.add(t);
        System.out.println("Item added.");
        return 0;
    }

    @Override
    public int updateItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title of the item to update: ");
        String title = sc.nextLine().trim();
        if (!isDuplicated(title)) {
            System.out.println("Item not found.");
            return 1;
        }
        System.out.print("Enter the new detail: ");
        String detail = sc.nextLine().trim();
        for (TodoItem item : list) {
            if (item.getTitle().equals(title)) {
                item.setDetail(detail);
                item.setReg_date(new Date());
                System.out.println("Item updated.");
                break;
            }
        }
        return 0;
    }

    @Override
    public int deleteItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title of the item to delete: ");
        String title = sc.nextLine().trim();
        if (!isDuplicated(title)) {
            System.out.println("Item not found.");
            return 1;
        }
        for (TodoItem item : list) {
            if (item.getTitle().equals(title)) {
                list.remove(item);
                System.out.println("Item deleted.");
                break;
            }
        }
        return 0;
    }

    @Override
    public void printItem() {
        System.out.println("Total " + this.list.size() + " items");
        for (TodoItem item : this.list) {
            System.out.println(item.toString());
        }
    }

    public boolean isDuplicated(String title) {
        for (TodoItem item : this.list) {
            if (title.equals(item.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public void sortByName() {
        Collections.sort(this.list, new TodoItemNameComparator());
    }

    public void sortByDate() {
        Collections.sort(this.list, new TodoItemDateComparator());
    }

    public void reverseList() {
        Collections.reverse(this.list);
    }

    class TodoItemNameComparator implements Comparator<TodoItem> {
        @Override
        public int compare(TodoItem o1, TodoItem o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    class TodoItemDateComparator implements Comparator<TodoItem> {
        @Override
        public int compare(TodoItem o1, TodoItem o2) {
            return o1.getReg_date().compareTo(o2.getReg_date());
        }
    }
}
