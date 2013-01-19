package malcjohn;
import java.util.Set;
import java.util.HashSet;


public enum Enum2 {
;

   /**
    * <pre>
    *           0..*     0..*
    * Enum2 ------------------------> CashMachine
    *           enum2        &gt;       cashMachine
    * </pre>
    */
   private Set<CashMachine> cashMachine;
   
   public Set<CashMachine> getCashMachine() {
      if (this.cashMachine == null) {
         this.cashMachine = new HashSet<CashMachine>();
      }
      return this.cashMachine;
   }
   
   }
