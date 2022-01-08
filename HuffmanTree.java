// HUFFMAN CODING
// 19BCE254 - SHAH NEEL
// 19BCE255 - SHAH PARAM
// 19BCE258 - SHAH RUSHABH



import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode{
    int data;
    char c;

    HuffmanNode l;
    HuffmanNode r;
}
class HuffmanComparator implements Comparator<HuffmanNode>{	// this class compares two huffman nodes
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.data-y.data;
    }
}
public class HuffmanTree {			// this class creates a huffman tree in its main method
    public static void printCode(HuffmanNode x,String s){		// this function prints huffman code for each character  
        if(x.l==null && x.r==null && Character.isLetter(x.c)){
            System.out.println(x.c +" : "+s);
            return;
        }
        printCode(x.l, s+"0");  // if we go to left then add "0" to the code
        printCode(x.r, s+"1");  // if we go to right then add "1" to the code
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of Characters:");
        int n = sc.nextInt();
        char[] charArray = new char[n];			// creating char array to store characters
        int[] charFreq = new int[n];			// creating frequency array to store frequency of each character
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(n,new HuffmanComparator());	// creating a priority queue object named pq
        for(int i=0;i<n;i++){				// taking input from user and adding node to priority queue
            System.out.print("Enter Character "+(i+1)+":");	
            charArray[i]=sc.next().charAt(0);
            System.out.print("Enter Frequency of "+charArray[i]+":");
            charFreq[i]=sc.nextInt();
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];
            hn.l = null;
            hn.r = null;
            pq.add(hn);
        }
        HuffmanNode root = null;
        while(pq.size()>1){		// this loop creates the huffman tree from priority queue
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.l = x;
            f.r = y;
            root = f;
            pq.add(f); 
        }
        printCode(root, "");		// this function prints the huffman code for each character
        sc.close();
    }
}