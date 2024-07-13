import java.util.ArrayList;
class TreeNode{
    public MilliPark data;

    public String ad;
    public int count;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public void displayNode(){              // Milli park nesnelerini tutan ağacın yazdırılması için.
        System.out.println(data + " ");
    }
    public void displayNode2(){             // Tüm kelimeleri tutan ağacın yazdırılması için.
        System.out.println(ad + " --> "+ count + " adet var.");
    }

}

public class Tree {
    TreeNode root;
    TreeNode root2;


    public Tree(){
        this.root = null;
        this.root2 = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getRoot2() {
        return root2;
    }

    public void insertMilliPark(MilliPark newMilliPark){                    //ekleme metodu
        TreeNode newNode = new TreeNode();
        newNode.data = newMilliPark;
        if (root == null){
            root = newNode;
        }
        else{
            TreeNode current = root;
            TreeNode parent;
            while(true){
                parent = current;
                if (current.data.getMilliParkAdi().compareTo(newMilliPark.getMilliParkAdi()) < 0) //milli park adına göre karşılaştırma yaparak yerleştirir.
                {
                    current = current.leftChild;
                    if (current == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    current = current.rightChild;
                    if (current == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void PreOrder(TreeNode localRoot)            //milli park ağacını preorder dolaşma metodu.
    {
        if (localRoot != null)
        {
            localRoot.displayNode();
            PreOrder(localRoot.leftChild);
            PreOrder(localRoot.rightChild);
        }
    }
    public void PreOrder2(TreeNode localRoot)           // tüm kelimelerin ağacını preorder dolaşma metodu.
    {
        if (localRoot != null)
        {
            localRoot.displayNode2();
            PreOrder2(localRoot.leftChild);
            PreOrder2(localRoot.rightChild);
        }
    }

    public int maxDepth(TreeNode localRoot) {           // ağacın max derinliğini bulan recursive metod.
        if (localRoot == null) {
            return -1;
        } else {
            int leftDepth = maxDepth(localRoot.leftChild);
            int rightDepth = maxDepth(localRoot.rightChild);
            if (leftDepth > rightDepth )
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    public int countNodes(TreeNode localRoot){      //ağaçtaki node sayısını döndüren metod.
        if(localRoot == null){
            return (0);
        }
        else{
            int leftCount = countNodes(localRoot.leftChild);
            int rightCount = countNodes(localRoot.rightChild);
            return leftCount + rightCount + 1;
        }
    }

    public int balancedMaxDepth(TreeNode localRoot){    // ağaç dengeli olsaydı derinliğini bulup döndüren metod.
        if(localRoot == null){
            return -1;
        }
        else{
            int nodeCount = countNodes(localRoot);
            int balancedDerinlik = 0;
            while(nodeCount > 1){
                nodeCount = nodeCount / 2;
                balancedDerinlik ++;
            }
            return balancedDerinlik;
        }
    }


    public Object iteSearch(String aranan){               // girilen milli parkın ilk 3 harfine göre arama yapar ve bulunduğu ili döndürür.
        TreeNode current = root;
        while(!current.data.getMilliParkAdi().substring(0,3).equals(aranan)){
            if (current.data.getMilliParkAdi().substring(0, 3).compareTo(aranan) < 0){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if(current == null){
                return "Bulunamadı veya yanlış girildi!";
            }
        }
        return  current.data.getIlAdi();
    }
    public TreeNode iteSearch2(String aranan){
        TreeNode current = root2;
        while(!current.ad.equals(aranan)){
            if (current.ad.compareTo(aranan) < 0){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if(current == null){
                return null;
            }
        }
        return  current;
    }

    public TreeNode insertInfo(String newKelime,ArrayList<String> bulunanlar){          //kelime ağacına kelimelerin eklenmesini sağlayan önceden eklendiyse node unu döndüren metod.

        if(bulunanlar.contains(newKelime)){
            return iteSearch2(newKelime);
        }
        TreeNode newNode2 = new TreeNode();
        newNode2.ad= newKelime;
        if (root2 == null){
            root2 = newNode2;
        }
        else{
            TreeNode current = root2;
            TreeNode parent;
            while(true){
                parent = current;
                if (current.ad.compareTo(newKelime) < 0)
                {
                    current = current.leftChild;
                    if (current == null && !bulunanlar.contains(newKelime))
                    {
                        parent.leftChild = newNode2;
                        return newNode2;
                    }
                }
                else
                {
                    current = current.rightChild;

                    if (current == null && !bulunanlar.contains(newKelime))
                    {
                        parent.rightChild = newNode2;
                        return newNode2;
                    }
                }
            }
        }
        return null;
    }
}