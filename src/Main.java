import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)  throws IOException{

        // citire din fisier text
        List<Pacient> pacienti = new ArrayList<>();
        try(var fisier = new BufferedReader(new FileReader("date\\Pacienti.txt"))){
//            for (var entry : pacienti)
//            {
//
//            }
           pacienti = fisier.lines().map(Pacient :: new).collect(Collectors.toList());
        }

        System.out.println("Numar total pacienti: " + pacienti.size());
        System.out.println();

        // scriere in fisier text


        // Cerinta 3
        Map<String, Sectie> sectii = new HashMap<>();
        for (var pacient: pacienti) {
            if (!sectii.containsKey(pacient.getDenumire_sectie())) {
                sectii.put(pacient.getDenumire_sectie(),
                        new Sectie(pacient.getDenumire_sectie()));
            }
            sectii.get(pacient.getDenumire_sectie()).numarPacienti++;
        }
        List<Sectie> listaSectii = new ArrayList<>(sectii.values());
        Collections.sort(listaSectii);
        System.out.println("Lista sortata descrescator dupa nr de pacienti");
        for (var sectie : listaSectii)
        {
            System.out.println(sectie);
        }
        System.out.println();

        // lista dupa coduri crescator
        Map<Integer, Pacient> coduriPacienti = new HashMap<>();
        for(var pacient : pacienti){
            if(!coduriPacienti.containsKey(pacient.getCod()))
            {
                coduriPacienti.put(pacient.getCod(), new Pacient(pacient.getCod(), pacient.getNume()));
            }
        }
        List<Pacient> listaCoduriPacienti = new ArrayList<>(coduriPacienti.values());
        Collections.sort(listaCoduriPacienti);
        System.out.println("Lista sortata crescator dupa coduri");
        for (var pacient : listaCoduriPacienti)
        {
            System.out.println(pacient);
        }
        System.out.println();

        // citire/scriere binar
        // citire
        try(var fisier = new DataOutputStream(new FileOutputStream("date\\Pacienti.dat")))
        {
            fisier.writeInt(pacienti.size());
            for(var pacient : pacienti)
            {
                fisier.writeInt(pacient.getCod());
                fisier.writeUTF(pacient.getNume());
                fisier.writeUTF(pacient.getDenumire_sectie());
            }
        }

        try(var fisier = new DataInputStream(new FileInputStream("date\\Pacienti.dat")))
        {
            int n = fisier.readInt();
            for (int i = 0; i < n; i++)
            {
                System.out.println(fisier.readInt() + " " +
                        fisier.readUTF() + " " +
                        fisier.readUTF());
            }
        }


    }
}
