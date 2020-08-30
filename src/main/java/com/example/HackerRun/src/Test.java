import java.util.*;
import java.util.stream.Collectors;

public class Test {

            public static int filteringMessages(String messageA, String messageB, String virusC) {
                StringBuilder message = new StringBuilder(messageA);
                StringBuilder palabraMayor = new StringBuilder(messageB);

                int valor =0;
                int cantidad=1;
                for(int i= message.length(); i>0; i--){
                    valor +=next( i , message, cantidad, palabraMayor);
                    System.out.println("cantidad "+ valor);
                    if (!validateMayor(message, palabraMayor))
                    {
                        System.out.println("cantidad final "+ valor);
                        return valor+1;
                    }

                }
                return 1;
            }

            public static int next(int cantidad, StringBuilder palabra, int contador, StringBuilder palabraMayor){

                char a='a';
                if(cantidad==palabra.length()){
                        a = palabra.charAt(cantidad-1);
                        while(true){
                            a+=1;
                            palabra.setCharAt(cantidad-1,a);
                            if (!validateMayor(palabra, palabraMayor))
                            {
                                return contador;
                            }
                            System.out.println(palabra);
                            contador++;
                            if(a=='z'){
                                if(validateAll(palabra)){
                                    return contador;
                                }
                                if (!validateMayor(palabra, palabraMayor))
                                {
                                    return contador;
                                }
                                a='a';
                                palabra.setCharAt(cantidad-1,a);
                                return contador;
                            }
                        }
                }
                else{
                    for(;;){
                        if (!validateMayor(palabra, palabraMayor))
                        {
                            return contador;
                        }
                        char aux = palabra.charAt(cantidad-1);
                        aux+=1;
                        palabra.setCharAt(cantidad-1,aux);
                        System.out.println(palabra);
                        contador++;
                        contador+= next(cantidad+1, palabra, contador, palabraMayor);
                        if(aux=='z'){
                            if(validateAll(palabra)){
                                return contador;
                            }
                            aux='a';
                            palabra.setCharAt(cantidad-1,aux);
                            System.out.println(palabra);
                            contador++;
                            return contador;
                        }
                    }
                }
            }

            public static  boolean validateAll(StringBuilder palabra){

                     return  palabra.chars().allMatch(x->x =='z');
            }

    public static  boolean validateMayor(StringBuilder palabramenor, StringBuilder palabramayor){
                return  palabramenor.toString().compareTo(palabramayor.toString())<0;
    }

//***************************************************************

                     public static String nextWord(String str)
                        {
                            if (str == ""){
                                return "a";
                            }

                            int i = str.length() - 1;
                            while (str.charAt(i) == 'z' && i >= 0){
                                str = str.substring(0, i) +"a"+((str.substring(i + 1)));
                                i--;
                            }


                            if (i == -1){
                                str = str + 'a';
                            }


                            else{
                                    str = str.substring(0, i) + (char)((int)(str.charAt(i)) + 1) + str.substring(i + 1);
                                }

                            return str;
                        }

    public static  void main (String args[]){
                int contador=0;
                String papa = "da";
                  String res ="ab";
                String virus ="c";
                while(true){

                     if (res.compareTo(papa)<=0){
                            if(!res.contains(virus)){
                                System.out.println("palabra "+res);
                                contador++;
                            }
                        }
                     else
                     {
                         break;
                     }
                    res =nextWord(res);
                    System.out.println("resultado "+contador);

                }
    }
}
