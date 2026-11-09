package main.sorting;

/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
import java.util.Arrays;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,9,8,5,3,6,78};
        int[] copy;

        copy = arr.clone();
        bubbleSort(copy);
        print(copy);

        copy = arr.clone();
        selectionSort(copy);
        print(copy);

        copy = arr.clone();
        insertionSort(copy);
        print(copy);

        copy = arr.clone();
        mergeSort(copy,0,copy.length-1);
        print(copy);

        copy = arr.clone();
        quickLomutoSort(copy,0,copy.length-1);
        print(copy);

        copy = arr.clone();
        quickhoreSort(copy,0,copy.length-1);
        print(copy);

    }
    public static void quickLomutoSort(int[] arr,int l,int h){
        if(l<h){
            int p = lomutoPartition(arr,l,h);
            quickLomutoSort(arr,l,p-1);
            quickLomutoSort(arr,p+1,h);
        }
    }

    public static void quickhoreSort(int[] arr,int l,int h){
        if(l<h){
            int p = horePartition(arr,l,h);
            quickLomutoSort(arr,l,p);
            quickLomutoSort(arr,p,h);
        }
    }

    public static void mergeSort(int[] arr,int l, int h){
        if(l<h){
            int m = l + (h-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,h);
            merge(arr,l,m,h);
        }
    }
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int j=i-1,ele = arr[i];
            while(j>=0 && arr[j]>ele){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ele;
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        int min;
        for(int i=0;i<n-1;i++){
            min = i;
            for(int j=i+1;j<n;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }


    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            boolean swapped = false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
            if(!swapped) return;
        }
    }

    public static void merge(int[] arr, int l, int m, int h){
        int n1 = m-l+1;
        int  n2 = h-m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0;i<n1;i++){
            arr1[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
            arr2[i] = arr[m+1+i];
        }

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                arr[k++] = arr1[i++];
            }else{
                arr[k++] = arr2[j++];
            }
        }
        while(i<n1){
            arr[k++] = arr1[i++];
        }
        while(j<n2){
            arr[k++] = arr2[j++];
        }
    }

    public static int lomutoPartition(int[] arr, int l, int h){
        int k = l-1;
        for(int i=l;i<h;i++){
            if(arr[i]<=arr[h]) swap(arr,++k,i);
        }
        swap(arr,++k,h);
        return k;
    }

    public static int horePartition(int[] arr, int l, int h){
        int i=l-1;
        int j = h+1;

        while(true){
            do{
                i++;
            }while(i<=h && arr[i]<arr[l]);

            do{
                j--;
            }while(j>=l && arr[j]>arr[l]);

            if(i>=j){
                return j;
            }
            swap(arr,i,j);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void print(int[] arr){
        for(int i:arr){
            System.out.print(i + ", ");
        }
        System.out.println("");
    }
}

