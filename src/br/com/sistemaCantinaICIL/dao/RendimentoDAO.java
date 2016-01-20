
package br.com.sistemaCantinaICIL.dao;

import static br.com.sistemaCantinaICIL.dao.JPAUtil.getEntityManager;
import br.com.sistemaCantinaICIL.model.Rendimento;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * 
 * @author Aricelio - 16/01/2016
 */
public class RendimentoDAO extends DAOGenerico<Rendimento> {

    // Construtor
    public RendimentoDAO() {
        super(Rendimento.class);
    }
    
    // Método BUSCAR.................................................................................................................................
    public List<Rendimento> Buscar(int mes, int ordenacao) throws Exception{
        EntityManager manager = getEntityManager();
        
        try{
            // Inicia a transação
            manager.getTransaction().begin();

            // Define a consulta
            String strConsulta = "SELECT r FROM Rendimento r";  
            
            // mes
            if( mes != 0){
                strConsulta += " WHERE MONTH(r.dataRecebimento) like :mes";
            }
            
            // ordenacao
            if(ordenacao == 1){
                strConsulta += " ORDER BY r.nome ";
            } else if(ordenacao == 2){
                strConsulta += " ORDER BY r.dataRecebimento ";
            }
            
            // Realiza a consulta            
            TypedQuery<Rendimento> query = manager.createQuery(strConsulta, Rendimento.class);            
            
            if(mes != 0){
                query.setParameter("mes", mes);
            }
            
            List<Rendimento> list = query.getResultList();

            // Finaliza a transação
            manager.getTransaction().commit();

            // Retorna a lista
            return list;
            
        } catch(Exception ex){
            // Imprime o log de erro
            ex.printStackTrace();

            // Da rollback na transação
            manager.getTransaction().rollback();

            // Lança a exceção
            throw new Exception("Atenção! Não foi possivel Buscar os Rendimentos!");
        } finally{
            // Fecha a conexão
            manager.close();
        }
    }
    
    // Método Listar.....................................................................................................................................
    public List<Rendimento> Listar() throws Exception {
        EntityManager manager = getEntityManager();
        try {
            
            // Inicia a Transação
            manager.getTransaction().begin();
            
            // Realiza a consulta
            Query query = manager.createQuery("SELECT r FROM Rendimento r ORDER BY r.nome ");
            List<Rendimento> list = query.getResultList();
            
            // Finaliza a transação
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
    
     // Método que retorna o total de Rendimentos do mês atual....................................................................
    public BigDecimal getTotalRendimentoMesAtual() throws Exception{
        EntityManager manager = getEntityManager();
        try{
            
            // Inicia a transação
            manager.getTransaction().begin();
            
            // Define o parametro
            Calendar cal = Calendar.getInstance();
            int mes = cal.get(Calendar.MONTH) + 1;
            
            // Define a consulta
            TypedQuery<BigDecimal> query = manager.createQuery(
                    "SELECT SUM(R.valor) FROM Rendimento R WHERE MONTH(R.data) LIKE :mes",
                    BigDecimal.class);            
            query.setParameter("mes", mes);
            
            // Realiza a consulta
            BigDecimal total = query.getSingleResult();
            
            // Retorna  o resultado
            if (total != null) {
                return total;
            } else {
                return BigDecimal.ZERO;
            }
            
        } catch(Exception ex){
            
            // Imprime o log de erro
            ex.printStackTrace();

            // Da rollback na transação
            manager.getTransaction().rollback();

            // Lança a exceção
            throw new Exception("Atenção! Não foi possivel Buscar o Total de Rendimentos!");
        } finally{
            // Fecha a conexão
            manager.close();
        }
    }

    @Override
    public List<Rendimento> Buscar(Rendimento object) throws Exception {
        return null;
    }

}
