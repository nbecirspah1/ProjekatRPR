package ba.unsa.etf.rpr.exceptions;

public class ProjekatException extends Exception {
 public ProjekatException(String poruka, Exception razlog){
     super(poruka, razlog);
 }
 public ProjekatException(String poruka){
     super(poruka);
 }
}
