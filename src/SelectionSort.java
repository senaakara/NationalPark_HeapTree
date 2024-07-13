class SelectionSort
{
    private final int[] selectionSortArr;
    private  int elemanSayisi;
    public SelectionSort(int max){
        selectionSortArr = new int[max];
        elemanSayisi = 0;
    }

    public void ekle(int eleman){
        selectionSortArr[elemanSayisi] = eleman;
        elemanSayisi++;
    }

    public void sortArray()
    {
        for (int i = 0; i < elemanSayisi -1; i++)
        {
            int minIndeks = i;
            for (int j = i+1; j < elemanSayisi; j++)
                if (selectionSortArr[j] < selectionSortArr[minIndeks])
                    minIndeks = j;
            int gecici = selectionSortArr[minIndeks];
            selectionSortArr[minIndeks] = selectionSortArr[i];
            selectionSortArr[i] = gecici;
        }
    }
    public void yazdir(){
        System.out.println(" ");
        System.out.print("Sıralı liste: ");
        for (int j : selectionSortArr)
            System.out.print( j + " ");
        System.out.println();
    }
}