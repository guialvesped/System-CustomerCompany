import org.example.Cliente;
import org.example.Empresa;
import org.example.Taxa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpresaTest {

    @Test
    void teste_se_addTaxas_esta_funcionando(){
        Empresa empresa = new Empresa("12.345.678/0001-95");
        Taxa taxaServico = new Taxa("Taxa de Serviço",2.0);
        empresa.addTaxa(taxaServico);
        Assertions.assertNotNull(empresa.getTaxas());
    }
    @Test
    void verifica_se_o_aplicaTaxa_funciona_corretamente(){
        Empresa empresa = new Empresa("12.345.678/0001-95");
        Taxa taxaServico = new Taxa("Taxa de Serviço",2.0);
        empresa.addTaxa(taxaServico);
        Cliente cliente = new Cliente("Guilherme","215.119.806-08");
        cliente.realizarDeposito(empresa,100);
        Assertions.assertEquals(98,empresa.getSaldo());
    }
    @Test
    void teste_se_o_cadastro_funciona_corretamente(){
        Empresa empresa = new Empresa("12.345.678/0001-95");
        empresa.isValidCnpj();
        Assertions.assertTrue(empresa.isValidCnpj());
    }
    @Test
    void teste_se_o_IsValidCNpj_pega_erro_dos_numeros_iguais(){
        Empresa empresa = new Empresa("00.000.000/0000-00");
        empresa.isValidCnpj();
        Assertions.assertFalse(empresa.isValidCnpj());
    }
    @Test
    void teste_se_o_IsValidCNpj_pega_erro_dos_numeros_a_menos(){
        Empresa empresa = new Empresa("12.345.78/0001-95");
        empresa.isValidCnpj();
        Assertions.assertFalse(empresa.isValidCnpj());
    }
}
