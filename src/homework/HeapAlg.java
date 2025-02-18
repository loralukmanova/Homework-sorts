
package homework;

import java.util.ArrayList;
public class HeapAlg {
    private ArrayList<Picture> list;

    public HeapAlg() {
        list = new ArrayList<>();
    }


    public HeapAlg(Picture[] objs) {
        this();
        for (int i = 0; i < objs.length; i++)
            add(objs[i]);
    }
    public void add(Picture newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                Picture temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break;

            currentIndex = parentIndex;
        }
    }

    public Picture remove() {
        if (list.size() == 0) return null;

        Picture removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;

            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                Picture temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break;
        }

        return removedObject;
    }

    public int getSize() {
        return list.size();
    }
}
