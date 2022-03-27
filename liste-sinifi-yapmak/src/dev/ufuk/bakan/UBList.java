package dev.ufuk.bakan;

public class UBList<T> {
    private T[] array = (T[]) new Object[10];
    private int size = 0;

    public UBList(){}
    public UBList(int capacity){
        array = (T[]) new Object[capacity];
    }

    public void add(T element){
        if(this.size == array.length){
            extendArray(); // Array sınıra ulaştıysa genişleten metodu çağır.
        }
        array[size] = element; // Son elemana eklenen elemanı ata
        size++; // boyutu bir arttır
    }

    private void extendArray(){
        T[] extendedArray = (T[])new Object[array.length*2]; // boyutu şimdikinin iki katı olan bir dizi oluştur
        for(int i = 0; i < size; i++){
            extendedArray[i] = array[i]; // eski dizideki her bir elemanı yeni diziye aktar
        }
        array = extendedArray; // şimdiki dizinin yerine genişletilmiş diziyi ata
    }

    public T get(int index) throws IndexOutOfBoundsException{
        if(index < size){
            return array[index];
        }else{ // indis dizi boyutundan büyükse hata fırlat:
            throw new IndexOutOfBoundsException();
        }
    }

    public T set(int index, T element){
        if(index < size){
            array[index] = element;
            return element; // atama gerçekleşirse atanan elemanı döndür
        }else{
            return null; // atama gerçekleşemezse null döndür (null döndürmesi isteniyor)
        }
    }

    public boolean remove(int index){
        if(index < size){
            shiftFrom(index);
            size--;
            return true; // eleman kaldırılırsa true döndür
        }else{
            return false; // eleman kaldırılamazsa false döndür (null döndürmesi isteniyor)
        }
    }

    private void shiftFrom(int index){ // verilen indisten itibaren sola kaydıran metot
        int i;
        for(i = index; i < size-1; i++){
            array[i] = array[i+1]; // sağdaki her elemanı soldakine ata
        }
        array[i] = null; // en sağda aynı elemandan iki tane olduğunda sonda kalan fazla elemanı sil.
    }

    public int getCapacity(){
        return array.length;
    }

    public int size(){
        return this.size;
    }

    public int indexOf(T element){
        int index = -1;
        for(int i = 0; i < size; i++){ // linear search ile elemanın bulunduğu indisi döndür
            if(array[i] == element) {
                index = i;
                break;
            }
        }
        return index; // eleman bulunamazsa ilk değer olan -1 döndürülür
    }

    public int lastIndexOf(T element){
        int index = -1;
        for(int i = size-1; i >= 0; i--){ // elemanı aramaya sondan başla ve bulunduğu indisi döndür
            if(array[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T[] toArray(){ // liste boyutuna eşit olan (kapasitesine değil) diziyi döndürür
        T[] result = (T[])new Object[size];
        for(int i = 0; i < size; i++){
            result[i] = array[i]; // listedeki elemanları diziye ata
        }
        return result;
    }

    public void clear(){
        array = (T[]) new Object[10]; // kapasiteyi ve diziyi sıfırlar
        size = 0; // boyutu sıfırla
    }

    public UBList<T> sublist(int lower, int upper){ // iki indis arasında kalan diziyi döndürür
        UBList<T> sublist = new UBList();
        for(int i = lower; i <= upper; i++){
            sublist.add(get(i)); // indisler arasında kalan elemanları sublist e ekle
        }
        return sublist;
    }

    public boolean contains(T element){
        boolean contains = false; // eleman bulundu mu değişkeni
        for(int i = 0; i < size; i++){
            if(array[i] == element){
                contains = true; // eleman bulunduysa contains=true
                break; // eleman bulunduysa döngüye devam etmeye gerek yok
            }
        }
        return contains;
    }

    @Override
    public String toString(){
        if(size > 0){
            String result = "";
            int i;
            for(i = 0; i < size-1; i++){ // her elamandan sonra virgül koy
                result += array[i].toString() + ", ";
            }
            result += array[i]; // son elemandan sonra virgül koyma
            return result;
        }
        else{
            return "Empty"; // dizi boşsa empty döndürür
        }
    }
}
