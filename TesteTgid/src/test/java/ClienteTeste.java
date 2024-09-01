import org.example.Cliente;
import org.example.Empresa;
import org.example.Taxa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTeste {


    @Test
    void teste_isCpfValid_esta_funcionando(){
        Cliente cliente = new Cliente("Guilherme","215.119.806-08");
        cliente.isCpfValid();
        Assertions.assertTrue(cliente.isCpfValid());
    }
    @Test
    void teste_isCpfValid_nao_esta_ignorando_erro_numeros_a_menos(){
        Cliente cliente = new Cliente("Guilherme","215.11.806-08");
        cliente.isCpfValid();
        Assertions.assertFalse(cliente.isCpfValid());
    }
    @Test
    void teste_isCpfValid_nao_esta_ignorando_erro_numeros_iguais(){
        Cliente cliente = new Cliente("Guilherme","000.000.000-00");
        cliente.isCpfValid();
        Assertions.assertFalse(cliente.isCpfValid());
    }
    @Test
    void teste_realizar_deposito(){
        Empresa empresa = new Empresa("12.345.678/0001-95");
        Cliente cliente = new Cliente("Guilherme","215.119.806-08");
        cliente.realizarDeposito(empresa,100);
        Assertions.assertEquals(100,empresa.getSaldo());
    }
    @Test
    void teste_realizar_saque(){
        Empresa empresa = new Empresa("12.345.678/0001-95");
        Cliente cliente = new Cliente("Guilherme","215.119.806-08");
        cliente.realizarDeposito(empresa,100);
        cliente.realizarSaque(empresa,50);
        Assertions.assertEquals(50,empresa.getSaldo());
    }

}
