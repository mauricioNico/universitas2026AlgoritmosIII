public class burbuja {
    public static void main(String[] args) {
        int[] numeros={4,7,2,9,1,23,40,11,25,10};
        for(int i=0;i<numeros.length-1;i++){
            for(int j=0;j<numeros.length-1-i;j++){
                if(numeros[j]>numeros[j+1]){
                    int temp=numeros[j];
                    numeros[j]=numeros[j+1];
                    numeros[j+1]=temp;
                }
            }
        }
        //ciclo for each en java
    for(int numero:numeros){
        System.out.print(numero+" ");
    }
}
}
