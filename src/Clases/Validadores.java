/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Notebook
 */
public class Validadores {
    
    // Username
    // Sin espacios (trim())
    // Min/Max 8/20
    // Sin caracteres especiales
    
    // Password
    // Sin espacios (trim())
    // Min/Max 8/20
    // password1 password2 que sean iguales
    
    // Email
    // xxxx@xxx.com
    // Min/Max 5/254
    // que contenga @ 
    // Sin espacios
    
    // Dni
    // Sin espacios
    // Solo numeros
    // 8 digitos
    // sin puntos
    
    // Crear metodos para validar los campos necesarios
      public String validarNombreApellido(String NomApe, int min, int max) {
        String resu="";
        NomApe=NomApe.trim().toUpperCase();
        
        if(NomApe.length() > min && NomApe.length() < max  ){
          if(!NomApe.contains("  "))
            resu=NomApe; 
        }
        if (resu=="") { 
            System.out.println("Debe Ingresar un Texto Valido ");
        }
        return resu;
    }    

    public String validarMail(String correo) {
        String resu="";
        correo = correo.trim();

        if( !correo.contains(" ")  ){
            if( (correo.length()> 6) && (correo.contains("@")))
                resu=correo; 
        }
        return resu;
    }

    public String validarPass(char pass1[], char pass2[]) {
        String passtxt1, passtxt2;
        String resu="";
    
        passtxt1=String.valueOf(pass1).trim();
        passtxt2=String.valueOf(pass2).trim();
        
        if( (passtxt1.length() > 7) && (passtxt1.length() < 21)){
            if( (passtxt1.equals(passtxt2)) && !(passtxt1.contains(" ") ) ) {
            resu=passtxt1; 
            }          
        }

        return resu;
    } 
//    Valida Numeros ...
//   str.matches("-?\\d+(\\.\\d+)?") para Numero, negativos (-) y Decimal (.)
    public boolean validarNumeros(String dato, int largo ){
    boolean resu=false;
    
      if(dato.matches("[0-9]*") && (dato.length() <= largo) ) 
         resu=true;
      
      return resu;  
    }
    
//    Valida Fecha ............... Retorna fecha valida o Null
    public String validarFecha(String fecha) {
        boolean resu=true;

        try{
        fecha = fecha.trim();
//        SimpleDateFormat fechaformato = new SimpleDateFormat("dd/MM/yyyy");
        
        SimpleDateFormat FecFormato = new SimpleDateFormat("dd/MM/yyyy");
        FecFormato.setLenient(false);

        String[] normali = fecha.split("/");
        if (normali.length == 3){
          if(normali[2].length() < 4)
            fecha=normali[0] + "/" + normali[1] + "/" + "19" + normali[2];
        
          FecFormato.parse(fecha);
        } else{
//           System.out.println("Debe ingresar una Fecha Valida: ");    
           fecha = "";
         }
        
        }
        catch (ParseException e){
         System.out.println("Debe ingresar una Fecha Valida: " + e);    
         fecha = "";
        }
        return fecha;
    }
}
