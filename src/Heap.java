import java.util.Arrays;
class HeapNode
{
    MilliPark milliPark;
    public HeapNode(MilliPark milliPark) {
        this.milliPark = milliPark;
    }
    public MilliPark getMilliPark() {
        return milliPark;
    }
}
public class Heap {
    private final HeapNode[] heapDizisi;
    private final int maxBuyukluk;
    private int buyukluk;

    public Heap(int size)
    {
        maxBuyukluk = size;
        buyukluk = 0;
        heapDizisi = new HeapNode[maxBuyukluk];
    }


    public HeapNode sil()
    {
        HeapNode root = heapDizisi[0];
        heapDizisi[0] = heapDizisi[--buyukluk];
        trickleDown(0);
        return root;
    }
    public void trickleUp(int index)
    {
        int parent = (index - 1) / 2;
        HeapNode bottom = heapDizisi[index];
        while (index > 0 && heapDizisi[parent].getMilliPark().getYuzOlcumu() < bottom.getMilliPark().getYuzOlcumu())
        {
            heapDizisi[index] = heapDizisi[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapDizisi[index] = bottom;
    }

    public void trickleDown(int index)
    {
        int buyukCocuk;
        HeapNode bas = heapDizisi[index];
        while (index < buyukluk / 2)
        {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < buyukluk && heapDizisi[leftChild].getMilliPark().getYuzOlcumu() < heapDizisi[rightChild].getMilliPark().getYuzOlcumu())
                buyukCocuk = rightChild;
            else
                buyukCocuk = leftChild;
            if (bas.getMilliPark().getYuzOlcumu() >= heapDizisi[buyukCocuk].getMilliPark().getYuzOlcumu())
                break;
            heapDizisi[index] = heapDizisi[buyukCocuk];
            index = buyukCocuk;
        }
        heapDizisi[index] = bas;
    }
    public void ekle(MilliPark milliPark)
    {
        if (buyukluk == maxBuyukluk)
            return;
        HeapNode nw = new HeapNode(milliPark);
        heapDizisi[buyukluk] = nw;
        trickleUp(buyukluk++);
    }
    public void heapYazdir() {
        System.out.println("Heap dizisi :");
        for (int m = 0; m < buyukluk; m++) {
            if (heapDizisi[m] != null)
                System.out.println(heapDizisi[m].getMilliPark().getMilliParkAdi()+ "");
        }
    }
    @Override
    public String toString() {
        return "Heap{" +
                "heapDizisi=" + Arrays.toString(heapDizisi) +
                ", maxBuyukluk=" + maxBuyukluk +
                ", buyukluk=" + buyukluk +
                '}';
    }
}