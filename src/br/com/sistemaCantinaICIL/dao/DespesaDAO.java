package br.com.sistemaCantinaICIL.dao;

import static br.com.sistemaCantinaICIL.dao.JPAUtil.getEntityManager;
import br.com.sistemaCantinaICIL.model.Despesa;
import br.com.sistemaCantinaICIL.model.EnumSituacao;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Aricelio de Souza - 15/12/2015
 */
public class DespesaDAO extends DAOGenerico<Despesa> {

    // Construtor.........................................................................................................................................
    public DespesaDAO() {
        super(Despesa.class);
    }

    // Método que verifica a situação de uma Venda.....................................................................................
    public void updateExpenseSituation() {
        EntityManager manager = getEntityManager();

        try {

            // Inicia a Transação
            manager.getTransaction().begin();

            // Pega a lista de Despesas
            List<Despesa> list = Listar();

            // Verifica se existe data de pagamento de cada Despesa
            for (Despesa d : list) {
                if ((d.getDataPagamento() != null) && (d.getSituacao() != EnumSituacao.PAGA)) {
                    d.setSituacao(EnumSituacao.PAGA);
                    Atualizar(d);
                }
            }

            // Finaliza a transação
            manager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    // Método Buscar...................................................................................................................................
    public List<Despesa> Buscar(int mes, String situacao, String tipo, int ordenacao) throws Exception {

        EntityManager manager = getEntityManager();

        try {
            // Inicia a transação
            manager.getTransaction().begin();

            // Define a consulta
            String strConsulta = "SELECT d FROM Despesa d";

            // Situacao
            if (situacao.equals("ABERTA")) {
                strConsulta += " WHERE d.situacao like 'ABERTA'";
            } else {
                strConsulta += " WHERE d.situacao like 'PAGA'";
            }

            // tipo
            if (tipo != null) {
                strConsulta += " AND d.dataVencimento < :dataAtual";
            }

            // mes
            if (mes != 0) {
                strConsulta += " AND MONTH(d.dataVencimento) like :mes";
            }

            // ordenacao
            if (ordenacao == 1) {
                strConsulta += " ORDER BY d.nome ";
            } else if (ordenacao == 2) {
                strConsulta += " ORDER BY d.dataVencimento ";
            }

            // Realiza a consulta            
            TypedQuery<Despesa> query = manager.createQuery(strConsulta, Despesa.class);
            Date dataAtual = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataAtual);

            if (tipo != null) {
                query.setParameter("dataAtual", cal);
            }

            if (mes != 0) {
                query.setParameter("mes", mes);
            }

            List<Despesa> list = query.getResultList();

            // Finaliza a transação
            manager.getTransaction().commit();

            // Retorna a lista
            return list;

        } catch (Exception ex) {
            // Imprime o log de erro
            ex.printStackTrace();

            // Da rollback na transação
            manager.getTransaction().rollback();

            // Lança a exceção
            throw new Exception("Atenção! Não foi possivel Buscar as Despesas!");
        } finally {
            // Fecha a conexão
            manager.close();
        }
    }

    // Método Buscar por Mês.......................................................................................................................
    public List<Despesa> BuscarDespesasMesAtual() throws Exception {
        EntityManager manager = getEntityManager();
        try {

            // Inicia a Transação
            manager.getTransaction().begin();

            // Realiza a consulta            
            Calendar cal = Calendar.getInstance();
            int mes = cal.get(Calendar.MONTH) + 1;

            TypedQuery<Despesa> query = manager.createQuery("SELECT d FROM Despesa d "
                    + "WHERE MONTH(d.dataVencimento) LIKE :mes", Despesa.class);
            query.setParameter("mes", mes);
            List<Despesa> list = query.getResultList();

            // Finaliza a Transação
            manager.getTransaction().commit();

            // Retorna a lista
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Atenção! Não foi possivel Listar os registros!");
        } finally {
            manager.close();
        }
    }

    // Listar.................................................................................................................................................
    public List<Despesa> Listar() throws Exception {
        EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("SELECT d FROM Despesa d ORDER BY d.nome ");
            List<Despesa> list = query.getResultList();
            manager.getTransaction().commit();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            manager.getTransaction().rollback();
            throw new Exception("Atenção! Não foi possivel Listar os registros!");
        } finally {
            manager.close();
        }
    }

    // Método que retorna o total de despesas do mês atual..........................................................................
    public BigDecimal getTotalDespesaMesAtual() throws Exception {
        EntityManager manager = getEntityManager();
        try {

            // Inicia a transação
            manager.getTransaction().begin();

            // Define a consulta
            Calendar cal = Calendar.getInstance();
            int mes = cal.get(Calendar.MONTH) + 1;
            TypedQuery<BigDecimal> query = manager.createQuery(
                    "SELECT SUM(d.valor) FROM Despesa d WHERE MONTH(d.dataVencimento) LIKE :mes",
                    BigDecimal.class);
            query.setParameter("mes", mes);

            BigDecimal total = query.getSingleResult();

            // Retorna  o resultado
            if (total != null) {
                return total;
            } else {
                return BigDecimal.ZERO;
            }

        } catch (Exception ex) {

            // Imprime o log de erro
            ex.printStackTrace();

            // Da rollback na transação
            manager.getTransaction().rollback();

            // Lança a exceção
            throw new Exception("Atenção! Não foi possivel Buscar o Total de Despesas!");
        } finally {
            // Fecha a conexão
            manager.close();
        }
    }

    // Método Buscar
    @Override
    public List<Despesa> Buscar(Despesa d) throws Exception {
        return null;
    }
}
