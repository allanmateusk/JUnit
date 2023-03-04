import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;
    @BeforeEach
    public  void inicializar(){
    this.service = new ReajusteService();
    this.funcionario = new Funcionario("mateus", LocalDate.now(), new BigDecimal("1000.00"));
    }
    @Test
    public void reajusteDeveriSerTresPorCentoQuandoDesenpenhoForAdesejar(){
        service.concederReajuste(funcionario,Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriSerTresPorCentoQuandoDesenpenhoForBom(){
        service.concederReajuste(funcionario,Desempenho.A_BOM);
        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }
    @Test
    public void reajusteDeveriSerTresPorCentoQuandoDesenpenhoForOtimo(){
        service.concederReajuste(funcionario,Desempenho.A_OTIMO);
        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
}
