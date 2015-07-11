
package org.unitec.maven;

import java.io.*;

public class LeerArchivo {
    
    public String leer()throws Exception{
        File file=new File("E:\\archivito.txt");
        FileInputStream fis=new FileInputStream(file);
        StringBuilder sb=new StringBuilder();//StringBuilder es acumulable de lo viejo aumenta lo nuevo.
        int ch=0;
        while((ch=fis.read())!=-1){
            sb.append((char)ch);//se realiza el casting 
            //porque read devuelve puros enteros.
        }
        return sb.toString();
    }
}
