package br.com.sistemaCantinaICIL.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aricelio 14/12/2015
 */
@Entity
public class Despesa implements Serializable {

    // Variaveis
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal valor;
    
    @Enumerated(EnumType.STRING)
    private EnumSituacao situacao;

    @Temporal(TemporalType.DATE)
    private Calendar dataVencimento;

    @Temporal(TemporalType.DATE)
    private Calendar dataPagamento;
    
    // Construtor
    public Despesa(){}    
    

    // Getters e Setters
    public void setSituacao(EnumSituacao situacao) {    
        this.situacao = situacao;
    }
    
    public EnumSituacao getSituacao() {
        return situacao;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String strDate) throws Exception {
        try {
            SimpleDateFormat simpleDateFomart = new SimpleDateFormat("dd/MM/yyyy");
            Date data = simpleDateFomart.parse(strDate);
            Calendar auxCalendar = Calendar.getInstance();
            auxCalendar.setTime(data);
            
            this.dataVencimento = auxCalendar;
        } 
        catch (ParseException pe) {
            pe.printStackTrace();
            throw new Exception("Atenção! A Data de Vencimento é inválida!");
        } 
        catch (Exception pe) {
            pe.printStackTrace();
            throw new Exception("Atenção! A Data de Vencimento é inválida!");
        }
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String strDate) throws Exception {
        try {            
            SimpleDateFormat simpleDateFomart = new SimpleDateFormat("dd/MM/yyyy");
            Date data = simpleDateFomart.parse(strDate);
            Calendar auxCalendar = Calendar.getInstance();
            auxCalendar.setTime(data);

            this.dataPagamento = auxCalendar;
        } 
        catch (ParseException pe) {
            throw new Exception("Atenção! A Data de Pagamento é inválida!");
        }
        catch (Exception pe) {
            throw new Exception("Atenção! A Data de Pagamento é inválida!");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new Exception("Atenção! O campo Nome é obrigatório!");
        }
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(String strValor) throws Exception {
        try {
            BigDecimal valor = new BigDecimal(strValor);
            if (valor.compareTo(BigDecimal.ZERO) > 0) {
                this.valor = valor;
            } else {
                throw new Exception("Atenção! O Valor da Despesa deve ser maior que zero!");
            }
        } catch (NumberFormatException ne) {
            throw new Exception("Atenção! O Valor da Despesa deve ser um número!");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    // Método HASHCODE
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    // Método EQUALS
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    // Método TOSTRING
    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nDescrição: " + descricao
                + "\nValor: R$ " + valor
                + "\n";
    }

}
